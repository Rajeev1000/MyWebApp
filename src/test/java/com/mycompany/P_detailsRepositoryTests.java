package com.mycompany;


import com.mycompany.P_details.P_details;
import com.mycompany.P_details.P_detailsRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)

public class P_detailsRepositoryTests {
    @Autowired private P_detailsRepository repo2;


    @Test
    public void testAddNew(){
        P_details p_details=new P_details();
        p_details.setId(10);
        p_details.setDate("21-5-2020");
        p_details.setSickness("Buikgriep");

        P_details savedP_details= repo2.save(p_details);
        Assertions.assertThat(savedP_details).isNotNull();
        Assertions.assertThat(savedP_details.getId()).isGreaterThan(0);
    }
    //Verdere test schrijven om de andere methods van CRUD uit te proberen
}
