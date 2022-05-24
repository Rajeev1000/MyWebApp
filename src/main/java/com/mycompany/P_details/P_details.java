package com.mycompany.P_details;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;

import javax.persistence.*;

@EnableAutoConfiguration(exclude = {ErrorMvcAutoConfiguration.class})
@Entity
@Table(name="Patient_Details")

 
public class P_details {
    public P_details(){

    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "P_Id",nullable = false)
    private Integer p_id;


    @Column(name = "Date",length = 10,nullable = false)
    private String Date;

    @Column(name="Sickness",length = 50,nullable =false)
    private String sickness;

    @Column(name="Medicine",length = 50,nullable = false)
    private String medicine;

    //@Column(name = "Naam",length = 50,nullable = false)
   // private String naam;

    //public String getNaam() {
    //    return naam;
    //}

   // public void setNaam(String naam) {
       // this.naam = naam;
   // }

    public String getMedicine() {
        return medicine;
    }

    public void setMedicine(String medicine) {
        this.medicine = medicine;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getSickness() {
        return sickness;
    }

    public void setSickness(String sickness) {
        this.sickness = sickness;
    }

    public Integer getP_id() {
        return p_id;
    }

    public void setP_id(Integer p_id) {
        this.p_id = p_id;
    }


    @Override
    public String toString() {
        return "P_details{" +
                "id=" + id +
                ", p_id='"+ p_id + '\''+
                ", Date='" + Date + '\'' +
                ", sickness='" + sickness + '\'' +
                ", medicine='" + medicine + '\'' +
              //  ", naam='" + naam + '\'' +
                '}';
    }


}
