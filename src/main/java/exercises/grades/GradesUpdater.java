package exercises.grades;

import java.util.Map;

public class GradesUpdater {
    public static Map<String, Integer> oldGrades = TestResults.getOriginalGrades();
    public static Map<String, Integer> newGrades = TestResults.getMakeUpGrades();

    public static void main(String[] args) {
        oldGrades.forEach((k, v) -> {
            if (newGrades.get(k) < v) {
                newGrades.put(k, v);
            }
        });

        System.out.println(newGrades);
    }
}

