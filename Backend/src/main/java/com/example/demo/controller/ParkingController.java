package com.example.demo.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.Parking;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.EmailService;
import com.example.demo.service.ParkingService;
import com.example.demo.service.UploadImageService;


@CrossOrigin
@RestController
public class ParkingController {

	@Autowired
	UserRepository 	userRepository ;

	@Autowired
	public ParkingService service;

	@Autowired
	public UploadImageService imageService;
	
	@Autowired
	public EmailService emailService;


//@PostMapping("/insertCarInfoo")
//	@Modifying
//	public ResponseEntity<HttpStatus> insertRecord(@RequestParam("parkingarea") String area,  @RequestParam("slotnumber") String slotnumber,
//			@RequestParam("slotimage") MultipartFile image) throws ParseException {
//	
//		String errorMessage=service.isSlotNumberPresent(slotnumber);
//		if(errorMessage != null) {
//			return new ResponseEntity<HttpStatus>(HttpStatus.ALREADY_REPORTED);
//		}
//		else {
//		Parking entity = new Parking();
//		entity.setParkingarea(area);
//		entity.setSlotnumber(slotnumber);
//		entity.setSlotimage(image.getOriginalFilename());
//		entity = service.insertDetails(entity);
//		String path = imageService.uploadImage(image, entity.getId());
//		entity.setSlotimage(path);
//		service.updatePath(entity.getId(), entity.getSlotimage());
//		System.out.println("Entity =" + entity);
//		return new ResponseEntity<HttpStatus>(HttpStatus.CREATED);
//		}
//	}

@PostMapping("/insertCarInfo")
@Modifying
public ResponseEntity<HttpStatus> insertRecordFile(@RequestParam("parkingarea") String area,  @RequestParam("slotnumber") String slotnumber,
		@RequestParam("slotimage") MultipartFile image) throws ParseException, IOException {

	String errorMessage=service.isSlotNumberPresent(slotnumber);
	if(errorMessage != null) {
		return new ResponseEntity<HttpStatus>(HttpStatus.ALREADY_REPORTED);
	}
	else {
	Parking entity = new Parking();
	entity.setParkingarea(area);
	entity.setSlotnumber(slotnumber);
	entity.setSlotimage(image.getOriginalFilename());
	entity.setCarImage(image.getBytes());
	service.insertDetails(entity);
	System.out.println("Entity =" + entity);
	return new ResponseEntity<HttpStatus>(HttpStatus.CREATED);
	}
}

	@GetMapping("/getData")
	public List<Parking> getAllData() {
		List cars = new ArrayList<Parking>();
		cars=service.getAllData();
		return cars;

	}
	
	
	
	@PostMapping(value="/sendmail/{email}")
	public void forgotPassword(@PathVariable(value = "email") String email) {
		User u = userRepository.findByEmail(email);
		emailService.sendEmail(email,u.getPassword());	
	}

	
	@PostMapping("/updateData")
	public ResponseEntity<HttpStatus> updateData(@RequestBody Parking parking) throws ParseException {
		
		service.updateDetails(parking);
//		System.out.println("Start Date ="+sdate);
//		service.updateDetails(parkDTO.getSlotNumber(), parkDTO.getCarNumber(), sdate, edate);
		return new ResponseEntity<HttpStatus>(HttpStatus.ACCEPTED);
		
		
	}


}
