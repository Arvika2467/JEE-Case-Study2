package com.example.demo;
import java.time.LocalDate;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.stereotype.Component;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Component
public class Donor {

	@Range(max=200000,min=1000,message="it should be between 1000 and 200000")
	int donorId;
	@Length(min=3,max=20,message="name should be 3 to 20 characters")
	String donorName;
	String gender;
	@Range(min=18,max=50,message="Age should be between 18 to 50")
	int age;
	String bloodGroup;
	@DateTimeFormat(iso = ISO.DATE)
	LocalDate lastBloodDonationDate;
	String email;
	long phoneNumber;
	String state;
	String city;   
}
