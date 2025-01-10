package day_10;

public class Day10 {

    public static void main(String[] args) {
        String input = "3113322113";

        System.out.println("Part one: " + iterateProcessing(input, 40));
        System.out.println("Part two: " + iterateProcessing(input, 50));
    }

    private static int iterateProcessing(String input, int count) {
        for (int iter = 0; iter < count; iter++) {
            input = processString(input);
        }
        
        return input.length();
    }
    
    private static String processString(String input) {
        StringBuilder sb = new StringBuilder();
        char prev = input.charAt(0);
        int count = 1;
        
        for (int i = 1; i < input.length(); i++) {
            char token = input.charAt(i);
            
            if (token == prev) {
                count++;
            } else {
                sb.append(count);
                sb.append(prev);
                count = 1;
            }
            
            prev = token;
        }

        sb.append(count);
        sb.append(prev);
        
        return sb.toString();
    }
}
