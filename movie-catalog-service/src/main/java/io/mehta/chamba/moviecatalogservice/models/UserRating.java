package io.mehta.chamba.moviecatalogservice.models;

import java.util.List;

public class UserRating {
	
	public UserRating() {
		super();
	}

	private List<Rating> userRating;

	public List<Rating> getUserRating() {
		return userRating;
	}

	public void setUserRating(List<Rating> userRating) {
		this.userRating = userRating;
	}

}
