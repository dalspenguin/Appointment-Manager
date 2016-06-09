package com.cbse;

import java.time.LocalDateTime;

/**
 * Created by dmitr on 6/8/2016.
 */
public class Payment {
    //  Data type

    private LocalDateTime date;  //  or whatever type of "DateTime"
    private Double amount;

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
