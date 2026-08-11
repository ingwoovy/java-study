public class Teacher extends Person implements Workable, Studyable{

    private String teacherId;
    private String subject;

    public String getTeacherId() {
        return teacherId;
    }
    public String getSubject() {
        return subject;
    }

    public Teacher(String name, int age, String teacherId, String subject) {
        super(name, age);
        if (teacherId == null || teacherId.isBlank()) {
            throw new IllegalArgumentException("교직원 번호는 비어 있을 수 없습니다.");
        }
        if (subject == null || subject.isBlank()) {
            throw new IllegalArgumentException("담당 과목은 비어 있을 수 없습니다.");
        }
        this.teacherId = teacherId;
        this.subject = subject;
    }

    @Override
    public void printInfo() {
        System.out.println("===================");
        System.out.println("교사 정보");
        System.out.println("===================");
        printBasicInfo();
        System.out.println("교직원 번호 : " + teacherId);
        System.out.println("담당 과목 : " + subject);
        System.out.println("===================");
    }
    @Override
    public void work() {
        System.out.println(getName() + " 선생님이 " + subject + " 수업을 합니다");
    }

    @Override
    public void study() {
        System.out.println(getName() + " 선생님이 " + subject +"를 공부합니다.");
    }
}
