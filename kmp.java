public class kmp {
    public int[] computeLPS(String pattern) {
        int m = pattern.length();
        int[] lps = new int[m];
        int length = 0;
        int i = 1;

        lps[0] = 0;

        while (i < m) {
            if (pattern.charAt(i) == pattern.charAt(length)) {
                length++;
                lps[i] = length;
                i++;
            } else {
                if (length != 0) {
                    length = lps[length - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }

    public int KMP(String pattern, String arr, int[] lps) {

        int i = 0;
        int j = 0;
        int found = 0;
        int[] index1= new int[lps.length];
        int index_it=0;
        while (i < arr.length()) {
            if (j == pattern.length() - 1) {
                found++;
                index1[index_it]=(i)-(pattern.length())+1;
                index_it++;
                j++;
                i++;
                j = lps[j - 1];

            } else if (arr.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            } else if (arr.charAt(i) != pattern.charAt(j)) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }

        }
        System.out.print("match found at " );
        for (int p=0;p<index_it;p++)
        {System.out.print(index1[p]+",");}
        System.out.println();
        return found;
    }
}
