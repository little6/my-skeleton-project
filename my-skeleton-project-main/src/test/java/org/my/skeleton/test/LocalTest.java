package org.my.skeleton.test;

import org.joda.time.DateTime;

public class LocalTest {

    public static void main(String[] args) {
        Double d = 21.32;
        Double d2 = null;
        System.out.println(String.valueOf(d));
        System.out.println(String.valueOf(d2));
        System.out.println(new DateTime().plusDays(1).toString("yyyy-MM-dd HH:mm:ss sss"));
    }
}
