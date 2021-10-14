package com.example.demo.repos;

import java.time.LocalDate;

import java.util.List;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import com.example.demo.Donor;

@Repository
public interface DonorRepository extends JpaRepository<Donor, Integer>{

	public List<Donor> findByBloodGroup(String key);
	public List<Donor> findByCity(String loc);
	public boolean existsById(int id);
	public void deleteById(int id);

	@Query(nativeQuery = true,value="update donor set lastBloodDonationDate=:date where donorId=:number")
	@Modifying
	@Transactional
	public int updateDonationDate(@Param("number") int domainId,@Param("date") LocalDate lastBloodDonationDate);
	
}
