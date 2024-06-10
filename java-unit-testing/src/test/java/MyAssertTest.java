import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MyAssertTest {

    List<String> todos = Arrays.asList("AWS", "DevOps", "Spring Boot");

    @Test
    void test() {
        var result = todos.contains("AWS");
        var result2 = todos.contains("GCP");

        assertTrue(result);
        assertFalse(result2);
        assertEquals(3, todos.size());
        // assertNull();
        // assertNotNull();
        assertArrayEquals(new int[]{1, 2}, new int[]{1, 2});
    }
}
