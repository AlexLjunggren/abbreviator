package io.ljunggren.abbreviator.abbreviation;

import static org.junit.Assert.*;

import org.junit.Test;

import io.ljunggren.abbreviator.Abbreviator;
import io.ljunggren.abbreviator.annotation.AbbreviateAddress;
import lombok.AllArgsConstructor;
import lombok.Getter;

public class CatchAllAbbreviationTest {
    
    @AllArgsConstructor
    @Getter
    private class CatchAllAbbrPojo {
        @AbbreviateAddress(capitalize = false, usePeriod = true)
        private int age;
    }

    @Test
    public void test() {
        CatchAllAbbrPojo pojo = new CatchAllAbbrPojo(40);
        new Abbreviator(pojo).abbreviate();
        assertEquals(40 , pojo.getAge());
    }

}
