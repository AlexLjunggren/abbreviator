package io.ljunggren.abbreviator.manipulation.province;

import io.ljunggren.abbreviator.manipulation.Manipulation;

public class CanadianProvinceManipulation extends Manipulation<String> {

    public CanadianProvinceManipulation(boolean isCapitalize, boolean hasPeriod, boolean aggressive) {
        super(isCapitalize, hasPeriod, aggressive);
    }

    @Override
    public String manipulate(String value) {
        return manipulate(value, CanadianProvinceReplacement.values());
    }

    @Override
    public String description() {
        return "Replaces Canadian Province(s) with abbreviation";
    }

}

