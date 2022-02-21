package com.mycompany.P_details;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class P_detailsController {
    @Autowired private P_detailsService service2;
    // hier moet er nog mappings geplaats worden die naar de webpages verwijzen
}
