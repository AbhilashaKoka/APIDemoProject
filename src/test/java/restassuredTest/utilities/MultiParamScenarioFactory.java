package restassuredTest.utilities;
import java.util.*;

public class MultiParamScenarioFactory {

    public static class TestScenario {
        public Map<String, Object> inputs;
        public int expectedStatus;

        public TestScenario(Map<String, Object> inputs, int expectedStatus) {
            this.inputs = inputs;
            this.expectedStatus = expectedStatus;
        }

        @Override
        public String toString() {
            return "Inputs: " + inputs + ", Expected: " + expectedStatus;
        }
    }

    /**
     * Generate EP + BVA scenarios for multiple parameters
     */
    public static List<TestScenario> generateScenarios(
            Map<String, int[]> ranges, int validStatus, int invalidStatus) {

        List<TestScenario> scenarios = new ArrayList<>();

        // For each parameter, generate EP + BVA values
        Map<String, List<Integer>> paramValues = new HashMap<>();
        for (Map.Entry<String, int[]> entry : ranges.entrySet()) {
            String param = entry.getKey();
            int min = entry.getValue()[0];
            int max = entry.getValue()[1];

            List<Integer> values = new ArrayList<>();
            // EP representative
            values.add((min + max) / 2);
            values.add(min - 1);
            values.add(max + 1);
            // BVA
            values.add(min - 1);
            values.add(min);
            values.add(min + 1);
            values.add(max - 1);
            values.add(max);
            values.add(max + 1);

            paramValues.put(param, values);
        }

        // Cartesian product of parameter values
        List<Map<String, Object>> combinations = cartesianProduct(paramValues);

        // Assign expected status
        for (Map<String, Object> combo : combinations) {
            boolean valid = true;
            for (Map.Entry<String, Object> entry : combo.entrySet()) {
                int value = (int) entry.getValue();
                int min = ranges.get(entry.getKey())[0];
                int max = ranges.get(entry.getKey())[1];
                if (value < min || value > max) {
                    valid = false;
                    break;
                }
            }
            scenarios.add(new TestScenario(combo, valid ? validStatus : invalidStatus));
        }

        return scenarios;
    }

    /**
     * Cartesian product helper
     */
    private static List<Map<String, Object>> cartesianProduct(Map<String, List<Integer>> paramValues) {
        List<Map<String, Object>> results = new ArrayList<>();
        cartesianRecursive(new ArrayList<>(paramValues.keySet()), paramValues, 0, new HashMap<>(), results);
        return results;
    }

    private static void cartesianRecursive(List<String> keys, Map<String, List<Integer>> paramValues,
                                           int index, Map<String, Object> current, List<Map<String, Object>> results) {
        if (index == keys.size()) {
            results.add(new HashMap<>(current));
            return;
        }
        String key = keys.get(index);
        for (Integer value : paramValues.get(key)) {
            current.put(key, value);
            cartesianRecursive(keys, paramValues, index + 1, current, results);
        }
    }

//    // Example usage
//    public static void main(String[] args) {
//        Map<String, int[]> ranges = new HashMap<>();
//        ranges.put("age", new int[]{18, 60});
//        ranges.put("amount", new int[]{100, 1000});
//
//        List<TestScenario> scenarios = generateScenarios(ranges, 200, 400);
//        scenarios.forEach(System.out::println);
//    }
}
