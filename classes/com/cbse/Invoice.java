package com.cbse;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * Created by dmitr on 6/8/2016.
 */
public class Invoice {
    //  Data type

    private LocalDateTime date;  //  or whatever type of "DateTime"

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

}
