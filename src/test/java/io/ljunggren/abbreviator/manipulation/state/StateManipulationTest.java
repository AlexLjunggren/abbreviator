package io.ljunggren.abbreviator.manipulation.state;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class StateManipulationTest {

    private void test(String string, String abbreviation) {
        assertEquals(abbreviation, new StateManipulation(false, false, false).manipulate(string));
        assertEquals(abbreviation + ".", new StateManipulation(false, true, false).manipulate(string));
        assertEquals(abbreviation.toUpperCase() + ".", new StateManipulation(true, true, false).manipulate(string));
        assertEquals(abbreviation.toUpperCase(), new StateManipulation(true, false, false).manipulate(string));
        assertEquals(abbreviation + ",", new StateManipulation(false, false, false).manipulate(string + ","));
        assertEquals(abbreviation + ",", new StateManipulation(false, false, true).manipulate(string + ","));
        assertEquals(string + string, new StateManipulation(false, false, false).manipulate(string + string));
    }
    
    @Test
    public void alabamaTest() {
        test("Alabama", "AL");
    }
    
    @Test
    public void emptyTest() {
        assertEquals("", new StateManipulation(false, false, false).manipulate(""));
        assertEquals(null, new StateManipulation(false, false, false).manipulate(null));
    }
    
    @Test
    public void descriptionTest() {
        assertNotNull(new StateManipulation(false, false, false).description());
    }

}
