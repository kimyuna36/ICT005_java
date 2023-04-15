package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import serviceClasses.Graded;
import stage1.User;
import stage2.Reply;
import stage3.Tweet;
import stage4.Timeline;
import stage5.Twitter;

public class TwitterTest { 

    @Test @Graded(description = "countIntersection", marks = 2)
    public void testCountIntersection() {
    	
    	Twitter twitter = generateTwitterNullTimelines();
    	User a = UserTest.generateUser1();
    	User b = UserTest.generateUser2();
    	int expectedResult = 0;
    	assertEquals(expectedResult, twitter.countIntersection(a, b));
    	
    	a = UserTest.generateUser2();
    	b = UserTest.generateUser1();
    	expectedResult = 0;
    	assertEquals(expectedResult, twitter.countIntersection(a, b));

    	a = UserTest.generateUser2();
    	b = UserTest.generateUser5();
    	a.following = new String[]{"Dave", "Ellen", "Obama", "Johndoe"};
    	expectedResult = 2;
    	assertEquals(expectedResult, twitter.countIntersection(a, b));
    	
    	a = UserTest.generateUser4();
    	b = UserTest.generateUser4();
    	expectedResult = 0;
    	assertEquals(expectedResult, twitter.countIntersection(a, b));
    	
    	a = UserTest.generateUser5();
    	b = UserTest.generateUser5();
    	expectedResult = 3;
    	assertEquals(expectedResult, twitter.countIntersection(a, b));
    	
    	b.handle = "Mario";
    	b.verified = true;
    	b.followers = new String[]{"Dave", "Ellen", "Obama", "Johndoe", "mic1511"};
    	expectedResult = 3;
    	assertEquals(expectedResult, twitter.countIntersection(a, b));
    	
    	a = UserTest.generateUser4();
    	b = UserTest.generateUser5();
    	a.following = new String[]{"Dave", "Ellen", "Obama", "Johndoe", "mic1511"};
    	b.following = new String[]{"Dave", "Ellen", "Obama", "Johndoe", "mic1511"};
    	expectedResult = 5;
    	assertEquals(expectedResult, twitter.countIntersection(a, b));
    	
        currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
    }
    
    @Test @Graded(description = "removeDuplicates", marks = 2)
    public void testRemoveDuplicates() {
    	
    	Twitter twitter = generateTwitterNullTimelines();
    	Tweet[] expectedResult = null;
    	assertArrayEquals(expectedResult, twitter.removeDuplicates());
    	
    	twitter.users = new User[0];
    	expectedResult = null;
    	assertArrayEquals(expectedResult, twitter.removeDuplicates());
    	
    	twitter.timelines = new Timeline[0];
    	twitter.users = null;
    	expectedResult = null;
    	assertArrayEquals(expectedResult, twitter.removeDuplicates());
    	
    	twitter = generateTwitter1();
    	expectedResult = new Tweet[]{tweet1, tweet4, tweet5, tweet2, printTimelineExample.tweets[0], printTimelineExample.tweets[1], printTimelineExample.tweets[2], tweet3};
    	assertArrayEquals(expectedResult, twitter.removeDuplicates());
    	
        currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
    }
    
    @Test @Graded(description = "mutuallyFollowing", marks = 2)
    public void testMutuallyFollowing() {
    	
    	Twitter twitter = generateTwitterNullTimelines();
    	twitter.timelines = new Timeline[0];
    	User[][] expectedResult = null;
    	assertArrayEquals(expectedResult, twitter.mutuallyFollowing());
    	
    	twitter = generateTwitter1();
    	expectedResult = new User[][]{
    		{user6, user1},
    		{user4, user1},
    		{user6, user2},
    		{user1, user4},
    		{user1, user6},
    		{user2, user6},
    	};
    	
    	user6.following = new String[]{"mic1511", "Janedoe"};
    	User[][] actualResult = twitter.mutuallyFollowing();
    	assertEquals(expectedResult.length, actualResult.length);
    	
    	//Check the same pairs are present in the expected and actual result
    	boolean arraysEqualOutOfOrder = arrayEquals(expectedResult, actualResult);
    	if(arraysEqualOutOfOrder == false) {
    	    System.out.println("expected");
    	    System.out.println(toString(expectedResult));
    	    System.out.println("actual");
            System.out.println(toString(actualResult));
    	    fail("The array returned does not contain the correct users, check the console for more details");
    	}
    	
    	
    	user6.following = new String[]{"mic1511", "Janedoe"}; // change Foodie's following list order
    	
    	// answer remains the same
    	expectedResult = new User[][]{
    		{user6, user1},
    		{user4, user1},
    		{user6, user2},
    		{user1, user4},
    		{user1, user6},
    		{user2, user6},
    	};
    	
    	actualResult = twitter.mutuallyFollowing();
    	assertEquals(expectedResult.length, actualResult.length);
    
    	//Check the same pairs are present in the expected and actual result
        arraysEqualOutOfOrder = arrayEquals(expectedResult, actualResult);
        if(arraysEqualOutOfOrder == false) {
            System.out.println("expected");
            System.out.println(toString(expectedResult));
            System.out.println("actual");
            System.out.println(toString(actualResult));
            fail("The array returned does not contain the correct users, check the console for more details");
        }
    	
    	// use UserTest users (no mutuals)
    	twitter.users[0] = TweetTest.user1;
    	twitter.users[1] = TweetTest.user2;
    	twitter.users[2] = TweetTest.user3;
    	twitter.users[3] = TweetTest.user4;
    	twitter.users[4] = TweetTest.user5;
    	twitter.users[5] = TweetTest.user6;
    	
    	assertEquals(0, twitter.mutuallyFollowing().length);
    	
        currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
    }
    
    public String toString(User[][] arr) {
        String result = "";
        for(int i = 0; i < arr.length; i++) {
            result += arr[i][0].handle + " | " + arr[i][1].handle + "\n";
        }
        return result;
    }
    
    // Can be simplified with generic typing and recursion but that's a topic for another unit!
    public static boolean arrayEquals(User[][] arr1, User[][] arr2) {
        if(arr1 == null && arr2 == null)
            return true;
        if(arr1 == null || arr2 == null)
            return false;
        if(arr1.length != arr2.length)
            return false;
        
        for(int i = 0; i < arr1.length; i++) {
            int occurencesIn1 = countOccurences(arr1, arr1[i]);
            int occurencesIn2 = countOccurences(arr2, arr1[i]);
            if(occurencesIn1 != occurencesIn2)
                return false;
        }
        
        return true;
    }
    
    private static int countOccurences(User[][] arr, User[] target) {
        int count = 0;
        for(int i = 0; i < arr.length; i++)
            if(arrayEquals(arr[i], target))
                count++;
        return count;
    }

    public static boolean arrayEquals(User[] arr1, User[] arr2) {
        if(arr1 == null && arr2 == null)
            return true;
        if(arr1 == null || arr2 == null)
            return false;
        if(arr1.length != arr2.length)
            return false;
        for(int i = 0; i < arr1.length; i++) {
            int occurencesIn1 = countOccurences(arr1, arr1[i]);
            int occurencesIn2 = countOccurences(arr2, arr1[i]);
            if(occurencesIn1 != occurencesIn2)
                return false;
        }
        return true;
    }
    
    public static int countOccurences(User[] arr, User target) {
        int count = 0;
        for(int i = 0; i < arr.length; i++)
            if(arr[i].equals(target))
                count++;
        return count;
    }
    
    @Test @Graded(description = "arrangeByPoster", marks = 2)
    public void testArrangeByPoster() {
    	
    	Twitter twitter = generateTwitterNullTimelines();
    	Tweet[][] expectedResult = null;
    	assertArrayEquals(expectedResult, twitter.arrangeByPoster());
    	
    	twitter.users = new User[0];
    	expectedResult = null;
    	assertArrayEquals(expectedResult, twitter.arrangeByPoster());
    	
    	twitter.timelines = new Timeline[0];
    	twitter.users = null;
    	expectedResult = null;
    	assertArrayEquals(expectedResult, twitter.arrangeByPoster());
    	
    	twitter = generateTwitter1();
    	
    	// use UserTest users
    	twitter.users[0] = TweetTest.user1;
    	twitter.users[1] = TweetTest.user2;
    	twitter.users[2] = TweetTest.user3;
    	twitter.users[3] = TweetTest.user4;
    	twitter.users[4] = TweetTest.user5;
    	twitter.users[5] = TweetTest.user6;
    	
    	expectedResult = new Tweet[][]{
    		{tweet1},
    		{tweet4, tweet2, printTimelineExample.tweets[2]},
    		{tweet5, printTimelineExample.tweets[0], printTimelineExample.tweets[1], tweet3},
    		{},
    		{},
    		{}
    	};
    	Tweet[][] actualResult = twitter.arrangeByPoster();
    	
    	// check each sub-array
    	for(int i = 0; i < expectedResult.length; i++) {
    		assertArrayEquals(expectedResult[i], actualResult[i]);
    	}
    	
    	// change tweet2 poster from being user 2 to being user 5
    	tweet2.poster = twitter.users[4];
    	
    	// change tweet5 poster from being user 3 to being user 6
    	tweet5.poster = twitter.users[5];
    	
    	expectedResult = new Tweet[][]{
    		{tweet1},
    		{tweet4, printTimelineExample.tweets[2]},
    		{printTimelineExample.tweets[0], printTimelineExample.tweets[1], tweet3},
    		{},
    		{tweet2},
    		{tweet5}
    	};
    	actualResult = twitter.arrangeByPoster();
    	
    	// check each sub-array
    	for(int i = 0; i < expectedResult.length; i++) {
    		assertArrayEquals(expectedResult[i], actualResult[i]);
    	}
    	
        currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
    }
    
    // VARIABLES & FUNCTIONS TO GENERATE DATA

    public static Twitter generateTwitterNullTimelines() {
    	Timeline[] timelines = null; 
    	User[] users = null;
        return new Twitter(timelines, users);
    }
    
    // Used to generate Twitter
    
    static Tweet tweet1 = TweetTest.generateTweet1();
    static Tweet tweet2 = TweetTest.generateTweet2();
    static Tweet tweet3 = TweetTest.generateTweet3();
    static Tweet tweet4 = TweetTest.generateTweet4();
    static Tweet tweet5 = TweetTest.generateTweet5();
    static Timeline printTimelineExample = TimelineTest.generatePrintTimelineExample();
    
    // Users' following & followers edited for testMutuallyFollowing
    
    static User user1 = UserTest.generateUser1(); // mic1511
    {
    	user1.following = new String[]{"Foodie", "Obama", "Charlie", "Samantha", "Andy87"};
    	user1.followers = new String[]{"Bob", "Foodie", "Samantha"};
    }
    static User user2 = UserTest.generateUser2(); // Janedoe
    {
    	user2.following = new String[]{"Dave", "Foodie", "Ellen"};
    	user2.followers = new String[]{"Foodie", "Alice", "Bob", "Charlie"};
    }
    static User user3 = UserTest.generateUser3(); // traveler
    {
    	user3.following = new String[]{"Foodie"};
    }
    static User user4 = UserTest.generateUser4(); // Samantha
    {
    	user4.following = new String[]{"mic1511", "hunter2"};
    	user4.followers = new String[]{"Johndoe", "Janedoe", "mic1511", "Alice", "Bob", "Charlie", "Dave",
    			"Ellen", "Frank", "Grace", "hunter2"};
    }
    static User user5 = UserTest.generateUser5(); // Charlie
    {
    	user5.following = new String[]{"Dave", "Foodie", "Ellen"};
    	user5.followers = new String[]{"Johndoe", "Dave", "mic1511", "Bob"};
    }
    static User user6 = UserTest.generateUser6(); // Foodie
    {
    	user6.following = new String[]{"Janedoe", "mic1511"};
    	user6.followers = new String[]{"Janedoe", "mic1511", "Charlie", "traveler"};
    }
    
    public static Twitter generateTwitter1() {
    	Timeline[] timelines = new Timeline[4];
    	timelines[0] = new Timeline(user2, new Tweet[]{tweet1, tweet4});
    	timelines[1] = new Timeline(user5, new Tweet[]{tweet5, tweet4, tweet2, tweet1});
    	timelines[2] = printTimelineExample;
    	timelines[3] = new Timeline(user4, new Tweet[]{tweet3, tweet2, tweet5});
    	User[] users = {user1, user2, user3, user4, user5, user6};
    	return new Twitter(timelines, users);
    }
    
    /*
     * DO NOT MODIFY BELOW
     */
    
    public static int score = 0;
    public static String result = "";
    public static String currentMethodName = null;
    ArrayList<String> methodsPassed = new ArrayList<String>();
    
    @BeforeEach
    public void run() {
        currentMethodName = null;
    }
    
    @AfterEach
    public void logSuccess() throws NoSuchMethodException, SecurityException {
        if (currentMethodName != null && !methodsPassed.contains(currentMethodName)) {
            methodsPassed.add(currentMethodName);
            Method method = getClass().getMethod(currentMethodName);
            Graded graded = method.getAnnotation(Graded.class);
            score += graded.marks();
            score = Math.min(score, 100);
            result += graded.description() + " passed. Marks awarded: " + graded.marks() + "\n";
            serviceClasses.CSV.write(this.getClass().toString(), currentMethodName, graded.marks());
        }
    }
    
    @AfterAll
    public static void wrapUp() throws IOException {
        if (result.length() != 0) {
            result = result.substring(0, result.length() - 1); // remove the last "\n"
        }
        System.out.println(result);
        System.out.println("\nMarks for this file: " + score);
    }
    
}
