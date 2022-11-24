package com.softwareacademy.sprint1.p9jb.model;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.databind.deser.std.DateDeserializers;
import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "patients")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "patient_id")
    private long id;

    @NotBlank
    @Length(max = 20, message = "Maximum 20 characters")
    @Column(name = "first_name")
    private String firstName;

    @NotBlank
    @Length(max = 20, message = "Maximum 20 characters")
    @Column(name = "last_name")
    private String lastName;

    @Past
    @NotNull
    @Column(name = "birth_date")
    @Temporal(TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-dd-MM")
    private Date birthdate;

    @NotBlank
    @Pattern(regexp = "M|F")
    @Column(name = "gender")
    private String gender;

    @Length(max = 20, message = "Maximum 20 characters")
    @Column(name = "phone")
    private String phone;

    @Length(max = 100, message = "Maximum 100 characters")
    @Column(name = "address")
    private String address;



}
