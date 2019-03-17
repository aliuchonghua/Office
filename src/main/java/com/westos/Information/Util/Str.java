package com.westos.Information.Util;

public class Str {
    public static boolean isAnyEmpty(String str) {
        return isBlank(str) || isEmpty(str) || "null".equalsIgnoreCase(str);
    }
    public static boolean isNotAnyEmpty(String str) {
        return !isAnyEmpty(str);
    }

    public static boolean isEmpty(String string) {
        return string == null || string.length() == 0;
    }

    public static boolean isBlank(String string) {
        return string == null || containsOnlyWhitespaces(string);
    }

    private static boolean containsOnlyWhitespaces(String string) {
        int size = string.length();

        for (int i = 0; i < size; ++i) {
            char c = string.charAt(i);

            if (!isWhitespace(c)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isWhitespace(char c) {
        return c <= ' ';
    }

}
