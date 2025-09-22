package Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Collections;

public class DesignTwitter {
    HashMap<Integer, HashSet<Integer>> user;
    HashMap<Integer, ArrayList<Integer>> tweetNumWithId;
    HashMap<Integer,Integer> tweets;
    int tweetNum;
    public DesignTwitter() {
        user = new HashMap<>();
        tweetNumWithId = new HashMap<>();
        tweets = new HashMap<>();
        tweetNum = 0;
    }

    public void postTweet(int userId, int tweetId) {
        if(!user.containsKey(userId)){
            user.put(userId, new HashSet<>());
            user.get(userId).add(userId);
        }
        if(!tweetNumWithId.containsKey(userId)){
            tweetNumWithId.put(userId,new ArrayList<>());
        }
        tweetNumWithId.get(userId).add(tweetNum);
        tweets.put(tweetNum,tweetId);
        tweetNum++;
    }

    public List<Integer> getNewsFeed(int userId) {
        if(!user.containsKey(userId)){
            user.put(userId, new HashSet<>());
            user.get(userId).add(userId);
        }
        ArrayList<Integer> allTweets = new ArrayList<>();
        HashSet<Integer> allFollowers = user.get(userId);
        for(int fol : allFollowers){
            if(tweetNumWithId.containsKey(fol)) allTweets.addAll(tweetNumWithId.get(fol));
        }
        Collections.sort(allTweets);
        List<Integer> ans = new ArrayList<>();
        for(int i=allTweets.size()-1; i>=Math.max(0,allTweets.size()-10); i--) ans.add(tweets.get(allTweets.get(i)));
        return ans;
    }

    public void follow(int followerId, int followeeId) {
        if(!user.containsKey(followerId)){
            user.put(followerId, new HashSet<>());
            user.get(followerId).add(followerId);
        }
        user.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if(!user.containsKey(followerId)) return;
        user.get(followerId).remove(followeeId);
    }
}
