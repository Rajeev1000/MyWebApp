package com.mycompany.Appointments;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentsService {
    @Autowired
    private AppointmentsRepository repo4;

    public List<Appointments> listall(){
        return (List<Appointments>) repo4.findAll();
    }
    public void save(Appointments appointments){
        repo4.save(appointments);
    }
    public Appointments get(Integer id) throws AppointmentsNotFoundException{
        Optional<Appointments> result=repo4.findById(id);
        if(result.isPresent()){
            return result.get();
        }
        throw new AppointmentsNotFoundException("Could not find any appointments with ID"+id);
    }
    public void delete(Integer id) throws AppointmentsNotFoundException{
        Long count=repo4.countById(id);
        if(count==null || count==0){
            throw new AppointmentsNotFoundException("Could not find any appointments with ID"+id);

        }
        repo4.deleteById(id);
    }
}
