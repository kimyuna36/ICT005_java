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

public class TimelineTest { 

    @Test @Graded(description = "countTweets", marks = 2)
    public void testCountTweets() {
    	
    	Timeline timeline = generateTimelineNullTweets();
    	
	    	User user = UserTest.generateUser1(); // mic1511
	    	int expectedResult = 0;
	    	assertEquals(expectedResult, timeline.countTweets(user));
	    	
	    	user = null;
	    	expectedResult = 0;
	    	assertEquals(expectedResult, timeline.countTweets(user));
    	
    	timeline = generatePrintTimelineExample();
    	
	    	user = null;
	    	expectedResult = 0;
	    	assertEquals(expectedResult, timeline.countTweets(user));
	    	
	    	user = UserTest.generateUser1(); // mic1511
	    	expectedResult = 0;
	    	assertEquals(expectedResult, timeline.countTweets(user));
	    	
	    	user = UserTest.generateUser2(); // Janedoe
	    	expectedResult = 1;
	    	assertEquals(expectedResult, timeline.countTweets(user));
	    	
	    	user = UserTest.generateUser3(); // traveler
	    	expectedResult = 2;
	    	assertEquals(expectedResult, timeline.countTweets(user));
	    	
	    	user = UserTest.generateUser5(); // Charlie
	    	expectedResult = 0;
	    	assertEquals(expectedResult, timeline.countTweets(user));
	    
	    timeline = generateTimeline1();
	    
		    user = UserTest.generateUser1();
	    	expectedResult = 1;
	    	assertEquals(expectedResult, timeline.countTweets(user));
	    	
	    	user = UserTest.generateUser2();
	    	expectedResult = 2;
	    	assertEquals(expectedResult, timeline.countTweets(user));
	    	
	    	user = UserTest.generateUser3();
	    	expectedResult = 2;
	    	assertEquals(expectedResult, timeline.countTweets(user));
	    	
	    	user = UserTest.generateUser4();
	    	expectedResult = 0;
	    	assertEquals(expectedResult, timeline.countTweets(user));
	    	
	    	user = UserTest.generateUser5();
	    	expectedResult = 0;
	    	assertEquals(expectedResult, timeline.countTweets(user));
	    	
	    	user = UserTest.generateUser6();
	    	expectedResult = 0;
	    	assertEquals(expectedResult, timeline.countTweets(user));
	    	
        currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
    }
    
    @Test @Graded(description = "mostTweets", marks = 2)
    public void testMostTweets() {
    	
    	Timeline timeline = generateTimelineNullTweets();
    	User expectedUser = null;
    	assertEquals(expectedUser, timeline.mostTweets());
    	
    	timeline = generateTimelineNullTweets();
    	timeline.tweets = new Tweet[0];
    	expectedUser = null;
    	assertEquals(expectedUser, timeline.mostTweets());
    	
    	timeline = generatePrintTimelineExample();
    	expectedUser = TweetTest.user3;
    	assertEquals(expectedUser, timeline.mostTweets());
    	
    	timeline = generateTimeline1();
    	expectedUser = TweetTest.user2;
    	assertEquals(expectedUser, timeline.mostTweets());
    	
    	timeline = generateTimeline1();
    	timeline.tweets[0].poster = TweetTest.user3;
    	expectedUser = TweetTest.user3;
    	assertEquals(expectedUser, timeline.mostTweets());
    	
        currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
    }
    
    @Test @Graded(description = "mostActivity", marks = 2)
    public void testMostActivity() {
    	
    	// Generated tweets modified to fit assumption:
    	// "every User has made at least one Tweet, i.e. there are no Users who have ONLY made replies"
    	
    	Timeline timeline = generateTimelineNullTweets();
    	User expectedUser = null;
    	assertEquals(expectedUser, timeline.mostActivity());
    	
    	timeline = generateTimelineNullTweets();
    	timeline.tweets = new Tweet[0];
    	expectedUser = null;
    	assertEquals(expectedUser, timeline.mostActivity());
    	
    	timeline = generatePrintTimelineExample();
    	timeline.tweets[1].poster = TweetTest.user5;
    	timeline.tweets[2].replies[0].from = TweetTest.user5;
    	expectedUser = TweetTest.user5;
    	assertEquals(expectedUser, timeline.mostActivity());
    	
    	timeline.tweets[2].replies[0].from = TweetTest.user2;
    	timeline.tweets[0].replies[0].from = TweetTest.user2;
    	expectedUser = TweetTest.user2;
    	assertEquals(expectedUser, timeline.mostActivity());
    	
    	timeline = generateTimeline1();
    	timeline.tweets[3].poster = TweetTest.user5; 
    	timeline.tweets[4].poster = TweetTest.user4;
    	expectedUser = TweetTest.user2;
    	assertEquals(expectedUser, timeline.mostActivity());
    	
    	timeline.tweets[2].replies[0].from = TweetTest.user1;
    	timeline.tweets[2].replies[1].from = TweetTest.user1;
    	timeline.tweets[2].replies[2].from = TweetTest.user3;
    	expectedUser = TweetTest.user1;
    	assertEquals(expectedUser, timeline.mostActivity());
    	
        currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
    }
    
    @Test @Graded(description = "getAllTweetsByTimelineOwner", marks = 2)
    public void testGetAllTweetsByTimelineOwner() {
    	
    	Timeline timeline = generateTimelineNullTweets();
    	Tweet[] expected = null;
    	assertEquals(expected, timeline.getAllTweetsByTimelineOwner());
    	
    	timeline.owner = null;
    	expected = null;
    	assertEquals(expected, timeline.getAllTweetsByTimelineOwner());
    
    	timeline.tweets = new Tweet[0];
    	expected = null;
    	assertEquals(expected, timeline.getAllTweetsByTimelineOwner());
    	
    	timeline = generatePrintTimelineExample();
    	expected = new Tweet[0];
    	assertArrayEquals(expected, timeline.getAllTweetsByTimelineOwner());
    	
    	timeline.owner = TweetTest.user2;
    	expected = new Tweet[]{timeline.tweets[2]};
    	assertArrayEquals(expected, timeline.getAllTweetsByTimelineOwner());
    	
    	timeline.owner = TweetTest.user3;
    	expected = new Tweet[]{timeline.tweets[0], timeline.tweets[1]};
    	assertArrayEquals(expected, timeline.getAllTweetsByTimelineOwner());
    	
    	timeline.owner = TweetTest.user4;
    	expected = new Tweet[0];
    	assertArrayEquals(expected, timeline.getAllTweetsByTimelineOwner());
    	
    	timeline = generateTimeline1();
    	expected = new Tweet[]{timeline.tweets[2], timeline.tweets[4]};
    	assertArrayEquals(expected, timeline.getAllTweetsByTimelineOwner());
    	
    	timeline.tweets[0].poster = TweetTest.user3;
    	timeline.tweets[1].poster = TweetTest.user3;
    	expected = new Tweet[]{timeline.tweets[0], timeline.tweets[1], timeline.tweets[2], timeline.tweets[4]};
    	assertArrayEquals(expected, timeline.getAllTweetsByTimelineOwner());
    	
    	timeline = generateTimeline1();
    	timeline.owner = TweetTest.user2;
    	expected = new Tweet[]{timeline.tweets[1], timeline.tweets[3]};
    	assertArrayEquals(expected, timeline.getAllTweetsByTimelineOwner());
    	
    	timeline.owner = TweetTest.user3;
    	expected = new Tweet[]{timeline.tweets[2], timeline.tweets[4]};
    	assertArrayEquals(expected, timeline.getAllTweetsByTimelineOwner());
    	
        currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
    }
    
    @Test @Graded(description = "printTimeline", marks = 2)
    public void testPrintTimeline() {
    	
    	Timeline timeline = generateTimelineNullTweets();
    	String expectedResult = 
    		"""
    		Timeline Owner: mic1511
    		----------
    		
    		No tweets
		      
		    ----------
	        """;
    	assertEquals(expectedResult, timeline.printTimeline());
    	
    	timeline = generatePrintTimelineExample();
    	expectedResult = 
    		"""
    		Timeline Owner: mic1511
    		----------
    		
    		=> Poster: traveler
    		=> Message: This is the first message!!!! 
	      
		    Replying to @mic1511, @Janedoe, @traveler
		    This is a test message
		    Replying to @traveler, @Charlie, @Foodie
		    This is another test message!!!
		      
		    ----------
		      
		    => Poster: traveler
		    => Message: Wow this is the second Tweet in this timeline :O
		      
		    Replying to @mic1511, @Janedoe, @traveler
		    This is a test message
		    Replying to @traveler, @Charlie, @Foodie
		    This is another test message!!!
		    
		    ----------
		    
		    => Poster: Janedoe
		    => Message: Finally at the last one now
		    
		    Replying to no one
		    This is the last message in this Timeline
		    
		    ----------
	        """;
    	assertEquals(expectedResult, timeline.printTimeline());
    	
    	timeline = generateTimeline1();
    	expectedResult =
			"""		
			Timeline Owner: traveler
			----------
			
			=> Poster: mic1511
			=> Message: For me, it's the McChicken. The best fast food sandwich.
			
			Replying to @mic1511
			I even ask for extra #McChicken sauce packets and the staff is so friendly and more than willing to oblige. #restaurant #goals
			Replying to @mic1511, @Janedoe
			One time I asked for #mcchicken sauce packets and they gave me three.
			Replying to @mic1511, @Janedoe
			I said, "Wow, #three-for-free !" and the nice friendly McDonald's worker laughed and said, "I'm going to call you #3forfree !"
			Replying to @mic1511, @Janedoe
			Now the staff greets me with "hey it's #threeforfree !" and ALWAYS give me three packets.
			Replying to @Janedoe, @mic1511, @traveler
			It's such a fun and cool atmosphere at my local #McDonald's restaurant
			Replying to @mic1511
			I go there at least 3 times a week for lunch and a large iced coffee with milk instead of cream
			Replying to no one
			
			Replying to @Charlie, @Janedoe, @Samantha, @traveler
			I go to #McDonalds 1-2 times for breakfast on the weekend, and maybe once for dinner when I'm in a rush #aintnobodygottimeforthat
			Replying to @mic1511
			#great #place for a great meal that is affordable, fast, and can match my daily nutritional needs. #cheapEats #health
			Replying to @Charlie
			I even dip my fries in #McChicken sauce, it's delicious!
			Replying to @Janedoe, @mic1511
			What a great restaurant.
			
			----------
			
			=> Poster: Janedoe
			=> Message: I just discovered the best local burger joint. Their fries are to die for too!
			
			Replying to @Janedoe
			What's the name of the place? I'm always on the lookout for a good burger joint!
			Replying to @Janedoe, @mic1511
			Agreed! That place has the best burgers and fries in town.
			Replying to @Samantha
			Thanks for the recommendation! I'll have to check it out.
			Replying to @mic1511
			You won't regret it, trust me!
			Replying to @mic1511, @Samantha
			It's called Burger Bliss, give it a try!
			
			----------
			
			=> Poster: traveler
			=> Message: I just finished reading the most amazing book. Has anyone else read it?
			
			Replying to @traveler
			What book is it?
			Replying to @traveler, @Janedoe
			I've been looking for a good book to read. Tell us more!
			Replying to @Charlie
			It's called The Nightingale by Kristin Hannah. It's a must-read!
			Replying to @Janedoe, @Charlie
			It's a historical fiction set in France during World War II. It's a heart-wrenching story of two sisters and their experiences during the war.
			
			----------
			
			=> Poster: Janedoe
			=> Message: Just tried the new vegetarian burger at Burger King and it's amazing! #vegetarian #burgerking
			
			Replying to @Janedoe
			I've been meaning to try that! Is it made with a veggie patty or something else?
			Replying to @mic1511
			Yes, it's made with a plant-based patty and it's delicious! You should definitely try it.
			Replying to @mic1511
			I heard that Burger King's vegetarian options are some of the best out there. Can't wait to try it!
			Replying to @Janedoe
			I'm not even vegetarian and I love the new burger too! It's definitely worth a try.
			
			----------
			
			=> Poster: traveler
			=> Message: I love my new AirPods Pro! They're worth the investment. #airpodspro #apple
			
			Replying to @traveler
			Do they really cancel out noise as well as they claim? I've been thinking about getting a pair.
			Replying to @Janedoe
			Yes, they definitely do! It's amazing how much they block out. I highly recommend them.
			Replying to @traveler
			I've been thinking about getting a pair of those too! Glad to hear they're worth it.
			
			----------
	        """;
    	assertEquals(expectedResult, timeline.printTimeline());
    	
        currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
    }
    
    @Test @Graded(description = "countSearchResults", marks = 2)
    public void testCountSearchResults() {
    	
    	Timeline timeline = generateTimelineNullTweets();
    	String term = "message";
    	int expectedResult = 0;
    	assertEquals(expectedResult, timeline.countSearchResults(term));
    	
    	timeline = generatePrintTimelineExample();
    	term = "message";
    	expectedResult = 3;
    	assertEquals(expectedResult, timeline.countSearchResults(term));
    	term = "Tweet";
    	expectedResult = 1;
    	assertEquals(expectedResult, timeline.countSearchResults(term));
    	term = "!";
    	expectedResult = 2;
    	assertEquals(expectedResult, timeline.countSearchResults(term));
    	term = "tweet";
    	expectedResult = 0;
    	assertEquals(expectedResult, timeline.countSearchResults(term));
    	
        currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
    }
    
    @Test @Graded(description = "searchAll", marks = 2)
    public void testSearchAll() {
    	
    	Timeline timeline = generateTimelineNullTweets();
    	String term = "message";
    	Tweet[] expectedResult = null;
    	assertEquals(expectedResult, timeline.searchAll(term));
    	
    	timeline = generatePrintTimelineExample();
    	term = "message";
    	expectedResult = new Tweet[]{timeline.tweets[0], timeline.tweets[1], timeline.tweets[2]};
    	assertArrayEquals(expectedResult, timeline.searchAll(term));
    	term = "Tweet";
    	expectedResult = new Tweet[]{timeline.tweets[1]};;
    	assertArrayEquals(expectedResult, timeline.searchAll(term));
    	term = "!";
    	expectedResult = new Tweet[]{timeline.tweets[0], timeline.tweets[1]};
    	assertArrayEquals(expectedResult, timeline.searchAll(term));
    	term = "tweet";
    	expectedResult = new Tweet[0];
    	assertArrayEquals(expectedResult, timeline.searchAll(term));
    	term = "travel"; // search triggered by user handle
    	expectedResult = new Tweet[]{timeline.tweets[0], timeline.tweets[1]};
    	assertArrayEquals(expectedResult, timeline.searchAll(term));
    	
    	timeline = generateTimeline1();
    	term = "Sam";
    	expectedResult = new Tweet[]{timeline.tweets[0], timeline.tweets[1], timeline.tweets[3]};
    	assertArrayEquals(expectedResult, timeline.searchAll(term));
    	term = "A";
    	expectedResult = new Tweet[]{timeline.tweets[0], timeline.tweets[1], timeline.tweets[4]};
    	assertArrayEquals(expectedResult, timeline.searchAll(term));
    	term = "a";
    	expectedResult = new Tweet[]{timeline.tweets[0], timeline.tweets[1], timeline.tweets[2], timeline.tweets[3], timeline.tweets[4]};
    	assertArrayEquals(expectedResult, timeline.searchAll(term));
    	term = "plant-based patty";
    	expectedResult = new Tweet[]{timeline.tweets[3]};
    	assertArrayEquals(expectedResult, timeline.searchAll(term));
    	
    	timeline = generateTimeline1();
    	term = "Food";
    	timeline.tweets[1].replies[1].to[1] = TweetTest.user6;
    	timeline.tweets[4].replies[2].to[0] = TweetTest.user6;
    	expectedResult = new Tweet[]{timeline.tweets[1], timeline.tweets[4]};
    	assertArrayEquals(expectedResult, timeline.searchAll(term));
    	
    	timeline.tweets[3].replies[2].to[0] = TweetTest.user6;
    	expectedResult = new Tweet[]{timeline.tweets[1], timeline.tweets[3], timeline.tweets[4]};
    	assertArrayEquals(expectedResult, timeline.searchAll(term));

        currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
    }
    
    // VARIABLES & FUNCTIONS TO GENERATE DATA

    public static Timeline generateTimelineNullTweets() {
    	User owner = UserTest.generateUser1();
    	Tweet[] tweets = null;
		return new Timeline(owner, tweets);
    }
    
    public static Timeline generateTimeline1() {
        User owner = UserTest.generateUser3();
        Tweet[] tweets = {TweetTest.generateTweet1(), TweetTest.generateTweet2(), TweetTest.generateTweet3(), TweetTest.generateTweet4(), TweetTest.generateTweet5()};
        return new Timeline(owner, tweets);
    }
    
    public static Timeline generatePrintTimelineExample() {
    	User mic1511 = TweetTest.user1;
    	User Janedoe = TweetTest.user2;
    	User traveler = TweetTest.user3;
    	User Charlie = TweetTest.user5;
    	User Foodie = TweetTest.user6;
    	
        User owner = mic1511;
        Tweet[] tweets = new Tweet[3];
        
        tweets[0] = new Tweet(traveler,
        				"This is the first message!!!!",
        				new Reply[] {
        					new Reply(
    							Charlie,
    							new User[]{mic1511, Janedoe, traveler},
    							"This is a test message",
    							0),
        					new Reply(
    							Janedoe,
    							new User[]{traveler, Charlie, Foodie},
    							"This is another test message!!!",
    							0)
        				}, 0);
        
        tweets[1] = new Tweet(traveler,
						"Wow this is the second Tweet in this timeline :O",
						new Reply[] {
							new Reply(
								Charlie,
								new User[]{mic1511, Janedoe, traveler},
								"This is a test message",
								0),
							new Reply(
								Janedoe,
								new User[]{traveler, Charlie, Foodie},
								"This is another test message!!!",
								0)
						}, 0);
        		
        tweets[2] = new Tweet(Janedoe,
        				"Finally at the last one now",
        				new Reply[] {
        					new Reply(
        						Foodie,
        						new User[0],
        						"This is the last message in this Timeline",
        						0),
        				}, 0);
        
        return new Timeline(owner, tweets);
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
