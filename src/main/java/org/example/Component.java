package org.example;

import java.util.ArrayList;
import java.util.List;

public class Component {
    private String name;
    private String type;
    private List<Attribute> attributes;

    public Component(String name, String type) {
        this.name = name;
        this.type = type;
        this.attributes = new ArrayList<>();
    }

    public void addAttribute(Attribute attribute) {
        attributes.add(attribute);
    }

    public String getName() { return name; }
    public String getType() { return type; }
    public List<Attribute> getAttributes() { return attributes; }

    @Override
    public String toString() {
        return type + ": " + name + " " + attributes;
    }
}
