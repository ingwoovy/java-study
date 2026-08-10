public class Student extends Person{

    private String studentId;

    public String getStudentId() {
        return studentId;
    }

    public Student(String name, int age, String studentId) {
        super(name, age);
        if (studentId == null || studentId.isBlank()) {
            throw new IllegalArgumentException("학번은 비어 있을 수 없습니다.");
        }
        this.studentId = studentId;
    }
    public void printInfo() {
        System.out.println("===================");
        System.out.println("학생 정보");
        System.out.println("===================");
        System.out.println("이름 : " + getName());
        System.out.println("나이 : " + getAge());
        System.out.println("학번 : " + studentId);
        System.out.println("===================");
    }


    public void updateInfo(String newName, int newAge) {
        updatePerson(newName, newAge);
    }
}