package com.example.demo.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Parking;
import com.example.demo.repository.ParkingRepository;


@Service
public class ParkingService {
	
	@Autowired
	public ParkingRepository repository;
	
	public Parking insertDetails(Parking entity) {
		return repository.save(entity);
	}
	
	public Parking updateDetails(Parking entity) {
		return repository.save(entity);
	}
	
	public List<Parking> getAllData(){
		return repository.findAll();
	}
	
	public void updatePath(Long id,String path) {
		 repository.updatePath(id,path);
	}
	
	public void updateDetails(String slotnumber, String carnumber, Date startdate, Date enddate) {
		repository.updateDetails(slotnumber, carnumber, startdate, enddate);
	}

	public String isSlotNumberPresent(String slotnumber) {
		Parking ps = repository.findBySlotnumber(slotnumber);
		if (ps != null) {
			return "Slotnumber Already Exist, Please Add Other Slotnumber.";
		}
			return null;
	}



}
