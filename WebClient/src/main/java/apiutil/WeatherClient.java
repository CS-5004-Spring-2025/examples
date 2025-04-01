package apiutil;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.*;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public class WeatherClient {

    private final String apiKey;
    private static final String CITY_SEARCH_URL = "http://dataservice.accuweather.com/locations/v1/cities/search";
    private static final String FORECAST_URL = "http://dataservice.accuweather.com/forecasts/v1/daily/1day/";

    public WeatherClient(String apiKey) {
        this.apiKey = apiKey;
    }

    private String encode (String stringToEncode) {
        return URLEncoder.encode(stringToEncode, StandardCharsets.UTF_8);
    }

    private String buildParamsString(Map<String, String> params) throws UnsupportedEncodingException {
        StringBuilder paramsBuilder = new StringBuilder();
        for(Map.Entry<String, String> entry : params.entrySet()) {
            paramsBuilder.append("&")
                    .append(encode(entry.getKey()))
                    .append("=")
                    .append(encode(entry.getValue()));
        }
        return paramsBuilder.toString();
    }

    private URI buildUri(String base, Map<String, String> params) throws UnsupportedEncodingException {

        String uriString = base;
        if(!params.isEmpty()) {
            uriString += "?" + buildParamsString(params);
        }
        URI uri = URI.create(uriString);
        System.out.println(uri);
        return uri;
    }

    private String getKeyFromJson(HttpResponse<String> response) throws JsonProcessingException {
        JsonNode node = new ObjectMapper().readTree(response.body());
        // TODO: handle location not found
        String key = node.get(0).get("Key").asText();
        return key;
    }

    private String getHeadlineFromJson(HttpResponse<String> response) throws JsonProcessingException {
        JsonNode node = new ObjectMapper().readTree(response.body());
        // TODO: handle location not found
        String text = node.get("Headline").get("Text").asText();
        return text;
    }


    private HttpResponse<String> makeRequest(URI uri) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .GET()
                .build();

        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .build();
        return client.send(request, HttpResponse.BodyHandlers.ofString());
    }

    public String getLocationKey(String city) {
        try {
            URI uri = buildUri(CITY_SEARCH_URL, Map.of("q", city, "apikey", apiKey));
            HttpResponse<String> response = makeRequest(uri);
            if(response.statusCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + response.statusCode());
            }

            return getKeyFromJson(response);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public String getForecast(String locationKey) {
        try {
            URI uri = buildUri(FORECAST_URL+locationKey, Map.of("apikey", apiKey));
            System.out.println(uri);
            HttpResponse<String> response = makeRequest(uri);
            if(response.statusCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + response.statusCode());
            }
            return getHeadlineFromJson(response);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}
