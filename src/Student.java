public class Student {

    String name;
    int age;
    String studentId;

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

}