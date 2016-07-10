package com.gojavaonline.module2.homework1;

/**
 * Created by oleksii.opanasiuk.
 */
public class PersonTask implements ITask<Person> {

    Person person;

    public PersonTask(Person person) {
        this.person = person;
    }

    @Override
    public void execute() {
        new PersonValidator().isValid(person);
    }

    @Override
    public Person getResult() {
        return person;
    }
}