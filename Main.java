import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        // Start the timer for the entire process
        long startTime = System.nanoTime();

        // Path to the directory containing the dataset files
        String directoryPath = "kmp_datasets"; // Update with your dataset directory

        // Get all the dataset files from the directory
        File dir = new File(directoryPath);
        File[] files = dir.listFiles((d, name) -> name.endsWith(".txt"));

        if (files != null && files.length > 0) {
            // Loop through all files in the directory
            for (File file : files) {
                System.out.println("Processing file: " + file.getName());

                // Process each dataset file
                try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                    // Read the first line as the text
                    String text = br.readLine();

                    // Read the second line as the pattern
                    String pattern = br.readLine();

                    // Initialize KMP object
                    kmp obj = new kmp();

                    // Compute the LPS array for the pattern
                    int[] lps = obj.computeLPS(pattern);

                    // Print the LPS array
                    System.out.print('[');
                    long startTimeFori = System.nanoTime();
                    for (int i = 0; i < lps.length; i++) {
                        System.out.print(lps[i]);
                        if (i != lps.length - 1) {
                            System.out.print(", ");
                        }
                    }
                    System.out.println(']');

                    // Apply the KMP algorithm to find the pattern in the text
                    System.out.println("Pattern found: " + obj.KMP(pattern, text, lps));
                    // End the timer for the entire process
                    long endTimeFori = System.nanoTime();
                    // Calculate execution time in milliseconds
                    long duration = (endTimeFori - startTimeFori) / 1000000; // Convert from nanoseconds to milliseconds
                    System.out.println("Execution Time: " + duration + " ms");
                } catch (IOException e) {
                    System.err.println("Error reading the file: " + e.getMessage());
                }

                // Print a separator between test cases for readability
                System.out.println("------------------------------------");
            }
        } else {
            System.out.println("No dataset files found in the directory.");
        }

        // End the timer for the entire process
        long endTime = System.nanoTime();

        // Calculate execution time in milliseconds
        long duration = (endTime - startTime) / 1000000; // Convert from nanoseconds to milliseconds
        System.out.println("Total Execution Time: " + duration + " ms");
    }
}
