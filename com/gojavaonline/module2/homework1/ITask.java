package com.gojavaonline.module2.homework1;

/**
 * Created by oleksii.opanasiuk.
 */
public interface ITask<T> {

    /**
     * Method make execution
     */
    void execute();


    /**
     * Method give results of execution
     * @return T
     */
    T getResult();
}