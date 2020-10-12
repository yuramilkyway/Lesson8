package ru.innopolis.impl;

import ru.innopolis.api.Cleaner;

import java.util.Map;
import java.util.Set;

public class CleanerManager implements Cleaner {

    /**
     * Метод, который определяет что храниться в object-e.
     * @param object Объект в котором зануляем и печаем значения.
     * @param fieldsToCleanup Множество значений для замены.
     * @param fieldsToOutput Множество значений для вывода в консоль.
     */
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
