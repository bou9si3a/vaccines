package com.interview.vaccines.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonView;
import com.interview.vaccines.views.VaccineViews;
import org.springframework.lang.Nullable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@JsonPropertyOrder({ "id", "dateTime", "type", "finalInjection" })
public class Vaccine extends Appointment implements Payable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonView(VaccineViews.MinimalView.class)
    private Long id;

    @Nullable
    private LocalDateTime nextInjectionDateTime;

    @JsonView(VaccineViews.MinimalView.class)
    private VaccineType type;

    public Vaccine() { }

    public Vaccine(
            String subjectFirstName,
            String subjectLastName,
            int subjectAge,
            String subjectSocialSecurityNumber,
            LocalDateTime dateTime,
            VaccineType type,
            @Nullable LocalDateTime nextInjectionDateTime
    ) {
        super(subjectFirstName, subjectLastName, subjectAge, subjectSocialSecurityNumber, dateTime);
        this.nextInjectionDateTime = nextInjectionDateTime;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public VaccineType getType() {
        return type;
    }

    @JsonIgnore
    @Override
    public int getCost() {
        return type.getCost();
    }

    @JsonView(VaccineViews.MinimalView.class)
    public boolean isFinalInjection() {
        return nextInjectionDateTime == null;
    }
}
