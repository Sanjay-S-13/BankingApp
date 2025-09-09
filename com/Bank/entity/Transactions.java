package com.Bank.entity;

import java.time.LocalDate;

public class Transactions {
    private LocalDate transactionDate;
    private String transactionUserId;
    private String transactionPerformedBy;
    private Double beforeAmount;
    private Double finalAmount;

    public Transactions(LocalDate transactionDate, String transactionUserId, String transactionPerformedBy, Double beforeAmount, Double finalAmount) {
        this.transactionDate = transactionDate;
        this.transactionUserId = transactionUserId;
        this.transactionPerformedBy = transactionPerformedBy;
        this.beforeAmount = beforeAmount;
        this.finalAmount = finalAmount;
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getTransactionUserId() {
        return transactionUserId;
    }

    public void setTransactionUserId(String transactionUserId) {
        this.transactionUserId = transactionUserId;
    }

    public String getTransactionPerformedBy() {
        return transactionPerformedBy;
    }

    public void setTransactionPerformedBy(String transactionPerformedBy) {
        this.transactionPerformedBy = transactionPerformedBy;
    }

    public Double getBeforeAmount() {
        return beforeAmount;
    }

    public void setBeforeAmount(Double beforeAmount) {
        this.beforeAmount = beforeAmount;
    }

    public Double getFinalAmount() {
        return finalAmount;
    }

    public void setFinalAmount(Double finalAmount) {
        this.finalAmount = finalAmount;
    }

    @Override
    public String toString() {
        return "Transactions{" +
                "transactionDate=" + transactionDate +
                ", transactionUserId='" + transactionUserId + '\'' +
                ", transactionPerformedBy='" + transactionPerformedBy + '\'' +
                ", beforeAmount=" + beforeAmount +
                ", finalAmount=" + finalAmount +
                '}';
    }
}
