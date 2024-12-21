import java.util.Random;

public class Main {

    public static void main(String[] args) {
        kmp obj = new kmp();
        String pattern = "aaba";

        // Dataset sizes
        int[] sizes = {1000, 10000, 100000, 1000000, 10000000, 100000000};

        // Execution time results
        float[] executionTimes = new float[sizes.length];

        for (int t = 0; t < sizes.length; t++) {
            int n = sizes[t];
            System.out.println("Testing dataset size: " + n);

            // Generate random text
            String text = generateRandomString(n);

            // Compute LPS array
            int[] lps = obj.computeLPS(pattern);

            // Measure execution time
            long startTime = System.nanoTime();
            obj.KMP(pattern, text, lps);
            long endTime = System.nanoTime();

            // Calculate execution time in milliseconds with float precision
            executionTimes[t] = (endTime - startTime) / 1_000_000.0f;

            System.out.println("Execution time for n=" + n + ": " + executionTimes[t] + " ms");
        }

        // Plot the results
        System.out.println("Execution Times (ms): ");
        for (int i = 0; i < sizes.length; i++) {
            System.out.println("n=" + sizes[i] + ", Time=" + executionTimes[i] + " ms");
        }
    }

    // Helper function to generate random string of size n
    private static String generateRandomString(int n) {
        String chars = "abcdefghijklmnopqrstuvwxyz";
        Random rand = new Random();
        StringBuilder sb = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            sb.append(chars.charAt(rand.nextInt(chars.length())));
        }
        return sb.toString();
    }
}
