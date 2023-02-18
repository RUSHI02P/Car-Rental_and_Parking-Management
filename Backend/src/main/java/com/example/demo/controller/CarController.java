package com.example.demo.controller;

import java.io.IOException;
import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.Car;
import com.example.demo.model.Parking;
import com.example.demo.repository.CarRepository;

@RestController
@CrossOrigin
public class CarController {

	@Autowired
	CarRepository 	carRepository ;

	
//	@PostMapping(value="/car/save")
//	public Car saveCar(@RequestBody Car car)
//	{
//		carRepository.save(car);
//		return car;
//	}
	
	
	@PostMapping("/car/save")
	@Modifying
	public ResponseEntity<HttpStatus> insertRecordFile(@RequestParam("selectedCompany") String selectedCompany,  @RequestParam("selectedModel") String selectedModel,
			@RequestParam("carNumber") String carNumber,@RequestParam("carIssueYear") String carIssueYear,@RequestParam("carCondition") String carCondition,
			@RequestParam("carColor") String carColor,
			@RequestParam("CarImage") MultipartFile carImage) throws ParseException, IOException {

//		String errorMessage=service.isSlotNumberPresent(slotnumber);
//		if(errorMessage != null) {
//			return new ResponseEntity<HttpStatus>(HttpStatus.ALREADY_REPORTED);
//		}
//		else {
//		Parking entity = new Parking();
//		entity.setParkingarea(area);
//		entity.setSlotnumber(slotnumber);
//		entity.setSlotimage(image.getOriginalFilename());
//		entity.setCarImage(image.getBytes());
//		service.insertDetails(entity);
//		System.out.println("Entity =" + entity);
//		return new ResponseEntity<HttpStatus>(HttpStatus.CREATED);
		
		Car entity=new Car();
		entity.setSelectedCompany(selectedCompany);
		entity.setSelectedModel(selectedModel);
		entity.setCarNumber(carNumber);
		entity.setCarIssueYear(carIssueYear);
		entity.setCarCondition(carCondition);
		entity.setCarColor(carColor);
		entity.setCarImage(carImage.getBytes());
		System.out.println(" ENTITY  : "+entity);
		return new ResponseEntity<HttpStatus>(HttpStatus.CREATED);
		
	}

}
