package com.codecool.web.model;

import java.util.Objects;

public class Attribure extends AbstractModel {

    private final String name;
    private final String valueType;

    public Attribure(int id, String name, String valueType) {
        super(id);
        this.name = name;
        this.valueType = valueType;
    }

    public String getName() {
        return name;
    }

    public String getValueType() {
        return valueType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Attribure that = (Attribure) o;
        return Objects.equals(getName(), that.getName()) &&
                Objects.equals(getValueType(), that.getValueType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getName(), getValueType());
    }
}
