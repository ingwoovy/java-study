public class Staff extends Person implements Workable{

    private String department;

    public String getDepartment (){
        return department;
    }

    public Staff (String name, int age, String department) {
        super(name, age);
        if(department == null || department.isBlank()) {
            throw new IllegalArgumentException("부서는 비어 있을 수 없습니다.");
        }
        this.department = department;
    }
    @Override
    public void printInfo() {
        System.out.println("===================");
        System.out.println("직원 정보");
        System.out.println("===================");
        printBasicInfo();
        System.out.println("부서 : " + department);
        System.out.println("===================");
    }
    @Override
    public void work() {
        System.out.println(getName() + " 직원이 " + department + "에서 근무를 합니다");
    }

}
