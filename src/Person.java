public abstract class Person {

    private String name;
    private int age;

    public Person(String name, int age) {
        if(name == null || name.isBlank()) {
            throw new IllegalArgumentException("이름은 비어 있을 수 없습니다.");
        }
        if (age <= 0) {
            throw new IllegalArgumentException("나이는 1 이상이어야 합니다.");
        }
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }

    public void updatePerson(String newName, int newAge) {
        if (newName == null || newName.isBlank()) {
            throw new IllegalArgumentException("이름은 비어 있을 수 없습니다.");
        }
        if (newAge <= 0) {
            throw new IllegalArgumentException("나이는 1 이상이어야 합니다.");
        }
        this.name = newName;
        this.age = newAge;
    }

    protected void printBasicInfo() {
        System.out.println("이름 : " + name);
        System.out.println("나이 : " + age);
    }

    public abstract void printInfo();

    public abstract String getId();
}
