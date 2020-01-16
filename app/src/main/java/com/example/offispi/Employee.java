package com.example.offispi;

public class Employee {

    private String name;
    private String displayName;
    private boolean present;

    public Employee(String name, String displayName, boolean present) {
        this.name = name;
        this.displayName = displayName;
        this.present = present;
    }

    public String getName() {
        return name;
    }

    public String getDisplayName() {
        return displayName;
    }

    public boolean isPresent() {
        return present;
    }
}
