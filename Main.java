public class Main {

    public static void main(String[] args) {
        // the complixty O(n+m) which n is lenth of text and m is length of lps list
        // need more test cases
        // to check my code effecincy
        kmp obj = new kmp();
        String text = "aabaacaadaabaaba";
        String pattren = "aaba";
        int[] lps = obj.computeLPS(pattren);
        for (int i = 0; i < lps.length; i++) {
            System.out.print(lps[i]);
            System.out.print(",");
        }

        System.out.println();
        System.out.println(obj.KMP(pattren, text, lps));

    }
}