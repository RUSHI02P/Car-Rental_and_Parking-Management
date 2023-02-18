package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "parkingmanagement")
public class Parking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String parkingarea;

	private String startdate;

	private String enddate;

	private String slotimage;

	private String carnumber;

	private String slotnumber;
	
	@Column(length = 2000)
	private byte[] carImage;

	public byte[] getCarImage() {
		return carImage;
	}

	public void setCarImage(byte[] carImage) {
		this.carImage = carImage;
	}

	public String getCarnumber() {
		return carnumber;
	}

	public void setCarnumber(String carnumber) {
		this.carnumber = carnumber;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getParkingarea() {
		return parkingarea;
	}

	public void setParkingarea(String parkingarea) {
		this.parkingarea = parkingarea;
	}

	public String getStartdate() {
		return startdate;
	}

	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}

	public String getEnddate() {
		return enddate;
	}

	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}

	public String getSlotimage() {
		return slotimage;
	}

	public void setSlotimage(String slotimage) {
		this.slotimage = slotimage;
	}

	public String getSlotnumber() {
		return slotnumber;
	}

	public void setSlotnumber(String slotnumber) {
		this.slotnumber = slotnumber;
	}

	public Parking(long id, String parkingarea, String startdate, String enddate, String slotimage, String carnumber,
			String slotnumber) {
		super();
		this.id = id;
		this.parkingarea = parkingarea;
		this.startdate = startdate;
		this.enddate = enddate;
		this.slotimage = slotimage;
		this.carnumber = carnumber;
		this.slotnumber = slotnumber;
	}

	public Parking() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Parking [id=" + id + ", parkingarea=" + parkingarea + ", startdate=" + startdate + ", enddate="
				+ enddate + ", slotimage=" + slotimage + ", carnumber=" + carnumber + ", slotnumber=" + slotnumber
				+ "]";
	}

}
