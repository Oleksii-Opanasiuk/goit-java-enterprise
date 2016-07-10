package com.gojavaonline.module2.homework1;

/**
 * Created by oleksii.opanasiuk.
 */
public class PersonValidator implements IValidator<Person> {

    @Override
    public boolean isValid(Person result) {
        return result.getName().length() > 0 && !result.getName().isEmpty()
                && result.getSname().length() > 0 && !result.getSname().isEmpty();
    }
}