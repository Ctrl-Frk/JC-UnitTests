import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class TaxSystemTest {

    @Test
    public void testNegativeTaxEarningsMinusSpendings() {
        //arrange
        int expected = 0;

        //act
        int result = TaxSystem.taxEarningsMinusSpendings(-1000, -500);

        //assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testTaxEarnings() {
        //arrange
        int expected = 300;

        //act
        int result = TaxSystem.taxEarnings(5000);

        //assert
        Assertions.assertEquals(expected, result);
    }


    @ParameterizedTest
    @MethodSource("methodSource")
    public void testCompareTax(int tax15, int tax6, int expected) {
        //act
        int result = TaxSystem.compareTax(tax15, tax6);

        //assert
        Assertions.assertEquals(expected, result);
    }

    public static Stream<Arguments> methodSource() {
        return Stream.of(
                Arguments.of(500, 1000, -1),
                Arguments.of(1000, 500, 1),
                Arguments.of(300, 300, 0)
        );
    }
}
