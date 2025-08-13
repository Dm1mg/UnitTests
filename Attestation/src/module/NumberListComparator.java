package module;

import java.util.List;

public class NumberListComparator {
    public double calculateAverage(List<Double> numbers) {
        if (numbers == null || numbers.isEmpty()) {
            throw new IllegalArgumentException("Список не должен быть пустым");
        }

        double sum = 0;
        for (Double number : numbers) {
            sum += number;
        }
        return sum / numbers.size();
    }

    public String compareAverages(List<Double> list1, List<Double> list2) {
        double avg1 = calculateAverage(list1);
        double avg2 = calculateAverage(list2);

        if (avg1 > avg2) {
            return "Первый список имеет большее среднее значение";
        } else if (avg2 > avg1) {
            return "Второй список имеет большее среднее значение";
        } else {
            return "Средние значения равны";
        }
    }
}
