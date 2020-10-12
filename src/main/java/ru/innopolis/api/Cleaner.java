package ru.innopolis.api;

import java.util.Set;

public interface Cleaner {

    /**
     * Необходимо реализовать метов void cleanup(Object object, Set<String> fieldsToCleanup, Set<String> fieldsToOutput),
     * принимающий любой объект и две коллекции строк. В объекте, посредством reflection надо поля, перечисленные
     * в fieldsToClenup установить в значение null, или, если поля примитивных типов в их значение по умолчанию.
     * Поля, перечисленные в fieldsToOutput сконвертировать в строку (вызвав toString у объектов,
     * или String.valueOf для примитивных типов) и вывести результат преобразования в консоль. Если переданный
     * первым параметром объект является реализацией интерфейса Map, то проделать аналогичные операции - для
     * списка fieldsToCleanup удалить ключи из мапы, для fieldsToOutput вывести в консоль значения, хранящиеся в мапе.
     * При отсутствии в объекте/мапе нузных полей/ключей - падать с IllegalArgumentException, оставив объект неизменным.
     * @param object Принимаемый объект.
     * @param fieldsToCleanup Множество названий значений, которые мы хотим обнулить.
     * @param fieldsToOutput Множество названий значений, которые мы хотим вывести в консоль.
     */
    void cleanup(Object object, Set<String> fieldsToCleanup, Set<String> fieldsToOutput);
}
