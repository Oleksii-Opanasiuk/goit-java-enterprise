package com.gojavaonline.module1.homework1;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

/**
 * Created by alex on 25.12.15.
 */
public class Collections {

    /**
     * @param args
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, IOException {
        Map<Class<?>, String> map = new HashMap<Class<?>, String>() {
            {
                put(ArrayList.class, "list");
                put(LinkedList.class, "list");
                put(HashSet.class, "set");
                put(TreeSet.class, "set");
            }
        };
        Map<String, Map<String, String>> resultMap = new HashMap<>();
        for (Map.Entry<Class<?>, String> entry : map.entrySet()) {
            Map<String, String> res = runOperations(entry.getKey(), entry.getValue());
            resultMap.put(entry.getKey().getSimpleName(), res);
        }

        Collections.DrawTable(resultMap);
    }

    /**
     * @param classType
     * @param type
     * @param <T>
     * @return
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    protected static <T> Map<String, String> runOperations (Class<T> classType, String type) throws IllegalAccessException, InstantiationException {
        Map<String, String> resultMap = new HashMap<>();
        if (type.equals("list")) {
            Map<String, String> res = Collections.ListOperations(classType);
            resultMap.putAll(res);
        }

        if (type.equals("set")) {
            Map<String, String> res = Collections.SetOperations(classType);
            resultMap.putAll(res);
        }

        return resultMap;
    }

    /**
     * @param classType
     * @param <T>
     * @return
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    protected static <T> Map<String, String> ListOperations(Class<T> classType) throws IllegalAccessException, InstantiationException {
        Map<String, String> res = new HashMap<>();
        String addResult = Long.toString(ListAddOperation(classType, 10000));
        addResult += "/" + Long.toString(ListAddOperation(classType, 100000));
        addResult += "/" + Long.toString(ListAddOperation(classType, 1000000));
        res.put("add", addResult);

        String getResult = Long.toString(ListGetOperation(classType, 10000));
        getResult += "/" + Long.toString(ListGetOperation(classType, 100000));
        getResult += "/" + Long.toString(ListGetOperation(classType, 1000000));
        res.put("get", getResult);

        String removeResult = Long.toString(ListRemoveOperation(classType, 10000));
        removeResult += "/" + Long.toString(ListRemoveOperation(classType, 100000));
        removeResult += "/" + Long.toString(ListRemoveOperation(classType, 1000000));
        res.put("remove", removeResult);

        String containsResult = Long.toString(ListContainsOperation(classType, 10000));
        containsResult += "/" + Long.toString(ListContainsOperation(classType, 100000));
        containsResult += "/" + Long.toString(ListContainsOperation(classType, 1000000));
        res.put("contains", containsResult);

        String populateResult = Long.toString(ListPopulateOperation(classType, 10000));
        populateResult += "/" + Long.toString(ListPopulateOperation(classType, 100000));
        populateResult += "/" + Long.toString(ListPopulateOperation(classType, 1000000));
        res.put("populate", populateResult);

        String iteratorAdd = Long.toString(ListIteratorAddOperation(classType, 10000));
        iteratorAdd += "/" + Long.toString(ListIteratorAddOperation(classType, 100000));
        iteratorAdd += "/" + Long.toString(ListIteratorAddOperation(classType, 1000000));
        res.put("iteratorAdd", iteratorAdd);

        String iteratorRemove = Long.toString(ListIteratorRemoveOperation(classType, 10000));
        iteratorRemove += "/" + Long.toString(ListIteratorRemoveOperation(classType, 100000));
        iteratorRemove += "/" + Long.toString(ListIteratorRemoveOperation(classType, 1000000));
        res.put("iteratorRemove", iteratorRemove);

        return res;
    }

    /**
     * @param classType
     * @param <T>
     * @return
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    protected static <T> Map<String, String> SetOperations(Class<T> classType) throws IllegalAccessException, InstantiationException {
        Map<String, String> res = new HashMap<>();
        String addResult = Long.toString(SetAddOperation(classType, 10000));
        addResult += "/" + Long.toString(SetAddOperation(classType, 100000));
        addResult += "/" + Long.toString(SetAddOperation(classType, 1000000));
        res.put("add", addResult);

        String removeResult = Long.toString(SetRemoveOperation(classType, 10000));
        removeResult += "/" + Long.toString(SetRemoveOperation(classType, 100000));
        removeResult += "/" + Long.toString(SetRemoveOperation(classType, 1000000));
        res.put("remove", removeResult);

        String containsResult = Long.toString(SetContainsOperation(classType, 10000));
        containsResult += "/" + Long.toString(SetContainsOperation(classType, 100000));
        containsResult += "/" + Long.toString(SetContainsOperation(classType, 1000000));
        res.put("contains", containsResult);

        String populateResult = Long.toString(SetPopulateOperation(classType, 10000));
        populateResult += "/" + Long.toString(SetPopulateOperation(classType, 100000));
        populateResult += "/" + Long.toString(SetPopulateOperation(classType, 1000000));
        res.put("populate", populateResult);

        return res;
    }

    /**
     * @param classType
     * @param depth
     * @param <T>
     * @return
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    protected static <T> long ListAddOperation(Class<T> classType, int depth) throws IllegalAccessException, InstantiationException {
        long res = 0;
        List list = getFilledList(classType, depth);
        for (int i = 0; i < 100; i++) {
            long start = System.nanoTime();
            list.add(i);
            long end = System.nanoTime();
            long time = end - start;
            res += time;
        }
        res = res/100;
        return res;
    }

    /**
     * @param classType
     * @param depth
     * @param <T>
     * @return
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    protected static <T> long SetAddOperation(Class<T> classType, int depth) throws IllegalAccessException, InstantiationException {
        long res = 0;
        Set set = getFilledSet(classType, depth);
        for (int i = 0; i < 100; i++) {
            long start = System.nanoTime();
            set.add(i);
            long end = System.nanoTime();
            long time = end - start;
            res += time;
        }
        res = res/100;
        return res;
    }

    /**
     * @param classType
     * @param depth
     * @param <T>
     * @return
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    protected static <T> long ListRemoveOperation(Class<T> classType, int depth) throws IllegalAccessException, InstantiationException {
        long res = 0;
        List list = getFilledList(classType, depth);
        for (int i = 0; i < 100; i++) {
            long start = System.nanoTime();
            list.remove(i);
            long end = System.nanoTime();
            long time = end - start;
            res += time;
        }
        res = res/100;
        return res;
    }

    /**
     * @param classType
     * @param depth
     * @param <T>
     * @return
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    protected static <T> long SetRemoveOperation(Class<T> classType, int depth) throws IllegalAccessException, InstantiationException {
        long res = 0;
        Set set = getFilledSet(classType, depth);
        for (int i = 0; i < 100; i++) {
            long start = System.nanoTime();
            set.remove(i);
            long end = System.nanoTime();
            long time = end - start;
            res += time;
        }
        res = res/100;
        return res;
    }

    /**
     * @param classType
     * @param depth
     * @param <T>
     * @return
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    protected static <T> long ListGetOperation(Class<T> classType, int depth) throws IllegalAccessException, InstantiationException {
        long res = 0;
        List list = getFilledList(classType, depth);
        for (int i = 0; i < 100; i++) {
            long start = System.nanoTime();
            list.get(i);
            long end = System.nanoTime();
            long time = end - start;
            res += time;
        }
        res = res/100;
        return res;
    }

    /**
     * @param classType
     * @param depth
     * @param <T>
     * @return
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    protected static <T> long ListContainsOperation(Class<T> classType, int depth) throws IllegalAccessException, InstantiationException {
        long res = 0;
        List list = getFilledList(classType, depth);
        for (int i = 0; i < 100; i++) {
            long start = System.nanoTime();
            list.contains(i);
            long end = System.nanoTime();
            long time = end - start;
            res += time;
        }
        res = res/100;
        return res;
    }

    /**
     * @param classType
     * @param depth
     * @param <T>
     * @return
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    protected static <T> long SetContainsOperation(Class<T> classType, int depth) throws IllegalAccessException, InstantiationException {
        long res = 0;
        Set set = getFilledSet(classType, depth);
        for (int i = 0; i < 100; i++) {
            long start = System.nanoTime();
            set.contains(i);
            long end = System.nanoTime();
            long time = end - start;
            res += time;
        }
        res = res/100;
        return res;
    }

    /**
     * @param classType
     * @param depth
     * @param <T>
     * @return
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    protected static <T> long ListPopulateOperation(Class<T> classType, int depth) throws IllegalAccessException, InstantiationException {
        long res = 0;

        for (int i = 0; i < 100; i++) {
            List collection = (List) classType.newInstance();
            long start = System.nanoTime();
            for (int j = 0; j < depth; j++) {
                collection.add(j);
            }
            long end = System.nanoTime();
            long time = end - start;
            res += time;
        }
        res = res/100;
        return res;
    }

    /**
     * @param classType
     * @param depth
     * @param <T>
     * @return
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    protected static <T> long SetPopulateOperation(Class<T> classType, int depth) throws IllegalAccessException, InstantiationException {
        long res = 0;

        for (int i = 0; i < 100; i++) {
            Set collection = (Set) classType.newInstance();
            long start = System.nanoTime();
            for (int j = 0; j < depth; j++) {
                collection.add(j);
            }
            long end = System.nanoTime();
            long time = end - start;
            res += time;
        }
        res = res/100;
        return res;
    }

    /**
     * @param classType
     * @param depth
     * @param <T>
     * @return
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    protected static <T> long ListIteratorAddOperation(Class<T> classType, int depth) throws IllegalAccessException, InstantiationException {
        long res = 0;
        List list = getFilledList(classType, depth);
        ListIterator iterator = list.listIterator();
        for (int i = 0; i < 100; i++) {
            long start = System.nanoTime();
            iterator.add(i);
            long end = System.nanoTime();
            long time = end - start;
            res += time;
        }
        res = res/100;
        return res;
    }

    /**
     * @param classType
     * @param depth
     * @param <T>
     * @return
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    protected static <T> long ListIteratorRemoveOperation(Class<T> classType, int depth) throws IllegalAccessException, InstantiationException {
        long res = 0;
        List list = getFilledList(classType, depth);
        ListIterator iterator = list.listIterator();
        for (int i = 0; i < 100; i++) {
            long start = System.nanoTime();
            iterator.next();
            iterator.remove();
            long end = System.nanoTime();
            long time = end - start;
            res += time;
        }
        res = res/100;
        return res;
    }

    /**
     * @param classType
     * @param depth
     * @param <T>
     * @return
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    protected static <T> List getFilledList(Class<T> classType, int depth) throws IllegalAccessException, InstantiationException {
        List collection = (List) classType.newInstance();
        for (int i = 0; i < depth; i++) {
            collection.add(i);
        }
        return collection;
    }

    /**
     * @param classType
     * @param depth
     * @param <T>
     * @return
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    protected static <T> Set getFilledSet(Class<T> classType, int depth) throws IllegalAccessException, InstantiationException {
        Set collection = (Set) classType.newInstance();
        for (int i = 0; i < depth; i++) {
            collection.add(i);
        }
        return collection;
    }

    /**
     * @param map
     */
    protected static void DrawTable(Map<String, Map<String, String>> map) throws IOException {

        FileWriter fwriter = new FileWriter("out.txt", false);
        PrintWriter outputfile = new PrintWriter(fwriter);

        String leftAlignFormat = "| %-12s | %-19s | %-19s | %-22s | %-24s | %-28s | %-28s | %-31s |%n";
        String str = "+--------------+---------------------+---------------------+" +
                "------------------------+--------------------------+------------------------------+" +
                "------------------------------+---------------------------------+%n";
        System.out.format(str);
        outputfile.format(str);

        str = "|              | add(10K/100K/1000K) | get(10K/100K/1000K) |" +
                " remove(10K/100K/1000K) | contains(10K/100K/1000K) |   populate(10K/100K/1000K)   |" +
                " iterator.add(10K/100K/1000K) | iterator.remove(10K/100K/1000K) |%n";
        System.out.format(str);
        outputfile.format(str);

        str = "+--------------+---------------------+---------------------+" +
                "------------------------+--------------------------+------------------------------+" +
                "------------------------------+---------------------------------+%n";
        System.out.format(str);
        outputfile.format(str);

        Iterator<Map.Entry<String, Map<String, String>>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Map<String, String>> pair = it.next();
            Map<String, String> values = pair.getValue();

            System.out.format(leftAlignFormat, pair.getKey(), values.get("add"),values.get("get"),
                    values.get("remove"),values.get("contains"),values.get("populate"),
                    values.get("iteratorAdd"),values.get("iteratorRemove"));

            outputfile.format(leftAlignFormat, pair.getKey(), values.get("add"),values.get("get"),
                    values.get("remove"),values.get("contains"),values.get("populate"),
                    values.get("iteratorAdd"),values.get("iteratorRemove"));


            it.remove();
        }

        str = "+--------------+---------------------+---------------------+" +
                "------------------------+--------------------------+------------------------------+" +
                "------------------------------+---------------------------------+%n";
        System.out.format(str);
        outputfile.format(str);
        outputfile.close();
    }
}

