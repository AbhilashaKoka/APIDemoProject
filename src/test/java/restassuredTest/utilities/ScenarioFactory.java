package restassuredTest.utilities;
import java.util.ArrayList;
import java.util.List;

public class ScenarioFactory {
    public static class TestScenario {
        public int input;
        public int expectedStatus;

        public TestScenario(int input, int expectedStatus) {
            this.input = input;
            this.expectedStatus = expectedStatus;
        }

        @Override
        public String toString() {
            return "Input: " + input + ", Expected: " + expectedStatus;
        }
    }

    /**
     * Generate Equivalence Partitioning (EP) scenarios
     */
    public static List<TestScenario> generateEP(int min, int max, int validStatus, int invalidStatus) {
        List<TestScenario> scenarios = new ArrayList<>();
        // Valid partition (pick a mid-value)
        scenarios.add(new TestScenario((min + max) / 2, validStatus));
        // Invalid partitions
        scenarios.add(new TestScenario(min - 1, invalidStatus));
        scenarios.add(new TestScenario(max + 1, invalidStatus));
        return scenarios;
    }

    /**
     * Generate Boundary Value Analysis (BVA) scenarios
     */
    public static List<TestScenario> generateBVA(int min, int max, int validStatus, int invalidStatus) {
        List<TestScenario> scenarios = new ArrayList<>();
        scenarios.add(new TestScenario(min - 1, invalidStatus)); // just below lower boundary
        scenarios.add(new TestScenario(min, validStatus));       // lower boundary
        scenarios.add(new TestScenario(min + 1, validStatus));   // just above lower boundary
        scenarios.add(new TestScenario(max - 1, validStatus));   // just below upper boundary
        scenarios.add(new TestScenario(max, validStatus));       // upper boundary
        scenarios.add(new TestScenario(max + 1, invalidStatus)); // just above upper boundary
        return scenarios;
    }

    /**
     * Unified factory method to generate EP + BVA scenarios
     */
    public static List<TestScenario> generateScenarios(int min, int max, int validStatus, int invalidStatus) {
        List<TestScenario> allScenarios = new ArrayList<>();
        allScenarios.addAll(generateEP(min, max, validStatus, invalidStatus));
        allScenarios.addAll(generateBVA(min, max, validStatus, invalidStatus));
        return allScenarios;
    }

    // Example usage
    public static void main(String[] args) {
        List<TestScenario> scenarios = generateScenarios(18, 60, 200, 400);
        scenarios.forEach(System.out::println);
    }
}
