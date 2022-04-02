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
        return aggressive ? aggressiveManipulate(value, replacements) : passiveManipulate(value, replacements);
    }
    
    private String aggressiveManipulate(String value, Replacement[] replacements) {
        for (Replacement replacement: replacements) {
            value = value.replaceAll(replacement.getRegex(), getAbbreviation(replacement));
        }
        return value;
    }
    
    private String passiveManipulate(String value, Replacement[] replacements) {
        String[] splits = value.split("[^a-zA-Z]+");
        for (String split: splits) {
            for (Replacement replacement: replacements) {
                if (split.matches(replacement.getRegex())) {
                    value = value.replaceFirst(replacement.getRegex(), getAbbreviation(replacement));
                }
            }
        }
        return value;
    }
    
    private String getAbbreviation(Replacement replacement) {
        String abbreviation = replacement.getAbbreviation();
        abbreviation = isCapitalize ? abbreviation.toUpperCase() : abbreviation;
        return hasPeriod ? abbreviation + "." : abbreviation;
    }

}
