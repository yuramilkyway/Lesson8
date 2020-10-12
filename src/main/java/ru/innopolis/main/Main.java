package ru.innopolis.main;

import ru.innopolis.impl.CleanerManager;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        Map<String, Integer> map = new HashMap<>();
        map.put("firstElem", 11);
        map.put("secondElem", 22);
        map.put("thirdElem", 33);
        map.put("fourthElem", 44);
        System.out.println(map.toString());

        Set<String> set1 = new HashSet<>();
        set1.add("firstElem");
        set1.add("thirdElem");

        Set<String> set2 = new HashSet<>();
        set2.add("firstElem");
        set2.add("secondElem");
        set2.add("thirdElem");
        set2.add("fourthElem");

        CleanerManager cleanerManager = new CleanerManager();
        cleanerManager.cleanup(map, set1, set2);
        System.out.println(map.toString() + "\n");

        Test obj = new Test();
        System.out.println(obj);
        Set<String> set3 = new HashSet<>();
        set3.add("a");
        set3.add("c");
        set3.add("d");

        Set<String> set4 = new HashSet<>();
        set4.add("a");
        set4.add("b");
        set4.add("c");

        cleanerManager.cleanup(obj, set3, set4);
        System.out.println(obj);

    }

    static class Test {
        int a = 5;
        double b =6.0;
        String c = "string c";
        boolean d = true;

        @Override
        public String toString() {
            return "Test{" +
                    "a=" + a +
                    ", b=" + b +
                    ", c='" + c + '\'' +
                    ", d=" + d +
                    '}';
        }
    }

}
