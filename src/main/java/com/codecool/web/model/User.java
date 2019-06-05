package com.codecool.web.model;

import java.util.Objects;

public final class User extends AbstractModel {

    private final String username;
    private final String email;
    private final String password;
    private final boolean role;

    public User(int id, String username, String email, String password, boolean role) {
        super(id);
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public boolean isRole() {
        return role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        User user = (User) o;
        return isRole() == user.isRole() &&
                Objects.equals(getUsername(), user.getUsername()) &&
                Objects.equals(getEmail(), user.getEmail()) &&
                Objects.equals(getPassword(), user.getPassword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getUsername(), getEmail(), getPassword(), isRole());
    }
}
