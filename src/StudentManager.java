import java.util.ArrayList;

public class StudentManager {

    ArrayList<Student> students = new ArrayList<>();

    // 학생 추가
    public void addStudent(Student student) {
        students.add(student);
    }

    // 전체 학생 출력
    public void printAllStudents() {
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            student.printInfo();
        }
    }

    // 학생 검색
    public void findStudentById(String searchStudentId) {

        boolean found = false;

        for (int i = 0; i < students.size(); i ++){
            Student student = students.get(i);

            if (searchStudentId.equals(student.studentId)) {
                found = true;
                System.out.println("학생을 찾았습니다.");
                student.printInfo();
                break;
            }
        }
        if (!found) {
            System.out.println("학생이 존재하지 않습니다.");
        }
    }

    //학생 삭제
    public void removeStudent(String studentId) {

        boolean found = false;

        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);

            if (studentId.equals(student.studentId)) {
                found = true;
                students.remove(i);
                System.out.println("학생이 삭제되었습니다.");
                break;
            }
        }
        if(!found) {
            System.out.println("학생이 존재하지 않습니다.");
        }
    }
}
