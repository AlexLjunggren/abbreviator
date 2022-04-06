package io.ljunggren.abbreviator;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.reflect.FieldUtils;

import io.ljunggren.abbreviator.abbreviation.AddressAbbreviation;
import io.ljunggren.abbreviator.abbreviation.CanadianProvinceAbbreviation;
import io.ljunggren.abbreviator.abbreviation.CatchAllAbbreviation;
import io.ljunggren.abbreviator.abbreviation.StateAbbreviation;
import lombok.Getter;

@Getter
public class Abbreviator {
    
    private Object object;
    
    public Abbreviator(Object object) {
        this.object = object;
    }
    
    public Abbreviator abbreviate() {
        List<Item> items = findItems(object);
        abbreviateItems(items);
        return this;
    }

    private List<Item> findItems(Object object) {
        List<Item> items = new ArrayList<Item>();
        List<Field> fields = findObjectFields(object);
        for (Field field : fields) {
            try {
                Object value = FieldUtils.readField(field, object, true);
                items.add(new Item(object, field, value));
            } catch (IllegalAccessException e) {
                // TODO: Add something here
            }
        }
        return items;
    }
    
    private List<Field> findObjectFields(Object object) {
        if (object != null) {
            Class<?> clazz = object.getClass();
            return FieldUtils.getAllFieldsList(clazz);
        }
        return new ArrayList<Field>();
    }
    
    private void abbreviateItems(List<Item> items) {
        items.stream().forEach(item -> abbreviateItem(item));
    }
    
    private void abbreviateItem(Item item) {
        Annotation[] annotations = item.getField().getAnnotations();
        Arrays.asList(annotations).forEach(annotation -> abbreviateChain(annotation, item));
    }
    
    private void abbreviateChain(Annotation annotation, Item item) {
        new AddressAbbreviation().nextChain(
                new CanadianProvinceAbbreviation().nextChain(
                new StateAbbreviation().nextChain(
                new CatchAllAbbreviation()
                        ))).abbreviate(annotation, item);
    }
    
}
