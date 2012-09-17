package akb

import grails.test.GrailsUnitTestCase
import org.apache.commons.lang.mutable.MutableInt
import org.mockito.Mockito
import twitter4j.Tweet

class PopularityServiceTests extends GrailsUnitTestCase {

    def popularityService
    private List<Tweet> tweets
    private Map<String, MutableInt> popularityMap

    protected void setUp() {
        popularityService = new PopularityService()

        //Set up tweets
        tweets = new ArrayList<Tweet>()

        Tweet tweet1fromUser2 = Mockito.mock(Tweet.class)
        Mockito.when(tweet1fromUser2.getFromUserName()).thenReturn("user2")
        tweets.add(tweet1fromUser2)

        Tweet tweet2FromUser2 = Mockito.mock(Tweet.class)
        Mockito.when(tweet2FromUser2.getFromUserName()).thenReturn("user2")
        tweets.add(tweet2FromUser2)

        Tweet tweet1FromUser3 = Mockito.mock(Tweet.class)
        Mockito.when(tweet1FromUser3.getFromUserName()).thenReturn("user3")
        tweets.add(tweet1FromUser3)

        Tweet tweet1fromUser1 = Mockito.mock(Tweet.class)
        Mockito.when(tweet1fromUser1.getFromUserName()).thenReturn("user1")
        tweets.add(tweet1fromUser1)

        Tweet tweet2FromUser1 = Mockito.mock(Tweet.class)
        Mockito.when(tweet2FromUser1.getFromUserName()).thenReturn("user1")
        tweets.add(tweet2FromUser1)

        Tweet tweet3FromUser1 = Mockito.mock(Tweet.class)
        Mockito.when(tweet3FromUser1.getFromUserName()).thenReturn("user1")
        tweets.add(tweet3FromUser1)

        //Set up popularityMap
        popularityMap = new HashMap<String, MutableInt>()
        popularityMap.put("user1", new MutableInt(4))
        popularityMap.put("user2", new MutableInt(1))
        popularityMap.put("user3", new MutableInt(6))
        popularityMap.put("user4", new MutableInt(9))


        super.setUp()
    }

    protected void tearDown() {
        super.tearDown()
    }

    void testGetTweetsLocationPopularity() {
        Map<String, MutableInt> result = popularityService.getTweetUserPopularity(tweets)
        assertTrue("Should have returned 3 results for user2 but returned, " + result.get("user1"),
                result.get("user1") == 3)

        assertTrue("Should have returned 2 results for user2 but returned, " + result.get("user2"),
                result.get("user2") == 2)

        assertTrue("Should have returned 1 results for user3 but returned, " + result.get("user3"),
                result.get("user3") == 1)
    }

    void testGetMostPopularLocation() {

        MemberInfo baseMemberInfo = popularityService.getMostPopularLocation(popularityMap)
        assertEquals("Username should be user4 but was " + baseMemberInfo.getUsername(),
                "user4",
                baseMemberInfo.getUsername() )

        assertNull("Message should be null but was " + baseMemberInfo.getMessage(),
                baseMemberInfo.getMessage() )

        assertEquals("Popularity should be 9 but was " + baseMemberInfo.getPopularity(),
                9,
                baseMemberInfo.getPopularity() )
    }

    void testGetMostPopularLocationEmptyMap() {
        Map<String, MutableInt> emptyMap = new HashMap<String, MutableInt>()

        MemberInfo baseMemberInfo = popularityService.getMostPopularLocation(emptyMap)
        assertNull("Username should be null but was " + baseMemberInfo.getUsername(),
                baseMemberInfo.getUsername() )

        assertNotNull("Message should not be null", baseMemberInfo.getMessage() )

        assertNull("Popularity should be null but was " + baseMemberInfo.getPopularity(),
                baseMemberInfo.getPopularity() )
    }
}
