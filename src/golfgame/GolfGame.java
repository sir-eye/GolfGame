package golfgame;

import java.util.Scanner;
import java.util.Random;

public class GolfGame {
    private static final int HOLES = 9; // Number of holes in the game
    private static final int PAR = 3;  // Standard par for each hole

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Welcome to the Interactive Golf Game!");
        System.out.println("You will play " + HOLES + " holes. Try to finish each hole in as few strokes as possible!\n");

        int totalScore = 0;

        for (int hole = 1; hole <= HOLES; hole++) {
            System.out.println("Hole " + hole + " (Par " + PAR + ")");
            int holeDistance = random.nextInt(200) + 100; // Random distance between 100 and 300 yards
            System.out.println("Hole distance: " + holeDistance + " yards");
            int strokes = playHole(holeDistance, scanner, random);
            totalScore += strokes;

            System.out.println("Hole " + hole + " completed in " + strokes + " strokes.");
            System.out.println("Current total score: " + totalScore + "\n");
        }

        System.out.println("Game Over! Your total score is: " + totalScore);
        if (totalScore < PAR * HOLES) {
            System.out.println("Congratulations! You finished under par.");
        } else if (totalScore == PAR * HOLES) {
            System.out.println("Great job! You finished at par.");
        } else {
            System.out.println("Better luck next time! You finished over par.");
        }
    }

    private static int playHole(int holeDistance, Scanner scanner, Random random) {
        int strokes = 0;
        int remainingDistance = holeDistance;

        while (remainingDistance > 0) {
            System.out.println("Remaining distance: " + remainingDistance + " yards");
            System.out.println("Choose your club:");
            System.out.println("1. Driver (200-300 yards)");
            System.out.println("2. Iron (100-150 yards)");
            System.out.println("3. Putter (10-20 yards)");

            int clubChoice = scanner.nextInt();
            int shotDistance;

            switch (clubChoice) {
                case 1 -> shotDistance = random.nextInt(101) + 200; // Driver
                case 2 -> shotDistance = random.nextInt(51) + 100; // Iron
                case 3 -> shotDistance = random.nextInt(11) + 10;  // Putter
                default -> {
                    System.out.println("Invalid choice! You lose your turn.");
                    shotDistance = 0;
                }
            }

            remainingDistance = Math.max(0, remainingDistance - shotDistance);
            strokes++;

            System.out.println("You hit the ball " + shotDistance + " yards.");
        }

        return strokes;
    }
}