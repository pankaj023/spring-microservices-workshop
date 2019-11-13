package io.mehta.chamba.moviecatalogservice.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import io.mehta.chamba.moviecatalogservice.models.Rating;
import io.mehta.chamba.moviecatalogservice.models.UserRating;

@Service
public class UserRatingInfo {
	
	@Autowired
	private RestTemplate restTemplate;
	
	
	@HystrixCommand(fallbackMethod="getFallBackUserRating" )
	public UserRating getUserRating(String userId) {
		return restTemplate.getForObject("http://ratings-data-service/ratingsdata/users/"+ userId, UserRating.class);
	}
	
	public UserRating getFallBackUserRating(String userId) {
		UserRating ratings = new UserRating();
		ratings.setUserRating(Arrays.asList(new Rating("0",0)));
		return ratings;
	}

}
