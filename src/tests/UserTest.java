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

public class UserTest { 

    @Test @Graded(description = "User", marks = 5)
    public void testUser() {
        User user = generateUser1();
        assertEquals("mic1511", user.handle);
        assertEquals("This is my bio :)", user.bio);
        assertArrayEquals(new String[] { "Bob" }, user.followers);
        assertArrayEquals(new String[] { "Obama" }, user.following);

        user = generateUser6();
        assertEquals("Foodie", user.handle);
        assertEquals(
                "I'm a food blogger and cookbook author. Follow me for recipes, restaurant reviews, and cooking tips!",
                user.bio);
        assertArrayEquals(new String[] {}, user.followers);
        assertArrayEquals(new String[] {}, user.following);
        
        currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
    }

    @Test @Graded(description = "moreFollowers", marks = 5)
    public void testMoreFollowers() {
        User user = generateUser2();
        assertEquals(1, user.moreFollowers());

        user = generateUser1();
        assertEquals(0, user.moreFollowers());

        user = generateUser4();
        assertEquals(1, user.moreFollowers());

        user = generateUser5();
        assertEquals(-1, user.moreFollowers());
        
        currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
    }
    
    // VARIABLES & FUNCTIONS TO GENERATE DATA
    
    public static User generateUser1() {
        String[] followers = new String[] { "Bob" };
        String[] following = new String[] { "Obama" };
        return new User("mic1511", "This is my bio :)", followers, following, true);
    }

    public static User generateUser2() {
        String[] followers = { "Alice", "Bob", "Charlie" };
        String[] following = { "Dave", "Ellen" };
        User user = new User("Janedoe", "Product manager at a tech startup.", followers, following, true);
        return user;
    }

    public static User generateUser3() {
        String bio = "I'm a travel enthusiast and photographer. Follow me for photos and stories from around the world!";
        User user = new User("traveler", bio, new String[0], new String[0], false);
        return user;
    }

    public static User generateUser4() {
        String[] followers = { "Johndoe", "Janedoe", "Alice", "Bob", "Charlie", "Dave", "Ellen", "Frank", "Grace",
                "Henry" };
        User user = new User("Samantha", "Tech journalist covering AI and machine learning.", followers, new String[0],
                true);
        return user;
    }

    public static User generateUser5() {
        String[] followers = { "Janedoe", "Alice" };
        String[] following = { "Johndoe", "Dave", "Bob" };
        User user = new User("Charlie", "Software engineer at a startup.", followers, following, false);
        return user;
    }

    public static User generateUser6() {
        String bio = "I'm a food blogger and cookbook author. Follow me for recipes, restaurant reviews, and cooking tips!";
        User user = new User("Foodie", bio, new String[0], new String[0], false);
        return user;
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
