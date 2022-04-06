package io.ljunggren.abbreviator.abbreviation;

import static org.junit.Assert.*;

import org.junit.Test;

import io.ljunggren.abbreviator.Abbreviator;
import io.ljunggren.abbreviator.annotation.AbbreviateCanadianProvince;
import lombok.AllArgsConstructor;
import lombok.Getter;

public class CanadianProvinceAbbreviationTest {
    
    @AllArgsConstructor
    @Getter
    private class CandadianProvincePojo {
        @AbbreviateCanadianProvince
        private String province;
    }

    @Test
    public void abbreviateTest() {
        CandadianProvincePojo pojo = new CandadianProvincePojo("British Columbia");
        new Abbreviator(pojo).abbreviate();
        assertEquals("BC", pojo.getProvince());
    }

}
