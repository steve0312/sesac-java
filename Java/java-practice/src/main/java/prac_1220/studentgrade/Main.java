package prac_1220.studentgrade;

public class Main {
    public static void main(String[] args) {
        Student student1 = new Student ("상호", 20);

        // 학생이 수강한 과목과 성적 저장
        student1.setSubjectGrade("영어", 90);
        student1.setSubjectGrade("수학", 100);
        student1.setSubjectGrade("과학", 95);

        Student student2 = new Student("재만", 25);

        // 학생이 수강한 과목과 성적 저장
        student2.setSubjectGrade("국어", 100);
        student2.setSubjectGrade("수학", 85);
        student2.setSubjectGrade("사회", 80);

        StudentManager studentManager = new StudentManager();

        // 학생 추가
        studentManager.addStudent(student1);
        studentManager.addStudent(student2);

        // 학생 검색
        studentManager.searchStudent("상호");
        studentManager.searchStudent("태영");
        System.out.println();

        // 학생들 목록 조회
        studentManager.getStudentsList();
        System.out.println();
        // 학생들 정보 조회
        studentManager.showStudentInfo();
        System.out.println();
        // 특정 학생 정보 조회
        studentManager.showStudentInfo("상호");
    }
}
