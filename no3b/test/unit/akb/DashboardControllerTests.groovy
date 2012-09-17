package akb

import grails.test.ControllerUnitTestCase
import org.apache.commons.lang.mutable.MutableInt
import org.mockito.Mockito
import twitter4j.Tweet

class DashboardControllerTests extends ControllerUnitTestCase {

    private DashboardController dashboardController

    protected void setUp() {
        dashboardController = new DashboardController()
        super.setUp()
    }

    protected void tearDown() {
        super.tearDown()
    }

    void testGetPopularity() {

        Map<String, MutableInt> popularityMap = new HashMap<String, MutableInt>()
        popularityMap.put("user1", new MutableInt(4))
        popularityMap.put("user2", new MutableInt(9))

        MemberInfo baseMemberInfo = new MemberInfo()
        baseMemberInfo.setUsername("user2")
        baseMemberInfo.setPopularity(9)

        List<Tweet> tweets = new ArrayList<Tweet>()
        Tweet tweet1fromUser2 = Mockito.mock(Tweet.class);
        Mockito.when(tweet1fromUser2.getFromUserName()).thenReturn("user2")
        tweets.add(tweet1fromUser2)

        Tweet tweet2FromUser2 = Mockito.mock(Tweet.class);
        Mockito.when(tweet2FromUser2.getFromUserName()).thenReturn("user2")
        tweets.add(tweet2FromUser2)

        Tweet tweet1FromUser3 = Mockito.mock(Tweet.class);
        Mockito.when(tweet1FromUser3.getFromUserName()).thenReturn("user3")
        tweets.add(tweet1FromUser3)

        def mockTwitterService = mockFor(TwitterService, true)
        def mockPopularityService = mockFor(PopularityService, true)

        mockTwitterService.demand.getSearchFor {def p, def q -> return tweets}
        mockPopularityService.demand.getTweetUserPopularity {def r -> return popularityMap}
        mockPopularityService.demand.getMostPopularLocation {def s -> return baseMemberInfo}

        dashboardController.params.member = new String("minegishi")

        dashboardController.popularityService = mockPopularityService.createMock()
        dashboardController.twitterService = mockTwitterService.createMock()

        dashboardController.getPopularity()

        assertEquals String.format("%s is Loving %s \nPosting %s times!",
                "user2",
                "minegishi",
                "9"), controller.response.contentAsString

    }
}
