package topic_1.class_problems;

import java.util.Random;

public class RockPaperScissorsGame {
    private static final String[] MOVES = {"Rock", "Paper", "Scissors"};
    private final Random random = new Random();

    public String playRound(String playerMove, String computerMove) {
        String player = normalizeMove(playerMove);
        String computer = normalizeMove(computerMove);

        if (player.equals(computer)) {
            return "Draw";
        }

        if ((player.equals("Rock") && computer.equals("Scissors"))
                || (player.equals("Paper") && computer.equals("Rock"))
                || (player.equals("Scissors") && computer.equals("Paper"))) {
            return "Player Wins";
        }

        return "Computer Wins";
    }

    public String randomMove() {
        return MOVES[random.nextInt(MOVES.length)];
    }

    private String normalizeMove(String move) {
        if (move == null) {
            throw new IllegalArgumentException("Move cannot be null.");
        }

        for (String validMove : MOVES) {
            if (validMove.equalsIgnoreCase(move.trim())) {
                return validMove;
            }
        }

        throw new IllegalArgumentException("Move must be Rock, Paper, or Scissors.");
    }

    public static void main(String[] args) {
        RockPaperScissorsGame game = new RockPaperScissorsGame();
        String[] playerMoves = {"Rock", "Paper", "Scissors", "Rock", "Paper"};
        int wins = 0;
        int losses = 0;
        int draws = 0;

        System.out.println("Round | Player Move | Computer Move | Result");
        for (int round = 0; round < playerMoves.length; round++) {
            String computerMove = game.randomMove();
            String result = game.playRound(playerMoves[round], computerMove);
            System.out.printf("%5d | %-11s | %-13s | %s%n",
                    round + 1, playerMoves[round], computerMove, result);

            if (result.equals("Player Wins")) {
                wins++;
            } else if (result.equals("Computer Wins")) {
                losses++;
            } else {
                draws++;
            }
        }

        double percentage = wins * 100.0 / playerMoves.length;
        System.out.printf("Wins: %d | Losses: %d | Draws: %d | Win %%: %.1f%%%n",
                wins, losses, draws, percentage);
    }
}
