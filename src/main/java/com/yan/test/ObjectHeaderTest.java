package com.yan.test;

import org.openjdk.jol.info.ClassLayout;
import org.w3c.dom.Node;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class ObjectHeaderTest {

    public static void main(String... args) {
        System.out.println(ClassLayout.parseInstance(new Boolean[20]).toPrintable());
    }
}