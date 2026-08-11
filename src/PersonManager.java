import java.util.HashMap;
import java.util.Map;

public class PersonManager {
    private Map<String, Person> personMap = new HashMap<>();

    // Create 추가
    public void addPerson(Person person) {
        if (personMap.containsKey(person.getId())) {
            System.out.println("이미 존재하는 고유 번호입니다.");
            return;
        }
        personMap.put(person.getId(), person);
        System.out.println("사람이 추가되었습니다.");
    }

    // Read 읽기
    public void printAllPerson () {
        if (personMap.isEmpty()) {
            System.out.println("등록된 사람이 없습니다.");
            return;
        }
        for (Person person : personMap.values()) {
            person.printInfo();
        }
    }

    // Read 학생 검색
    public Person findPerson (String id) {
        return personMap.get(id);
    }
    public void findPersonById (String id) {

        Person person = findPerson(id);

        if (person == null) {
            System.out.println("존재하는 사람이 없습니다.");
            return;
        }
        System.out.println("사람을 찾았습니다.");
        person.printInfo();
    }

    // Update 수정
    public void updatePerson(String id, String newName, int newAge) {

        Person person = findPerson(id);

        if (person == null) {
            System.out.println("존재하는 사람이 없습니다.");
            return;
        }
        person.updatePerson(newName, newAge);
        System.out.println("수정이 완료되었습니다.");
    }

    // Delete 삭제
    public void removePerson(String id) {

        Person person = findPerson(id);

        if (person == null) {
            System.out.println("존재하는 사람이 없습니다.");
            return;
        }
        personMap.remove(id);
        System.out.println("사람이 삭제되었습니다.");
    }
}