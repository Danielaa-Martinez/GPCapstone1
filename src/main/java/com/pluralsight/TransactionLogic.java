package com.pluralsight;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

    //make the transaction variable and document it'll read from.
    public class transactions() {
        private Object description;
        private Object vendor;
        private Object mytype;
        private LocalDate mydate;
        private LocalTime mytime;
        private double amount;

        public transactions(LocalDate mydate, String description, String vendor, String paymenttype, double myamount) {
            description = description;
            vendor = vendor;
            mytype = paymenttype;
            mydate = mydate;
            amount = myamount;
        }

        //Ready... Getters, Setters, Go!
        //Date Get-Set
        public String getDate() {
            return String.valueOf(mydate);
        }

        public void setDate(String date) {
            mytime = LocalTime.parse(getTime());
        }


        //Time Get-Set
        public String getTime() {
            return String.valueOf(mytime);
        }

        public void setTime(String time) {
            mydate = LocalDate.from(LocalTime.parse(getTime()));
        }


        //Description Get-Set
        public String getDescription() {
            return String.valueOf(description);
        }

        public void setDescription(String description) {
            description = getDescription();
        }


        //Vendor Get-Set
        public String getVendor() {
            return String.valueOf(vendor);
        }

        public void setVendor(String vendor) {
            vendor = getVendor();
        }


        //Type Get-Set
        public String getType() {
            return String.valueOf(mytype);
        }

        public void setType(String type) {
            type = getType();
        }


        //Amount Get-Set
        public String getAmount(Double amount) {
            return String.valueOf(amount);
        }

        public void setAmount(Double amount) {
            amount = setAmount();
        }

        private Double setAmount() {
            return 0.0;
        }

        public static void readTransactionsInCSV() {

            ArrayList<Object> transactions = new ArrayList<>();

            Scanner reader = new Scanner(System.in);
            String filename = "transactions.csv";
            try (BufferedReader bfreader = new BufferedReader(new FileReader(filename))) {
                String line;
                while ((line = bfreader.readLine()) != null) {
                    String[] fields = line.split(",");
                    LocalDate date = LocalDate.parse(fields[0]);
                    LocalTime time = LocalTime.parse(fields[1]);
                    String description = fields[2];
                    String vendor = fields[3];
                    double amount = Double.parseDouble(fields[4]); // Assuming TransactionLogicAndIO is a valid class transactions.add(new TransactionLogicAndIO(date, time, amount)); } } catch (IOException e) { System.out.println("An error occurred while trying to access and read this file. Please try again."); e.printStackTrace(); } // Return an unmodifiable list of transactions return Collections.unmodifiableList(transactions); } }

                    transactions.add(new transactions(date, description, vendor, "all", amount)); }

                class TransactionLogic {

                    // Writes the list of transactions to a CSV file
                    public static <TransactionLogic> void writeTransactionsInCSV(List<TransactionLogic> transactions, String filename) {
                        try (FileWriter writer = new FileWriter(filename, true)) { // Appending to the file
                            for (TransactionLogic transaction : transactions) {
                                writer.write(transaction.toString() + "\n");
                            }
                        } catch (IOException e) {
                            System.out.println("An error occurred while writing to the CSV.");
                            e.printStackTrace();
                        }
                    }

                    // Adds a deposit and a payment transaction to the list
                    public static void addTransactions(List<Transaction> transactions, TransactionHandler handler) {
                        Transaction deposit = handler.addDeposit();
                        transactions.add(deposit);

                        Transaction payment = handler.addPayment();
                        transactions.add(payment);
                    }

                    // Displays the list of transactions
                    public static void displayTransactions(List<TransactionLogic> transactions) {
                        for (TransactionLogic transaction : transactions) {
                            System.out.println("Date: " + transaction.getDate() + ", Time: " + transaction.getTime() + ", Amount: " + transaction.getAmount());
                        }
                    }

                    private String getAmount() {
                        return null;
                    }

                    private String getTime() {
                        return null;
                    }

                    private String getDate() {
                        return null;
                    }

                    // Sorts the transactions by date
                    public static void sortTransactionsByDate(List<TransactionLogic> transactions) {
                        Collections.sort(transactions, Comparator.comparing(TransactionLogic::getDate));
                    }

                    // Mock method for adding a deposit (to be replaced with actual implementation)
                    public Transaction addDeposit() {
                        // Add logic to handle deposit creation
                        return new Transaction();
                    }

                    // Mock method for adding a payment (to be replaced with actual implementation)
                    public Transaction addPayment() {
                        // Add logic to handle payment creation
                        return new Transaction();
                    }
                }
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
