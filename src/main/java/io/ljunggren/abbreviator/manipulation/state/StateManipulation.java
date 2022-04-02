package io.ljunggren.abbreviator.manipulation.state;

import io.ljunggren.abbreviator.manipulation.Manipulation;

public class StateManipulation extends Manipulation<String> {

    public StateManipulation(boolean isCapitalize, boolean hasPeriod, boolean aggressive) {
        super(isCapitalize, hasPeriod, aggressive);
    }

    @Override
    public String manipulate(String value) {
        return manipulate(value, StateReplacement.values());
    }

    @Override
    public String description() {
        return "Replaces State with abbreviation";
    }

}
