package day_17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

public class Day17 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> inputLines = reader.lines().collect(Collectors.toList());
        reader.close();

        int[] numbers = new int[inputLines.size()];
        int numCount = 0;
        
        for (String line : inputLines) {
            try {
                int number = Integer.parseInt(line);
                numbers[numCount++] = number;
            } catch (NumberFormatException e) {
                System.out.println("Invalid number: " + line);
                System.exit(1);
            }
        }

        long startTime = System.currentTimeMillis();
        int part1Count = 0;
        int minContainers = Integer.MAX_VALUE;
        int minContainerCount = 0;
        
        for (int i = 0; i < 1 << numCount; i++) {
            int value = 0;
            int containerCount = 0;
            
            for (int j = 0; j < numCount; j++) {
                if ((i & (1 << j)) > 0) {
                    value += numbers[j];
                    containerCount++;
                }
            }
            
            if (value == 150) {
                part1Count++;
                
                if (containerCount < minContainers) {
                    minContainers = containerCount;
                    minContainerCount = 1;
                } else if (containerCount == minContainers) {
                    minContainerCount++;
                }
            }
        }
        
        System.out.println("Part 1: " + part1Count);
        System.out.println("Part 2: " + minContainerCount);
        System.out.println(String.format("Time: %d ms", System.currentTimeMillis() - startTime));
    }
}
