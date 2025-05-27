package org.example;

import java.util.ArrayList;
import java.util.List;

public class MetadataModel {
    private List<Component> components = new ArrayList<>();
    private List<Relation> relations = new ArrayList<>();

    public void addComponent(Component component) {
        components.add(component);
    }

    public void addRelation(Relation relation) {
        relations.add(relation);
    }
    public Component findByName(String name) {
        for (Component c : components) {
            if (c.getName().equals(name)) return c;
        }
        return null;
    }
    public void printModel() {
        System.out.println("=== Components ===");
        for (Component c : components) {
            System.out.println(c);
        }
        System.out.println("\n=== Relations ===");
        for (Relation r : relations) {
            System.out.println(r);
        }
    }


}
