package com.example.demo.controller;

import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.Donor;

import com.example.demo.service.DonorService;

@RequestMapping(path = "/api/v1/donors")
@RestController
public class DonorController {

	@Autowired
	private DonorService service;
	public void setService(DonorService service) {
		this.service = service;
	}
	@PostMapping
	public ResponseEntity<Donor> addDonor(@RequestBody Donor entity) {
		Donor addedEntity=this.service.addDonor(entity);
		return ResponseEntity.status(HttpStatus.CREATED).body(addedEntity);
	}
	@GetMapping 
	public List<Donor> findAll() {
		
		return this.service.findAll();
		
	}
	@GetMapping(path = "/{donorId}")
	public Donor findById(@PathVariable("donorId")int DonorId) {
		
		return this.service.findById(DonorId);
		
	}
	
	@GetMapping(path = "/searchbybloodgroup/{bloodGroup}")
	public List<Donor> findByBloodGroup(@PathVariable("bloodGroup")String BloodGroup) {
		
		return this.service.findByBloodGroup(BloodGroup);
		
	}
	@GetMapping(path = "/searchbycity/{city}")
	public List<Donor> findByCity(@PathVariable("city")String city) {
		
		return this.service.findByCity(city);
		
	}
	@PutMapping(path = "/{donorId}/{lastBloodDonationDate}")
	public ResponseEntity<String> updateDonationDate(@PathVariable("donorId")int DomainId,@PathVariable("lastBloodDonationDate")String LastBloodDonationDate) {
		LocalDate lbd=LocalDate.parse(LastBloodDonationDate);
		int count= this.service.updateDonationDate(DomainId, lbd);
		return ResponseEntity.ok().body(count+"=Records updated");
		
	}
	@DeleteMapping(path="/{donorId}")
	public ResponseEntity<String> removeDonor(@PathVariable("donorId")int DonorId) {
			int count= this.service.remove(DonorId);
			HttpStatus status = HttpStatus.NOT_FOUND;
			String message="Record Not Found";
			if(count==1) {
				status=HttpStatus.OK;
				message="one record deleted";
			}
			return ResponseEntity.status(status).body(message);
		}

}
