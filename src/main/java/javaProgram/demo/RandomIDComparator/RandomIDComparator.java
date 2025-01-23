package javaProgram.demo.RandomIDComparator;

import java.util.Set;
import java.util.UUID;

public class RandomIDComparator {
    private Set<String> existingIDs;


    public RandomIDComparator(Set<String> existingIDs) {
        this.existingIDs = existingIDs;
    }

    public void generateAndCompareID() {
        String newRandomID;
        do {
            newRandomID = UUID.randomUUID().toString();
            }
        while (existingIDs.contains(newRandomID));
        System.out.println("Generated Unique Random ID: " + newRandomID);
    }
}
