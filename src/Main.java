public class Main {

    public static void main(String[] args) {
        StudentManager manager = new StudentManager();

        Student student1 = new Student("홍길동", 23, "2026001");
        Student student2 = new Student("김철수", 25, "2026002");
        Student student3 = new Student("이영희", 22, "2026003");

        manager.addStudent(student1);
        manager.addStudent(student2);
        manager.addStudent(student3);

        manager.printAllStudents();
        manager.findStudentById("2026002");
    }
}