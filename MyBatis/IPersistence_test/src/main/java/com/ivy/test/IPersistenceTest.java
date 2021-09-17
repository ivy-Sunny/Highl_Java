package com.ivy.test;

import com.ivy.io.Resources;

import java.io.InputStream;

public class IPersistenceTest {
    public void test() {
        InputStream resourceAsStream =  Resources.getResourceAsStream("sqlMapConfig.xml");
    }
}
