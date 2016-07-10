package com.gojavaonline.module2.homework1;

/**
 * Created by oleksii.opanasiuk.
 */
public interface IValidator<T> {

    // Валидирует переданое значение
    boolean isValid(T result);

}
