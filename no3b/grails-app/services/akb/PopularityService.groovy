package akb

import org.apache.commons.lang.mutable.MutableInt
import org.apache.commons.logging.LogFactory
import twitter4j.Tweet

class PopularityService {

    static transactional = false
    private static final logger = LogFactory.getLog(this)

    public Map<String, MutableInt> getTweetUserPopularity(List<Tweet> tweets) {
        Map<String, MutableInt> popularityUserMap = new HashMap<String, MutableInt>()

        tweets.each {
            String user = it.fromUserName
            if(user != null && user.length() > 0) {
                if(popularityUserMap.containsKey(user)) {
                    popularityUserMap.get(user).increment()
                } else {
                    popularityUserMap.put(user, new MutableInt(1))
                }
            }
        }

        return  popularityUserMap
    }

    public MemberInfo getMostPopularMemberInfo(Map<String, MutableInt> popularityUserMap) {

        MemberInfo memberInfo = new MemberInfo()

        if(!popularityUserMap.isEmpty()) {

            popularityUserMap = popularityUserMap.findAll {
                it ->
                it.value > 1
            }

            popularityUserMap = popularityUserMap.sort {
                a,
                b ->
                b.value <=> a.value
            }

            Map.Entry<String, MutableInt> entry = popularityUserMap.entrySet().iterator().next()

            memberInfo.setPopularity(entry.value.toInteger())
            memberInfo.setUsername(entry.key)

        } else {

            logger.info("No valid results where returned from the twitter search")
            memberInfo.setMessage("No one is talking about you... sorry... :(")
        }

        return memberInfo
    }
}
