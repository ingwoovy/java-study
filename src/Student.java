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
        this.name = newName;
        this.age = newAge;
    }
}