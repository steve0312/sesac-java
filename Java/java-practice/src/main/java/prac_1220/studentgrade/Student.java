package prac_1220.studentgrade;

import java.util.HashMap;
import java.util.Map;

public class Student {
    private String name;
    private int age;
    private Map<String, Integer> subjects;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
        this.subjects = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // 과목별 성적 저장
    public void setSubjectGrade(String subjectName, int subjectGrade) {
        subjects.put(subjectName, subjectGrade);
    }

    // 과목 조회
    public Map<String, Integer> getSubject() {
        return subjects;
    }

    // 성적의 평균 계산
    public double calculateGradeAve() {
        int sum = 0;

        for (String key : subjects.keySet()) {
            sum += subjects.get(key);
        }

        return (double) sum / subjects.size();
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }
}
