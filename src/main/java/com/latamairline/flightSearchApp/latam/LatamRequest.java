package com.latamairline.flightSearchApp.latam;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class LatamRequest {
    
    private String cookieValue = "D8E25D89DA0E696621A255ECC5805F38~0~YAAQxboXAkwtO8aDAQAAz6SryAi4dIzXOEamr97cmQ3uoAyCTXryQQkNTJFJeFbv1grq/B8UEylimMovFbGYVd7HeCu5ZRenoC6MO1qjtTcvQGKnHJmgbAAXi91qSMPlQW8AkO1aEH+NGpez+BYfbmrHToJIN/N27QVJMtPf2HxTC934cd2YSG0qxlxUytpNpbCjU6JThkEaEmQ3uJ6iNIEzfi9aUYPoWbBuybIJLfxAJzwxMDXUsbOQU2OWWmzXUyFEwrEAmW/Ai0STswxgiYDs5f8ZPgvglJOfWD2zAe59BwFgS453Yp7PmaPzEptRTwHigA2CqZTWqvvA46QH3kalEOPhvbe+inrg98jWrDycgARqr9tdJN0hSbr+SyyV7UyVZZm1vmOHVWGQJ8yqWZ6FBzD3XdkpBG0nLT3R~-1~||-1||~-1";

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
                .queryParam("outFrom","2022-11-15T15%3A00%3A00.000Z")
                .queryParam("outOfferId","null")
                .queryParam("adult","1")
                .queryParam("child","0")
                .queryParam("infant","0")
                .queryParam("redemption","false")
                .build();

        headers.set("cookie", "_abck="+cookieValue);
        headers.set("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:104.0) Gecko/20100101 Firefox/104.0");
        headers.set("Accept", "*/*");
        headers.set("Accept-Language", "pt-BR,pt;q=0.8,en-US;q=0.5,en;q=0.3");
        headers.set("Accept-Encoding", "gzip, deflate, br");
        headers.set("Referer", "\thttps://www.latamairlines.com/br/pt/oferta-voos?origin=GRU&inbound=null&outbound=2022-09-30T15%3A00%3A00.000Z&destination=IGU&adt=1&chd=0&inf=0&trip=OW&cabin=Economy&redemption=false&sort=RECOMMENDED");
        headers.set("X-latam-App-Session-Id", "84196897-1687-4d8c-8e63-083091ac204f");
        headers.set("Content-Type", "application/json");
        headers.set("X-latam-Action-Name", "search-result.flightselection.offers-search");
        headers.set("X-latam-Application-Name", "web-air-offers");
        headers.set("X-latam-Client-Name", "web-air-offers");
        headers.set("X-latam-Track-Id", "3a4ae189-e218-4606-bd9e-8b17efc93463");
        headers.set("X-latam-Request-Id", "ff44ef24-e6d0-4cb0-984c-df1db18cee19");
        headers.set("X-latam-Application-Country", "BR");
        headers.set("X-latam-Application-Oc", "br");
        headers.set("X-latam-Application-Lang", "pt");
        headers.set("Connection", "keep-alive");
        headers.set("Cookie", "_abck="+cookieValue);
        headers.set("Sec-Fetch-Dest", "empty");
        headers.set("Sec-Fetch-Mode", "cors");
        headers.set("Sec-Fetch-Site", "same-origin");
        headers.set("TE", "trailers");

        HttpEntity<String> entity = new HttpEntity("body", headers);
        ResponseEntity<String> response = template.exchange(uri.toUriString(), HttpMethod.GET, entity, String.class);
        System.out.println(response);

    }


}
