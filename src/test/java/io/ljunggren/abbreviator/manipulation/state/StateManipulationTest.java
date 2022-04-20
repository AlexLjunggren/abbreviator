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
        assertEquals(string + "filler", new StateManipulation(false, false, false).manipulate(string + "filler"));
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
    public void newHampshireTest() {
        test("New Hampshire", "NH");
    }
    @Test
    public void newJerseyTest() {
        test("New Jersey", "NJ");
    }
    @Test
    public void newMexicoTest() {
        test("New Mexico", "NM");
    }
    @Test
    public void newYorkTest() {
        test("New York", "NY");
    }
    @Test
    public void northCarolinaTest() {
        test("North Carolina", "NC");
    }
    @Test
    public void northDakotaTest() {
        test("North Dakota", "ND");
    }
    @Test
    public void ohioTest() {
        test("Ohio", "OH");
    }
    @Test
    public void oklahomaTest() {
        test("Oklahoma", "OK");
    }
    @Test
    public void oregonTest() {
        test("Oregon", "OR");
    }
    @Test
    public void pennsylvainiaTest() {
        test("Pennsylvania", "PA");
    }
    @Test
    public void rhodeIslandTest() {
        test("Rhode Island", "RI");
    }
    @Test
    public void southDakotaTest() {
        test("South Dakota", "SD");
    }
    @Test
    public void tennesseeTest() {
        test("Tennessee", "TN");
    }
    @Test
    public void texasTest() {
        test("Texas", "TX");
    }
    @Test
    public void utahTest() {
        test("Utah", "UT");
    }
    @Test
    public void vermontTest() {
        test("Vermont", "VT");
    }
    @Test
    public void virginiaTest() {
        test("Virginia", "VA");
    }
    @Test
    public void washingtonTest() {
        test("Washington", "WA");
    }
    @Test
    public void wetVirginiaTest() {
        test("West Virginia", "WV");
    }
    @Test
    public void wisconsinTest() {
        test("Wisconsin", "WI");
    }
    @Test
    public void wyomingTest() {
        test("Wyoming", "WY");
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
