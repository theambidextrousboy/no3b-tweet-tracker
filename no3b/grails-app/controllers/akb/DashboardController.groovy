package akb

import twitter4j.GeoLocation
import twitter4j.Tweet

class DashboardController {

    def twitterService
    def popularityService

    def index = {
    }

    def getPopularity = {
        List<Tweet> tweets = twitterService.getSearchFor(params.member, 10)
        Map<GeoLocation, String> map = popularityService.getTweetsLocationPopularity(tweets)
        BaseMemberInfo baseMemberInfo = popularityService.getMostPopularLocation(map)

            if (baseMemberInfo.message != null){
                render baseMemberInfo.message
            } else {
            render String.format("%s is Loving %s \nPosting %s times!",
                    baseMemberInfo.username,
                    params.member,
                    baseMemberInfo.popularity)
        }

    }
}
