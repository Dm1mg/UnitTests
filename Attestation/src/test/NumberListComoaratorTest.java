package test;

import module.NumberListComparator;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SuppressWarnings("checkstyle:MissingJavadocType")
public class NumberListComoaratorTest {
    private final NumberListComparator comparator = new NumberListComparator();

    @SuppressWarnings("checkstyle:Indentation")
    @Test
    void testCalculateAverage_normalList() {
        List<Double> list = List.of(1.0, 2.0, 3.0);
        double avg = comparator.calculateAverage(list);
        assertEquals(2.0, avg);
    }

    @SuppressWarnings("checkstyle:Indentation")
    @Test
    void testCalculateAverage_throwsOnEmptyList() {
        List<Double> list = List.of();
        assertThrows(IllegalArgumentException.class, () -> comparator.calculateAverage(list));
    }

    @SuppressWarnings("checkstyle:Indentation")
    @Test
    void testCompareAverages_firstGreater() {
        List<Double> list1 = List.of(10.0, 20.0);
        List<Double> list2 = List.of(1.0, 2.0);
        String result = comparator.compareAverages(list1, list2);
        assertEquals("Первый список имеет большее среднее значение", result);
    }

    @SuppressWarnings("checkstyle:Indentation")
    @Test
    void testCompareAverages_secondGreater() {
        List<Double> list1 = List.of(1.0, 2.0);
        List<Double> list2 = List.of(10.0, 20.0);
        String result = comparator.compareAverages(list1, list2);
        assertEquals("Второй список имеет большее среднее значение", result);
    }

    @SuppressWarnings("checkstyle:Indentation")
    @Test
    void testCompareAverages_equal() {
        List<Double> list1 = List.of(5.0, 5.0);
        List<Double> list2 = List.of(5.0, 5.0);
        String result = comparator.compareAverages(list1, list2);
        assertEquals("Средние значения равны", result);
    }

}
