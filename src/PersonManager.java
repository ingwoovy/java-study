import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Collections;
import java.util.Comparator;

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

    // 사람 종류별 통계
    public void printPersonStatistics() {

        int studentCount = 0;
        int teacherCount = 0;
        int staffCount = 0;

        for (Person person : personMap.values()) {
            if (person instanceof Student) {
                studentCount ++;
            } else if (person instanceof Teacher) {
                teacherCount ++;
            } else if (person instanceof Staff) {
                staffCount ++;
            }
        }
        System.out.println("===== 사람 종류별 통계 =====");
        System.out.println("학생 : " + studentCount);
        System.out.println("교사 : " + teacherCount);
        System.out.println("직원 : " + staffCount);
        System.out.println("총 인원 : " + personMap.size());
    }

    // 이름순으로 사람 조회 (Comparable)
    public void printAllPersonSortedByName () {
        List<Person> personList = new ArrayList<>(personMap.values());

        Collections.sort(personList);

        System.out.println("이름순 출력");

        for (Person person : personList) {
            person.printInfo();
        }
    }

    // 나이순으로 사람 조회 (Comparator)
    public void printAllPersonSortedByAge() {
        List<Person> personList =
                new ArrayList<>(personMap.values());

        Comparator<Person> ageComparator =
                new Comparator<Person>() {

                    @Override
                    public int compare(Person p1, Person p2) {
                        return Integer.compare(p1.getAge(),p2.getAge());
                    }
                };
        Collections.sort(personList, ageComparator);

        System.out.println("나이순 출력");

        for (Person person : personList) {
            person.printInfo();
        }
    }

    // ID순으로 사람 조회 (Comparator Lambda)
    public void printAllPersonSortedById() {
        List<Person> personList =
                new ArrayList<>(personMap.values());

        Comparator<Person> idComparator =
                (p1, p2) -> p1.getId().compareTo(p2.getId());
        Collections.sort(personList, idComparator);

        System.out.println("ID순 출력");

        for (Person person : personList) {
            person.printInfo();
        }
    }
}