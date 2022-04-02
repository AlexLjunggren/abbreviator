package io.ljunggren.abbreviator.manipulation.state;

import io.ljunggren.abbreviator.manipulation.Replacement;

public enum StateReplacement implements Replacement {

    ALABAMA("(?i)alabama", "AL"),
    ALASKA("(?i)alaska", "AK"),
    ARIZONA("(?i)arizona", "AZ"),
    ARKANSAS("(?i)arkansas", "AR"),
    CALIFORNIA("(?i)california", "CA"),
    COLORADO("(?i)colorado", "CO"),
    CONNECTICUT("(?i)connecticut", "CT"),
    DELAWARE("(?i)delaware", "DE"),
    DISTRICT_OF_COLUMBIA("(?i)district of columbia", "DC"),
    FLORIDA("(?i)florida", "FL"),
    GEORGIA("(?i)georgia", "GA"),
    HAWAII("(?i)hawaii", "HI"),
    IDAHO("(?i)idaho", "ID"),
    ILLINOIS("(?i)illinois", "IL"),
    INDIANA("(?i)indiana", "IN"),
    IOWA("(?i)iowa", "IA"),
    KANSAS("(?i)kansas", "KS"),
    KENTUCKY("(?i)kentucky", "KY"),
    LOUISIANA("(?i)louisiana", "LA"),
    MAINE("(?i)maine", "ME"),
    MARYLAND("(?i)maryland", "MD"),
    MASSACHUSETTS("(?i)massachusetts", "MA"),
    MICHIGAN("(?i)michigan", "MI"),
    MINNESOTA("(?i)minnesota", "MN"),
    MISSISSIPPI("(?i)mississippi", "MS"),
    MISSOURI("(?i)missouri", "MO"),
    MONTANA("(?i)montana", "MT"),
    NEBRASKA("(?i)nebraska", "NE"),
    NEVADA("(?i)nevada", "NV"),
    NEW_HAMPSHIRE("(?i)new hampshire", "NH"),
    NEW_JERSEY("(?i)new jersey", "NJ"),
    NEW_MEXICO("(?i)new mexico", "NM"),
    NEW_YORK("(?i)new york", "NY"),
    NORTH_CAROLINA("(?i)north carolina", "NC"),
    NORTH_DAKOTA("(?i)north dakota", "ND"),
    OHIO("(?i)ohio", "OH"),
    OKLAHOMA("(?i)oklahoma", "OK"),
    OREGON("(?i)oregon", "OR"),
    PENNSYLVANIA("(?i)pennsylvania", "PA"),
    RHODE_ISLAND("(?i)rhode island", "RI"),
    SOUTH_CAROLINA("(?i)south carolina", "SC"),
    SOUTH_DAKOTA("(?i)south dakota", "SD"),
    TENNESSEE("(?i)tennessee", "TN"),
    TEXAS("(?i)texas", "TX"),
    UTAH("(?i)utah", "UT"),
    VERMONT("(?i)vermont", "VT"),
    VIRGINIA("(?i)virginia", "VA"),
    WASHINGTON("(?i)washington", "WA"),
    WEST_VIRGINIA("(?i)west virginia", "WV"),
    WISCONSIN("(?i)wisconsin", "WI"),
    WYOMING("(?i)wyoming", "WY");
    
    private String regex;
    private String abbreviation;
    
    StateReplacement(String regex, String abbreviation) {
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
