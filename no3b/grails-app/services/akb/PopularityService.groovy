package akb

import org.apache.commons.lang.mutable.MutableInt
import org.apache.commons.logging.LogFactory
import twitter4j.Tweet

class PopularityService {

    static transactional = false
    private static final logger = LogFactory.getLog(this)

    public Map<String, MutableInt> getTweetUserPopularity(List<Tweet> tweets) {
        Map<String, MutableInt> popularityLocationMap = new HashMap<String, MutableInt>()

        tweets.each {
            String user = it.fromUserName
            if(user != null && user.length() > 0) {
                if(popularityLocationMap.containsKey(user)) {
                    popularityLocationMap.get(user).increment()
                } else {
                    popularityLocationMap.put(user, new MutableInt(1))
                }
            }
        }

        return  popularityLocationMap
    }

    public MemberInfo getMostPopularLocation(Map<String, MutableInt> popularityLocationMap) {

        MemberInfo memberInfo = new MemberInfo()

        if(!popularityLocationMap.isEmpty()) {

            popularityLocationMap = popularityLocationMap.findAll {
                it ->
                it.value > 1
            }

            popularityLocationMap = popularityLocationMap.sort {
                a,
                b ->
                b.value <=> a.value
            }

            Map.Entry<String, MutableInt> entry = popularityLocationMap.entrySet().iterator().next()

            memberInfo.setPopularity(entry.value.toInteger())
            memberInfo.setUsername(entry.key)

        } else {

            logger.info("No valid results where returned from the twitter search")
            memberInfo.setMessage("No one is talking about you... sorry... :(")
        }

        return memberInfo
    }
}
