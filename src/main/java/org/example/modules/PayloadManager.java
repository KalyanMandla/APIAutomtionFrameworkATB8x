package org.example.modules;

import com.google.gson.Gson;
import org.example.pojos.*;

public class PayloadManager {

    // Converting the JAVA object to the String

    // GSON
    Gson gson;

    public String createPayloadBookingAsString(){   // Serialization
        Booking booking = new Booking();
        booking.setFirstname("Pramod");
        booking.setLastname("Dutta");
        booking.setTotalprice(112);
        booking.setDepositpaid(true);

        Bookingdates bookingDates = new Bookingdates();
        bookingDates.setCheckin("2025-03-20");
        bookingDates.setCheckout("2025-03-20");
        booking.setBookingdates(bookingDates);
        booking.setAdditionalneeds("Breakfast");

        System.out.println(booking);
        Gson gson = new Gson();
        // Object -> JSON String (GSON) -> Ser
        String jsonStringPayload = gson.toJson(booking);
        System.out.println(jsonStringPayload);
        return jsonStringPayload;

    }

    // public String createPayloadBookingAsStringFromExcel(){}

    public BookingResponse bookingResponseJava(String responseString){  // De-Serialization
        gson = new Gson();
        BookingResponse bookingResponse = gson.fromJson(responseString, BookingResponse.class);
        return bookingResponse;

    }

    public Booking getResponseFromJSON(String getResponse){
        Booking booking = gson.fromJson(getResponse,Booking.class);
        return booking;
    }

    // get Token
    public String setAuthPayload(){
        // Auth Object -> json string
        Auth auth = new Auth();
        auth.setUsername("admin");
        auth.setPassword("password123");
        gson = new Gson();
        String jsonPayloadString = gson.toJson(auth);
        System.out.println("Payload set to the -> " + jsonPayloadString);
        return jsonPayloadString;
    }

    public String getTokenFromJSON(String tokenResponse){
        gson = new Gson();
        TokenResponse tokenResponse1 = gson.fromJson(tokenResponse, TokenResponse.class);
        return tokenResponse1.getToken();
    }

    public String fullyUpdatePayloadAsString(){
        Booking booking = new Booking();
        booking.setFirstname("Pramod");
        booking.setLastname("Dutta");
        booking.setTotalprice(112);
        booking.setDepositpaid(true);

        Bookingdates bookingdates = new Bookingdates();
        bookingdates.setCheckin("2025-03-23");
        bookingdates.setCheckout("2025-03-23");
        booking.setBookingdates(bookingdates);
        booking.setAdditionalneeds("Breakfast");
        return gson.toJson(booking);

    }




}
