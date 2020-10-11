package ru.innopolis.impl;

import ru.innopolis.api.Cleaner;

import java.util.Map;
import java.util.Set;

public class CleanerManager implements Cleaner {
    @Override
    public void cleanup(Object object, Set<String> fieldsToCleanup, Set<String> fieldsToOutput) {
        if (object instanceof Map) {
            MapCleaner mapCleaner = new MapCleaner();
            mapCleaner.cleanup((Map) object, fieldsToCleanup, fieldsToOutput);
        }
        else {
            ObjectCleaner objectCleaner = new ObjectCleaner();
            objectCleaner.cleanup(object, fieldsToCleanup, fieldsToOutput);
        }
    }
}
