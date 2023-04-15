package stage1;

public class User {
    public String handle;
    public String bio;
    public String[] followers;
    public String[] following;
    public boolean verified;

    /**
     * @param hnd   - for handle
     * @param b     - for bio
     * @param fwers - for followers
     * @param fwing - for following
     * @param ver   - for verified
     */
    public User(String hnd, String b, String[] fwers, String[] fwing, boolean ver) {
        // TODO To be completed
    	this.handle=hnd;
    	this.bio=b;
    	this.followers=fwers;
    	this.following=fwing;
    	this.verified=ver;
    }

    /**
     * @return 1 if the user has more followers then they are following, -1 if the
     *         user has less followers then they are following, 0 if the user has
     *         the same number of followers as they are following
     */
    public int moreFollowers() {
        // TODO To be completed
    	int followersCount = this.followers.length;
        int followingCount = this.following.length;
    	
        if (followersCount > followingCount) {
            return 1;
        } else if (followersCount < followingCount) {
            return -1;
        } else {
            return 0;
        }
    }

    /**
     * DO NOT MODIFY
     * 
     * @return true if handle is valid, false otherwise
     */
    public boolean validHandle() {
        
    	if (handle == null || handle.length() < 1 || handle.length() > 15)
            return false;

        for (char c : handle.toCharArray())
            if (!((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9')))
                return false;
        return true;
    }

    /**
     * DO NOT MODIFY
     * 
     * @return true if the calling object and the passed object are equal, false
     *         otherwise
     */
    public boolean equals(User otherUser) {
        return this.handle.equals(otherUser.handle) && 
                this.bio.equals(otherUser.bio) && 
                sameUsers(this.followers, otherUser.followers) && 
                sameUsers(this.following, otherUser.following) && 
                this.verified == otherUser.verified;
    }
    
    public boolean sameUsers(String[] arr1, String[] arr2) {
    	if (arr1.length != arr2.length) {
    		return false;
    	}
    	for(int i = 0; i < arr1.length; i++) {
    		if(!arr1[i].equals(arr2[i])) { 
    			return false;
    		}
    	}
    	return true;
    }
    
    /**
     * DO NOT MODIFY
     */
    public User(String path) {
        
    }
    
    /**
	 * DO NOT MODIFY
	 */
	public String toString() {
		String result = "User: ";
		result += "@" + handle + " " + ((verified) ? "✓": "") + "\n";
		result += bio + "\n";
		result += "Followers: [";
		for(String s : followers) {
			result += "@" + s + ", ";
		}
		if(followers.length > 0) {
			result = result.substring(0, result.length() - 2);
		}
		result += "]" + "\n";
		result += "Following: [";
		for(String s : following) {
			result += "@" + s + ", ";
			
		}
		if(following.length > 0) {
			result = result.substring(0, result.length() - 2);
		}
		result += "]";
		return result;
	}
}
