import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {

    private static int readInt(Scanner scanner, String message) {
        while (true) {
            try {
                System.out.print(message);
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("숫자를 입력하세요.");
                scanner.nextLine();
            }

        }
    }

    public static void main(String[] args) {

        Person person1 = new Student("홍길동", 20, "2026001");
        Person person2 = new Teacher("김선생",35, "T001", "java");

        Person[] people = { person1, person2 };

        for (Person person : people) {
            if (person instanceof Student) {
                Student student = (Student) person;
                System.out.println("학생입니다.");
                System.out.println("학번 : " + student.getStudentId());
            }
            if (person instanceof Teacher) {
                Teacher teacher = (Teacher) person;
                System.out.println("교사입니다.");
                System.out.println("교직원 번호 : " + teacher.getTeacherId());
            }
        }

        Scanner scanner = new Scanner(System.in);

        StudentManager manager = new StudentManager();

        while (true) {
            System.out.println("===== 학생 관리 프로그램 =====");
            System.out.println("1. 학생 추가");
            System.out.println("2. 전체 학생 출력");
            System.out.println("3. 학번으로 학생 검색");
            System.out.println("4. 학생 정보 수정");
            System.out.println("5. 학번으로 학생 삭제");
            System.out.println("6. 종료");

            int menu = readInt(scanner, "메뉴 번호를 입력하세요: ");


            switch (menu) {
                case 1:
                    System.out.println("학생 추가를 선택했습니다.");

                    System.out.print("이름을 입력하세요: ");
                    String name = scanner.next();

                    int age = readInt(scanner, "나이를 입력하세요: ");

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

                    if (!manager.existsStudent(updateStudentId)) {
                        System.out.println("학생이 존재하지 않습니다.");
                        break;
                    }

                    System.out.print("새 이름을 입력하세요: ");
                    String newName = scanner.next();

                    int newAge = readInt(scanner, "새 나이를 입력하세요: ");

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