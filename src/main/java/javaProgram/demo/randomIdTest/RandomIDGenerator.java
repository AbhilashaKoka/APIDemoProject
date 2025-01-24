package javaProgram.demo.randomIdTest;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class RandomIDGenerator {
    private Set<String> uniqueIDs;

    public RandomIDGenerator() {
        uniqueIDs = new HashSet<>();
    }

    public String generateRandomID() {
        return UUID.randomUUID().toString();
    }

    public void addRandomID() {
        String randomID = generateRandomID();
        uniqueIDs.add(randomID);
        System.out.println("Added Random ID: " + randomID);
    }

    public Set<String> getUniqueIDs() {
        return uniqueIDs;
    }
}
