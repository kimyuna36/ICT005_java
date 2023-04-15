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

public class TweetTest {

	@Test @Graded(description = "getReply", marks = 4)
	public void testGetReply() {

		Tweet tweet = generateTweetNullReplies();
		assertNull(tweet.getReply(0));
		assertNull(tweet.getReply(5));

		tweet = generateTweet1();
		Reply reply = tweet.replies[0];
		assertEquals(reply, tweet.getReply(0));
		reply = tweet.replies[5];
		assertEquals(reply, tweet.getReply(5));
		reply = tweet.replies[10];
		assertEquals(reply, tweet.getReply(10));
		assertNull(tweet.getReply(11));
		assertNull(tweet.getReply(-2));

		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "getMessage", marks = 4)
	public void testGetMessage() {

		Tweet tweet = generateTweetNullReplies();
		assertNull(tweet.getMessage(0));
		assertNull(tweet.getMessage(5));

		tweet = generateTweet1();
		String message = "I even ask for extra #McChicken sauce packets and the staff is so friendly and more than willing to oblige. #restaurant #goals";
		assertEquals(message, tweet.getMessage(0));
		message = "I go there at least 3 times a week for lunch and a large iced coffee with milk instead of cream";
		assertEquals(message, tweet.getMessage(5));
		message = "What a great restaurant.";
		assertEquals(message, tweet.getMessage(10));
		assertNull(tweet.getReply(11));
		assertNull(tweet.getReply(-2));

		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "totalViews", marks = 4)
	public void testTotalViews() {

		Tweet tweet = generateTweetNullReplies();
		assertEquals(0, tweet.totalViews());

		tweet = noNullReplies(generateTweet1());
		assertEquals(282, tweet.totalViews());

		tweet.views = 55;
		assertEquals(185, tweet.totalViews());

		tweet.replies[4].views = 18;
		assertEquals(193, tweet.totalViews());

		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "mostPopularReply", marks = 4)
	public void testMostPopularReply() {

		Tweet tweet = generateTweetNullReplies();
		assertNull(tweet.mostPopularReply());

		tweet = noNullReplies(generateTweet1());
		Reply mostPopularReply = tweet.replies[2];
		assertEquals(mostPopularReply, tweet.mostPopularReply());

		tweet.replies[7].views = 42;
		mostPopularReply = tweet.replies[7];
		assertEquals(mostPopularReply, tweet.mostPopularReply());

		tweet.replies[6].views = 42;
		mostPopularReply = tweet.replies[6];
		assertEquals(mostPopularReply, tweet.mostPopularReply());

		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "findReplyFrom", marks = 4)
	public void testFindReplyFrom() {

		Tweet tweet = generateTweetNullReplies();
		assertNull(tweet.findReplyFrom("testUser"));

		tweet = noNullReplies(generateTweet1());
		String posterHandle = UserTest.generateUser1().handle;
		String replyUser1Handle = UserTest.generateUser2().handle; 
		String replyUser2Handle = UserTest.generateUser3().handle; 
		String replyUser3Handle = UserTest.generateUser4().handle;
		String replyUser4Handle = UserTest.generateUser5().handle;

		Reply reply = tweet.replies[7];
		String testHandle = posterHandle;
		assertEquals(reply, tweet.findReplyFrom(testHandle));
		reply = tweet.replies[0];
		testHandle = replyUser1Handle;
		assertEquals(reply, tweet.findReplyFrom(testHandle));
		reply = tweet.replies[1];
		testHandle = replyUser2Handle;
		assertEquals(reply, tweet.findReplyFrom(testHandle));
		reply = tweet.replies[4];
		testHandle = replyUser3Handle;
		assertEquals(reply, tweet.findReplyFrom(testHandle));
		reply = tweet.replies[5];
		testHandle = replyUser4Handle;
		assertEquals(reply, tweet.findReplyFrom(testHandle));

		testHandle = "testUser";
		assertNull(tweet.findReplyFrom(testHandle));

		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "findReplyTo", marks = 4)
	public void testFindReplyTo() {

		Tweet tweet = generateTweetNullReplies();
		assertNull(tweet.findReplyTo("testUser"));

		tweet = noNullReplies(generateTweet1());
		String posterHandle = UserTest.generateUser1().handle;
		String replyUser1Handle = UserTest.generateUser2().handle; 
		String replyUser2Handle = UserTest.generateUser3().handle; 
		String replyUser3Handle = UserTest.generateUser4().handle;
		String replyUser4Handle = UserTest.generateUser5().handle;

		Reply reply = tweet.replies[0];
		String testHandle = posterHandle;
		assertEquals(reply, tweet.findReplyTo(testHandle));
		reply = tweet.replies[1];
		testHandle = replyUser1Handle;
		assertEquals(reply, tweet.findReplyTo(testHandle));
		reply = tweet.replies[4];
		testHandle = replyUser2Handle;
		assertEquals(reply, tweet.findReplyTo(testHandle));
		reply = tweet.replies[7];
		testHandle = replyUser3Handle;
		assertEquals(reply, tweet.findReplyTo(testHandle));
		reply = tweet.replies[7];
		testHandle = replyUser4Handle;
		assertEquals(reply, tweet.findReplyTo(testHandle));

		// swap replies[0] and replies[7]
		Reply temp = tweet.replies[0];
		tweet.replies[0] = tweet.replies[7];
		tweet.replies[7] = temp;

		reply = tweet.replies[0];
		testHandle = replyUser1Handle;
		assertEquals(reply, tweet.findReplyTo(testHandle));
		testHandle = replyUser2Handle;
		assertEquals(reply, tweet.findReplyTo(testHandle));
		testHandle = replyUser3Handle;
		assertEquals(reply, tweet.findReplyTo(testHandle));
		testHandle = replyUser4Handle;
		assertEquals(reply, tweet.findReplyTo(testHandle));

		testHandle = "testUser";
		assertNull(tweet.findReplyTo(testHandle));

		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "getHashtags", marks = 4)
	public void testGetHashtags() {

		// Re-uses the replies from generateTweet1() as standalone tweets for further testing
		Tweet tweet = generateTweetNullReplies();
		tweet.message = null;
		String[] expectedResult = new String[0];
		assertArrayEquals(expectedResult, tweet.getHashtags());

		tweet = noNullReplies(generateTweet1());
		expectedResult = new String[]{};
		assertArrayEquals(expectedResult, tweet.getHashtags());

		// change the Tweet message to the first reply's message
		tweet.message = tweet.replies[0].message;
		expectedResult = new String[]{"#restaurant", "#goals"};
		assertArrayEquals(expectedResult, tweet.getHashtags());

		tweet.message = tweet.replies[1].message;
		expectedResult = new String[]{"#mcchicken"};
		assertArrayEquals(expectedResult, tweet.getHashtags());

		tweet.message = tweet.replies[2].message;
		expectedResult = new String[]{};
		assertArrayEquals(expectedResult, tweet.getHashtags());

		tweet.message = tweet.replies[3].message;
		expectedResult = new String[]{"#threeforfree"};
		assertArrayEquals(expectedResult, tweet.getHashtags());

		tweet.message = tweet.replies[4].message;
		expectedResult = new String[]{};
		assertArrayEquals(expectedResult, tweet.getHashtags());

		tweet.message = tweet.replies[5].message;
		expectedResult = new String[]{};
		assertArrayEquals(expectedResult, tweet.getHashtags());

		tweet.message = tweet.replies[6].message;
		expectedResult = new String[]{};
		assertArrayEquals(expectedResult, tweet.getHashtags());

		tweet.message = tweet.replies[7].message;
		expectedResult = new String[]{"#aintnobodygottimeforthat"};
		assertArrayEquals(expectedResult, tweet.getHashtags());

		tweet.message = tweet.replies[8].message;
		expectedResult = new String[]{"#great", "#place", "#health"};
		assertArrayEquals(expectedResult, tweet.getHashtags());

		tweet.message = tweet.replies[9].message;
		expectedResult = new String[]{};
		assertArrayEquals(expectedResult, tweet.getHashtags());

		tweet.message = tweet.replies[10].message;
		expectedResult = new String[]{};
		assertArrayEquals(expectedResult, tweet.getHashtags());

		tweet.message = "#a #b #cd #efgh #ij #klmno #P #qr-s #tuv #w&x #y #z";
		expectedResult = new String[]{"#a", "#b", "#cd", "#efgh", "#ij", "#klmno", "#tuv", "#y", "#z"};
		assertArrayEquals(expectedResult, tweet.getHashtags());

		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	// VARIABLES & FUNCTIONS TO GENERATE DATA

	public static Tweet generateTweetNullReplies() {
		User poster = UserTest.generateUser2();
		String message = "LOL gg";
		Reply[] replies = null;
		int views = 0;
		return new Tweet(poster, message, replies, views);
	}
	
	static User user1 = UserTest.generateUser1();
	static User user2 = UserTest.generateUser2();
	static User user3 = UserTest.generateUser3();
	static User user4 = UserTest.generateUser4();
	static User user5 = UserTest.generateUser5();
	static User user6 = UserTest.generateUser6();

	public static Tweet generateTweet1() {
		User poster = user1;
		String message = "For me, it's the McChicken. The best fast food sandwich.";
		Reply[] replies = new Reply[11];
		replies[0] = new Reply(user2, new User[]{poster}, "I even ask for extra #McChicken sauce packets and the staff is so friendly and more than willing to oblige. #restaurant #goals", 25);
		replies[1] = new Reply(user3, new User[]{poster, user2}, "One time I asked for #mcchicken sauce packets and they gave me three.", 16);
		replies[2] = new Reply(user3, new User[]{poster, user2}, "I said, \"Wow, #three-for-free !\" and the nice friendly McDonald's worker laughed and said, \"I'm going to call you #3forfree !\"", 30);
		replies[3] = new Reply(user3, new User[]{poster, user2}, "Now the staff greets me with \"hey it's #threeforfree !\" and ALWAYS give me three packets.", 12);
		replies[4] = new Reply(user4, new User[]{user2, poster, user3}, "It's such a fun and cool atmosphere at my local #McDonald's restaurant", 10);
		replies[5] = new Reply(user5, new User[]{poster}, "I go there at least 3 times a week for lunch and a large iced coffee with milk instead of cream", 8);
		replies[6] = new Reply(new User("", "", new String[0], new String[0], false), new User[0], "", 0);
		replies[7] = new Reply(poster, new User[]{user5, user2, user4, user3}, "I go to #McDonalds 1-2 times for breakfast on the weekend, and maybe once for dinner when I'm in a rush #aintnobodygottimeforthat", 11);
		replies[8] = new Reply(user5, new User[]{poster}, "#great #place for a great meal that is affordable, fast, and can match my daily nutritional needs. #cheapEats #health", 6);
		replies[9] = new Reply(user2, new User[]{user5}, "I even dip my fries in #McChicken sauce, it's delicious!", 7);
		replies[10] = new Reply(user5, new User[]{user2, poster}, "What a great restaurant.", 5);	
		int views = 152;
		return new Tweet(poster, message, replies, views);
	}

	public static Tweet noNullReplies(Tweet t) {
		for(int i = 0; i < t.replies.length; i++) {
			if(t.replies[i] == null) {
				t.replies[i] = new Reply(new User("", "", new String[0], new String[0], false), new User[0], "", 0);
			}
		}
		return t;
	}
	
	// Used in TimelineTest.java

	public static Tweet generateTweet2() {
		User poster = user2;
		String message = "I just discovered the best local burger joint. Their fries are to die for too!";
		Reply[] replies = new Reply[5];
		replies[0] = new Reply(user1, new User[]{poster}, "What's the name of the place? I'm always on the lookout for a good burger joint!", 10);
		replies[1] = new Reply(user4, new User[]{poster, user1}, "Agreed! That place has the best burgers and fries in town.", 8);
		replies[2] = new Reply(user1, new User[]{user4}, "Thanks for the recommendation! I'll have to check it out.", 5);
		replies[3] = new Reply(user4, new User[]{user1}, "You won't regret it, trust me!", 3);
		replies[4] = new Reply(poster, new User[]{user1, user4}, "It's called Burger Bliss, give it a try!", 6);
		int views = 87;
		return new Tweet(poster, message, replies, views);
	}

	public static Tweet generateTweet3() {
		User poster = user3;
		String message = "I just finished reading the most amazing book. Has anyone else read it?";
		Reply[] replies = new Reply[4];
		replies[0] = new Reply(user2, new User[]{poster}, "What book is it?", 6);
		replies[1] = new Reply(user5, new User[]{poster, user2}, "I've been looking for a good book to read. Tell us more!", 5);
		replies[2] = new Reply(user2, new User[]{user5}, "It's called The Nightingale by Kristin Hannah. It's a must-read!", 8);
		replies[3] = new Reply(poster, new User[]{user2, user5}, "It's a historical fiction set in France during World War II. It's a heart-wrenching story of two sisters and their experiences during the war.", 12);
		int views = 63;
		return new Tweet(poster, message, replies, views);
	}
	
	public static Tweet generateTweet4() {
	    User poster = user2;
	    String message = "Just tried the new vegetarian burger at Burger King and it's amazing! #vegetarian #burgerking";
	    Reply[] replies = new Reply[4];
	    replies[0] = new Reply(user1, new User[]{poster}, "I've been meaning to try that! Is it made with a veggie patty or something else?", 9);
	    replies[1] = new Reply(poster, new User[]{user1}, "Yes, it's made with a plant-based patty and it's delicious! You should definitely try it.", 13);
	    replies[2] = new Reply(user3, new User[]{user1}, "I heard that Burger King's vegetarian options are some of the best out there. Can't wait to try it!", 6);
	    replies[3] = new Reply(user4, new User[]{poster}, "I'm not even vegetarian and I love the new burger too! It's definitely worth a try.", 4);
	    int views = 75;
	    return new Tweet(poster, message, replies, views);
	}
	
	public static Tweet generateTweet5() {
	    User poster = user3;
	    String message = "I love my new AirPods Pro! They're worth the investment. #airpodspro #apple";
	    Reply[] replies = new Reply[3];
	    replies[0] = new Reply(user2, new User[]{poster}, "Do they really cancel out noise as well as they claim? I've been thinking about getting a pair.", 14);
	    replies[1] = new Reply(poster, new User[]{user2}, "Yes, they definitely do! It's amazing how much they block out. I highly recommend them.", 8);
	    replies[2] = new Reply(user1, new User[]{poster}, "I've been thinking about getting a pair of those too! Glad to hear they're worth it.", 5);
	    int views = 125;
	    return new Tweet(poster, message, replies, views);
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
