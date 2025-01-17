package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static com.pluralsight.reportsLogic.reader;

public class mainCLI {

    public void main(String[] args) {

        menuLoop();
    } //Menu? I think it goes here?

    public static void menuLoop() {
        Scanner scanner = new Scanner(System.in);
        final char[] option = new char[1];

        class displayBanner {
            final displayBanner displayBanner = new displayBanner();

            public void displayBanner() {
                String fileName = "C:/Users/Student/OneDrive - Year Up- BOS/Desktop/Year Up Courses/PluralSight/Year Up United Projects/LearnToCode_Capstones/CapstoneBankBanner.txt";

                displayBanner();

                //IO for the banner
                try (BufferedReader reader = new BufferedReader(new FileReader("CapstoneBankBanner.txt"))) {
                    String line = "";
                    while (line.equals(reader.readLine())) System.out.println(line);
                } catch (IOException e) {
                    System.out.println("Error reading the GPFC banner file.");
                    e.printStackTrace();
                }
            }
        }

        //Date and time config
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm:ss");
        String formattedDateTime = currentDateTime.format(formatter);

        //Menu starts here!

        do {
            System.out.println("Today's Date and Time: " + formattedDateTime);
            System.out.println("══════════════════════════════════════════════════════════════");
            System.out.println("Please type in the letter that matches the option needed: ");
            System.out.println("D) Add Deposit");
            System.out.println("P) Make Payment");
            System.out.println("L) View Past Ledger Information");
            System.out.println("R) View Past Report Information");
            System.out.println("X) Exit the Application");
            System.out.println("Please enter the required letter here: ");
            System.out.println("══════════════════════════════════════════════════════════════");
            option[0] = scanner.nextLine().toUpperCase().charAt(0);

            //Initializing menu loop...

            switch (option[0]) {
                case 'D':
                    //Make the variables to ask for here:
                    String date1 = ""; //Current date
                    String time1 = ""; //Current time
                    String description1 = ""; //Description of item, like 'vacuum cleaner'
                    String vendor1 = ""; //Who paid you/who did you pay?
                    String type1 = ""; //Are you getting paid or paying someone else?
                    double amount1 = 0; //Amount that you're receiving or paying

                    System.out.println("══════════════════════════════════════════════════════════════");
                    System.out.println("Please enter in the description of your transaction: ");
                    description1 = scanner.nextLine();

                    System.out.println("Please enter in the name or business that you received the deposit from: ");
                    vendor1 = scanner.nextLine();

                    System.out.println("Please enter the amount of the deposit you would like to make: ");
                    amount1 = scanner.nextDouble();
                    scanner.nextLine();

                    System.out.println("Last Transaction Input Recorded: " + description1 + date1 + time1 + vendor1 + amount1);
                    System.out.println("═════════════════════════════════════════════════════════════");
                    break;

                    //Payment Info
                    case 'P':

                        //Make the variables to ask for here:
                        String date2 = ""; //Current date
                        String time2 = ""; //Current time
                        String description2 = ""; //Description of item, like 'vacuum cleaner'
                        String vendor2 = ""; //Who paid you/who did you pay?
                        String type2 = ""; //Are you getting paid or paying someone else?
                        double amount2 = 0; //Amount that you're receiving or paying

                        System.out.println("══════════════════════════════════════════════════════════════");
                        System.out.println("Please enter in the description of the payment: ");
                        description2 = scanner.nextLine();

                        System.out.println("Please enter in the name or business the payment was sent to: ");
                        vendor2 = scanner.nextLine();

                        System.out.println("Please enter the amount of the payment: ");
                        amount2 = scanner.nextDouble();
                        scanner.nextLine();

                        System.out.println("Last Transaction Input Recorded: " + description2 + date2 + time2 + vendor2 + amount2);
                        System.out.println("══════════════════════════════════════════════════════════════");
                        break;

                        //Ledger Screen
                        case 'L':

                            System.out.println("══════════════════════════════════════════════════════════════");
                            System.out.println("Would you like to view ledgers sorted by:");
                            System.out.println("A) All - Displays all ledgers currently available to access.");
                            System.out.println("D) Only the currently available deposits.");
                            System.out.println("P) Only the currently available payments.");
                            System.out.println("Please enter the letter of your desired search:");
                            System.out.println("══════════════════════════════════════════════════════════════");
                            break;

                        //Reports Screen
                        case 'R':

                            System.out.println("══════════════════════════════════════════════════════════════");
                            System.out.println("Would you like to view reports sorted by:");
                            System.out.println("Transactions Listed by Month to Date");
                            System.out.println("Transactions From Previous Month");
                            System.out.println("Transactions From Previous Year to Date");
                            System.out.println("Transactions From Previous Year");
                            System.out.println("Transactions From A Specific Vendor");
                            System.out.println("0) Go to Previous Page");
                            System.out.println("0) Go to Home Page");
                            System.out.println("══════════════════════════════════════════════════════════════");
                            break;

                        //Ending Screen
                        case 'X':

                            System.out.println("══════════════════════════════════════════════════════════════");
                            System.out.println("Thank you for your patronage, have a wonderful day!");
                            System.out.println("Golden Phoenix Financial Corporation: Blaze a path to better finances.");
                            System.out.println("══════════════════════════════════════════════════════════════");
                            break;
                        }
            }
                while (option[0] != 'X') ;
                scanner.close();
            }
    public static void displayReports() throws FileNotFoundException {
        String reportOptions;
        // another do while loop, will run unless 0 is selected
        do {
            System.out.println("Welcome to your reports. Please select one of the following options: " +
                    "\n" + "1 - Month to Date" +
                    "\n" + "2 - Previous Month" +
                    "\n" + "3 - Year to Date" +
                    "\n" + "4 - Previous Year" +
                    "\n" + "5 - Search by Vendor" +
                    "\n" + "0 - Back");

            reportOptions = reader.nextLine();
            // reader.nextLine();
            switch (reportOptions) {
                case "1":
                    reportsLogic.displayMonthToDate();
                    break;
                case "2":
                    reportsLogic.displayPreviousMonth();
                    break;
                case "3":
                    reportsLogic.displayYearToDate();
                    break;
                case "4":
                    reportsLogic.displayPreviousYear();
                    break;
                case "5":
                    reportsLogic.searchVendor();
                    break;
                case "0":
                    break;
                default:
                    System.out.println("That is not a valid selection. Please try again.");
            }
        } while (!reportOptions.equals("0"));
    }
}