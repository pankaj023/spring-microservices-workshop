package io.doomon.coronavirustracker.services;

import java.io.IOException;
import java.io.StringReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import io.doomon.coronavirustracker.models.LocationStats;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@Service
public class CoronaVirusDataService {

	private static String VIRUS_DATA_URL = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_confirmed_global.csv";
	private List<LocationStats> allStats = new ArrayList<>();
	private String lastUpdateDate;

	public String getLastUpdateDate() {
		return lastUpdateDate;
	}

	public List<LocationStats> getAllStats() {
		return allStats;
	}

	@PostConstruct
	@Scheduled(cron = "* * 1 * * *")
	public void fetchViursData() throws IOException, InterruptedException, ParseException {
		List<LocationStats> newStats = new ArrayList<>();

		OkHttpClient client = new OkHttpClient();
		StringReader csvBodyReader;
		String data;

		Request request = new Request.Builder().url(VIRUS_DATA_URL).build();

		try (Response response = client.newCall(request).execute()) {
			data = response.body().string();
			csvBodyReader = new StringReader(data);
		}
		
//		HttpClient  client = HttpClient.newHttpClient();
//		HttpRequest request = HttpRequest.newBuilder()
//				.uri(URI.create(VIRUS_DATA_URL))
//				.build();
//		
//		HttpResponse<String> httpResponse = client.send(request,HttpResponse.BodyHandlers.ofString());
		// System.out.println(httpResponse.body());
		
		
		String[] parts = data.split("\\r?\\n");
		String [] date = parts[0].split(",");
		Date updateDate = new SimpleDateFormat("mm/dd/yy").parse(date[date.length -1]); 
		DateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy");  
		lastUpdateDate = dateFormat.format(updateDate); 
		
		Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(csvBodyReader);

		for (CSVRecord record : records) {
			LocationStats locationStats = new LocationStats();
			locationStats.setState(record.get("Province/State"));
			locationStats.setCountry(record.get("Country/Region"));

			int latestCases = Integer.parseInt(record.get(record.size() - 1));
			int prevDayCases = Integer.parseInt(record.get(record.size() - 2));

			locationStats.setLatestTotalCases(latestCases);
			locationStats.setDiffFromPrevDay(latestCases - prevDayCases);

			newStats.add(locationStats);
		}

		this.allStats = newStats;
	}

}
