package com.mycompany.Appointments;

import org.springframework.data.repository.CrudRepository;

public interface AppointmentsRepository extends CrudRepository<Appointments,Integer> {
    public Long countById(Integer id);
}
