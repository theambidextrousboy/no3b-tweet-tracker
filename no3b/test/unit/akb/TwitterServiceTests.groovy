package akb

import grails.test.GrailsUnitTestCase
import twitter4j.Tweet

class TwitterServiceTests extends GrailsUnitTestCase {

    def twitterService
    private List<Tweet> tweets
    private List<Tweet> tweets2Page

    protected void setUp() {
        twitterService = new TwitterService()
        tweets = twitterService.getSearchFor("fish", 0)
        tweets2Page = twitterService.getSearchFor("b", 1)

        super.setUp()
    }

    protected void tearDown() {
        super.tearDown()
    }

    void testGetSearchResultsPageSize() {
        assertTrue tweets.size() <= 100
        assertTrue tweets.size() > 0

        assertTrue tweets2Page.size() <= 200
        assertTrue tweets2Page.size() >= 100
    }
}
