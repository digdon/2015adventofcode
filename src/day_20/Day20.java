package day_20;

public class Day20 {

    public static void main(String[] args) {
        int target = 34000000;

        part1Sieve(target);
        part2Sieve(target);
    }

    private static void part1Sieve(int target) {
        long startTime = System.currentTimeMillis();
        
        int limit = target / 10 / 2;
        int[] houses = new int[limit + 1];
        
        for (int elf = 1; elf <= limit; elf++) {
            for (int i = elf; i <= limit; i += elf) {
                houses[i] += elf * 10;
            }
        }

        int minHouse = 0;
        
        for (int i = 1; i < houses.length; i++) {
            if (houses[i] >= target) {
                minHouse = i;
                break;
            }
        }

        System.out.println(String.format("Part 1 (sieve): %d (%d ms)", minHouse, System.currentTimeMillis() - startTime));
    }
    
    private static void part2Sieve(int target) {
        long startTime = System.currentTimeMillis();
        
        int limit = target / 11 / 2;
        int[] houses = new int[limit + 1];
        
        for (int elf = 1; elf <= limit; elf++) {
            for (int i = elf, houseCount = 0; i <= limit && houseCount < 50; i += elf, houseCount++) {
                houses[i] += elf * 11;
            }
        }

        int minHouse = 0;
        
        for (int i = 1; i < houses.length; i++) {
            if (houses[i] >= target) {
                minHouse = i;
                break;
            }
        }

        System.out.println(String.format("Part 2 (sieve): %d (%d ms)", minHouse, System.currentTimeMillis() - startTime));
    }
}
