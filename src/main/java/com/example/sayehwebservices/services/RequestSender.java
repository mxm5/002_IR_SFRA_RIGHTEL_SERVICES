package com.example.sayehwebservices.services;

import com.example.sayehwebservices.services.dto.ShahKarReq;
import com.example.sayehwebservices.services.dto.ShahkarAccessTokenResponse;
import com.google.gson.Gson;
import com.squareup.okhttp.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class RequestSender {

    public static final String SHAH_KAR_LINK = "https://pgsb.iran.gov.ir/oauth/token";
    public static final String JSON_CONTENT_TYPE = "application/json";
    public static final String URLENCODED = "application/x-www-form-urlencoded";
    public static final String BASIC_AUTH_TOKEN = "Basic bWNsc2dvdkNsaWVudDp6a3RNN2lid0RhaWc2MVY5";
    public static String LAST_ACCESS_TOKEN = "";
    public static String LAST_REFRESH_TOKEN = "";

    public void getTokenForShahkar() throws IOException {


        OkHttpClient client = new OkHttpClient();


        MediaType urlEncodeMediaType = MediaType.parse(URLENCODED);
        String bodyString = "grant_type=password&username=mclsgov&password=MCLSPass@98352";
        RequestBody requestBody = RequestBody.create(urlEncodeMediaType, bodyString);

        Request request =
                new Request
                        .Builder()
                        .url(SHAH_KAR_LINK)
                        .method(HttpMethod.POST.toString(), requestBody)
                        .addHeader(HttpHeaders.ACCEPT, JSON_CONTENT_TYPE)
                        .addHeader(HttpHeaders.CONTENT_TYPE, URLENCODED)
                        .addHeader(HttpHeaders.AUTHORIZATION, BASIC_AUTH_TOKEN)
                        .build();
        Response response =
                client
                        .newCall(request)
                        .execute();

        int code = response.code();

        Headers responseHeaders = response.headers();

        String responseBody = response.body().string();

        Map<String, List<String>> stringListMap =
                responseHeaders.toMultimap();

        HttpHeaders httpHeaders =
                new HttpHeaders();

        httpHeaders
                .putAll(stringListMap);

//        parse the json string body

        Gson gson = new Gson();
        ShahkarAccessTokenResponse shahkarAccessTokenResponse = gson.fromJson(
                responseBody,
                ShahkarAccessTokenResponse.class);
        LAST_ACCESS_TOKEN = shahkarAccessTokenResponse.getAccess_token();
        LAST_REFRESH_TOKEN = shahkarAccessTokenResponse.getRefresh_token();
        ResponseEntity<String> stringResponseEntity = new ResponseEntity<>(responseBody, httpHeaders, code);
    }


    public ResponseEntity<Object> giveFailureResponse(IOException e) {
        MultiValueMap<String, String> json = new HttpHeaders();
        json.put(HttpHeaders.CONTENT_TYPE, List.of("application/json"));
        return new ResponseEntity<>("{" +
                "\"error\":\"" + e.getMessage() + "\"," +
                "\"type\":\"" + e.getClass().getSimpleName() + "\"," +
                "\"server-time\":\"" + LocalDateTime.now() + "\"," + "}",
                json,
                HttpStatus.NOT_FOUND
        );
    }


    public void getRefreshToken() throws IOException {

        if (LAST_REFRESH_TOKEN == null) getTokenForShahkar();

        OkHttpClient client = new OkHttpClient();

        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
        RequestBody body = RequestBody.create(mediaType, "grant_type=refresh_token&refresh_token=" + LAST_REFRESH_TOKEN + "");
        Request request = new Request.Builder()
                .url("https://pgsb.iran.gov.ir/oauth/token")
                .method("POST", body)
                .addHeader("Accept", "application/json")
                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                .addHeader("Authorization", "Basic bWNsc2dvdkNsaWVudDp6a3RNN2lid0RhaWc2MVY5")
                .build();
        Response response = client.newCall(request).execute();

        int code = response.code();

        Headers responseHeaders = response.headers();

        String responseBody = response.body().string();

        Map<String, List<String>> stringListMap =
                responseHeaders.toMultimap();

        HttpHeaders httpHeaders =
                new HttpHeaders();

        httpHeaders
                .putAll(stringListMap);
        Gson gson = new Gson();
        ShahkarAccessTokenResponse shahkarAccessTokenResponse = gson.fromJson(
                responseBody,
                ShahkarAccessTokenResponse.class);
        LAST_ACCESS_TOKEN = shahkarAccessTokenResponse.getAccess_token();
        LAST_REFRESH_TOKEN = shahkarAccessTokenResponse.getRefresh_token();
        ResponseEntity<String> stringResponseEntity = new ResponseEntity<>(responseBody, httpHeaders, code);

    }


}
