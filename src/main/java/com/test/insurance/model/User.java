package com.test.insurance.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user_table")
//@Data
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(nullable = false,unique = true)
    private String mobileNumber;

    @Column(nullable = false)
    private String emailId;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "user")
    private List<Insurance> insurances;

}
