import com.mohsin.MyMath;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyMathTest {

    private MyMath math = new MyMath();

    @Test
    void calculateSum_ThreeMemberArray() {
        var sum = math.calculateSum(new int[]{1, 2, 3});
        assertEquals(6, sum);
    }

    @Test
    void calculateSum_ZeroLengthArray() {
        var sum = math.calculateSum(new int[]{});
        assertEquals(0, sum);
    }
}
