package _28060.Procurement_Management_System;

import java.util.Date;

public class Entity {
    private int id;
    private Date createdDate;
    private Date updatedDate;

    public Entity(int id) {
        if (id <= 0) throw new IllegalArgumentException("ID must be greater than 0");
        this.id = id;
        this.createdDate = new Date();
        this.updatedDate = new Date();
    }

    public int getId() {
        return id;
    }

    public void updateTimestamp() {
        this.updatedDate = new Date();
    }

    @Override
    public String toString() {
        return "Entity ID: " + id + "27801, Created: " + createdDate + ", Updated: " + updatedDate;
    }
}
