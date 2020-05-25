package com.daquan.chapter1;

import java.util.concurrent.ConcurrentHashMap;

public class TestConcurrentHashMap {
    public static void main(String[] args) {
        ConcurrentHashMap map = new ConcurrentHashMap();
        map.size();
        map.put("123","123");
        map.get("123");
        map.entrySet();
        map.clear();
    }
}
