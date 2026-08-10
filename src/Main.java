import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StudentManager manager = new StudentManager();

        Student student1 = new Student("홍길동", 23, "2026001");
        Student student2 = new Student("김철수", 25, "2026002");
        Student student3 = new Student("이영희", 22, "2026003");

        manager.addStudent(student1);
        manager.addStudent(student2);
        manager.addStudent(student3);

        while (true) {
            System.out.println("===== 학생 관리 프로그램 =====");
            System.out.println("1. 학생 추가");
            System.out.println("2. 전체 학생 출력");
            System.out.println("3. 학번으로 학생 검색");
            System.out.println("4. 학생 정보 수정");
            System.out.println("5. 학번으로 학생 삭제");
            System.out.println("6. 종료");
            System.out.print("메뉴 번호를 입력하세요: ");

            int menu = scanner.nextInt();


            switch (menu) {
                case 1:
                    System.out.println("학생 추가를 선택했습니다.");

                    System.out.print("이름을 입력하세요: ");
                    String name = scanner.next();

                    System.out.print("나이를 입력하세요: ");
                    int age = scanner.nextInt();

                    System.out.print("학번을 입력하세요: ");
                    String studentId = scanner.next();

                    try {
                        Student newStudent = new Student(name, age, studentId);
                        manager.addStudent(newStudent);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 2:
                    System.out.println("전체 출력을 선택했습니다.");
                    manager.printAllStudents();
                    break;

                case 3:
                    System.out.println("학생 검색을 선택했습니다.");
                    System.out.print("검색할 학번을 입력하세요: ");

                    String searchStudentId = scanner.next();

                    manager.findStudentById(searchStudentId);
                    break;

                case 4:
                    System.out.println("학생 정보 수정을 선택했습니다.");

                    System.out.print("수정할 학생의 학번을 입력하세요: ");
                    String updateStudentId = scanner.next();

                    System.out.print("새 이름을 입력하세요: ");
                    String newName = scanner.next();

                    System.out.print("새 나이를 입력하세요: ");
                    int newAge = scanner.nextInt();

                    try {
                        manager.updateStudent(updateStudentId, newName, newAge);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 5:
                    System.out.println("학생 삭제를 선택했습니다.");
                    System.out.print("삭제할 학번을 입력하세요: ");

                    String removeStudentId = scanner.next();

                    manager.removeStudent(removeStudentId);
                    break;

                case 6:
                    System.out.println("프로그램을 종료합니다.");
                    scanner.close();
                    return;

                default:
                    System.out.println("올바른 번호를 입력하세요.");
            }
        }
    }
}