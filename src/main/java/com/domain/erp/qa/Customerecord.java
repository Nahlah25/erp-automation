package com.domain.erp.qa;

import java.util.Objects;

public class Customerecord {

    private int id;
    private String name;

    public Customerecord(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null)
            return false;

        if (getClass() != obj.getClass())
            return false;

        Customerecord other = (Customerecord) obj;

        return id == other.id &&
               Objects.equals(name, other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
    @Override
    public String toString() {
        return "id"+id+"name"+name;
    }
}