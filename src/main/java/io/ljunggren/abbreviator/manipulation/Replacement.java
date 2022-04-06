package io.ljunggren.abbreviator.manipulation;

public interface Replacement {

    String getPassiveRegex();
    String getAggressiveRegex();
    String getAbbreviation();
    
}
