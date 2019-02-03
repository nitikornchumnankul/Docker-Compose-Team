package com.okta.developer.demo;

import javax.persistence.*;
import lombok.*;
import java.sql.Date;

@Entity
@Setter @Getter
@ToString
@NoArgsConstructor
@EqualsAndHashCode

@Table (name="Student")

public class Student {

    @Id 
    @SequenceGenerator(name="student_seq",sequenceName="student_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="student_seq")
    @Column(name="studentID",insertable = false)
    private @NonNull Long id;


    private @NonNull String firstname;
    private @NonNull String lastname;
    private @NonNull String cardid;
    private @NonNull String nametitle;

    public void setFirstname(String name){ this.firstname = name;}
    public String getFisrtname(){return this.firstname;}

    public void setLastname(String name){ this.lastname = name;}
    public String getLastname(){return this.lastname;}

    public void setCardid(String id){this.cardid = id;}
    public String getCardid(){return this.cardid;}

    public void setNametitle(String name){this.nametitle = name;}
    public String getNametitle(){return this.nametitle;}

  

}