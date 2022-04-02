package io.ljunggren.abbreviator.manipulation.address;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

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
    public void longStringTest() {
        String string = "  1 Main     Street  ";
        String expected = "  1 Main     St  ";
        assertEquals(expected, new AddressManipulation(false, false, false).manipulate(string));
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
    public void streetTest() {
        test("Street", "St");
    }
    @Test
    public void roadTest() {
        test("Road", "Rd");
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
