package org.example;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

public class Main {
    public static void main(String[] args) throws Exception {
        MetadataModel model = new MetadataModel();
        DataLoader.loadComponents("src/main/java/org/example/data/components.csv", model);
        DataLoader.loadRelations("src/main/java/org/example/data/relations.csv", model);
        model.printModel();
    }
}
