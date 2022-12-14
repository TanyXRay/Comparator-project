import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Решение задачи №1 и №2 по теме: Коллекции TreeSet,TreeMap,Comparator,Comparable.
 * * Решение задачи №1 и №2 по теме: Лямбда-выражения.
 */
public class Main {

    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Алексей", "Альбединский-Покровский", 26));
        people.add(new Person("Юлия", "Белозерова,Востокова,Воскресенская", 23));
        people.add(new Person("Александра", "Далевиднова Непомнящих Бушкевич", 17));
        people.add(new Person("Дмитрий", "Донской,Златовласов,Казанцев,Сиванцев", 18));
        people.add(new Person("Сергей", "Калинин", 42));
        people.add(new Person("Артем", "Чуждинин Прокопьев", 24));
        people.add(new Person("Костя", "Булдинин-Прохопьев", 21));
        people.add(new Person("Татьяна", "Булкина", 41));
        people.add(new Person("Николай", "Пчелкин-Соболев", 16));

        Collections.sort(people, (o1, o2) -> {
            String[] wordsInSurname1 = o1.getSurname().split("\\p{Punct}|\\p{Space}");
            String[] wordsInSurname2 = o2.getSurname().split("\\p{Punct}|\\p{Space}");
            int maxLenghtOfSurname = 2;
            if (wordsInSurname1.length > maxLenghtOfSurname
                && wordsInSurname2.length > maxLenghtOfSurname) {
                return Integer.compare(o1.getAge(), o2.getAge());
            }
            if (wordsInSurname1.length > wordsInSurname2.length) {
                return 1;
            } else if (wordsInSurname1.length < wordsInSurname2.length) {
                return -1;
            } else return Integer.compare(o1.getAge(), o2.getAge());
        });

        System.out.println();

        people.removeIf(person -> person.getAge() < 18);

        people.forEach(System.out::println);
    }
}
