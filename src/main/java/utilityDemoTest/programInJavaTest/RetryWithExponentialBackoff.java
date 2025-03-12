package utilityDemoTest.programInJavaTest;

import java.util.concurrent.TimeUnit;

public class RetryWithExponentialBackoff {

    public static void main(String[] args) {
        int maxRetries = 5; // Maximum number of retries
        int retryCount = 0;
        long waitTime = 1000; // Initial wait time in milliseconds (1 second)

        while (retryCount < maxRetries) {
            try {
                // Simulating API call or server interaction
                if (makeApiCall()) {
                    System.out.println("API call successful!");
                    break;
                } else {
                    throw new RuntimeException("Server returned 500 error");
                }
            } catch (Exception e) {
                retryCount++;
                if (retryCount < maxRetries) {
                    System.out.println("Retry " + retryCount + " failed. Waiting " + waitTime + "ms before retrying...");
                    try {
                        TimeUnit.MILLISECONDS.sleep(waitTime);
                    } catch (InterruptedException interruptedException) {
                        Thread.currentThread().interrupt();
                        break;
                    }
                    waitTime *= 2; // Exponential backoff (doubling wait time)
                } else {
                    System.out.println("Max retries reached. Exiting.");
                }
            }
        }
    }

    private static boolean makeApiCall() {
        // Simulate server behavior (return false to mimic 500 error)
        return Math.random() > 0.7; // 70% chance of failure
    }
}
