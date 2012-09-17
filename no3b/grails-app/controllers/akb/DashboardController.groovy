package akb

import org.apache.commons.lang.mutable.MutableInt
import twitter4j.Tweet

class DashboardController {

    def twitterService
    def popularityService

    def index = {
    }

    def getPopularity = {
        List<Tweet> tweets = twitterService.getSearchFor(params.member, 3)
        Map<String, MutableInt> map = popularityService.getTweetUserPopularity(tweets)
        MemberInfo memberInfo = popularityService.getMostPopularMemberInfo(map)

            if (memberInfo.message != null) {
                render memberInfo.message
            } else {
                render String.format("%s is loving %s! Posting %s times!",
                        memberInfo.username,
                        params.member,
                        memberInfo.popularity)
        }
    }
}
