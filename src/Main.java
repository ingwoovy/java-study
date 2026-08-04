public class Main {

    public static void main(String[] args) {
        Student student1 = new Student("홍길동", 23, "2026001");
        Student student2 = new Student("김철수", 25, "2026002");
        Student student3 = new Student("이영희", 22, "2026003");

        student1.printInfo();
        student2.printInfo();
        student3.printInfo();
    }
}