package com.gojavaonline.module2.homework1;

/**
 * Created by oleksii.opanasiuk on 10.07.16.
 */
import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) throws ExecutorException {
        List<Person> persons = new ArrayList<Person>(){{
            add(new Person("Aaa", "Bbb"));
            add(new Person("Ccc"));
            add(new Employee("Dddd", "Eeee", "Azaza"));
            add(new Professional("Fff", "Gggg", "Bebebe", 10));
            add(new Professional("Yyy", "Xxx", "Gugugu", 20));
        }};

        Executor<Person> personExecutor = new Executor<>();
        for (Person person : persons) {
            personExecutor.addTask(new PersonTask(person), new PersonValidator());
        }
        personExecutor.addTask(new PersonTask(new Professional("Ppp", "Mmm", "Jocker", 100)));

        personExecutor.execute();

        System.out.println("Valid results:");
        personExecutor.getValidResults().forEach(System.out::println);
        System.out.println();
        System.out.println();
        System.out.println("Invalid results:");
        personExecutor.getInvalidResults().forEach(System.out::println);
    }

}