package io.ljunggren.abbreviator;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.Field;

import org.apache.commons.lang3.reflect.FieldUtils;
import org.junit.Test;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class ItemTest {

    @AllArgsConstructor
    @Getter
    private class TestPojo {
        public String address;
    }

    @Test
    public void setValueTest() {
        TestPojo pojo = new TestPojo("14 West Mountain Circle, Apartment 2A");
        String value = "14 W. Mtn. Cir., Apt. 2A";
        Field field = FieldUtils.getDeclaredField(TestPojo.class, "address");
        Item item = new Item(pojo, field, value);
        item.setValue(value);
        assertEquals(value, pojo.getAddress());
    }
    
}
