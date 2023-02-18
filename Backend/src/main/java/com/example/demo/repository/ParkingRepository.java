package com.example.demo.repository;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Parking;



@Repository
public interface ParkingRepository extends JpaRepository<Parking, Long>{

	@Transactional
	@Modifying
	@Query(value="update parkingmanagement set slotimage =:path where id=:id",nativeQuery=true)
	public void updatePath(@Param("id") Long id,@Param("path") String path);

	@Transactional
	@Modifying
	@Query(value="update parkingmanagement set carnumber =:carnumber , startdate =:startdate , enddate =:enddate where slotnumber=:slotnumber",nativeQuery=true)
	public void updateDetails(@Param("slotnumber") String slotnumber,@Param("carnumber") String carnumber,@Param("startdate") Date startdate,@Param("enddate") Date enddate);


	public Parking findBySlotnumber(String slotnumber);
}
