package com.gojavaonline.module2.homework1;

/**
 * Created by oleksii.opanasiuk.
 */
import java.util.List;

/**
 * @param <T>
 */
public interface IExecutor<T> {


    /**
     * @param task
     * @param <T>
     * @throws ExecutorException
     */
    <T> void addTask(ITask<? extends T> task) throws ExecutorException;


    /**
     * @param task
     * @param validator
     * @param <T>
     * @throws ExecutorException
     */
    <T> void addTask(ITask<? extends T> task, IValidator<? extends T> validator) throws ExecutorException;

    /**
     *
     */
    void execute();

    /**
     * @return
     * @throws ExecutorException
     */
    List<T> getValidResults() throws ExecutorException;

    /**
     * @return
     * @throws ExecutorException
     */
    List<T> getInvalidResults() throws ExecutorException;
}


