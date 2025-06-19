package day_10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

public class Day10 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> inputLines = reader.lines().collect(Collectors.toList());
        reader.close();
        
        String input = inputLines.getFirst();

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
