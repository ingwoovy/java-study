public class Student extends Person implements Studyable{

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
    @Override
    public void printInfo() {
        System.out.println("===================");
        System.out.println("학생 정보");
        System.out.println("===================");
        printBasicInfo();
        System.out.println("학번 : " + studentId);
        System.out.println("===================");
    }

    @Override
    public void study() {
        System.out.println(getName() + " 학생이 공부합니다.");
    }

    public void updateInfo(String newName, int newAge) {
        updatePerson(newName, newAge);
    }
}