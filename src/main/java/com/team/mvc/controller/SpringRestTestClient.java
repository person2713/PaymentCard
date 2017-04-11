package com.team.mvc.controller;

/**

 */
import java.net.URI;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.web.client.RestTemplate;
public class SpringRestTestClient {
    public static final String REST_SERVICE_URI = "http://localhost:9555/Spring4MVCCRUDRestService";
    /* GET */
    @SuppressWarnings("unchecked")
    private static void listAllBlockCards(){
        System.out.println("Testing listAllBlockCards API-----------");

        RestTemplate restTemplate = new RestTemplate();
        List<LinkedHashMap<String, Object>> blockCardsMap = restTemplate.getForObject(REST_SERVICE_URI+"/blockCards/", List.class);

        if(blockCardsMap!=null){
            for(LinkedHashMap<String, Object> map :blockCardsMap){
                System.out.println("blockCards : id="+map.get("cardId"));
            }
        }else{
            System.out.println("No blockCards exist----------");
        }}

    public static void main(String args[]){
        listAllBlockCards();
    }

    }


