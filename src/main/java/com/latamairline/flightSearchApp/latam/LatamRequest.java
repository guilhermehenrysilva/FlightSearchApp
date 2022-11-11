package com.latamairline.flightSearchApp.latam;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.awt.print.Pageable;
import java.net.URI;
import java.util.List;

public class LatamRequest {

    private RestTemplate restTemplate = new RestTemplate(this.getClientHttpFactory());

    public void consumerAPILatam(){
        HttpEntity<Object> httpEntity = new HttpEntity<>(getHeaders());
        ResponseEntity<Pageable> response = restTemplate.exchange(getUri(), HttpMethod.GET, httpEntity, Pageable.class);
        System.out.println(response.getBody());
    }

    private HttpHeaders getHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:104.0) Gecko/20100101 Firefox/104.0");
        headers.set("Accept", "*/*");
        headers.set("Content-Type", "application/json");
        headers.set("X-latam-App-Session-Id", "84196897-1687-4d8c-8e63-083091ac204f");
        headers.set("X-latam-Action-Name", "search-result.flightselection.offers-search");
        headers.set("X-latam-Application-Name", "web-air-offers");
        headers.set("X-latam-Client-Name", "web-air-offers");
        headers.set("X-latam-Track-Id", "3a4ae189-e218-4606-bd9e-8b17efc93463");
        headers.set("X-latam-Request-Id", "ff44ef24-e6d0-4cb0-984c-df1db18cee19");
        headers.set("X-latam-Application-Country", "BR");
        headers.set("X-latam-Application-Oc", "br");
        headers.set("X-latam-Application-Lang", "pt");
        headers.set("Cookie", getCookie());

        return headers;
    }

    private URI getUri(){
        UriComponents uri = UriComponentsBuilder.newInstance()
                .scheme("https")
                .host("www.latamairlines.com")
                .path("bff/air-offers/offers/search")
                .queryParam("sort","RECOMMENDED")
                .queryParam("cabinType","Economy")
                .queryParam("origin","GRU")
                .queryParam("destination","BSB")
                .queryParam("inFlightDate","null")
                .queryParam("inFrom","null")
                .queryParam("inOfferId","null")
                .queryParam("outFlightDate","null")
                .queryParam("outFrom","2022-11-25T15%3A00%3A00.000Z")
                .queryParam("outOfferId","null")
                .queryParam("adult","1")
                .queryParam("child","0")
                .queryParam("infant","0")
                .queryParam("redemption","false")
                .build();

        return uri.toUri();
    }

    private String getCookie(){
        String url = "https://www.latamairlines.com/br/pt";

        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

        List<String> cookies = response.getHeaders().get("Set-Cookie");
        String cookieAbck = cookies.stream()
                .filter(cookie -> cookie.startsWith("_abck"))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Not found \"abck_ cookie"));

        return cookieAbck;
    }
    
    private SimpleClientHttpRequestFactory getClientHttpFactory() {
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setConnectTimeout(10000);
        factory.setReadTimeout(10000);
        return factory;
    }
}


