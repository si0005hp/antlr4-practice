package com.example;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class CalcTest {
    @Test
    public void test() {
        assertThat(new Calc().calc("1+2"), is(3));
        assertThat(new Calc().calc("5-3"), is(2));
        assertThat(new Calc().calc("2*3"), is(6));
        assertThat(new Calc().calc("8/4"), is(2));
        assertThat(new Calc().calc("1+2*3-12/4+30+1-7*10/2"), is(0));
    }
}
