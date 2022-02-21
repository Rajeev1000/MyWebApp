package com.mycompany.P_details;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Patient_Details")


public class P_details {
    @Id
    private Integer id;

    @Column(nullable = false,name = "Date",length = 10)
    private String Date;

    @Column(nullable = false,name="Sickness")
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
