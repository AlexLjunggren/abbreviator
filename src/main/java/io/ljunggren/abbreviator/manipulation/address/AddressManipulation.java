package io.ljunggren.abbreviator.manipulation.address;

import io.ljunggren.abbreviator.manipulation.Manipulation;

public class AddressManipulation extends Manipulation<String> {
    
    public AddressManipulation(boolean capitalize, boolean usePeriod, boolean aggressive) {
        super(capitalize, usePeriod, aggressive);
    }
    
    @Override
    public String manipulate(String value) {
        return manipulate(value, AddressReplacement.values());
    }

    @Override
    public String description() {
        return "Replace with Street abbreviation(s)";
    }
    
}
