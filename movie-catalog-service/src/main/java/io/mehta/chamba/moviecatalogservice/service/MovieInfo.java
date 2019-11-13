package io.mehta.chamba.moviecatalogservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import io.mehta.chamba.moviecatalogservice.models.CatalogItem;
import io.mehta.chamba.moviecatalogservice.models.Movie;
import io.mehta.chamba.moviecatalogservice.models.Rating;

@Service
public class MovieInfo {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod="getFallBackCatalogItem" )
	public CatalogItem getCatalogItem(Rating rating) {
		Movie movie = restTemplate.getForObject("http://movie-info-service/movies/"+ rating.getMovieId(), Movie.class);
		return new CatalogItem(movie.getName(),"Description",rating.getRating());
	}

	public CatalogItem getFallBackCatalogItem(Rating rating) {
		return new CatalogItem("movie not found","Description",rating.getRating());
	}

}
