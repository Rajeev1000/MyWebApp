package com.mycompany.Date;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "dates")
public class Date {

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name="id",referencedColumnName = "users.id")
    @JoinColumn(name="Dates",referencedColumnName = "lastVisited")
    private List<Date> user_date;




  @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

  @Column(length = 10,nullable = false,name="Dates")
    private String date;

    @Column(length = 45,nullable = false,name="Issues")
    private String issues;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getIssues() {
        return issues;
    }

    public void setIssues(String issues) {
        this.issues = issues;
    }
}
