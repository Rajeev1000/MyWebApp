package com.mycompany.labresults;


import javax.persistence.*;

@Entity
@Table(name="Labresults")
public class Labresults {
    public Labresults(){

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "P_Id",nullable = false)
    private Integer p_id;

    @Column(name = "date",length = 10,nullable = false)
    private String date;

    @Column(name = "Conclusion",nullable = false)
    private String conclusion;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getP_id() {
        return p_id;
    }

    public void setP_id(Integer p_id) {
        this.p_id = p_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getConclusion() {
        return conclusion;
    }

    public void setConclusion(String conclusion) {
        this.conclusion = conclusion;
    }

    @Override
    public String toString() {
        return "Labresults{" +
                "id=" + id +
                ", p_id=" + p_id +
                ", date='" + date + '\'' +
                ", conclusion='" + conclusion + '\'' +
                '}';
    }
}
