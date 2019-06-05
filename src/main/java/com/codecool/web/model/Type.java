package com.codecool.web.model;

import java.util.Objects;

public class Type extends AbstractModel {

    private final String name;

    public Type(int id, String name) {
        super(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Type type = (Type) o;
        return Objects.equals(getName(), type.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getName());
    }
}
