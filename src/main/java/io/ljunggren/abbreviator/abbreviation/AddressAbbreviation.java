package io.ljunggren.abbreviator.abbreviation;

import java.lang.annotation.Annotation;

import io.ljunggren.abbreviator.Item;
import io.ljunggren.abbreviator.annotation.AbbreviateAddress;
import io.ljunggren.abbreviator.manipulation.address.AddressManipulation;

public class AddressAbbreviation extends AbbreviationChain {
    
    @Override
    public void abbreviate(Annotation annotation, Item item) {
        if (annotation.annotationType() == AbbreviateAddress.class && isString(item)) {
            item.setValue(abbreviate(annotation, item.getValue().toString()));
            return;
        }
        nextChain.abbreviate(annotation, item);
    }
    
    private String abbreviate(Annotation annotation, String value) {
        AbbreviateAddress abbreviateAddress = (AbbreviateAddress) annotation;
        boolean capitalize = abbreviateAddress.capitalize();
        boolean usePeriod = abbreviateAddress.usePeriod();
        boolean aggressive = abbreviateAddress.aggresive();
        return new AddressManipulation(capitalize, usePeriod, aggressive).manipulate(value);
    }

}
