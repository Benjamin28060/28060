package _28060.Stock_Management_System;

import java.time.LocalDate;

public class Entity {
    private int id;
    private LocalDate createdDate;
    private LocalDate updatedDate;

    public Entity(int id) {
        if (id <= 0)
            throw new IllegalArgumentException("27801 | ID must be greater than 0");
        this.id = id;
        this.createdDate = LocalDate.now();
        this.updatedDate = LocalDate.now();
    }

    public int getId() { return id; }
    public LocalDate getCreatedDate() { return createdDate; }
    public LocalDate getUpdatedDate() { return updatedDate; }
}
