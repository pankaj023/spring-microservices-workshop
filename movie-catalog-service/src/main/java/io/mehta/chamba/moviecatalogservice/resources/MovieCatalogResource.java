package io.mehta.chamba.moviecatalogservice.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import io.mehta.chamba.moviecatalogservice.models.CatalogItem;
import io.mehta.chamba.moviecatalogservice.models.UserRating;
import io.mehta.chamba.moviecatalogservice.service.MovieInfo;
import io.mehta.chamba.moviecatalogservice.service.UserRatingInfo;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private WebClient.Builder webClientBuilder;
	
	@Autowired
	MovieInfo movieInfo;
	
	@Autowired
	UserRatingInfo userRatingInfo;

	@RequestMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId){

		UserRating ratings= userRatingInfo.getUserRating(userId); 

		return ratings.getUserRating().stream().map(rating ->{
			return movieInfo.getCatalogItem(rating);
		}).collect(Collectors.toList());


		/*return Collections.singletonList(
				new CatalogItem("Jeet", "Test",4 ));*/
	}
}


/*Movie movie = webClientBuilder.build()
.get()
.uri("http://localhost:8082/movies/"+ rating.getMovieId())
.retrieve()
.bodyToMono(Movie.class)
.block();*/