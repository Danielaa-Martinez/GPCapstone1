package com.pluralsight;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

public class transactions {
    private String description;
    private String vendor;
    private String paymentType;
    private LocalDate date;
    private LocalTime time;
    private double amount;

    public transactions(LocalDate date, String description, String vendor, String paymentType, double amount) {
        this.description = description;
        this.vendor = vendor;
        this.paymentType = paymentType;
        this.date = date;
        this.amount = amount;
    }

    // Getters and Setters
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return date + "," + time + "," + description + "," + vendor + "," + paymentType + "," + amount;
    }

    // Static Methods for CSV Handling
    public static List<transactions> readTransactionsInCSV(String filename) {
        List<transactions> transactions = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                LocalDate date = LocalDate.parse(fields[0]);
                LocalTime time = LocalTime.parse(fields[1]);
                String description = fields[2];
                String vendor = fields[3];
                double amount = Double.parseDouble(fields[4]);
                transactions.add(new transactions(date, description, vendor, "default", amount));
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return transactions;
    }

    public static void writeTransactionsToCSV(List<transactions> transactions, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
            for (transactions transaction : transactions) {
                writer.write(transaction.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}
