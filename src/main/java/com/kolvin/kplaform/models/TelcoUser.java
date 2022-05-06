package com.kolvin.kplaform.models;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity(name = "TelcoUser")
@Table(
        name = "telco_user",
        uniqueConstraints = {
                @UniqueConstraint(name = "user_mobile_number_unique", columnNames = "mobile_number")
        }
)
public class TelcoUser {

    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private int id;

    @Column(
            name = "mobile_number",
            nullable = false,
            length = 100
    )
    private String mobileNumber;

    @Column(
            name = "status",
            nullable = false
    )
    private int status;

    @Column(
            name = "service_provider",
            nullable = false,
            length = 20
    )
    private String serviceProvider;

    @CreationTimestamp
    @Column(
            name = "created_date",
            nullable = false
    )
    private LocalDateTime createdDate;

    public TelcoUser() {
    }

    public TelcoUser(int id, String mobileNumber, int status, String serviceProvider, LocalDateTime createdDate) {
        this.id = id;
        this.mobileNumber = mobileNumber;
        this.status = status;
        this.serviceProvider = serviceProvider;
        this.createdDate = createdDate;
    }

    public TelcoUser(String mobileNumber, int status, String serviceProvider) {
        this.mobileNumber = mobileNumber;
        this.status = status;
        this.serviceProvider = serviceProvider;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public String getServiceProvider() {
        return serviceProvider;
    }

    public void setServiceProvider(String serviceProvider) {
        this.serviceProvider = serviceProvider;
    }

    @Override
    public String toString() {
        return "TelcoUser{" +
                "id=" + id +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", status=" + status +
                ", serviceProvider='" + serviceProvider + '\'' +
                ", createdDate=" + createdDate +
                '}';
    }
}
