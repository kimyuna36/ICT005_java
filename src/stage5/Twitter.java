package stage5;

import stage1.User;
import stage2.Reply;
import stage3.Tweet;
import stage4.Timeline;

public class Twitter {
    public Timeline[] timelines;
    public User[] users;

    /**
     * @param a - the first User
     * @param b - the second User
     * @return the number of User objects that both User a and b are following.
     *         Hint: use equals when comparing String objects.
     */
    public int countIntersection(User a, User b) {
        // TODO To be completed
    	if (a == null || b == null) {
            return 0;
        }
        
        int count = 0;
        
        
  
    
    }

    /**
     * @return return one unique instance of each Tweet object, i.e. If a Tweet
     *         appears in two timelines, only one copy of the Tweet should be
     *         returned. Hint: use the equals function to compare Tweet objects.
     */
    public Tweet[] removeDuplicates() {
        // TODO To be completed
        return null;
    }

    /**
     * @return a 2D array where each sub array contains two User objects that are
     *         following each other. You will need to compare the handles of users
     *         against the 'following' String arrays in each User. Hint: You can
     *         ignore the 'timelines' instance variable for this question.
     */
    public User[][] mutuallyFollowing() {
        // TODO To be completed
        return null;
    }

    /**
     * @return a 2D array where each sub array contains Tweet objects from different
     *         users, i.e. sub array 1 will contain all tweets by user "A", sub
     *         array 2 will contain all tweets by user "B" and so forth. You can
     *         assume that the 'users' instance variable contains all the users
     *         which have posted in each Timeline. You must ensure that you do not
     *         add duplicate tweets into the final result (Hint:
     *         removeDuplicates()). The order of sub arrays is determined by the
     *         'users' instance variable. All posts made by user[0] will appear in
     *         the first sub array, all posts made by user[1] will appear in the
     *         second sub array and so forth. The order of Tweet objects in each sub
     *         array is determined by their order of appearance in each Timeline.
     */
    public Tweet[][] arrangeByPoster() {
        // TODO To be completed
        return null;
    }
    
    /**
     * DO NOT MODIFY
     */
    public Twitter(Timeline[] timelines, User[] users) {
    	this.timelines = timelines;
    	this.users = users;
    }

}
