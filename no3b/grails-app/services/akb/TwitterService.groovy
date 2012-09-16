package akb

import twitter4j.*

class TwitterService {

    static transactional = false

    public List<Tweet> getSearchFor(String searchTerm, Integer pages) {
        Twitter twitter = new TwitterFactory().getInstance()

        List<Tweet> addedResults = new ArrayList<Tweet>()
        Query query = new Query(searchTerm)
        query.resultType(Query.RECENT)
        query.rpp(100)
        QueryResult queryResult = twitter.search(query)
        addedResults.addAll(queryResult.tweets)

        if(pages > 0){
            for(int i = 1; i <= pages; i++) {
                query.page(i)
                queryResult = twitter.search(query)
                addedResults.addAll(queryResult.tweets)
            }
        }

        return addedResults
    }
}
