package restassuredTest.utilities;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NestedScenarioFactory {


        public static class TestScenario {
            public Map<String, Object> payload;
            public int expectedStatus;

            public TestScenario(Map<String, Object> payload, int expectedStatus) {
                this.payload = payload;
                this.expectedStatus = expectedStatus;
            }
        }

        public static List<TestScenario> generateNestedScenarios(
                Map<String, int[]> ranges, int validStatus, int invalidStatus) {

            List<TestScenario> scenarios = new ArrayList<>();

            // Generate EP + BVA values for each nested path
            Map<String, List<Integer>> paramValues = new HashMap<>();
            for (Map.Entry<String, int[]> entry : ranges.entrySet()) {
                String path = entry.getKey(); // e.g. "customer.age"
                int min = entry.getValue()[0];
                int max = entry.getValue()[1];

                List<Integer> values = new ArrayList<>();
                values.add((min + max) / 2); // EP representative
                values.add(min - 1); values.add(max + 1); // invalid partitions
                values.add(min); values.add(min + 1); // lower boundary
                values.add(max - 1); values.add(max); // upper boundary
                paramValues.put(path, values);
            }

            // Cartesian product of nested values
            List<Map<String, Object>> combinations = cartesianProduct(paramValues);

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
                // Build nested JSON payload from flattened paths
                Map<String, Object> payload = buildNestedPayload(combo);
                scenarios.add(new TestScenario(payload, valid ? validStatus : invalidStatus));
            }

            return scenarios;
        }

        // Helper: build nested JSON from flattened paths
        private static Map<String, Object> buildNestedPayload(Map<String, Object> flatMap) {
            Map<String, Object> root = new HashMap<>();
            for (Map.Entry<String, Object> entry : flatMap.entrySet()) {
                String[] parts = entry.getKey().split("\\.");
                Map<String, Object> current = root;
                for (int i = 0; i < parts.length - 1; i++) {
                    current = (Map<String, Object>) current.computeIfAbsent(parts[i], k -> new HashMap<>());
                }
                current.put(parts[parts.length - 1], entry.getValue());
            }
            return root;
        }

        // Cartesian product helper (same as before)
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
    }

