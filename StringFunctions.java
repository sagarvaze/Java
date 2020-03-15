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

    public static String acronym(String phrase) {
        StringBuilder result = new StringBuilder();
        for (String token : phrase.split("\\s+")) {
            result.append(token.toUpperCase().charAt(0));
        }
        return result.toString();
    }

    public static int countWord(String s, String target) {
        int count = 0;
        for (String token : s.split("\\s+")) {
            if (token.equals(target)) count++;
        }
        return count;
    }
    
    public static int countWordIgnoreCase(String s, String target) {
        int count = 0;
        for (String token : s.split("\\s+")) {
            if (token.equalsIgnoreCase(target)) count++;
        }
        return count;
    }

    public static String reverse(String s) {
        StringBuilder result = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) result.append(s.charAt(i));
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println("Number of this's: " + 
            count2("this and this and that and this", "this"));
        System.out.println("Acronym of 'Sagar Rajiv Vaze': " + acronym("Sagar Rajiv Vaze"));
        System.out.println("Number of this's: " + 
            countWord("this and this and that and This", "this"));
        System.out.println("Number of this's: " + 
            countWordIgnoreCase("this and this and that and This", "this"));
        System.out.println("Reverse : " + reverse("Reverse"));
    }
}