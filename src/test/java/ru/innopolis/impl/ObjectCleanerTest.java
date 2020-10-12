package ru.innopolis.impl;

import org.junit.Assert;

import java.util.*;

public class ObjectCleanerTest {

    @org.junit.Test
    public void mapCleaner() {
        Map<String, Integer> expectedMap = new HashMap<>();
        expectedMap.put("1", 11);
        expectedMap.put("2", 22);
        expectedMap.put("3", 33);
        expectedMap.put("4", 44);
        expectedMap.put("5", 55);
        expectedMap.put("6", 66);

        Set<String> set1 = new HashSet<>();
        set1.add("2");
        set1.add("6");
        set1.add("4");

        Set<String> set2 = new HashSet<>();
        set2.add("1");
        set2.add("2");
        set2.add("3");

        CleanerManager cleanerManager = new CleanerManager();
        cleanerManager.cleanup(expectedMap, set1, set2);

        Map<String, Integer> actualMap = new HashMap<>();
        actualMap.put("1", 11);
        actualMap.put("2", null);
        actualMap.put("3", 33);
        actualMap.put("4", null);
        actualMap.put("5", 55);
        actualMap.put("6", null);

        Assert.assertEquals(actualMap, expectedMap);
    }

    static class TestedClass {
        int anInt;
        double aDouble;
        String string;
        boolean aBoolean;
        float aFloat;
        char aChar;
        byte aByte;
        short aShort;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            TestedClass that = (TestedClass) o;
            return anInt == that.anInt &&
                    Double.compare(that.aDouble, aDouble) == 0 &&
                    aBoolean == that.aBoolean &&
                    Float.compare(that.aFloat, aFloat) == 0 &&
                    aChar == that.aChar &&
                    aByte == that.aByte &&
                    aShort == that.aShort &&
                    Objects.equals(string, that.string);
        }

        @Override
        public int hashCode() {
            return Objects.hash(anInt, aDouble, string, aBoolean, aFloat, aChar, aByte, aShort);
        }

        public TestedClass(int anInt, double aDouble, String string, boolean aBoolean, float aFloat, char aChar, byte aByte, short aShort) {
            this.anInt = anInt;
            this.aDouble = aDouble;
            this.string = string;
            this.aBoolean = aBoolean;
            this.aFloat = aFloat;
            this.aChar = aChar;
            this.aByte = aByte;
            this.aShort = aShort;
        }

        @Override
        public String toString() {
            return "TestedClass{" +
                    "anInt=" + anInt +
                    ", aDouble=" + aDouble +
                    ", string='" + string + '\'' +
                    ", aBoolean=" + aBoolean +
                    ", aFloat=" + aFloat +
                    ", aChar=" + aChar +
                    ", aByte=" + aByte +
                    ", aShort=" + aShort +
                    '}';
        }
    }

    @org.junit.Test
    public void objectCleaner() {
        TestedClass testedClass = new TestedClass(5, 2.0, "star", true,
                                                 55.3f, (char) 88, (byte) 1,(short) 44);
        Set<String> set1 = new HashSet<>();
        set1.add("anInt");
        set1.add("string");
        set1.add("aBoolean");

        Set<String> set2 = new HashSet<>();
        set2.add("anInt");
        set2.add("aDouble");
        set2.add("aBoolean");

        CleanerManager cleanerManager = new CleanerManager();
        cleanerManager.cleanup(testedClass,set1, set2);

        TestedClass actualClass = new TestedClass(0, 2.0, null, false,
                55.3f, (char) 88, (byte) 1,(short) 44);
        Assert.assertEquals(actualClass, testedClass);
    }
}