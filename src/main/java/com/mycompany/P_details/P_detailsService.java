package com.mycompany.P_details;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class P_detailsService {
    @Autowired private P_detailsRepository repo2;

    public List<P_details> listall(){
        return (List<P_details>) repo2.findAll();
    }

    public void save(P_details p_details){
        repo2.save(p_details);
    }
    // er moet nog delete method komen
}
