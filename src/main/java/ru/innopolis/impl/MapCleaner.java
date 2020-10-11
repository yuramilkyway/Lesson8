package ru.innopolis.impl;

import java.util.Map;
import java.util.Set;

public class MapCleaner {
    public void cleanup(Map map, Set<String> fieldsToCleanup, Set<String> fieldsToOutput) {
        validateArguments(map, fieldsToCleanup);
        validateArguments(map, fieldsToOutput);

        for (String field : fieldsToCleanup) {
            cleanField(field, map);
        }

        for (String field : fieldsToOutput) {
            printField(field, map);
        }
    }

    private void validateArguments(Map map, Set<String> names) {
        for (String name : names) {
            if (!(map.containsKey(name))) {
                throw new IllegalArgumentException("Поле не неайдено.");
            }
        }
    }

    private void cleanField(String fieldName, Map map) {
        map.replace(fieldName, null);
    }

    private void printField(String fieldName, Map map) {
        if (map.get(fieldName) != null) {
            System.out.println(map.get(fieldName).toString());
        } else {
            System.out.println("null");
        }
    }
}
