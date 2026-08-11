public class Staff extends Person implements Workable{

    private String department;
    private String staffId;

    public String getDepartment (){
        return department;
    }

    public String getStaffId () { return staffId; }

    public Staff (String name, int age, String staffId,String department) {
        super(name, age);
        if(staffId == null || staffId.isBlank()) {
            throw new IllegalArgumentException("직원 번호는 비어 있을 수 없습니다.");
        }
        if(department == null || department.isBlank()) {
            throw new IllegalArgumentException("부서는 비어 있을 수 없습니다.");
        }
        this.staffId = staffId;
        this.department = department;
    }
    @Override
    public void printInfo() {
        System.out.println("===================");
        System.out.println("직원 정보");
        System.out.println("===================");
        printBasicInfo();
        System.out.println("번호 : " + staffId);
        System.out.println("부서 : " + department);
        System.out.println("===================");
    }
    @Override
    public void work() {
        System.out.println(getName() + " 직원이 " + department + "에서 근무를 합니다");
    }
    @Override
    public String getId() {
        return staffId;
    }

    public void updateDepartment(String newDepartment) {
        if (newDepartment == null || newDepartment.isBlank()) {
            throw new IllegalArgumentException("담당 부서는 비어 있을 수 없습니다.");
        }
        this.department = newDepartment;
    }
}
