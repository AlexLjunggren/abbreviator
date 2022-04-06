package io.ljunggren.abbreviator.manipulation;

import org.apache.commons.lang3.StringUtils;

public abstract class Manipulation<T> {

    protected boolean isCapitalize;
    protected boolean hasPeriod;
    protected boolean aggressive;
    
    public Manipulation(boolean isCapitalize, boolean hasPeriod, boolean aggressive) {
        this.isCapitalize = isCapitalize;
        this.hasPeriod = hasPeriod;
        this.aggressive = aggressive;
    }
    
    public abstract String manipulate(T value);
    public abstract String description();
    
    protected String manipulate(String value, Replacement[] replacements) {
        if (StringUtils.isEmpty(value)) {
            return value;
        }
        for (Replacement replacement: replacements) {
            value = value.replaceAll(
                    aggressive ? replacement.getAggressiveRegex() : replacement.getPassiveRegex(),
                    getAbbreviation(replacement));
        }
        return value;
    }
    
    private String getAbbreviation(Replacement replacement) {
        String abbreviation = replacement.getAbbreviation();
        abbreviation = isCapitalize ? abbreviation.toUpperCase() : abbreviation;
        return hasPeriod ? abbreviation + "." : abbreviation;
    }

}
