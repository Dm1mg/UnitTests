package seminars.third.coverage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class SomeServiceTest {
    private SomeService someService;
    @BeforeEach
    void setUp(){someService = new SomeService();}

   // 3.1.
    @ParameterizedTest
    @ValueSource(ints = {3,6,9,33})
    void multipleThreeNotFiveReturnsFizz(int n) {
        assertEquals("Fizz", someService.fizzBuzz(n));
    }

    @ParameterizedTest
    @ValueSource (ints = {5, 10, 20, 55})
    void multipleFiveNotThreeReturnsBuzz(int n) {assertEquals("Buzz", someService.fizzBuzz(n)); }


    @ParameterizedTest
    @ValueSource (ints = {15, 225, 3375})
    void multipleThreeAndFiveReturnsFizzBuzz(int n){assertEquals("FizzBuzz", someService.fizzBuzz(n));}


    @ParameterizedTest
    @ValueSource (ints = {1, 2, 41, 43})
    void notMultipleOfThreeofFiveReturnsNumber(int n){assertEquals(Integer.toString(n), someService.fizzBuzz(n));}


    @Test
    void first6ReturnTrue(){ assertTrue(someService.firstLast6(new int[]{6,3,4,3}));}
    @Test
    void last6ReturnTrue(){ assertTrue(someService.firstLast6(new int[]{2,34,4,6}));}
    @Test
    void noFirstLast6ReturnFalse(){ assertFalse(someService.firstLast6(new int[]{2,34,4,5}));}


    @Test
    void insufficientCoverageTest(){
        System.out.println(someService.calculatingDiscount(2000, 10));
        assertThat(someService.calculatingDiscount(2000, 50)).isEqualTo(1000);
        assertThat(someService.calculatingDiscount(2000, 100)).isEqualTo(0);
        assertThat(someService.calculatingDiscount(2000, 0)).isEqualTo(2000);

        assertThatThrownBy(() ->
               someService.calculatingDiscount(2000, 110))
               .isInstanceOf(ArithmeticException.class)
               .hasMessage("Скидка должна быть в диапазоне от 0 до 100%");

        assertThatThrownBy(() ->
                someService.calculatingDiscount(2000, -10))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Скидка должна быть в диапазоне от 0 до 100%");

        assertThatThrownBy(() ->
                someService.calculatingDiscount(-2000, 10))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Сумма покупки не может быть отрицательной");
    }

    @Test
    void calculatingCorrectDiscount(){
        assertThat(someService.calculatingDiscount(1000, 25)).isEqualTo(750);
        assertThat(someService.calculatingDiscount(1000, 100)).isEqualTo(0);
        assertThat(someService.calculatingDiscount(1000, 0)).isEqualTo(1000);
    }

    @Test
    void negativePurchaseAmountException(){
        assertThatThrownBy(() -> someService.calculatingDiscount(-1000, 50))
                .isInstanceOf(ArithmeticException.class).hasMessage("Сумма покупки не может быть отрицательной");
    }

    @Test
    void negativePurchaseDiscountException(){
        assertThatThrownBy(() -> someService.calculatingDiscount(1000, -50))
                .isInstanceOf(ArithmeticException.class).hasMessage("Скидка должна быть в диапазоне от 0 до 100%");
    }

    @Test
    void discountMore100Exception(){
        assertThatThrownBy(() -> someService.calculatingDiscount(1000, 101))
                .isInstanceOf(ArithmeticException.class).hasMessage("Скидка должна быть в диапазоне от 0 до 100%");
    }

    @Test
    void correctLuckySum(){
        assertThat(someService.luckySum(13, 1,1)).isEqualTo(2);
        assertThat(someService.luckySum(1, 13,1)).isEqualTo(2);
        assertThat(someService.luckySum(1, 1,13)).isEqualTo(2);

        assertThat(someService.luckySum(13, 13,1)).isEqualTo(1);
        assertThat(someService.luckySum(1, 13,13)).isEqualTo(1);
        assertThat(someService.luckySum(13, 1,13)).isEqualTo(1);

        assertThat(someService.luckySum(13, 13,13)).isEqualTo(0);
    }

    //HomeWork
    @Test
    void oddNumberTrue(){
        assertTrue(someService.evenOddNumber(-2));
        assertTrue(someService.evenOddNumber(2));
        assertTrue(someService.evenOddNumber(0));
    }

    @Test
    void oddNumberFalse(){
        assertFalse(someService.evenOddNumber(-1));
        assertFalse(someService.evenOddNumber(1));
    }

    //HomeWork
    @Test
    void numberInIntervalTrue(){
        assertTrue(someService.numberInInterval(25));
        assertTrue(someService.numberInInterval(75));
        assertTrue(someService.numberInInterval(100));
    }

    @Test
    void numberInIntervalFalse(){
        assertFalse(someService.numberInInterval(24));
        assertFalse(someService.numberInInterval(-75));
        assertFalse(someService.numberInInterval(101));
    }
}

