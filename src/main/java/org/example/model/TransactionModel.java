package org.example.model;

public class TransactionModel {
    private int id_transaction;
    private String date;
    private double value_total;
    private int id_origin_account;
    private int id_destination_account;

    public int getId_transaction() {
        return id_transaction;
    }

    public void setId_transaction(int id_transaction) {
        this.id_transaction = id_transaction;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getValue_total() {
        return value_total;
    }

    public void setValue_total(double value_total) {
        this.value_total = value_total;
    }

    public int getId_origin_account() {
        return id_origin_account;
    }

    public void setId_origin_account(int id_origin_account) {
        this.id_origin_account = id_origin_account;
    }

    public int getId_destination_account() {
        return id_destination_account;
    }

    public void setId_destination_account(int id_destination_account) {
        this.id_destination_account = id_destination_account;
    }
}
