package io.ljunggren.abbreviator.abbreviation;

import static org.junit.Assert.*;

import org.junit.Test;

import io.ljunggren.abbreviator.Abbreviator;
import io.ljunggren.abbreviator.annotation.AbbreviateState;
import lombok.AllArgsConstructor;
import lombok.Getter;

public class StateAbbreviationTest {
    
    @AllArgsConstructor
    @Getter
    private class StateAbbrPojo {
        @AbbreviateState
        private String state;
    }

    @Test
    public void abbreviateTest() {
        StateAbbrPojo pojo = new StateAbbrPojo("Alabama");
        new Abbreviator(pojo).abbreviate();
        assertEquals("AL", pojo.getState());
    }

}
