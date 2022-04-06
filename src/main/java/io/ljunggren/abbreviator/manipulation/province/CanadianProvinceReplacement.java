package io.ljunggren.abbreviator.manipulation.province;

import io.ljunggren.abbreviator.manipulation.Replacement;

public enum CanadianProvinceReplacement implements Replacement {
    ALBERTA("alberta", "AB"),
    BRITISH_COLUMBIA("British Columbia", "BC"),
    MANITOBA("manitoba", "MB"),
    NEW_BRUNSWICK("new brunswick", "NB"),
    NEWFOUNDLAND_AND_LABRADOR("newfoundland and labrador", "NL"),
    NORTHWEST_TERRITORIES("northwest territories", "NT"),
    NOVA_SCOTIA("nova scotia", "NS"),
    NUNAVUT("nunavut", "NU"),
    ONTARIO("ontario", "ON"),
    PRINCE_EDWARD_ISLAND("prince edward island", "PE"),
    QUEBEC("quebec", "QC"),
    SASKATCHEWAN("saskatchewan", "SK"),
    YUKON("yukon", "YK");
    
    private String string;
    private String abbreviation;
    
    CanadianProvinceReplacement(String string, String abbreviation) {
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
