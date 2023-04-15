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

public class ReplyTest {
	
	// Used in assertions (not modified / passed into the functions)
	User unknownUser = new User("unknown", "", new String[0], new String[0], false);
	User user1 = UserTest.generateUser1();
	User user2 = UserTest.generateUser2();
	User user3 = UserTest.generateUser3();
	User user4 = UserTest.generateUser4();
	User user5 = UserTest.generateUser5();
	User user6 = UserTest.generateUser6();

    @Test @Graded(description = "ReplyUserString", marks = 5)
    public void testReplyUserString() {
    	Reply reply = generateReply1();
    	String[] toUsers = reply.toUsersToString(); 
    	assertEquals(user1.toString(), reply.from.toString());
    	assertArrayEquals(new String[] {user2.toString(), user3.toString()}, toUsers);
    	assertEquals("Hello, how are you doing today?", reply.message);
    	assertEquals(0, reply.views);
        
        reply = generateReply2();
        toUsers = reply.toUsersToString(); 
        assertTrue(user3.toString().equals(reply.from.toString()));
        assertArrayEquals(new String[] {user1.toString()}, toUsers);
        assertTrue("Thanks for asking, I'm doing well. How about you?".equals(reply.message));
        assertEquals(0, reply.views);
        
        reply = generateReply3();
        toUsers = reply.toUsersToString();
        assertTrue(user2.toString().equals(reply.from.toString()));
        assertArrayEquals(new String[] {}, toUsers);
        assertTrue("Thanks for asking, I'm doing well. How about you?".equals(reply.message));
        assertEquals(0, reply.views);
        
        reply = generateReply4();
        toUsers = reply.toUsersToString();
        assertTrue(user4.toString().equals(reply.from.toString()));
        assertArrayEquals(new String[] {user2.toString(), user4.toString(), user5.toString(), user6.toString()}, toUsers);
        assertTrue("I think the answer is 42.".equals(reply.message));
        assertEquals(0, reply.views);
        
        reply = generateReply6();
        toUsers = reply.toUsersToString();
        assertTrue(user4.toString().equals(reply.from.toString()));
        assertArrayEquals(new String[] {user2.toString(), user2.toString(), user6.toString()}, toUsers);
        assertTrue("Great point, thanks for sharing! I completely agree with your perspective on this issue.".equals(reply.message));
        assertEquals(0, reply.views);
        
        currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
    }

    @Test @Graded(description = "ReplyString", marks = 5)
    public void testReplyString() {
    	Reply reply = generateReply5();
    	String[] toUsers = reply.toUsersToString();
        assertEquals(unknownUser.toString(), reply.from.toString());
        assertArrayEquals(new String[] {}, toUsers);
        assertEquals("This is a test reply.", reply.message);
        assertEquals(0, reply.views);
        
        currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
    }
    
    @Test @Graded(description = "compareTo", marks = 5)
    public void testCompareTo() {
        assertEquals(-1, generateReply1().compareTo(generateReply2()));
        assertEquals(-1, generateReply1().compareTo(generateReply3()));
        assertEquals(1, generateReply2().compareTo(generateReply1()));
        assertEquals(1, generateReply3().compareTo(generateReply1()));
    	
        assertEquals(-1, generateReply5().compareTo(generateReply4()));
        assertEquals(1, generateReply4().compareTo(generateReply5()));
        
        assertEquals(1, generateReply6().compareTo(generateReply1()));
        assertEquals(1, generateReply6().compareTo(generateReply2()));
        assertEquals(1, generateReply6().compareTo(generateReply3()));
        assertEquals(1, generateReply6().compareTo(generateReply4()));
        assertEquals(1, generateReply6().compareTo(generateReply5()));
        assertEquals(1, generateReply6().compareTo(generateReply7()));
        
        assertEquals(-1, generateReply1().compareTo(generateReply6()));
        assertEquals(-1, generateReply2().compareTo(generateReply6()));
        assertEquals(-1, generateReply3().compareTo(generateReply6()));
        assertEquals(-1, generateReply4().compareTo(generateReply6()));
        assertEquals(-1, generateReply5().compareTo(generateReply6()));
        assertEquals(-1, generateReply7().compareTo(generateReply6()));
    	
    	assertEquals(0, generateReply1().compareTo(generateReply7()));
    	assertEquals(0, generateReply2().compareTo(generateReply3()));
    	assertEquals(0, generateReply3().compareTo(generateReply2()));
        currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
    }
    
    @Test @Graded(description = "modifyMessage", marks = 5)
    public void testModifyMessage() {
        Reply testReply = generateReply1();
        testReply.message = "Hello, how are you doing today? Goodbye";
        Reply modifiedReply = generateReply1();
        modifiedReply.modifyMessage(1, "Goodbye");
        assertEquals(testReply.toString(), modifiedReply.toString());
        
        testReply = generateReply1();
        modifiedReply = generateReply1();
        modifiedReply.message = "Hello, Hello! how Hello! are you Hello! doing today? Hello!";
        modifiedReply.modifyMessage(2, " Hello!");
        assertEquals(testReply.toString(), modifiedReply.toString());
        
        testReply = generateReply1();
        testReply.message = "[This reply has been removed]";
        modifiedReply = generateReply1();
        modifiedReply.modifyMessage(3, " Hello!");
        assertEquals(testReply.toString(), modifiedReply.toString());
        
        testReply = generateReply2();
        modifiedReply = generateReply2();
        modifiedReply.modifyMessage(2, "not");
        assertEquals(testReply.toString(), modifiedReply.toString());
        
        testReply = generateReply2();
        testReply.message = "[This reply has been removed]";
        modifiedReply = generateReply2();
        modifiedReply.modifyMessage(3, "placeholder");
        assertEquals(testReply.toString(), modifiedReply.toString());
        
        testReply = generateReply5();
        testReply.message = "This is a test reply. STOP.";
        modifiedReply = generateReply5();
        modifiedReply.modifyMessage(1, "STOP.");
        assertEquals(testReply.toString(), modifiedReply.toString());
        
        currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
    }
    
    // VARIABLES & FUNCTIONS TO GENERATE DATA

    public static Reply generateReply1() {
        User from = UserTest.generateUser1();
        User[] to = {UserTest.generateUser2(), UserTest.generateUser3()};
        String message = "Hello, how are you doing today?";
        return new Reply(from, to, message);
    }

    public static Reply generateReply2() {
        User from = UserTest.generateUser3();
        User[] to = {UserTest.generateUser1()};
        String message = "Thanks for asking, I'm doing well. How about you?";
        return new Reply(from, to, message);
    }
    
    public static Reply generateReply3() {
        User from = UserTest.generateUser2();
        User[] to = {};
        String message = "Thanks for asking, I'm doing well. How about you?";
        return new Reply(from, to, message);
    }

    public static Reply generateReply4() {
        User from = UserTest.generateUser4();
        User[] to = {UserTest.generateUser2(), UserTest.generateUser4(), UserTest.generateUser5(), UserTest.generateUser6()};
        String message = "I think the answer is 42.";
        return new Reply(from, to, message);
    }

    public static Reply generateReply5() {
        String message = "This is a test reply.";
        return new Reply(message);
    }
    
    public static Reply generateReply6() {
    	User from = UserTest.generateUser4();
        User[] to = {UserTest.generateUser2(), UserTest.generateUser2(), UserTest.generateUser6()};
        String message = "Great point, thanks for sharing! I completely agree with your perspective on this issue.";
        return new Reply(from, to, message);
    }

    public static Reply generateReply7() {
        User from = UserTest.generateUser5();
        User[] to = {UserTest.generateUser6(), UserTest.generateUser1(), UserTest.generateUser2()};
        String message = "abcde, fghi jk lmn opqrst uvwxy";
        return new Reply(from, to, message);
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
