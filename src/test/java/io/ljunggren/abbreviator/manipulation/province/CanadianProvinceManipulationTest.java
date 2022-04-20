package io.ljunggren.abbreviator.manipulation.province;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import io.ljunggren.abbreviator.manipulation.Replacement;

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
    public void newBrunswickTest() {
        test("New Brunswick", "NB");
    }
    @Test
    public void newfoundlandAndLabradorTest() {
        test("Newfoundland and Labrador", "NL");
    }
    @Test
    public void northWestTerritoriesTest() {
        test("NorthWest Territories", "NT");
    }
    @Test
    public void novaScotiaTest() {
        test("Nova Scotia", "NS");
    }
    @Test
    public void nunavutTest() {
        test("Nunavut", "NU");
    }
    @Test
    public void ontarioTest() {
        test("Ontario", "ON");
    }
    @Test
    public void princeEdwardIslandTest() {
        test("Prince Edward Island", "PE");
    }
    @Test
    public void quebecTest() {
        test("Quebec", "QC");
    }
    @Test
    public void saskatchewanTest() {
        test("Saskatchewan", "SK");
    }
    @Test
    public void yukonTest() {
        test("Yukon", "YK");
    }

    @Test
    public void emptyTest() {
        assertEquals("", new CanadianProvinceManipulation(false, false, false).manipulate(""));
        assertEquals(null, new CanadianProvinceManipulation(false, false, false).manipulate(null));
    }
    
    @Test
    public void descriptionTest() {
        assertNotNull(new CanadianProvinceManipulation(false, false, false).description());
    }

}
