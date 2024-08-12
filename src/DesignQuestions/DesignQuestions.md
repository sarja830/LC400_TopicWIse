
#### 355. Design Twitter
```java
class Twitter {
    class Helper implements Comparable<Helper>
    {
        int time;
        int index;
        int userId;
        int tweetId;
        @Override
        public int compareTo(Helper o)
        {
            return  o.time - this.time;
        }
        Helper(int[] tweet, int index, int userId)
        {
            tweetId = tweet[0] ;
            this.time = tweet[1];
            this.index = index;
            this.userId = userId;
        }
       int nextFeed()
        {
            return index-1;
        }

    }
    int time ;
    // to store what all users a user follows
    HashMap<Integer, HashSet<Integer>> followsMap ;
    // to store the tweet and its time
    HashMap<Integer, List<int[]>> tweetsMap;

    public Twitter() {
        followsMap = new HashMap();
        tweetsMap = new HashMap();
        // time count
        time = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        List<int[]> tweets = tweetsMap.getOrDefault(userId, new LinkedList());
        tweets.add(new int[]{ tweetId, time++});
        tweetsMap.put(userId, tweets);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        // merge k sorted algorithm on a linkedlist/ arraylist
        PriorityQueue<Helper> pq = new PriorityQueue();
        List<int[]> tweets;

        tweets = tweetsMap.getOrDefault( userId,new LinkedList() );
        // construct a helper method to take care of the last index and sort tweets based on time in the priority queue with the help the comparable interface (recent first)
        if(tweets.size()>0)
            pq.add( new Helper(tweets.getLast(),tweets.size()-1, userId) );

        // add all the followers tweets also to the priority queue

        // if(followsMap.containsKey(userId))
            for(int followingId: followsMap.getOrDefault(userId, new HashSet<Integer>()))
            {
                tweets = tweetsMap.getOrDefault(followingId, new LinkedList());
                if(tweets.size()>0)
                    pq.add(new Helper(tweets.getLast(), tweets.size()-1, followingId));
            }
        List<Integer> feeds  =  new LinkedList();
        while(!pq.isEmpty() && feeds.size()<10)
        {
            Helper feed = pq.poll();
            feeds.add(feed.tweetId);
            if(feed.nextFeed()>=0)
            {
                
                pq.add(new Helper( tweetsMap.get(feed.userId).get(feed.nextFeed()) , feed.nextFeed() ,feed.userId ));
            }
        }
        return feeds;
    }
    
    public void follow(int followerId, int followeeId) {
        HashSet<Integer> follows = followsMap.getOrDefault(followerId , new HashSet());
        follows.add(followeeId);
        followsMap.put(followerId, follows);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followsMap.containsKey(followerId))
            followsMap.get(followerId).remove(followeeId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
```