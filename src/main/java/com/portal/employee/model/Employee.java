package com.portal.employee.model;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name="EMPLOYEES")
public class Employee {

        @Id
        @GeneratedValue
        @Column(name="EMPLOYEE_ID")
        private Long id;

        @Column(name="EMPLOYEE_FIRSTNAME")
        @NotEmpty(message="Please Enter Your First Name")
        private String firstName;

        @Column(name="EMPLOYEE_LASTNAME")
        @NotEmpty(message="Please Enter Your Last Name")
        private String lastName;

        @Column(name="EMPLOYEE_EMAIL")
        @NotEmpty(message="Please Enter Your Email")
        @Email(message = "{user.email.invalid}")
        private String email;

        @Column(name="EMPLOYEE_HIREDATE")
        @NotNull
        private Date hireDate;

        @Column(name="EMPLOYEE_SALARY")
        @NotNull
        private Double salary;

        @Column(name="EMPLOYEE_ADDRESS")
        private String address;

        @Column(name="EMPLOYEE_ZIPCODE")
        private String zipcode;

        @Column(name="EMPLOYEE_PHONENUMBER")
        private String phoneNumber;

        @Column(name="EMPLOYEE_TITLE")
        private String title;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public Date getHireDate() {
            return hireDate;
        }

        public void setHireDate(Date hireDate) {
            this.hireDate = hireDate;
        }

        public Double getSalary() {
            return salary;
        }

        public void setSalary(Double salary) {
            this.salary = salary;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getZipcode() {
            return zipcode;
        }

        public void setZipcode(String zipcode) {
            this.zipcode = zipcode;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
}
