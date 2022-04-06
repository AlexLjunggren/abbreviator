package io.ljunggren.abbreviator.manipulation.address;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import io.ljunggren.abbreviator.manipulation.Replacement;

public class AddressManipulationTest {
    
    private void test(String string, String abbreviation) {
        assertEquals(abbreviation, new AddressManipulation(false, false, false).manipulate(string));
        assertEquals(abbreviation + ".", new AddressManipulation(false, true, false).manipulate(string));
        assertEquals(abbreviation.toUpperCase() + ".", new AddressManipulation(true, true, false).manipulate(string));
        assertEquals(abbreviation.toUpperCase(), new AddressManipulation(true, false, false).manipulate(string));
        assertEquals(abbreviation + ",", new AddressManipulation(false, false, false).manipulate(string + ","));
        assertEquals(abbreviation + ",", new AddressManipulation(false, false, true).manipulate(string + ","));
        assertEquals(string + string, new AddressManipulation(false, false, false).manipulate(string + string));
    }
    
    @Test
    public void aggressiveRegexTest() {
        String string = "avenueavenue";
        Replacement replacement = AddressReplacement.AVENUE;
        String replaced = string.replaceAll(replacement.getAggressiveRegex(), replacement.getAbbreviation());
        assertEquals("AveAve", replaced);
    }

    @Test
    public void passiveRegexTest() {
        String string = "avenueavenue";
        Replacement replacement = AddressReplacement.AVENUE;
        String replaced = string.replaceAll(replacement.getPassiveRegex(), replacement.getAbbreviation());
        assertEquals(string, replaced);
    }

    @Test
    public void avenueTest() {
        test("Avenue", "Ave");
    }
    @Test
    public void boulevardTest() {
        test("Boulevard", "Blvd");
    }
    @Test
    public void centerTest() {
        test("Center", "Ctr");
    }
    @Test
    public void circleTest() {
        test("Circle", "Cir");
    }
    @Test
    public void courtTest() {
        test("Court", "Ct");
    }
    @Test
    public void driveTest() {
        test("Drive", "Dr");
    }
    @Test
    public void expresswayTest() {
        test("Expressway", "Expy");
    }
    @Test
    public void heightsTest() {
        test("Heights", "Hts");
    }
    @Test
    public void highwayTest() {
        test("Highway", "Hwy");
    }
    @Test
    public void islandTest() {
        test("Island", "Is");
    }
    @Test
    public void junctionTest() {
        test("Junction", "Jct");
    }
    @Test
    public void lakeTest() {
        test("Lake", "Lk");
    }
    @Test
    public void mountainTest() {
        test("Mountain", "Mtn");
    }
    @Test
    public void parkwayTest() {
        test("Parkway", "Pwy");
    }
    @Test
    public void placeTest() {
        test("Place", "Pl");
    }
    @Test
    public void plazaTest() {
        test("Plaza", "Plz");
    }
    @Test
    public void ridgeTest() {
        test("Ridge", "Rdg");
    }
    @Test
    public void roadTest() {
        test("Road", "Rd");
    }
    @Test
    public void squareTest() {
        test("Square", "Sq");
    }
    @Test
    public void streetTest() {
        test("Street", "St");
    }
    @Test
    public void stationTest() {
        test("Station", "Sta");
    }
    @Test
    public void terraceTest() {
        test("Terrace", "Ter");
    }
    @Test
    public void trailTest() {
        test("Trail", "Trl");
    }
    @Test
    public void turnpikeTest() {
        test("Turnpike", "Tpke");
    }
    @Test
    public void valleyTest() {
        test("Valley", "Vly");
    }
    
    @Test
    public void apartmentTest() {
        test("Apartment", "Apt");
    }
    @Test
    public void buildingTest() {
        test("Building", "Bldg");
    }
    @Test
    public void roomTest() {
        test("Room", "Rm");
    }
    @Test
    public void suiteTest() {
        test("Suite", "Ste");
    }
    
    @Test
    public void EastTest() {
        test("East", "E");
    }
    @Test
    public void northTest() {
        test("North", "N");
    }
    @Test
    public void southTest() {
        test("South", "S");
    }
    @Test
    public void westTest() {
        test("West", "W");
    }
    @Test
    public void northEastTest() {
        test("NorthEast", "NE");
    }
    @Test
    public void northWestTest() {
        test("NorthWest", "NW");
    }
    @Test
    public void southEastTest() {
        test("SouthEast", "SE");
    }
    @Test
    public void southWestTest() {
        test("SouthWest", "SW");
    }
    
    @Test
    public void emptyTest() {
        assertEquals("", new AddressManipulation(false, true, false).manipulate(""));
        assertEquals(null, new AddressManipulation(false, true, false).manipulate(null));
    }
    
    @Test
    public void descriptionTest() {
        assertNotNull(new AddressManipulation(false, true, false).description());
    }

}
