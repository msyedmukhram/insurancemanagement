package com.test.insurance.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "insurance_table")
//@Data
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
//@ToString
public class Insurance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String insuranceNumber;

    private String vehicleNumber;

    private String vehicleName;

    private String vehicleType;



    @Temporal(TemporalType.DATE)
    @Column(name = "start_date")
    private Date insuranceStartDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "end_date")
    private Date insuranceExpiryDate;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @Override
	public String toString() {
		return "Insurance [id=" + id + ", insuranceNumber=" + insuranceNumber + ", vehicleNumber=" + vehicleNumber
				+ ", vehicleName=" + vehicleName + ", vehicleType=" + vehicleType + ", insuranceStartDate="
				+ insuranceStartDate + ", insuranceExpiryDate=" + insuranceExpiryDate + "]";
	}
}
