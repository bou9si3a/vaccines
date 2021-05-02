package com.interview.vaccines.domain;

import com.fasterxml.jackson.annotation.JsonView;
import com.interview.vaccines.views.VaccineViews;

import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
public abstract class Appointment {
    // Subject information
    @JsonView(VaccineViews.DetailView.class)
    private String subjectFirstName;
    @JsonView(VaccineViews.DetailView.class)
    private String subjectLastName;
    @JsonView(VaccineViews.DetailView.class)
    private int subjectAge;

    // Date & time
    @JsonView(VaccineViews.MinimalView.class)
    private LocalDateTime dateTime;

    public Appointment() { }

    public Appointment(String subjectFirstName, String subjectLastName, int subjectAge, LocalDateTime dateTime) {
        this.subjectFirstName = subjectFirstName;
        this.subjectLastName = subjectLastName;
        this.subjectAge = subjectAge;
        this.dateTime = dateTime;
    }

    public String getSubjectFirstName() {
        return subjectFirstName;
    }

    public String getSubjectLastName() {
        return subjectLastName;
    }

    public int getSubjectAge() {
        return subjectAge;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }
}
