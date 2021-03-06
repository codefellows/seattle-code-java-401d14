/*
 * This Java source file was generated by the Gradle 'init' task.
 */
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class LibraryTest {
    @Test public void testSomeLibraryMethod() {
        Library classUnderTest = new Library();
        assertTrue("someLibraryMethod should return 'true'", classUnderTest.someLibraryMethod());
    }

    @Test
    public void testReverseArray() {
        String[] animals = {"cat", "dog"};
        String[] reversedAnimals = Library.reverse(animals);
        // dog is the first item
        // cat is the second item
        // the size is 2
        assertEquals("reversed animals should have dog first", animals[1], reversedAnimals[0]);
        assertEquals("reversed animals should have cat second", animals[0], reversedAnimals[1]);
        assertEquals("reversed animals should have the same size as animals", animals.length, reversedAnimals.length);
    }

    @Test
    public void testReverseArrayList() {
        ArrayList<String> animals = new ArrayList<>();
        animals.add("cat");
        animals.add("dog");
        ArrayList<String> reversedAnimals = Library.reverse(animals);
        // dog is the first item
        // cat is the second item
        // the size is 2
        assertEquals("reversed animals should have dog first", animals.get(1), reversedAnimals.get(0));
        assertEquals("reversed animals should have cat second", animals.get(0), reversedAnimals.get(1));
        assertEquals("reversed animals should have the same size as animals", animals.size(), reversedAnimals.size());
    }
}
