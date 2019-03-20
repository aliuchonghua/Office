package com.westos.Information.util;

import java.util.UUID;

public class ID {
    public static String getID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
