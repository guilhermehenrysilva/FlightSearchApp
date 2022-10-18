package com.latamairline.flightSearchApp.latam;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class LatamRequest {

    public void consumerAPILatam(){
        RestTemplate template = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();

        //h.ttps://www.latamairlines.com/bff/air-offers/offers/search
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
                .queryParam("outFrom","2022-10-15T15%3A00%3A00.000Z")
                .queryParam("outOfferId","null")
                .queryParam("adult","1")
                .queryParam("child","0")
                .queryParam("infant","0")
                .queryParam("redemption","true")
                .build();

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

        HttpEntity<String> httpEntity = new HttpEntity<>(headers);
        ResponseEntity<String> response = template.exchange(uri.toUriString(), HttpMethod.GET, httpEntity, String.class); //todo: Bad Request
        System.out.println(response);
    }

}


