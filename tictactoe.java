import java.util.Scanner;

public class Tictactoe {

    private final Board board = new Board();

    public void startGame () {

        Scanner scanner = new Scanner(System.in);

        board.printBoard();

        while (true) {
            playerTurn(scanner);
            if (isGameFinished()){
                // When game is finnished
                System.out.println("Want to play again? (Y/N): ");
                String playAgain = scanner.nextLine();
                if (playAgain.equals("Y")) {
                    board.resetGame();
                } else if (playAgain.equals("N")) {
                    break;
                }
            }
            PlayerTurn2(scanner);
            if (isGameFinished()){
                // When game is finnished
                System.out.println("Want to play again? (Y/N): ");
                String playAgain = scanner.nextLine();
                if (playAgain.equals("Y")) {
                    board.resetGame();
                } else if (playAgain.equals("N")) {
                    break;
                }
            }
        }
        scanner.close();
    }


    private boolean isGameFinished() {

        if (hasContestantWon('X')) {
            board.printBoard();
            System.out.println("Player 1 wins!");
            return true;
        }

        if (hasContestantWon('O')) {
            board.printBoard();
            System.out.println("Player 2 wins!");
            return true;
        }

        for (char[] chars : board.getBoard()) {
            for (char aChar : chars) {
                if (aChar == ' ') {
                    return false;
                }
            }
        }
        board.printBoard();
        System.out.println("The game ended in a tie!");
        return true;
    }


    private boolean hasContestantWon(char symbol) {
        return (board.getBoard()[0][0] == symbol && board.getBoard()[0][1] == symbol && board.getBoard()[0][2] == symbol) ||
                (board.getBoard()[1][0] == symbol && board.getBoard()[1][1] == symbol && board.getBoard()[1][2] == symbol) ||
                (board.getBoard()[2][0] == symbol && board.getBoard()[2][1] == symbol && board.getBoard()[2][2] == symbol) ||

                (board.getBoard()[0][0] == symbol && board.getBoard()[1][0] == symbol && board.getBoard()[2][0] == symbol) ||
                (board.getBoard()[0][1] == symbol && board.getBoard()[1][1] == symbol && board.getBoard()[2][1] == symbol) ||
                (board.getBoard()[0][2] == symbol && board.getBoard()[1][2] == symbol && board.getBoard()[2][2] == symbol) ||

                (board.getBoard()[0][0] == symbol && board.getBoard()[1][1] == symbol && board.getBoard()[2][2] == symbol) ||
                (board.getBoard()[0][2] == symbol && board.getBoard()[1][1] == symbol && board.getBoard()[2][0] == symbol);
    }


    private void PlayerTurn2(Scanner scanner) {
        String userInput;
        while (true) {
            System.out.println("Where would you like to play? (1-9)");
            userInput = scanner.nextLine();
            if (isValidMove(userInput)){
                break;
            } else {
                System.out.println(userInput + " is not a valid move.");
            }
        }
        placeMove(userInput, 'X');
        board.printBoard();
    }

    private void playerTurn(Scanner scanner) {
        String userInput;
        while (true) {
            System.out.println("Where would you like to play? (1-9)");
            userInput = scanner.nextLine();
            if (isValidMove(userInput)){
                break;
            } else {
                System.out.println(userInput + " is not a valid move.");
            }
        }
        placeMove(userInput, 'O');
        board.printBoard();
    }


    private boolean isValidMove (String position) {
        return switch (position) {
            case "1" -> (board.getBoard()[0][0] == ' ');
            case "2" -> (board.getBoard()[0][1] == ' ');
            case "3" -> (board.getBoard()[0][2] == ' ');
            case "4" -> (board.getBoard()[1][0] == ' ');
            case "5" -> (board.getBoard()[1][1] == ' ');
            case "6" -> (board.getBoard()[1][2] == ' ');
            case "7" -> (board.getBoard()[2][0] == ' ');
            case "8" -> (board.getBoard()[2][1] == ' ');
            case "9" -> (board.getBoard()[2][2] == ' ');
            default -> false;
        };
    }

    private void placeMove(String position, char symbol) {
        switch (position) {
            case "1" -> board.getBoard()[0][0] = symbol;
            case "2" -> board.getBoard()[0][1] = symbol;
            case "3" -> board.getBoard()[0][2] = symbol;
            case "4" -> board.getBoard()[1][0] = symbol;
            case "5" -> board.getBoard()[1][1] = symbol;
            case "6" -> board.getBoard()[1][2] = symbol;
            case "7" -> board.getBoard()[2][0] = symbol;
            case "8" -> board.getBoard()[2][1] = symbol;
            case "9" -> board.getBoard()[2][2] = symbol;
            default -> System.out.println(":(");
        }
    }

   }
