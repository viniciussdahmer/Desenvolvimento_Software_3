package com.example.desenvolvimento_software_3.application.sintoma;

import com.example.desenvolvimento_software_3.application.user.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "SINTOMAS")
public class Sintoma {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "SINTOMA_SEQ")
    @SequenceGenerator(name = "SINTOMA_SEQ", sequenceName = "SINTOMA_SEQ")
    @Column(name = "ID")
    private Long id;

    @JoinColumn(name = "USER_ID")
    @ManyToOne
    @JsonIgnoreProperties("sintomas")
    private User user;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "DATETIME")
    private String dateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }
}
