package com.codecool.web.model;

import java.util.Objects;

public class Value {


    private final int attributeId;
    private final int productId;
    private final int intValue;
    private final String stringValue;
    private final boolean booleanValue;

    public Value(int attributeId, int productId, int intValue, String stringValue, boolean booleanValue) {
        this.attributeId = attributeId;
        this.productId = productId;
        this.intValue = intValue;
        this.stringValue = stringValue;
        this.booleanValue = booleanValue;
    }

    public int getAttributeId() {
        return attributeId;
    }

    public int getProductId() {
        return productId;
    }

    public int getIntValue() {
        return intValue;
    }

    public String getStringValue() {
        return stringValue;
    }

    public boolean isBooleanValue() {
        return booleanValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Value value = (Value) o;
        return getAttributeId() == value.getAttributeId() &&
                getProductId() == value.getProductId() &&
                getIntValue() == value.getIntValue() &&
                isBooleanValue() == value.isBooleanValue() &&
                Objects.equals(getStringValue(), value.getStringValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAttributeId(), getProductId(), getIntValue(), getStringValue(), isBooleanValue());
    }
}
