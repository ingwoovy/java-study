public class Student {

    private String name;
    private int age;
    private String studentId;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
    public String getStudentId() {
        return studentId;
    }

    public Student(String name, int age, String studentId) {
        if(name == null || name.isBlank()) {
            throw new IllegalArgumentException("이름은 비어 있을 수 없습니다.");
        }
        if (age <= 0) {
            throw new IllegalArgumentException("나이는 1 이상이어야 합니다.");
        }
        if (studentId == null || studentId.isBlank()) {
            throw new IllegalArgumentException("학번은 비어 있을 수 없습니다.");
        }

        this.name = name;
        this.age = age;
        this.studentId = studentId;
    }

    public void printInfo() {
        System.out.println("===================");
        System.out.println("학생 정보");
        System.out.println("===================");
        System.out.println("이름 : " + name);
        System.out.println("나이 : " + age);
        System.out.println("학번 : " + studentId);
        System.out.println("===================");
    }

    public void updateInfo(String newName, int newAge) {
        if (newName == null || newName.isBlank()) {
            throw new IllegalArgumentException("이름은 비어 있을 수 없습니다.");
        }
        if (newAge <= 0) {
            throw new IllegalArgumentException("나이는 1 이상이어야 합니다.");
        }

        this.name = newName;
        this.age = newAge;
    }
}