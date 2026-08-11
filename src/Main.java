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

        PersonManager personManager = new PersonManager();
        Person person = personManager.findPerson("T001");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("===== 인원 관리 프로그램 =====");
            System.out.println("1. 사람 추가");
            System.out.println("2. 전체 사람 출력");
            System.out.println("3. ID로 사람 검색");
            System.out.println("4. 사람 정보 수정");
            System.out.println("5. 사람 삭제");
            System.out.println("6. 종료");

            int menu = readInt(scanner, "메뉴 번호를 입력하세요: ");

            switch (menu) {
                case 1:
                    System.out.println("사람 추가를 선택했습니다.");
                    System.out.println("어떤 사람을 추가하시겠습니까?");
                    System.out.println("1. 학생 ");
                    System.out.println("2. 선생 ");
                    System.out.println("3. 직원 ");

                    int choice = readInt(scanner, "번호를 입력하세요 : ");

                        switch (choice) {
                            case 1: {
                                System.out.print("이름을 입력하세요: ");
                                String name = scanner.next();

                                int age = readInt(scanner, "나이를 입력하세요: ");

                                System.out.print("학번을 입력하세요: ");
                                String studentId = scanner.next();

                                try {
                                    Student newStudent = new Student(name, age, studentId);
                                    personManager.addPerson(newStudent);
                                } catch (IllegalArgumentException e) {
                                    System.out.println(e.getMessage());
                                }
                                break;
                            }
                            case 2: {
                                System.out.print("이름을 입력하세요: ");
                                String name = scanner.next();

                                int age = readInt(scanner, "나이를 입력하세요: ");

                                System.out.print("교직원 번호를 입력하세요: ");
                                String teacherId = scanner.next();

                                System.out.println("담당 과목을 입력하세요: ");
                                String subject = scanner.next();

                                try {
                                    Teacher newTeacher = new Teacher(name, age, teacherId, subject);
                                    personManager.addPerson(newTeacher);
                                } catch (IllegalArgumentException e) {
                                    System.out.println(e.getMessage());
                                }
                                break;
                            }
                            case 3: {
                                System.out.print("이름을 입력하세요: ");
                                String name = scanner.next();

                                int age = readInt(scanner, "나이를 입력하세요: ");

                                System.out.print("직원 번호를 입력하세요: ");
                                String staffId = scanner.next();

                                System.out.print("담당 부서를 입력하세요: ");
                                String department = scanner.next();

                                try {
                                    Staff newStaff = new Staff(name, age, staffId, department);
                                    personManager.addPerson(newStaff);
                                } catch (IllegalArgumentException e) {
                                    System.out.println(e.getMessage());
                                }
                                break;
                            }
                            default:
                                System.out.println("올바른 번호를 입력하세요.");
                        }
                        break;


                case 2:
                    System.out.println("전체 출력을 선택했습니다.");
                    personManager.printAllPerson();
                    break;

                case 3:
                    System.out.println("사람 검색을 선택했습니다.");
                    System.out.print("검색할 ID를 입력하세요: ");

                    String id = scanner.next();

                    personManager.findPersonById(id);
                    break;

                case 4:
                    System.out.println("사람 정보 수정을 선택했습니다.");

                    System.out.print("수정할 사람의 ID를 입력하세요: ");
                    String updatePersonId = scanner.next();

                    Person updatePerson = personManager.findPerson(updatePersonId);

                    if (updatePerson == null) {
                        System.out.println("사람이 존재하지 않습니다.");
                        break;
                    }

                    System.out.print("새 이름을 입력하세요: ");
                    String newName = scanner.next();

                    int newAge = readInt(scanner, "새 나이를 입력하세요: ");

                    try {
                        personManager.updatePerson(updatePersonId, newName, newAge);
                        if (updatePerson instanceof Teacher) {
                            Teacher teacher = (Teacher) updatePerson;

                            System.out.print("변경된 새 과목을 입력하세요: ");
                            String newSubjecet = scanner.next();
                            teacher.updateSubject(newSubjecet);
                        }
                        else if (updatePerson instanceof Staff) {
                            Staff staff = (Staff) updatePerson;

                            System.out.print("변경된 새 담당 부서를 입력하세요: ");
                            String newDepartment = scanner.next();
                            staff.updateDepartment(newDepartment);
                        }
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 5:
                    System.out.println("사람 삭제를 선택했습니다.");
                    System.out.print("삭제할 ID를 입력하세요: ");

                    String removePersonId = scanner.next();

                    personManager.removePerson(removePersonId);
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