package com.appointment.api;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.LinkedList;
import java.util.List;


@RunWith(MockitoJUnitRunner.class)
public class TestClass {
    @Test
    public void test() {
    }

    @Test
    public void test2() {
        System.out.println("".toUpperCase());
    }

    @Test
    public void test3() {
        List<String> list = new LinkedList<>();;
        fillList(list);
        System.out.println(list);
    }

    private void fillList(List<String> list) {
        list.add("osman");
    }
}
