package io.ljunggren.abbreviator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import io.ljunggren.abbreviator.annotation.AbbreviateAddress;
import lombok.AllArgsConstructor;
import lombok.Getter;

public class AbbreviatorTest {
    
    @AllArgsConstructor
    @Getter
    private class TestPojo {
        @AbbreviateAddress(capitalize = false, usePeriod = true)
        private String address;
    }

    @Test
    public void test() {
        TestPojo pojo = new TestPojo("14 West Mountain Circle, Apartment 2A");
        new Abbreviator(pojo).abbreviate();
        assertEquals("14 W. Mtn. Cir., Apt. 2A", pojo.getAddress());
    }

}
