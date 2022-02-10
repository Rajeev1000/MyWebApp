package com.mycompany.Date;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DateService {

    @Autowired private DateRepository repo2;

    public List<Date> listall() {
        return (List<Date>) repo2.findAll();
    }




}
