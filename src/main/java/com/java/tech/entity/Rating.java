package com.java.tech.entity;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Rating {

	private String ratingId;
	private String userId;
	private String hotelId;
	private int rating;
	private String feedback;
}
