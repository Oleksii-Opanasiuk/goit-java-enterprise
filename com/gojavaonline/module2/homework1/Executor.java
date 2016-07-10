package com.gojavaonline.module2.homework1;

/**
 * Created by oleksii.opanasiuk.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Executor<Person> implements IExecutor<Person> {

    private boolean wasExecuted = false;
    private Map<ITask, IValidator> personTasks = new HashMap<>();
    private List<Person> validPersons = new ArrayList<>();
    private List<Person> invalidPersons = new ArrayList<>();

    @Override
    public <T> void addTask(ITask<? extends T> task) throws ExecutorException {
        if (wasExecuted) {
            throw new ExecutorException("Tasks have been executed already");
        }
        personTasks.put(task, null);
    }

    @Override
    public <T> void addTask(ITask<? extends T> task, IValidator<? extends T> validator) throws ExecutorException {
        if (wasExecuted) {
            throw new ExecutorException("Tasks have been executed already");
        }
        personTasks.put(task, validator);
    }

    /**
     * @return
     * @throws ExecutorException
     */
    @Override
    public List<Person> getValidResults() throws ExecutorException {
        if (!wasExecuted) {
            throw new ExecutorException("Please call execute method first");
        }
        return validPersons;
    }

    /**
     * @return
     * @throws ExecutorException
     */
    @Override
    public List<Person> getInvalidResults() throws ExecutorException {
        if (!wasExecuted) {
            throw new ExecutorException("Please call execute method first");
        }
        return invalidPersons;
    }

    @Override
    public void execute() {
        for (Map.Entry<ITask, IValidator> set : personTasks.entrySet()) {
            ITask task = set.getKey();
            IValidator validator = set.getValue();
            task.execute();
            if (validator == null) {
                validPersons.add((Person) task.getResult());
            } else if (validator.isValid(task.getResult())) {
                validPersons.add((Person) task.getResult());
            } else {
                invalidPersons.add((Person) task.getResult());
            }
        }
        wasExecuted = true;
    }
}
