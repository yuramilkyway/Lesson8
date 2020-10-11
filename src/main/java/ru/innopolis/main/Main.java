package ru.innopolis.main;

import ru.innopolis.impl.CleanerManager;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("1", 11);
        map.put("2", 22);
        map.put("3", 33);
        map.put("4", 44);
        map.put("5", 55);
        map.put("6", 66);
        System.out.println(map.toString());

        Set<String> set1 = new HashSet<>();
        set1.add("2");
        set1.add("6");
        set1.add("4");

        Set<String> set2 = new HashSet<>();
        set2.add("1");
        set2.add("2");
        set2.add("3");

        CleanerManager cleanerManager = new CleanerManager();
        cleanerManager.cleanup(map, set1, set2);
        System.out.println(map.toString());

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

    static class  Test {
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
