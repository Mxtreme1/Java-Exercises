package filesystem;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.regex.Pattern;

import static org.junit.Assert.*;

public class ExampleTests {

    @Test
    public void test1() {
        FSTree tree = FSTrees.empty()
                        .createFile(Arrays.asList("home", "fennell", "Desktop"),
                                    new Document("Greeting", "Hello World"))
                        .createFile(Arrays.asList("home", "fennell"),
                                    new Document("Greeting2", "Hello again, World"))
                        .createFile(Arrays.asList("home", "fennell", "Desktop"),
                                    new Document("PhoneBook", "Lu: 2038053"));

        assertEquals(40, tree.getSize());
        assertSetEquals(Arrays.asList(
               new Document("Greeting", "Hello World"),
               new Document("Greeting2", "Hello again, World")),
               tree.find(Pattern.compile("Greeting[0-9]?")));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFail() {
        FSTree tree = FSTrees.empty()
                             .createFile(Arrays.asList("home", "fennell", "Desktop"),
                                         new Document("Greeting", "Hello World"))
                             .createFile(Arrays.asList("home", "fennell"),
                                         new Document("Greeting2", "Hello again, World"))
                             .createFile(Arrays.asList("home", "fennell", "Desktop"),
                                         new Document("PhoneBook", "Lu: 2038053"));

       tree.createFile(Arrays.asList("home", "fennell", "Desktop", "Greeting", "subdir"),
                       new Document("File", "content"));
    }

    private <T> void assertSetEquals(Collection<T> expected, Collection<T> actual) {
        assertEquals(new HashSet<>(expected), new HashSet<>(actual));
    }


}