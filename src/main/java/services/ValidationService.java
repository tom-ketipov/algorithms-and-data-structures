package services;

import java.util.LinkedList;

public class ValidationService {
    public static void validateInRange(int value, int min, int max, String message) {
        if (value < min || value > max) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void validateInRange(long value, long min, long max, String message) {
        if (value < min || value > max) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void validateNotNull(Object str, String message) {
        if (str == null) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void validateNotNull(Object[] array, String message) {
        if (array == null) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void validateNotEmpty(Object[] array, String message) {
        if (array.length == 0) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void validateInArrayBounds(Object[] array, int index, String message) {
        if (index < 0 || index >= array.length) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void validateNotNull(int[] array, String message) {
        if (array == null) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void validateNotEmpty(int[] array, String message) {
        if (array.length == 0) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void validateArrayIndexesInRange(int[] array, int min, int max, String message) {
        for (int indexValue : array) {
            validateInRange(indexValue, min, max, message);
        }
    }

    public static void validateInArrayBounds(int[] array, int index, String message) {
        if (index < 0 || index >= array.length) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void validateNotNull(long[] array, String message) {
        if (array == null) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void validateNotEmpty(long[] array, String message) {
        if (array.length == 0) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void validateArrayIndexesInRange(long[] array, long min, long max, String message) {
        for (long indexValue : array) {
            validateInRange(indexValue, min, max, message);
        }
    }

    public static void validateInArrayBounds(long[] array, int index, String message) {
        if (index < 0 || index >= array.length) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void validateNotNull(LinkedList<Object> linkedList, String message) {
        if (linkedList == null) {
            throw new IllegalArgumentException(message);
        }
    }
}
