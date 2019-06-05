package com.codecool.web.model;

import java.util.Objects;

public class Value {

    private final int productId;
    private final int attributeId;
    private final int intValue;
    private final int stringValue;
    private final boolean booleanValue;

    public Value( int productId, int attributeId, int intValue, int stringValue, boolean booleanValue) {
        this.productId = productId;
        this.attributeId = attributeId;
        this.intValue = intValue;
        this.stringValue = stringValue;
        this.booleanValue = booleanValue;
    }

    public int getProductId() {
        return productId;
    }

    public int getAttributeId() {
        return attributeId;
    }

    public int getIntValue() {
        return intValue;
    }

    public int getStringValue() {
        return stringValue;
    }

    public boolean isBooleanValue() {
        return booleanValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Value value = (Value) o;
        return getProductId() == value.getProductId() &&
                getAttributeId() == value.getAttributeId() &&
                getIntValue() == value.getIntValue() &&
                getStringValue() == value.getStringValue() &&
                isBooleanValue() == value.isBooleanValue();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getProductId(), getAttributeId(), getIntValue(), getStringValue(), isBooleanValue());
    }
}
