package io.ljunggren.abbreviator.abbreviation;

import static org.junit.Assert.*;

import org.junit.Test;

import io.ljunggren.abbreviator.Abbreviator;
import io.ljunggren.abbreviator.annotation.AbbreviateAddress;
import lombok.AllArgsConstructor;
import lombok.Getter;

public class AddressAbbreviationTest {
    
    @AllArgsConstructor
    @Getter
    private class AddressAbbrPojo {
        @AbbreviateAddress(capitalize = false, usePeriod = true)
        private String address;
    }

    @Test
    public void abbreviateTest() {
        AddressAbbrPojo pojo = new AddressAbbrPojo("14 West Mountain Circle, Apartment 2A");
        new Abbreviator(pojo).abbreviate();
        assertEquals("14 W. Mtn. Cir., Apt. 2A", pojo.getAddress());
    }

}
