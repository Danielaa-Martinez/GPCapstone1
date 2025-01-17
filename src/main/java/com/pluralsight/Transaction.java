package com.pluralsight;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Transaction {
    private List<transactions> transactions;

    public Transaction() {
        transactions = new ArrayList<>();
    }

    //adding transactions
    public static void addTransaction(double amount, String description, String vendor) {
        LocalDateTime dateTime = LocalDateTime.now();
        String transactionFile = "transactions.csv";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(transactionFile, true))) {
            File file = new File(transactionFile);


            if (!file.exists() || file.length() == 0) {
                writer.write("date|time|description|vendor|amount");
                writer.newLine();
            }

            //format for date and time
            String date = dateTime.toLocalDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            String time = dateTime.toLocalTime().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
            writer.write(date + "|" + time + "|" + description + "|" + vendor + "|" + amount);
            writer.newLine();

            //Confirmation message:
            if (amount > 0) {
                System.out.println("Deposit of $" + amount + " complete.");
            } else {
                System.out.println("Payment of $" + Math.abs(amount) + " complete.");
            }
        } catch (IOException e) {
            System.out.println("An unexpected error occurred");
        }
    }

    // Method to display ALL entries
    public static void displayAllEntries() {
        String transactionsFile = "transactions.csv";
        try (BufferedReader bufReader = new BufferedReader(new FileReader(transactionsFile))) {
            String line;
            boolean isFirstLine = true;

            while ((line = bufReader.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false; //skips header
                    continue;

                }
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    // if statement to show only Deposits
    public static void displayOnlyDeposits() {
        String transactionsFile = "transactions.csv";
        try (BufferedReader reader = new BufferedReader(new FileReader(transactionsFile))) {
            String line;
            boolean isFirstLine = true;

            while ((line = reader.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false; //skips header
                    continue;
                }
                //Splitting inputs in to their categories
                String[] parts = line.split("\\|");
                // there are 5 categories
                if (parts.length == 5) {
                    //parse amount section
                    double amount = Double.parseDouble(parts[4]);
                    // comparing if value is + or -, indicating deposit or payment
                    if (amount > 0) {
                        System.out.println(line);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());

        }

    }

    // if statement to show only Payments
    public static void displayPaymentsOnly() {
        String transactionsFile = "transactions.csv";
        try (BufferedReader reader = new BufferedReader(new FileReader(transactionsFile))) {
            String line;
            boolean isFirstLine = true;

            while ((line = reader.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false; //skips header line
                    continue;
                }
                String[] parts = line.split("\\|");
                if (parts.length == 5) {
                    double amount = Double.parseDouble(parts[4]);
                    if (amount < 0) {
                        System.out.println(line);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}

