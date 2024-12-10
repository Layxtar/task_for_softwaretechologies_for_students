package org.softwaretechnologies;

import java.util.Optional;

public class ExceptionTask {
    /**
     * Исправленная функция printMessage.
     * Выводит сообщение и обрабатывает RuntimeException.
     */
    public static void printMessage() {
        try {
            throwRuntimeException();
        } catch (RuntimeException e) {
            System.out.println("Вызвана функция printMessage");
        }
    }

    /**
     * Исправленная функция printMessage2.
     * Выводит сообщение и обрабатывает Exception.
     */
    public static void printMessage2() throws Exception {
        try {
            throwCatchableException();
        } catch (Exception e) {
            System.out.println("Вызвана функция printMessage2");
        }
    }

    private static void throwCatchableException() throws Exception {
        throw new Exception();
    }

    private static void throwRuntimeException() {
        throw new RuntimeException();
    }

    /**
     * Функция divide.
     * Проверяет делитель и выбрасывает DivideOnNullException при делении на 0.
     */
    public static int divide(int dividend, int divisor) throws DivideOnNullException {
        if (divisor == 0) {
            throw new DivideOnNullException();
        }
        return dividend / divisor;
    }

    /**
     * Функция mergeStrings.
     * Возвращает Optional со строками, учитывая null-значения.
     */
    public static Optional<String> mergeStrings(String first, String second) {
        if (first == null && second == null) {
            return Optional.empty();
        }
        if (first == null) {
            return Optional.of(second);
        }
        if (second == null) {
            return Optional.of(first);
        }
        return Optional.of(first.length() >= second.length() ? first + second : second + first);
    }
}

