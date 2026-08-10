import java.util.HashMap;
import java.util.Map;

public class StudentManager {

    private Map<String, Student> studentMap = new HashMap<>();

    private  Student findStudent(String studentId) {
                return studentMap.get(studentId);
    }

    // 학생 추가  Create
    public void addStudent(Student student) {

        if (studentMap.containsKey(student.getStudentId())) {
            System.out.println("이미 존재하는 학번입니다.");
            return;
        }
        studentMap.put(student.getStudentId(),student);
        System.out.println("학생이 추가되었습니다.");
    }

    // 전체 학생 출력 Read
    public void printAllStudents() {
        if (studentMap.isEmpty()) {
            System.out.println("등록된 학생이 없습니다.");
            return;
        }
        for (Student student : studentMap.values()) {
            student.printInfo();
        }
    }

    public void printStudentIds() {
        for (String studentId : studentMap.keySet()) {
            System.out.println(studentId);
        }
    }

    public void printStudentSummary() {
        for (Map.Entry<String, Student> entry : studentMap.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue().getName());
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
        return studentMap.containsKey(studentId);
    }

    // 학생 삭제 delete
    public void removeStudent(String studentId) {
        Student student = findStudent(studentId);

        if (student == null) {
            System.out.println("학생이 존재하지 않습니다.");
            return;
        }
        studentMap.remove(studentId);
        System.out.println("학생이 삭제되었습니다.");
    }
}
