package com.mycompany;

import com.mycompany.labresults.Labresults;
import com.mycompany.labresults.LabresultsRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class LabresultsTest {
    @Autowired private LabresultsRepository repo3;


    @Test
    public void testAddNew(){
        Labresults labresults=new Labresults();
        labresults.setP_id(4);
        labresults.setAchternaam("world");
        labresults.setDate("22-2-2005");
        labresults.setConclusion("suiker");

        Labresults savedLabresults= repo3.save(labresults);
        Assertions.assertThat(savedLabresults).isNotNull();
        Assertions.assertThat(savedLabresults.getId()).isGreaterThan(0);
    }
    @Test
    public void testListAll() {
        Iterable<Labresults> labresult = repo3.findAll();
        Assertions.assertThat(labresult).hasSizeGreaterThan(0);

        for (Labresults labresults : labresult) {
            System.out.println(labresults);
        }
    }
    @Test
    public void testUpdate() {
        Integer labresultsId=1;
        Optional<Labresults> optionalLabresults= repo3.findById(labresultsId);
        Labresults labresults=optionalLabresults.get();
        labresults.setP_id(3);
        labresults.setAchternaam("");
        labresults.setDate("22-3-2007");
        labresults.setConclusion("");
        repo3.save(labresults);

       Labresults updatedLabresults= repo3.findById(labresultsId).get();
       Assertions.assertThat(updatedLabresults.getP_id()).isEqualTo(3);
        Assertions.assertThat(updatedLabresults.getDate()).isEqualTo("22-3-2007");
        Assertions.assertThat(updatedLabresults.getConclusion()).isEqualTo("");
    }
    @Test
    public void testGet(){
        Integer labresultsId=1;
        Optional<Labresults> optionalLabresults=repo3.findById(labresultsId);
        Labresults labresults=optionalLabresults.get();
        Assertions.assertThat(optionalLabresults).isPresent();
        System.out.println(optionalLabresults.get());
    }
    @Test
    public void testDelete(){
        Integer labresultsId=2;
        repo3.deleteById(labresultsId);
        Optional<Labresults> optionalLabresults=repo3.findById(labresultsId);
        Assertions.assertThat(optionalLabresults).isNotPresent();
    }

    }

