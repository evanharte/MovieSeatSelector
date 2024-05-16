import java.util.Scanner;

public class MovieSeatSelector {
    // Create a java class that allows the user to reserve an available seat in a movie theater.
    String[][] theatreSeats = new String[8][6];

    public MovieSeatSelector() {
        for (int row = 0; row < theatreSeats.length; row++) {
            for (int col = 0; col < theatreSeats[0].length; col++) {
                theatreSeats[row][col] = "O";
            }
        }
    }

    public void displaySeats() {
        for (int row = 0; row < theatreSeats.length; row++) {
            for (int col = 0; col < theatreSeats[0].length; col++) {
                if (col == 2) {
                    System.out.print(theatreSeats[row][col] + " | | ");
                } else {
                    System.out.print(theatreSeats[row][col] + " ");
                }
            }
            System.out.println();
        }
    }

    public void claimSeat(int row, int col) {
        if (theatreSeats[row - 1][col - 1].equals("X")) {
            System.out.println();
            System.out.println("The seat at " + row + ", " + col + " has already been claimed. Please try again.");
        } else {
            theatreSeats[row - 1][col - 1] = "X";
            System.out.println("Seat successfully claimed (indicated by 'X').");
        }
    }

    public static void main(String[] args) {
        MovieSeatSelector seatSelector = new MovieSeatSelector();
        System.out.println();
        System.out.println("Welcome to the movie seat selector!");
        System.out.println();

        while (true) {
            seatSelector.displaySeats();
            System.out.println();

            Scanner scanner = new Scanner(System.in);
            System.out.println("View the above representation of the theatre and select a row number followed by a seat/column number to claim your seat.");
            System.out.println("You must book one seat at a time.");

            try {
                System.out.println("Enter the row number (1-8): ");
                int row = scanner.nextInt();
                System.out.println("Enter the column/seat number (1-6): ");
                int col = scanner.nextInt();

                seatSelector.claimSeat(row, col);
                System.out.println();
                seatSelector.displaySeats();
                System.out.println();
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("You have entered an invalid row and/or column number. Please try again");
            }

            System.out.println("Would you like to claim another seat? (y/n): ");
            String answer = scanner.next();
            System.out.println();
            if (answer.equals("n")) {
                System.out.println();
                break;
            }
        }
        System.out.println("Thank you for using our movie seat selector. Have a great day!");
    }
}
