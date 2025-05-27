package org.example;

import java.util.List;

public class Relation {
    private String name;
    private Component from;
    private Component to;
    private List<Attribute> attributes;

    public Relation(String name, Component from, Component to, List<Attribute> attributes) {
        this.name = name;
        this.from = from;
        this.to = to;
        this.attributes = attributes;
    }

    public String getName() { return name; }
    public Component getFrom() { return from; }
    public Component getTo() { return to; }

    public List<Attribute> getAttributes() {
        return attributes;
    }

    @Override
    public String toString() {
        return from.getName() + " --" + name + "--> " + to.getName();
    }
}
