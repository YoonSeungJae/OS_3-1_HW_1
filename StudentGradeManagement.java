import java.util.Scanner;

public class StudentGradeManagement {

    public static void main(String[] args) {

        // 5명의 학생을 저장할 배열 생성
        Student[] students = new Student[5];

        // 입력 받기
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            System.out.println("학번, 이름, 국어, 영어, 수학, 자바 점수를 입력하세요: ");
            String id = scanner.next();
            String name = scanner.next();
            int korean = scanner.nextInt();
            int english = scanner.nextInt();
            int math = scanner.nextInt();
            int java = scanner.nextInt();
            students[i] = new Student(id, name, korean, english, math, java);
        }

        // 출력
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println("|     학번     |    이름    |  국어  |  영어  |  수학  |  자바  | 총점 | 평균 | 학점 |");
        System.out.println("-------------------------------------------------------------------------");
        for (int i = 0; i < 5; i++) {
            students[i].printGrade();
        }
        System.out.println("---------------------------------------------------------------------------------");
    }
}

class Student {

    private String id;
    private String name;
    private int korean;
    private int english;
    private int math;
    private int java;
    private int total;
    private double average;
    private String grade;

    // 생성자
    public Student(String id, String name, int korean, int english, int math, int java) {
        this.id = id;
        this.name = name;
        this.korean = korean;
        this.english = english;
        this.math = math;
        this.java = java;
        this.total = korean + english + math + java;
        this.average = (double) total / 4;
        this.grade = getGrade(average);
    }

    // 평균 점수에 따른 학점 계산
    private String getGrade(double average) {
        if (average >= 90) {
            return "A";
        } else if (average >= 80) {
            return "B";
        } else if (average >= 70) {
            return "C";
        } else if (average >= 60) {
            return "D";
        } else {
            return "F";
        }
    }

    // 성적 정보 출력
    public void printGrade() {
        System.out.printf("|  %-12s|  %-10s|  %4d  |  %4d  |  %4d  |  %4d  |  %3d | %4.1f |    %s |\n", id, name, korean, english, math, java, total, average, grade);
    }
}