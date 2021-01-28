package com.example.notifier.domain;

import java.util.Objects;

public class SkillTestInfo {
    private String name;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SkillTestInfo that = (SkillTestInfo) o;
        return name.equals(that.name) &&
                email.equals(that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, email);
    }

    public SkillTestInfo(String name, String email) {
        this.name = name;
        this.email = email;
    }
}
