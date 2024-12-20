package prac_1220.studentgrade;

import java.util.ArrayList;
import java.util.List;

public class StudentManager {
    private List<Student> students;

    public StudentManager() {
        this.students = new ArrayList<>();
    }

    // 학생 목록 조회
    public void getStudentsList() {
        for (Student student : students) {
            System.out.println(student.toString());
        }
    }

    // 학생 추가
    public void addStudent(Student student) {
        students.add(student);
    }

    // 학생 검색
    public void searchStudent(String name) {
        for (Student student : students) {
            if(student.getName().equals(name)) {
                System.out.println(name + " 학생이 존재합니다.");
                return;
            }
        }

        System.out.println(name + " 학생은 존재하지 않습니다.");
    }

    // 전체 학생 정보 조회 (이름, 나이, 과목별 성적, 성적 평균)
    public void showStudentInfo() {
        for (Student student : students) {
            System.out.println("학생 이름 : " + student.getName());
            System.out.println("학생 나이 : " + student.getAge());
            System.out.println("과목별 성적 : " + student.getSubject());
            System.out.println("성적 평균 : " + student.calculateGradeAve());
        }
    }

    // 특정 학생의 정보 조회 (이름, 나이, 과목별 성적, 성적 평균)
    public void showStudentInfo(String name) {
        for (Student student : students) {
            if(student.getName().equals(name)) {
                System.out.println("학생 이름 : " + student.getName());
                System.out.println("학생 나이 : " + student.getAge());
                System.out.println("과목별 성적 : " + student.getSubject());
                System.out.println("성적 평균 : " + student.calculateGradeAve());

                return;
            }
        }
    }
}
