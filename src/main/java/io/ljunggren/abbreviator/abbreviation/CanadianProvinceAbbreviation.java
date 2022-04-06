package io.ljunggren.abbreviator.abbreviation;

import java.lang.annotation.Annotation;

import io.ljunggren.abbreviator.Item;
import io.ljunggren.abbreviator.annotation.AbbreviateCanadianProvince;
import io.ljunggren.abbreviator.manipulation.province.CanadianProvinceManipulation;

public class CanadianProvinceAbbreviation extends AbbreviationChain {

    @Override
    public void abbreviate(Annotation annotation, Item item) {
        if (annotation.annotationType() == AbbreviateCanadianProvince.class && isString(item)) {
            item.setValue(abbreviate(annotation, item.getValue().toString()));
            return;
        }
        nextChain.abbreviate(annotation, item);
    }

    private String abbreviate(Annotation annotation, String value) {
        AbbreviateCanadianProvince abbreviateAddress = (AbbreviateCanadianProvince) annotation;
        boolean capitalize = true;
        boolean usePeriod = false;
        boolean aggressive = abbreviateAddress.aggresive();
        return new CanadianProvinceManipulation(capitalize, usePeriod, aggressive).manipulate(value);
    }

}
