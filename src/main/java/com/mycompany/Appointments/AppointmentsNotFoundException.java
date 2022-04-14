package com.mycompany.Appointments;

public class AppointmentsNotFoundException extends Throwable {
    public AppointmentsNotFoundException(String message) {
        super (message);
    }
}
