package io.ljunggren.abbreviator.manipulation.state;

import io.ljunggren.abbreviator.manipulation.Replacement;

public enum StateReplacement implements Replacement {

    ALABAMA("alabama", "AL"),
    ALASKA("alaska", "AK"),
    ARIZONA("arizona", "AZ"),
    ARKANSAS("arkansas", "AR"),
    CALIFORNIA("california", "CA"),
    COLORADO("colorado", "CO"),
    CONNECTICUT("connecticut", "CT"),
    DELAWARE("delaware", "DE"),
    DISTRICT_OF_COLUMBIA("district of columbia", "DC"),
    FLORIDA("florida", "FL"),
    GEORGIA("georgia", "GA"),
    HAWAII("hawaii", "HI"),
    IDAHO("idaho", "ID"),
    ILLINOIS("illinois", "IL"),
    INDIANA("indiana", "IN"),
    IOWA("iowa", "IA"),
    KANSAS("kansas", "KS"),
    KENTUCKY("kentucky", "KY"),
    LOUISIANA("louisiana", "LA"),
    MAINE("maine", "ME"),
    MARYLAND("maryland", "MD"),
    MASSACHUSETTS("massachusetts", "MA"),
    MICHIGAN("michigan", "MI"),
    MINNESOTA("minnesota", "MN"),
    MISSISSIPPI("mississippi", "MS"),
    MISSOURI("missouri", "MO"),
    MONTANA("montana", "MT"),
    NEBRASKA("nebraska", "NE"),
    NEVADA("nevada", "NV"),
    NEW_HAMPSHIRE("new hampshire", "NH"),
    NEW_JERSEY("new jersey", "NJ"),
    NEW_MEXICO("new mexico", "NM"),
    NEW_YORK("new york", "NY"),
    NORTH_CAROLINA("north carolina", "NC"),
    NORTH_DAKOTA("north dakota", "ND"),
    OHIO("ohio", "OH"),
    OKLAHOMA("oklahoma", "OK"),
    OREGON("oregon", "OR"),
    PENNSYLVANIA("pennsylvania", "PA"),
    RHODE_ISLAND("rhode island", "RI"),
    SOUTH_CAROLINA("south carolina", "SC"),
    SOUTH_DAKOTA("south dakota", "SD"),
    TENNESSEE("tennessee", "TN"),
    TEXAS("texas", "TX"),
    UTAH("utah", "UT"),
    VERMONT("vermont", "VT"),
    VIRGINIA("virginia", "VA"),
    WASHINGTON("washington", "WA"),
    WEST_VIRGINIA("west virginia", "WV"),
    WISCONSIN("wisconsin", "WI"),
    WYOMING("wyoming", "WY");
    
    private String string;
    private String abbreviation;
    
    StateReplacement(String string, String abbreviation) {
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
