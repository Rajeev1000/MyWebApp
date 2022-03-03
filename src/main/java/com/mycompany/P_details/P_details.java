package com.mycompany.P_details;

import javax.persistence.*;

@Entity
@Table(name="Patient_Details")


public class P_details {
    public P_details(){

    }
    @Id

   //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "Date",length = 10,nullable = false)
    private String Date;

    @Column(name="Sickness",length = 50,nullable =false)
    private String sickness;

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
    @Override
    public String toString() {
        return "P_details{" +
                "id=" + id +
                ", Date='" + Date + '\'' +
                ", sickness='" + sickness + '\'' +
                '}';
    }
}
