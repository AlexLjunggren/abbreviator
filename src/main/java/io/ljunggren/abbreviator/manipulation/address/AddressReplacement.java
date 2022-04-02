package io.ljunggren.abbreviator.manipulation.address;

import io.ljunggren.abbreviator.manipulation.Replacement;

public enum AddressReplacement implements Replacement {
    
    AVENUE("(?i)avenue", "Ave"),
    BOULEVARD("(?i)boulevard", "Blvd"),
    CENTER("(?i)center", "Ctr"),
    CIRLCE("(?i)circle", "Cir"),
    COURT("(?i)court", "Ct"),
    DRIVE("(?i)drive", "Dr"),
    EXPRESSWAY("(?i)expressway", "Expy"),
    HEIGHTS("(?i)heights", "Hts"),
    HIGHWAY("(?i)highway", "Hwy"),
    ISLAND("(?i)island", "Is"),
    JUNCTION("(?i)junction", "Jct"),
    LAKE("(?i)lake", "Lk"),
    LANE("(?i)lane", "Ln"),
    MOUNTAIN("(?i)mountain", "Mtn"),
    PARKWAY("(?i)parkway", "Pwy"),
    PLACE("(?i)place", "Pl"),
    PLAZA("(?i)plaza", "Plz"),
    RIDGE("(?i)ridge", "Rdg"),
    ROAD("(?i)road", "Rd"),
    SQUARE("(?i)square", "Sq"),
    STREET("(?i)street", "St"),
    STATION("(?i)station", "Sta"),
    TERRACE("(?i)terrace", "Ter"),
    TRAIL("(?i)trail", "Trl"),
    TURNPIKE("(?i)turnpike", "Tpke"),
    VALLEY("(?i)valley", "Vly"),
    
    APARTMENT("(?i)apartment", "Apt"),
    ROOM("(?i)room", "Rm"),
    SUITE("(?i)suite", "Ste"),
    
    NORTH("(?i)north", "N"),
    EAST("(?i)east", "E"),
    SOUTH("(?i)south", "S"),
    WEST("(?i)west", "W"),
    NORTHEAST("(?i)northeast", "NE"),
    NORTHWEST("(?i)northwest", "NW"),
    SOUTHEAST("(?i)southeast", "SE"),
    SOUTHWEST("(?i)southwest", "SW");

    private String regex;
    private String abbreviation;
    
    AddressReplacement(String regex, String abbreviation) {
        this.regex = regex;
        this.abbreviation = abbreviation;
    }
    
    @Override
    public String getRegex() {
        return this.regex;
    }
    
    @Override
    public String getAbbreviation() {
        return this.abbreviation;
    }

}
