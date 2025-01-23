package javaProgram.demo.RandomIDComparator;

public class Main {
    public static void main(String[] args) {
        // Initialize RandomIDGenerator and generate some IDs
        RandomIDGenerator idGenerator = new RandomIDGenerator();
        for (int i = 0; i < 5; i++)
        {
            idGenerator.addRandomID();
        }

        // Initialize RandomIDComparator with the existing IDs
        RandomIDComparator idComparator = new RandomIDComparator(idGenerator.getUniqueIDs());

        // Generate and compare new random IDs
        idComparator.generateAndCompareID();
        idComparator.generateAndCompareID();  // Generate another unique ID
    }
}
