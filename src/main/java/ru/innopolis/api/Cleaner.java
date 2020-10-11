package ru.innopolis.api;

import java.util.Set;

public interface Cleaner {
    void cleanup(Object object, Set<String> fieldsToCleanup, Set<String> fieldsToOutput);
}
