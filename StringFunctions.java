public class StringFunctions {
    public static int count(String s, String target) {
        int count = 0;
        int n = target.length();
        for (int i = 0; i <= s.length() - n; i++) {
            String piece = s.substring(i, i + n);
            if (piece.equals(target)) count++;
        }
        return count;
    }

    public static int countIgnoreCase(String s, String target) {
        int count = 0;
        int n = target.length();
        for (int i = 0; i <= s.length() - n; i++) {
            String piece = s.substring(i, i + n);
            if (piece.equalsIgnoreCase(target)) count++;
        }
        return count;
    }

    public static int count2(String s, String target) {
        int prevIdx = -1, count = 0,offset = 0;
        int idx = s.indexOf(target);
        while (idx != -1) {
            if (idx != prevIdx) {
                prevIdx = idx;
                count++;
            }
            idx = s.indexOf(target, offset);
            offset++;
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println("Number of this's: " + 
            count2("this and this and that and this", "this"));
    }
}