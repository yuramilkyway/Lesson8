package ru.innopolis.impl;

import java.util.Map;
import java.util.Set;

public class MapCleaner {
    /**
     * Метод принимающий карту(map) и две коллекции строк.
     * В карте, посредством reflection поля, перечисленные
     * в fieldsToClenup устанавливает в значение null.
     * @param map Карта в которой удаляем ключи.
     * @param fieldsToCleanup Поля, перечисленные в fieldsToClenup
     * устанавливаем в значение null.
     * @param fieldsToOutput Поля, перечисленные в fieldsToOutput
     * конвертируем в строку (вызвав toString у объектов, или String.valueOf для примитивных типов)
     * и выводим результат преобразования в консоль
     */
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

    /**
     * При отсутствии в мапе нужных ключей - вызываем
     * IllegalArgumentException, оставив объект неизменным.
     * @param map Мапа, в который ищем ключи.
     * @param names Множество ключей.
     */
    private void validateArguments(Map map, Set<String> names) {
        for (String name : names) {
            if (!(map.containsKey(name))) {
                throw new IllegalArgumentException("Поле не неайдено.");
            }
        }
    }

    /**
     * Заменяем ключи в мапе.
     * @param fieldName Ключ.
     * @param map Карта в которой чистим ключи.
     */
    private void cleanField(String fieldName, Map map) {
        map.replace(fieldName, null);
    }

    /**
     * Печатаем ноды карты по указанному ключу.
     * @param fieldName Ключ.
     * @param map Карта.
     */
    private void printField(String fieldName, Map map) {
        if (map.get(fieldName) != null) {
            System.out.println(map.get(fieldName).toString());
        } else {
            System.out.println("null");
        }
    }
}
