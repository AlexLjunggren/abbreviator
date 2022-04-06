package io.ljunggren.abbreviator.manipulation.address;

import io.ljunggren.abbreviator.manipulation.Replacement;

public enum AddressReplacement implements Replacement {
    
    AVENUE("avenue", "Ave"),
    BOULEVARD("boulevard", "Blvd"),
    CENTER("center", "Ctr"),
    CIRLCE("circle", "Cir"),
    COURT("court", "Ct"),
    DRIVE("drive", "Dr"),
    EXPRESSWAY("expressway", "Expy"),
    HEIGHTS("heights", "Hts"),
    HIGHWAY("highway", "Hwy"),
    ISLAND("island", "Is"),
    JUNCTION("junction", "Jct"),
    LAKE("lake", "Lk"),
    LANE("lane", "Ln"),
    MOUNTAIN("mountain", "Mtn"),
    PARKWAY("parkway", "Pwy"),
    PLACE("place", "Pl"),
    PLAZA("plaza", "Plz"),
    RIDGE("ridge", "Rdg"),
    ROAD("road", "Rd"),
    SQUARE("square", "Sq"),
    STREET("street", "St"),
    STATION("station", "Sta"),
    TERRACE("terrace", "Ter"),
    TRAIL("trail", "Trl"),
    TURNPIKE("turnpike", "Tpke"),
    VALLEY("valley", "Vly"),
    
    APARTMENT("apartment", "Apt"),
    BUILDING("(?)building", "Bldg"),
    ROOM("room", "Rm"),
    SUITE("suite", "Ste"),
    
    EAST("east", "E"),
    NORTH("north", "N"),
    SOUTH("south", "S"),
    WEST("west", "W"),
    NORTHEAST("northeast", "NE"),
    NORTHWEST("northwest", "NW"),
    SOUTHEAST("southeast", "SE"),
    SOUTHWEST("southwest", "SW");

    private String string;
    private String abbreviation;
    
    AddressReplacement(String string, String abbreviation) {
        this.string = string;
        this.abbreviation = abbreviation;
    }
    
    @Override
    public String getAggressiveRegex() {
        return "(?i)" + this.string;
    }
    
    @Override
    public String getPassiveRegex() {
        return "(?<![a-zA-Z])(?i)" + this.string + "(?![a-zA-Z])";
    }
    
    @Override
    public String getAbbreviation() {
        return this.abbreviation;
    }

}
