package com.mycompany;

import com.mycompany.Appointments.Appointments;
import com.mycompany.Appointments.AppointmentsRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class AppointmentsTests {
    @Autowired private AppointmentsRepository repo4;

    @Test
    public void testAddNew(){
        Appointments appointments=new Appointments();
        appointments.setP_id(4);
        appointments.setDate("22-2-2000");
        appointments.setTime("10.30 am");

        Appointments savedAppointments=repo4.save(appointments);
        Assertions.assertThat(savedAppointments).isNotNull();
        Assertions.assertThat(savedAppointments.getId()).isGreaterThan(0);
    }
}
