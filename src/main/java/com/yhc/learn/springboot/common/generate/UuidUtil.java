package com.yhc.learn.springboot.common.generate;

import java.util.UUID;

public class UuidUtil {
    public static String getUuid() {
        String uuid=  UUID.randomUUID().toString().replace("-","");
        return uuid;
    }
}
