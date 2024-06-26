package com.masai.model;

import java.time.LocalDate;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.masai.repository.UserRepo;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Future;

import com.masai.model.User;
import com.masai.repository.UserRepo;
//import com.masai.exception.CustomDateDeserializer;

@Entity
public class Reservation {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer reservationId;
	
	private String reservationStatus;
	
	private String reservationType;

	@Future(message = "Date should not be in past *")
//	@NotNull(message = "Reservation Date is mandatory *")
	@JsonFormat(pattern = "yyyy-MM-dd", shape = Shape.STRING)
	private LocalDate reservationDate;
	
	
//	@NotNull(message = "Reservation Time is mandatory *")
//	@JsonFormat(pattern = "hh-mm-ss", shape = Shape.STRING)
	private LocalTime reservationTime;
	
//	@NotNull(message = "Reservation source is mandatory *")
	private String source;
	
//	@NotBlank(message = "Reservation destination not be ramain empty *")
//	@NotNull(message = "Reservation destination is mandatory *")
	private String destination;

	private Integer userId;
	
	@OneToOne
	private Bus bus;
	@OneToOne
	private User user;

	@JsonIgnore
    public Reservation(Integer reservationId,
			@Future(message = "Date should not be in past *") LocalDate reservationDate, String source,
			String destination, Integer userId) {
		super();
		this.reservationId = reservationId;
		this.reservationDate = reservationDate;
		this.source = source;
		this.destination = destination;
		this.userId = userId;
		this.user = user;
	}


	public Reservation() {
		
	}


	public Integer getReservationId() {
		return reservationId;
	}


	public void setReservationId(Integer reservationId) {
		this.reservationId = reservationId;
	}


	public String getReservationStatus() {
		return reservationStatus;
	}


	public void setReservationStatus(String reservationStatus) {
		this.reservationStatus = reservationStatus;
	}


	public String getReservationType() {
		return reservationType;
	}


	public void setReservationType(String reservationType) {
		this.reservationType = reservationType;
	}


	public LocalDate getReservationDate() {
		return reservationDate;
	}


	public void setReservationDate(LocalDate reservationDate) {
		this.reservationDate = reservationDate;
	}


	public LocalTime getReservationTime() {
		return reservationTime;
	}


	public void setReservationTime(String reservationTime) {
		this.reservationTime = LocalTime.parse(reservationTime);
	}


	public String getSource() {
		return source;
	}


	public void setSource(String source) {
		this.source = source;
	}


	public String getDestination() {
		return destination;
	}


	public void setDestination(String destination) {
		this.destination = destination;
	}


	public Bus getBus() {
		return bus;
	}


	public void setBus(Bus bus) {
		this.bus = bus;
	}

	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}

	public User getUserId() {
		return user;
	}


	public void setUserId(Integer UserId) {
		this.userId = UserId;
	}


	@Override
	public String toString() {
//		return "Reservation [reservationId=" + reservationId + ", reservationStatus=" + reservationStatus
//				+ ", reservationType=" + reservationType + ", reservationDate=" + reservationDate + ", reservationTime="
//				+ reservationTime + ", source=" + source + ", destination=" + destination + ", userId=" + userId +", user=" + user + "]";
		return "Reservation [reservationId=" + reservationId + ", reservationStatus=" + reservationStatus
				+ ", reservationType=" + reservationType + ", reservationDate=" + reservationDate + ", reservationTime="
				+ reservationTime + ", source=" + source + ", destination=" + destination +", user=" + userId + "]";
	}

}
