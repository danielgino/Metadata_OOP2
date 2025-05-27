package org.example;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.util.List;

public class DataLoader {

    public static void loadComponents(String path, MetadataModel model) throws Exception {
        try (CSVReader reader = new CSVReader(new FileReader(path))) {
            String[] header = reader.readNext();
            String[] line;
            while ((line = reader.readNext()) != null) {
                Component c = new Component(line[0], line[1]);
                for (int i = 2; i < header.length; i++) {
                    if (i < line.length && !line[i].isEmpty()) {
                        c.addAttribute(new Attribute(header[i], line[i]));
                    }
                }
                model.addComponent(c);
            }
        }
    }

    public static void loadRelations(String path, MetadataModel model) throws Exception {
        try (CSVReader reader = new CSVReader(new FileReader(path))) {
            reader.readNext();
            String[] line;
            while ((line = reader.readNext()) != null) {
                Component from = model.findByName(line[0]);
                Component to = model.findByName(line[2]);
                if (from != null && to != null) {
                    List<Attribute> relationAttrs = List.of(new Attribute("RelationType", line[3]));
                    model.addRelation(new Relation(line[1], from, to, relationAttrs));

                } else {
                    System.out.println("error" + line[0] + " " + line[2]);
                }
            }
        }
    }
}
