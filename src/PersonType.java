public enum PersonType {
    STUDENT(1),
    TEACHER(2),
    STAFF(3);

    private int number;

    PersonType (int number) {
        this.number = number;
    }
    public int getNumber () {
        return number;
    }
    public static PersonType fromNumber(int number) {

        for (PersonType type : PersonType.values()) {
            if (type.getNumber() == number){
                return type;
            }
        }
        throw new IllegalArgumentException("올바른 사람 종류를 선택하세요.");
    }
}
