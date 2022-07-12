package com.example.sayehwebservices.services;

import com.example.sayehwebservices.services.dto.ShahkarToken;
import com.google.gson.Gson;
import com.squareup.okhttp.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.List;
import java.util.Map;

@Service
public class ShahKarService {
    private String getShahkarToken() throws IOException {
        OkHttpClient client = new OkHttpClient();
        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
        RequestBody body = RequestBody.create(mediaType, "grant_type=password&username=mclsgov&password=MCLSPass@98352");
        Request request = new Request.Builder()
                .url("https://pgsb.iran.gov.ir/oauth/token")
                .method("POST", body)
                .addHeader("Accept", "application/json")
                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                .addHeader("Authorization", "Basic bWNsc2dvdkNsaWVudDp6a3RNN2lid0RhaWc2MVY5")
                .build();
        Response response = client.newCall(request).execute();
        String result = response.body().string();
        Gson gson = new Gson();
        ShahkarToken shahkarToken = gson.fromJson(result, ShahkarToken.class);
        return shahkarToken.getAccess_token();
    }


   public ResponseEntity<Object> getShahkar(String phoneNumber, String NationalCode) throws IOException {
        OkHttpClient client = new OkHttpClient();

        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\n \"requestId\": \"" + getRequestId() + "\",\n \"serviceNumber\": \"" + phoneNumber + "\",\n \"serviceType\": 2,\n \"identificationType\": 0,\n \"identificationNo\": \"" + NationalCode + "\"\n}");
        Request request = new Request.Builder()
                .url("https://pgsb.iran.gov.ir/api/client/apim/v1/shahkar/gwsh/serviceIDmatching")
                .method("POST", body)
                .addHeader("basicAuthorization", "Basic dmV6YXJhdF90YWF2b246YzcwYXZpazA=")
                .addHeader("pid", "6297621e159c8b2bc8638ec2")
                .addHeader("Authorization", "Bearer " + getShahkarToken() + "")
                .addHeader("Content-Type", "application/json")
                .build();
        Response response = client.newCall(request).execute();

        int code = response.code();

        Headers responseHeaders = response.headers();

        String responseBody = response.body().string();

        Map<String, List<String>> stringListMap =
                responseHeaders.toMultimap();

        HttpHeaders httpHeaders =
                new HttpHeaders();

       Map<String, List<String>> jsonHeader = Map.of(
               "Content-Type",
               List.of("application/json")
       );

       httpHeaders
                .putAll(jsonHeader);

        return new ResponseEntity<>(responseBody, httpHeaders, code);
    }


    private static String getRequestId() {
        LocalDateTime now = LocalDateTime.now();
        TemporalUnit x;
        now = now.plus(4, ChronoUnit.SECONDS);
        String rawString = now.toString();
        System.out.println(rawString);
        String timeString = removeLastThree(removeTLetter(removeDots(removeColons(removeDashes(rawString)))));
        String providerCode = "0515";
        return providerCode + timeString;
    }

    private static String removeLastThree(String text) {
        return text.substring(0, text.length() - 3);
    }

    private static String removeDashes(String text) {
        return text.replace("-", "");
    }

    private static String removeColons(String text) {
        return text.replace(":", "");
    }

    private static String removeDots(String text) {
        return text.replace(".", "");
    }

    private static String removeTLetter(String text) {
        return text.replace("T", "");
    }


    public ResponseEntity<Object> giveFailureResponse(Exception e) {
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


}
