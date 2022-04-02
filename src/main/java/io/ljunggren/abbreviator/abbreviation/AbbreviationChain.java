package io.ljunggren.abbreviator.abbreviation;

import java.lang.annotation.Annotation;

import io.ljunggren.abbreviator.Item;

public abstract class AbbreviationChain {
    
    protected AbbreviationChain nextChain;
    
    public AbbreviationChain nextChain(AbbreviationChain nextChain) {
        this.nextChain = nextChain;
        return this;
    }
    
    public abstract void abbreviate(Annotation annotation, Item item);
    
    protected boolean isString(Item item) {
        return item.getValue() instanceof String;
    }

}
