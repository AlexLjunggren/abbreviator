package io.ljunggren.abbreviator.abbreviation;

import java.lang.annotation.Annotation;

import io.ljunggren.abbreviator.Item;

public class CatchAllAbbreviation extends AbbreviationChain {

    @Override
    public void abbreviate(Annotation annotation, Item item) {
        return;
    }

}
