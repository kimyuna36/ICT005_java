package stage4;

import stage1.User;
import stage2.Reply;
import stage3.Tweet;

/**
 * Represents Tweet recommendations to a specific user. This user is the
 * 'owner' of the Timeline.
 * @author mic
 */

public class Timeline {

    public User owner;
    public Tweet[] tweets;

    /**
     * @param u - the user to check for
     * @return the number of Tweet objects in 'tweets' whose 'poster' is equal to
     *         the passed User object 'u'. Hint: use the equals function to compare
     *         User objects.-
     */
    public int countTweets(User u) {
    	//TODO to be completed
    	int count=0;
    	if(tweets!= null) {
    		for(Tweet t: tweets) {
    			if(t.poster.equals(u)) {
    				count++;
    			}
    		}
    	}
    	return count;
    	
    }
     




    	
    	
    	
    

    /**
     * @return the User object who is the poster of the most Tweet objects in
     *         'tweets', i.e. the User who has made the most Tweets. Return null if
     *         'tweets' is null or 'tweets' is of length 0.
     */
    public User mostTweets() {
        // TODO To be completed
    	User mostTweets=null;
    	int maxCount=0;
    	if(tweets==null || tweets.length==0) {
    		return null;
    	}
    	
    	for(Tweet t:tweets) {
    		int count=countTweets(t.poster);
    		if(count>maxCount) {
    			maxCount=count;
    			mostTweets=t.poster;
    		}
    	}
    	
    	return mostTweets;
        }

     

    /**
     * @return the User who has had the most activity. Activity is defined as the
     *         number of Tweets posted plus the number of replies made. Return null
     *         if 'tweets' is null or 'tweets' is of length 0. You may assume that
     *         every User has made at least one Tweet, i.e. there are no Users who
     *         have ONLY made replies.
     */
    public User mostActivity() {
    	
    	User mostActivity=null;
    	int maxCount=0;
    	if(tweets==null || tweets.length==0) {
    		return null;
    	}
    	for(Tweet t: tweets) {
    		int activity =countTweets(t.poster)+(t.replies.length);
    		if(activity>maxCount) {
    			maxCount=activity;
    			mostActivity=t.poster;
    		}
    	}
        // TODO To be completed
        return mostActivity;
    }

    /**
     * @return an array of Tweet objects containing all Tweets made by the owner of
     *         the timeline, i.e. all Tweets the owner has posted. Return null if
     *         'owner' or 'tweets' is null. Hint: use the equals function to compare
     *         User objects.
     */
    public Tweet[] getAllTweetsByTimelineOwner() {
        // TODO To be completed
    	if(owner==null || tweets==null) {
    		return null;
    	}
    	int count=0;
    	for(Tweet t:tweets) {
    		if(t.poster.equals(owner)) {
    			count++;
    		}
    	}
        
	    Tweet[] ownerTweets=new Tweet[count];
	    int index=0;
	    for(Tweet t: tweets) {
	    	if(t.poster.equals(owner)) {
	    		ownerTweets[index]=t;
	    		index++;
	    	}
	    }
	    return ownerTweets;
	    
    	
    }
    
    /**
     * @return a String which represents the Timeline object.
     * The String should follow the below format (with the actual Timeline data used).
     * Hint: the \n character adds a new line
     * For example:
     * 
     * Timeline Owner: mic1511
     * ----------
     * 
     * => Poster: traveler
     * => Message: This is the first message!!!! 
     * 
     * Replying to @mic1511, @Janedoe, @traveler
     * This is a test message
     * Replying to @traveler, @Charlie, @Foodie
     * This is another test message!!!
     * 
     * ----------
     * 
     * => Poster: traveler
     * => Message: Wow this is the second Tweet in this timeline :O
     * 
     * Replying to @mic1511, @Janedoe, @traveler
     * This is a test message
     * Replying to @traveler, @Charlie, @Foodie
     * This is another test message!!!
     * 
     * ----------
     * 
     * => Poster: Janedoe
     * => Message: Finally at the last one now
     * 
     * Replying to no one
     * This is the last message in this Timeline
     * 
     * ----------
     */
    public String printTimeline() {
        // TODO To be completed
        return null;
    }
    
    
    /**
     * 
     * @param term - the term to look for
     * @return the number of Tweet objects with either a message that contains the passed 
     *         'term' or has a Reply whose message contains the passed term.
     *         If the 'term' appears in a Tweet objects message and in its replies, 
     *         it should be counted once.
     */
    public int countSearchResults(String term) {
        //TODO To be completed
        return -100;
    }

    /**
     * @param term - the term to look for
     * @return an array of Tweet objects from 'tweets' which match any of the
     *         following criteria: 1) the Tweet has a poster whose handle contains
     *         'term', 2) the Tweet contains a message containing 'term', 3) the
     *         Tweet contains any replies whose message contains 'term' and 4) the
     *         tweet contains any replies whose 'from' and 'to' User objects have a
     *         handle containing 'term'.
     */
    public Tweet[] searchAll(String term) {
        // TODO To be completed
        return null;
    }
    
    /**
     * DO NOT MODIFY
     */
    public Timeline(User owner, Tweet[] tweets) {
    	this.owner = owner;
    	this.tweets = tweets;
    }

}
