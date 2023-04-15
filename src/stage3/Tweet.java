package stage3;

import java.util.ArrayList;

import stage1.User;
import stage2.Reply;

public class Tweet {
    public User poster;
    public String message;
    public Reply[] replies;
    public int views;

    /**
     * @param idx - the idx to retrieve at
     * @return the Reply object from the 'replies' instance variable at position
     *         'idx'. Return null if replies is null, or position 'idx' does not
     *         exist.
     */

    public Reply getReply(int idx) {
        
    	if (replies == null || idx < 0 || idx >= replies.length) {
            return null;
        }
        return replies[idx];
    
    }

    /**
     * 
     * @param idx - the idx to retrieve at
     * @return the message inside the Reply object from the 'replies' instance
     *         variable at position 'idx'. Return null if replies is null or
     *         position 'idx' does not exist.
     */
    public String getMessage(int idx) {
        
//    	if (replies == null || idx < 0 || idx >= replies.length) {
//            return null;
//        }
//        return replies[idx].message;
    	Reply reply = getReply(idx);
        if (reply == null) {
            return null;
        }
        return reply.message;
        }

    /**
     * @return The total number of views from the Tweet calling object and all of
     *         its replies.
     */
    public int totalViews() {
        int total = views;
        
        if (replies != null) {
            for (Reply reply : replies) {
                total += reply.views;
            }
        }
        
        return total;

    }

    /**
     * @return The reply object in 'replies' with the highest number of views.
     * 		   In case of a tie, the first Reply object with the highest number
     *         of views should be returned.
     *         Return null if 'replies' is null.
     */
    public Reply mostPopularReply() {
    	if (replies == null) {
            return null;
        }
        Reply mostPopular = replies[0];
        for (int i = 1; i < replies.length; i++) {
            if (replies[i].views > mostPopular.views) {
                mostPopular = replies[i];
            }
        }
        return mostPopular;
    }

    /**
     * @param handle - the User handle to check for
     * @return the first Reply object FROM a User with the passed handle. Return
     *         null if no users match the passed handle.
     */
    public Reply findReplyFrom(String handle) {

    	if(replies!=null) {
    		for(int i=0; i<replies.length;i++) {
    			if(replies[i].from.handle.equals(handle)) {
    				return replies[i];
    			}
    		}
    	}
    	return null;
    }

    /**
     * @param handle - the User handle to check for
     * @return the first Reply object TO a user with the passed handle. Return null
     *         if no users match the passed handle. Hint: you will need a nested
     *         loop.
     */
    public Reply findReplyTo(String handle) {
        // TODO To be completed
    	if(replies!=null) {
    		for(int i=0; i<replies.length;i++) {
    			if(replies[i].to[i].handle.equals(handle)) {
    				return replies[i];
    			}
    		}
    	}
    	return null;
    	
    	 
    }

    /**
     * (HD level question)
     * 
     * @return a String array containing all the hashtags in the instance variable
     *         'message'. Return empty array if no hashtags are found. A hashtag is
     *         defined as a sequence of characters starting with a '#' character
     *         followed by one or more LOWERCASE letters and is terminated by a space
     *         character or the end of the string. The hashtag must be at the start
     *         of the message or follow a space. e.g. "#test" is a valid hashtag in
     *         the following strings: "#test message", "not a #test" and "hashtag
     *         #test in the middle".
     */
    public String[] getHashtags() {
    	ArrayList<String> hashtags=new ArrayList<String>();
    	String[] words=message.split("||s+");
    	for(String word:words) {
    		if(word.matches("#[a-z]+")) {
    			hashtags.add(word);
    		}
    	}
    	return hashtags.toArray(new String[0]);
    }
    	   
    /**
     * DO NOT MODIFY
     * 
     * @return true if the calling object and the passed object are equal, false
     *         otherwise
     */
    public boolean equals(Object other) {
        if (!(other instanceof Tweet))
            return false;
        Tweet otherTweet = (Tweet) other;
        return this.poster.equals(otherTweet.poster)
                && this.message.equals(otherTweet.message)
                && this.replies == otherTweet.replies
                && this.views == otherTweet.views;
    }
    
    /**
     * DO NOT MODIFY
     */
    public Tweet(User poster, String message, Reply[] replies, int views) {
    	this.poster = poster;
    	this.message = message;
    	this.replies = replies;
    	this.views = views;
    }
}
