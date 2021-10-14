package com.example.demo.repos;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.DonationCamp;

@Repository
public interface DonationCampRepository extends JpaRepository<DonationCamp, Integer>{

	public List<DonationCamp> findByCity(String loc);
	public List<DonationCamp> findByCampDate(LocalDate date);

}
