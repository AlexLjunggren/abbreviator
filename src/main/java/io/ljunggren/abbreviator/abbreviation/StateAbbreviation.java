package io.ljunggren.abbreviator.abbreviation;

import java.lang.annotation.Annotation;

import io.ljunggren.abbreviator.Item;
import io.ljunggren.abbreviator.annotation.AbbreviateState;
import io.ljunggren.abbreviator.manipulation.state.StateManipulation;

public class StateAbbreviation extends AbbreviationChain {

    @Override
    public void abbreviate(Annotation annotation, Item item) {
        if (annotation.annotationType() == AbbreviateState.class && isString(item)) {
            item.setValue(abbreviate(annotation, item.getValue().toString()));
            return;
        }
        nextChain.abbreviate(annotation, item);
    }

    private String abbreviate(Annotation annotation, String value) {
        AbbreviateState abbreviateAddress = (AbbreviateState) annotation;
        boolean capitalize = true;
        boolean usePeriod = false;
        boolean aggressive = abbreviateAddress.aggresive();
        return new StateManipulation(capitalize, usePeriod, aggressive).manipulate(value);
    }

}
