package com.lab.tourist.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Tourist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String contactNumber;
    private String email;
    private String visitedDestination;
    private String hotelName;

    public Tourist() {
    }

    public Tourist(String name, String contactNumber, String email,
                   String visitedDestination, String hotelName) {
        this.name = name;
        this.contactNumber = contactNumber;
        this.email = email;
        this.visitedDestination = visitedDestination;
        this.hotelName = hotelName;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getContactNumber() { return contactNumber; }
    public void setContactNumber(String contactNumber) { this.contactNumber = contactNumber; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getVisitedDestination() { return visitedDestination; }
    public void setVisitedDestination(String visitedDestination) { this.visitedDestination = visitedDestination; }
    public String getHotelName() { return hotelName; }
    public void setHotelName(String hotelName) { this.hotelName = hotelName; }
}
