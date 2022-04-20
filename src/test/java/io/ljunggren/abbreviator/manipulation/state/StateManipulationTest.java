package io.ljunggren.abbreviator.manipulation.state;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import io.ljunggren.abbreviator.manipulation.Replacement;

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
    public void aggressiveRegexTest() {
        String string = "alabamaalabama";
        Replacement replacement = StateReplacement.ALABAMA;
        String replaced = string.replaceAll(replacement.getAggressiveRegex(), replacement.getAbbreviation());
        assertEquals("ALAL", replaced);
    }
    @Test
    public void passiveRegexTest() {
        String string = "alabamaalabama";
        Replacement replacement = StateReplacement.ALABAMA;
        String replaced = string.replaceAll(replacement.getPassiveRegex(), replacement.getAbbreviation());
        assertEquals(string, replaced);
    }
    
    @Test
    public void alabamaTest() {
        test("Alabama", "AL");
    }
    @Test
    public void alaskaTest() {
        test("Alaska", "AK");
    }
    @Test
    public void arizonaTest() {
        test("Arizona", "AZ");
    }
    @Test
    public void arkansasTest() {
        test("Arkansas", "AR");
    }
    @Test
    public void californiaTest() {
        test("California", "CA");
    }
    @Test
    public void coloradoTest() {
        test("Colorado", "CO");
    }
    @Test
    public void connecticutTest() {
        test("Connecticut", "CT");
    }
    @Test
    public void delawareTest() {
        test("Delaware", "DE");
    }
    @Test
    public void districtOfColumbiaTest() {
        test("District of Columbia", "DC");
    }
    @Test
    public void floridaTest() {
        test("Florida", "FL");
    }
    @Test
    public void georgiaTest() {
        test("Georgia", "GA");
    }
    @Test
    public void hawaiiTest() {
        test("Hawaii", "HI");
    }
    @Test
    public void idahoTest() {
        test("Idaho", "ID");
    }
    @Test
    public void illinoisTest() {
        test("Illinois", "IL");
    }
    @Test
    public void idianaTest() {
        test("Indiana", "IN");
    }
    @Test
    public void iowaTest() {
        test("Iowa", "IA");
    }
    @Test
    public void kansasTest() {
        test("Kansas", "KS");
    }
    @Test
    public void kentukyTest() {
        test("Kentucky", "KY");
    }
    @Test
    public void louisianaTest() {
        test("Louisiana", "LA");
    }
    @Test
    public void maineTest() {
        test("Maine", "ME");
    }
    @Test
    public void marylandTest() {
        test("Maryland", "MD");
    }
    @Test
    public void massachusettsTest() {
        test("Massachusetts", "MA");
    }
    @Test
    public void michiganTest() {
        test("Michigan", "MI");
    }
    @Test
    public void minnesotaTest() {
        test("Minnesota", "MN");
    }
    @Test
    public void mississippiTest() {
        test("Mississippi", "MS");
    }
    @Test
    public void missouriTest() {
        test("Missouri", "MO");
    }
    @Test
    public void montanaTest() {
        test("Montana", "MT");
    }
    @Test
    public void nebraskaTest() {
        test("Nebraska", "NE");
    }
    @Test
    public void nevadaTest() {
        test("Nevada", "NV");
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
