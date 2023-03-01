
import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Write your code here
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of rows:");
        int rowNumber = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int seatsNumber = scanner.nextInt();

        String[][] arr = new String[rowNumber + 1][seatsNumber + 1];

        fillArr(arr);
        int switcher = 4;
        while (switcher != 0) {

            makeChose();
            switcher = enterSwitch();
            if (switcher == 0) {
                break;
            }
            switch (switcher) {
                case 1:
                    showTheSeats(arr);
                    break;
                case 2:
                    buyATicket(arr, rowNumber, seatsNumber);
                    break;
                case 3:
                    showStatistic(arr, rowNumber, seatsNumber);
                    break;
                case 0:
                    switcher = 0;
                    break;
                default:
                    break;
            }
        }


    }

    private static void showStatistic(String[][] arr, int rowNumber, int seatsNumber) {

        double totalSeats = rowNumber * seatsNumber;
        int number = 0;
        double percentage;
        int curIncome = 0;
        int totalIncome = 0;
        int ticketPrice;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == "B") {
                    number++;
                    if (rowNumber * seatsNumber <= 60) {
                        curIncome += 10;
                    } else {
                        if (rowNumber / 2 >= i) {
                            curIncome += 10;
                        } else {
                            curIncome += 8;
                        }
                    }
                }
            }
        }


        if (rowNumber * seatsNumber <= 60) {
            totalIncome = rowNumber * seatsNumber * 10;
        } else {
            totalIncome = (int) (rowNumber / 2 * seatsNumber * 10 + (totalSeats - (rowNumber / 2 * seatsNumber)) * 8);
        }
//        DecimalFormat df = new DecimalFormat("#.00");
//        df.setDecimalSeparatorAlwaysShown(true);

        percentage = 100 / totalSeats * number;
        System.out.println("Number of purchased tickets: " + number);
        System.out.println("Percentage: " + String.format("%.2f", percentage) + "%");
        System.out.println("Current income: $" + curIncome);
        System.out.println("Total income: $" + totalIncome);
    }

    public static void buyATicket(String arr[][], int rowNumber, int seatsNumber) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter a row number:");
            int rowNumberPrice = scanner.nextInt();
            System.out.println("Enter a seat number in that row:");
            int seatNumberPrice = scanner.nextInt();

            if (rowNumberPrice > rowNumber || seatNumberPrice > seatsNumber) {
                System.out.println("Wrong input!");
                continue;
            } else if (arr[rowNumberPrice][seatNumberPrice] == "B") {
                System.out.println("That ticket has already been purchased!");
                continue;
            } else {

                arr[rowNumberPrice][seatNumberPrice] = "B";
                int ticketPrice;
                if (rowNumber * seatsNumber <= 60) {
                    ticketPrice = 10;
                } else {
                    if (rowNumber / 2 >= rowNumberPrice) {
                        ticketPrice = 10;
                    } else {
                        ticketPrice = 8;
                    }
                }


                System.out.println("Ticket price: $" + ticketPrice);

                System.out.println();
                break;
            }


        }
    }

    public static void showTheSeats(String arr[][]) {
        System.out.println("Cinema:");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int enterSwitch() {
        Scanner scanner = new Scanner(System.in);
        int numbSwitch = scanner.nextInt();
        return numbSwitch;
    }

    public static void makeChose() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Show the seats");
        System.out.println("2. Buy a ticket");
        System.out.println("3. Statistics");
        System.out.println("0. Exit");

    }

    public static void fillArr(String arr[][]) {
        System.out.println("Cinema:");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (i == 0 && j == 0) {
                    arr[i][j] = " ";
                    System.out.print(arr[i][j] + " ");
                } else if (i == 0 && j != 0) {
                    arr[i][j] = j + "";
                    System.out.print(arr[i][j] + " ");
                } else if (i != 0 && j == 0) {
                    arr[i][j] = i + "";
                    System.out.print(arr[i][j] + " ");
                } else {
                    arr[i][j] = "S";
                    System.out.print(arr[i][j] + " ");
                }
            }
            System.out.println();
        }

        System.out.println();
    }
}