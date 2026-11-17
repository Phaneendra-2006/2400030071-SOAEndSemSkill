package com.lab.tourist.dto;

public class TouristUpdateRequest {
    private String contactNumber;
    private String email;
    private String visitedDestination;
    private String hotelName;

    public TouristUpdateRequest() {
    }

    public String getContactNumber() { return contactNumber; }
    public void setContactNumber(String contactNumber) { this.contactNumber = contactNumber; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getVisitedDestination() { return visitedDestination; }
    public void setVisitedDestination(String visitedDestination) { this.visitedDestination = visitedDestination; }
    public String getHotelName() { return hotelName; }
    public void setHotelName(String hotelName) { this.hotelName = hotelName; }
}
