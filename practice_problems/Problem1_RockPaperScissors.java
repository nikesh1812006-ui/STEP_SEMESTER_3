import java.util.Random;

/**
 * Problem 1: Rock-Paper-Scissors Game
 * Scenario: The College Coding Arcade
 * 
 * Generates rounds of Rock-Paper-Scissors between a player and computer,
 * determines winners, logs results in a summary table, and prints final statistics.
 */
public class Problem1_RockPaperScissors {

    /**
     * Determines the winner of a single round.
     * 
     * @param playerMove The player's chosen move ("Rock", "Paper", "Scissors")
     * @param computerMove The computer's chosen move ("Rock", "Paper", "Scissors")
     * @return "Player Wins", "Computer Wins", or "Draw"
     */
    public static String playRound(String playerMove, String computerMove) {
        if (playerMove.equalsIgnoreCase(computerMove)) {
            return "Draw";
        }
        
        switch (playerMove.toLowerCase()) {
            case "rock":
                return computerMove.equalsIgnoreCase("scissors") ? "Player Wins" : "Computer Wins";
            case "paper":
                return computerMove.equalsIgnoreCase("rock") ? "Player Wins" : "Computer Wins";
            case "scissors":
                return computerMove.equalsIgnoreCase("paper") ? "Player Wins" : "Computer Wins";
            default:
                return "Invalid Move";
        }
    }

    public static void main(String[] args) {
        String[] moves = {"Rock", "Paper", "Scissors"};
        Random random = new Random(42); // Seeded for reproducible demonstration

        // Predefined simulation inputs from sample
        String[][] demoRounds = {
            {"Rock", "Scissors"},
            {"Paper", "Paper"},
            {"Scissors", "Rock"},
            {"Rock", "Scissors"},
            {"Paper", "Rock"}
        };

        int totalRounds = demoRounds.length;
        String[][] roundTable = new String[totalRounds][4];
        int wins = 0, losses = 0, draws = 0;

        System.out.println("=== Orientation Arcade: Rock-Paper-Scissors ===");
        for (int i = 0; i < totalRounds; i++) {
            String pMove = demoRounds[i][0];
            String cMove = demoRounds[i][1];
            String result = playRound(pMove, cMove);

            if (result.equals("Player Wins")) wins++;
            else if (result.equals("Computer Wins")) losses++;
            else if (result.equals("Draw")) draws++;

            roundTable[i][0] = "Round " + (i + 1);
            roundTable[i][1] = pMove;
            roundTable[i][2] = cMove;
            roundTable[i][3] = result;
        }

        // Display summary table
        System.out.printf("%-10s | %-12s | %-14s | %-14s%n", "Round", "Player Move", "Computer Move", "Result");
        System.out.println("----------------------------------------------------------");
        for (String[] row : roundTable) {
            System.out.printf("%-10s | %-12s | %-14s | %-14s%n", row[0], row[1], row[2], row[3]);
        }
        System.out.println("----------------------------------------------------------");

        double winPercentage = (totalRounds > 0) ? ((double) wins / totalRounds) * 100 : 0.0;
        System.out.printf("Final Summary (after %d rounds) Wins: %d | Losses: %d | Draws: %d | Win %% = %.1f%%%n",
                totalRounds, wins, losses, draws, winPercentage);
    }
}
