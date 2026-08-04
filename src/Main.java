import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Student student1 = new Student("홍길동", 23, "2026001");
        Student student2 = new Student("김철수", 25, "2026002");
        Student student3 = new Student("이영희", 22, "2026003");

        ArrayList<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);
        students.add(student3);

        for (int i = 0; i < students.size(); i ++){
            Student student = students.get(i);
            student.printInfo();
        }
    }
}