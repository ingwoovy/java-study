import java.util.ArrayList;
import java.util.List;

public class StudentManager {

    private List<Student> students = new ArrayList<>();

    private  Student findStudent(String studentId) {
        for (Student student : students) {
            if (studentId.equals(student.getStudentId())){
                return student;
            }
        }
        return null;
    }
    // 학생 추가  Create
    public void addStudent(Student student) {
        Student existingStudent = findStudent(student.getStudentId());

        if (existingStudent != null) {
            System.out.println("이미 존재하는 학번입니다.");
            return;
        }
        students.add(student);
        System.out.println("학생이 추가되었습니다.");
    }

    // 전체 학생 출력 Read
    public void printAllStudents() {
        if (students.isEmpty()) {
            System.out.println("등록된 학생이 없습니다.");
            return;
        }
        for (Student student : students) {
            student.printInfo();
        }
    }

    // 학생 검색 Read
    public void findStudentById(String searchStudentId) {
        Student student = findStudent(searchStudentId);

        if (student == null) {
            System.out.println("학생이 존재하지 않습니다.");
            return;
        }
        System.out.println("학생을 찾았습니다.");
        student.printInfo();
        }


    // 학생 정보 수정 Update
    public  void updateStudent(String studentId, String newName, int newAge) {
        Student student = findStudent(studentId);

        if (student == null) {
            System.out.println("학생이 존재하지 않습니다.");
            return;
        }
        student.updateInfo(newName, newAge);
        System.out.println("수정이 완료되었습니다.");
    }

    //학생 존재 여부
    public boolean existsStudent(String studentId) {
        return findStudent(studentId) != null;
    }

    // 학생 삭제 delete
    public void removeStudent(String studentId) {
        Student student = findStudent(studentId);

        if (student == null) {
            System.out.println("학생이 존재하지 않습니다.");
            return;
        }
        students.remove(student);
        System.out.println("학생이 삭제되었습니다.");
    }
}
