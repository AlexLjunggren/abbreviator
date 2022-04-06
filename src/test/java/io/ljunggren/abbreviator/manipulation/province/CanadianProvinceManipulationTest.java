package io.ljunggren.abbreviator.manipulation.province;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import io.ljunggren.abbreviator.manipulation.Replacement;
import io.ljunggren.abbreviator.manipulation.state.StateManipulation;

public class CanadianProvinceManipulationTest {
    
    private void test(String string, String abbreviation) {
        assertEquals(abbreviation, new CanadianProvinceManipulation(false, false, false).manipulate(string));
        assertEquals(abbreviation + ".", new CanadianProvinceManipulation(false, true, false).manipulate(string));
        assertEquals(abbreviation.toUpperCase() + ".", new CanadianProvinceManipulation(true, true, false).manipulate(string));
        assertEquals(abbreviation.toUpperCase(), new CanadianProvinceManipulation(true, false, false).manipulate(string));
        assertEquals(abbreviation + ",", new CanadianProvinceManipulation(false, false, false).manipulate(string + ","));
        assertEquals(abbreviation + ",", new CanadianProvinceManipulation(false, false, true).manipulate(string + ","));
        assertEquals(string + string, new CanadianProvinceManipulation(false, false, false).manipulate(string + string));
    }
    
    @Test
    public void aggressiveRegexTest() {
        String string = "albertaalberta";
        Replacement replacement = CanadianProvinceReplacement.ALBERTA;
        String replaced = string.replaceAll(replacement.getAggressiveRegex(), replacement.getAbbreviation());
        assertEquals("ABAB", replaced);
    }
    @Test
    public void passiveRegexTest() {
        String string = "albertaalberta";
        Replacement replacement = CanadianProvinceReplacement.ALBERTA;
        String replaced = string.replaceAll(replacement.getPassiveRegex(), replacement.getAbbreviation());
        assertEquals(string, replaced);
    }
    
    @Test
    public void albertaTest() {
        test("Alberta", "AB");
    }
    @Test
    public void britishColumbiaTest() {
        test("British Columbia", "BC");
    }
    @Test
    public void manitobaTest() {
        test("Manitoba", "MB");
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
