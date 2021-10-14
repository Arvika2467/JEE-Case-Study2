package com.example.demo;

import java.time.LocalDate;
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
public class DonationCamp {

	@Range(min=1000,max=200000,message="it should be between 1000 and 200000")
	int donorId;
	String city;
	long phoneNumber;
	@DateTimeFormat(iso = ISO.DATE)
	LocalDate campDate;
	
}
