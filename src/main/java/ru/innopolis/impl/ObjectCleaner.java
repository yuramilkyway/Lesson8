package ru.innopolis.impl;

import ru.innopolis.api.Cleaner;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class ObjectCleaner implements Cleaner {
    /**
     * Метод принимающий объект и две коллекции строк.
     * В объекте, посредством reflection поля, перечисленные
     * в fieldsToClenup устанавливает в значение null.
     * @param object Объект в которой удаляем .
     * @param fieldsToCleanup Поля, перечисленные в fieldsToClenup
     * устанавливаем в значение null.
     * @param fieldsToOutput Поля, перечисленные в fieldsToOutput
     * конвертируем в строку (вызвав toString у объектов, или String.valueOf для примитивных типов)
     * и выводим результат преобразования в консоль
     */
    @Override
    public void cleanup(Object object, Set<String> fieldsToCleanup, Set<String> fieldsToOutput) {
        validateArguments(object, fieldsToCleanup);
        validateArguments(object, fieldsToOutput);

        for (String field : fieldsToCleanup) {
            cleanField(field, object);
        }

        for (String field : fieldsToOutput) {
            printField(field, object);
        }
    }

    /**
     * При отсутствии в объекте нужных значений - вызываем
     * IllegalArgumentException, оставив объект неизменным.
     * @param obj объект в котором ищем.
     * @param names Множество значений.
     */
    private void validateArguments(Object obj, Set<String> names) {
        Class<?> objClass = obj.getClass();
        List<Field> fields = Arrays.asList(objClass.getDeclaredFields());

        for (String name : names) {
            boolean present = false;
            for (Field field : fields) {
                if (field.getName().equals(name)) {
                    present = true;
                    break;
                }
            }
            if (!(present)) {
                throw new IllegalArgumentException("Поле не неайдено.");
            }
        }
    }

    /**
     * Заменяем значения в объекте.
     * @param fieldName Ключ.
     * @param obj объект в котором обнуляем значения.
     */
    private void cleanField(String fieldName, Object obj) {
        try {
            Field declaredField = obj.getClass().getDeclaredField(fieldName);
            String typeName = declaredField.getType().getCanonicalName();
            declaredField.setAccessible(true);
            switch (typeName) {
                case "byte": {
                    declaredField.setByte(obj, (byte) 0);
                    break;
                }
                case "int": {
                    declaredField.setInt(obj, 0);
                    break;
                }
                case "short": {
                    declaredField.setShort(obj, (short) 0);
                    break;
                }
                case "char": {
                    declaredField.setChar(obj, (char) 0);
                    break;
                }
                case "long": {
                    declaredField.setLong(obj, (long) 0);
                    break;
                }
                case "double": {
                    declaredField.setDouble(obj, (double) 0);
                    break;
                }
                case "float": {
                    declaredField.setFloat(obj, (float) 0);
                    break;
                }
                case "boolean": {
                    declaredField.setBoolean(obj, false);
                    break;
                }
                default:
                    declaredField.set(obj, null);
            }
            declaredField.setAccessible(false);

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    /**
     * Выводим выбранные значения объекта.
     * @param fieldName выбранное значение.
     * @param obj объект.
     */
    private void printField(String fieldName, Object obj) {
        try {
            Field declaredField = obj.getClass().getDeclaredField(fieldName);
            String typeName = declaredField.getType().getCanonicalName();
            declaredField.setAccessible(true);
            switch (typeName) {
                case "byte": {
                    System.out.println(String.valueOf(declaredField.getByte(obj)));
                    break;
                }
                case "int": {
                    System.out.println(String.valueOf(declaredField.getInt(obj)));
                    break;
                }
                case "short": {
                    System.out.println(String.valueOf(declaredField.getShort(obj)));
                    break;
                }
                case "char": {
                    System.out.println(String.valueOf(declaredField.getChar(obj)));
                    break;
                }
                case "long": {
                    System.out.println(String.valueOf(declaredField.getLong(obj)));
                    break;
                }
                case "double": {
                    System.out.println(String.valueOf(declaredField.getDouble(obj)));
                    break;
                }
                case "float": {
                    System.out.println(String.valueOf(declaredField.getFloat(obj)));
                    break;
                }
                case "boolean": {
                    System.out.println(String.valueOf(declaredField.getBoolean(obj)));
                    break;
                }
                default:
                    if ( declaredField.get(obj) != null) {
                        System.out.println(declaredField.get(obj).toString());
                    } else {
                        System.out.println("null");
                    }
            }
            declaredField.setAccessible(false);

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
