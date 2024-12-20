import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        // Path to the input file
        String filePath = "kmp_datasets/dataset_n10000000_edge_no_match.txt"; // Update with your file path

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            // Read the first line as text
            String text = br.readLine();

            // Read the second line as the pattern
            String pattern = br.readLine();

            // Initialize KMP object
            kmp obj = new kmp();

            // Compute the LPS array for the pattern
            int[] lps = obj.computeLPS(pattern);

            // Print the LPS array
            System.out.print('[');
            for (int i = 0; i < lps.length; i++) {
                System.out.print(lps[i]);
                if (i != lps.length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println(']');

            // Apply the KMP algorithm to find the pattern in the text
            System.out.println("Pattern found: " + obj.KMP(pattern, text, lps));

        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }
}
