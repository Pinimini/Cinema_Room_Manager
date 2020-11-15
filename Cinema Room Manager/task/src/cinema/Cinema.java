package cinema;

import java.util.Scanner;

public class Cinema {
    static Scanner sc = new Scanner(System.in);
    static int rows = 0;
    static int seats = 0;
    static String[][] kinozal;
    static int numberOfBuyTicket = 0;
    static int summa = 0;
    static int doxod = 0;

    public static void main(String[] args) {
        kinozal();
        while (true) {
            System.out.println("\n1. Show the seats\n" +
                    "2. Buy a ticket\n" +
                    "3. Statistics\n" +
                    "0. Exit");
            int key = sc.nextInt();
            if (key == 1) {
                printKinozal(kinozal);
            } else if (key == 2) {
                buyTicket(kinozal);
            } else if (key == 3) {
                showStatiscic();
            } else if (key == 0) {
                break;
            }
        }
    }

    public static void kinozal() {
        System.out.println("Enter the number of rows:");
        rows = sc.nextInt();
        System.out.println("Enter the number of seats in each row:");
        seats = sc.nextInt();
        kinozal = new String[rows + 1][seats + 1];
        for (int i = 0; i < rows + 1; i++) {
            for (int j = 0; j < seats + 1; j++) {
                if (i == 0 && j == 0) {
                    kinozal[i][j] = "  ";
                } else if (i == 0) {
                    kinozal[0][j] = j + " ";
                } else if (j == 0) {
                    kinozal[i][0] = i + " ";
                } else {
                    kinozal[i][j] = "S ";
                }
            }
        }
        if (rows * seats <= 60) {
            doxod = rows * seats * 10;
        } else {
            doxod = ((rows / 2) * seats * 10) + ((rows - rows / 2) * seats * 8);
        }
    }

    public static void printKinozal(String[][] mesta) {
        System.out.println("\nCinema:");
        for (String[] rows :
                mesta) {
            for (String seats :
                    rows) {
                System.out.print(seats);
            }
            System.out.println();
        }
    }

    public static void buyTicket(String[][] bilet) {
        while (true) {
            System.out.println("\nEnter a row number:");
            int rows1 = sc.nextInt();
            System.out.println("Enter a seat number in that row:");
            int seats1 = sc.nextInt();
            if (rows1 > rows || seats1 > seats) {
                System.out.println("Wrong input!");
            } else if (bilet[rows1][seats1].equals("B ")) {
                System.out.println("That ticket has already been purchased!");
            } else {
                bilet[rows1][seats1] = "B ";
                podschet(rows1);
                numberOfBuyTicket++;
                break;
            }
        }
    }

    public static void podschet(int rows1) {
        if (rows * seats <= 60) {
            System.out.println("Ticket price: $" + 10);
            summa += 10;
        } else {
            if (rows1 <= rows / 2) {
                System.out.println("Ticket price: $" + 10);
                summa += 10;
            } else {
                System.out.println("Ticket price: $" + 8);
                summa += 8;
            }
        }
    }

    public static void showStatiscic() {
        System.out.println("\nNumber of purchased tickets: " + numberOfBuyTicket);
        double numberOfBuyTicketPercent = (double) numberOfBuyTicket / (rows * seats) * 100;
        System.out.printf("Percentage: %.2f", numberOfBuyTicketPercent);
        System.out.println("%");
        System.out.println("Current income: $" + summa);
        System.out.println("Total income: $" + doxod);
    }
}