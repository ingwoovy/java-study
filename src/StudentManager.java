import java.util.ArrayList;

public class StudentManager {

    private ArrayList<Student> students = new ArrayList<>();

    // 학생 추가  Create
    public void addStudent(Student student) {
        for (int i = 0; i < students.size(); i ++) {
            Student existingStudent = students.get(i);
            if (student.getStudentId().equals(existingStudent.getStudentId())){
                System.out.println("이미 존재하는 학번입니다.");
                return;
            }
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
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            student.printInfo();
        }
    }

    // 학생 검색 Read
    public void findStudentById(String searchStudentId) {

        boolean found = false;

        for (int i = 0; i < students.size(); i ++){
            Student student = students.get(i);

            if (searchStudentId.equals(student.getStudentId())) {
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

    // 학생 정보 수정 Update
    public  void updateStudent( String studentId, String newName, int newAge) {
        boolean found = false;

        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);

            if (studentId.equals(student.getStudentId())) {
                student.updateInfo(newName, newAge);

                found = true;

                System.out.println("수정이 완료되었습니다.");
                break;
            }
        }
        if (!found) {
            System.out.println("학생이 존재하지 않습니다.");
        }
    }

    // 학생 삭제 delete
    public void removeStudent(String studentId) {

        boolean found = false;

        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);

            if (studentId.equals(student.getStudentId())) {
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
