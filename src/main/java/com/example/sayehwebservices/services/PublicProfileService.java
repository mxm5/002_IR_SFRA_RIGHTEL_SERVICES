package com.example.sayehwebservices.services;

import com.example.sayehwebservices.domain.RegisteredPublicProfile;
import com.example.sayehwebservices.repository.PublicProfileRepository;
import com.example.sayehwebservices.services.dto.PublicProfileRequest;
import com.github.mfathi91.time.PersianDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class PublicProfileService {
    @Autowired
    PublicProfileRepository publicProfileRepo;

    public ResponseEntity<Object> getByBirthdayAndNationalCode(PublicProfileRequest publicProfileRequest) throws Exception {

        if (publicProfileRequest.getNationalCode() == null || publicProfileRequest.getBirthDate() == null) {
            throw new Exception("fields can't be empty");
        }
        String persianBirthdateUnformatted = publicProfileRequest.getBirthDate();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        PersianDate persianDateObj = PersianDate.parse(persianBirthdateUnformatted, formatter);
        LocalDate gregorianBirthdate = persianDateObj.toGregorian();
        String nationalCode = publicProfileRequest.getNationalCode();

        long hashedNationalCode = publicProfileRepo.getHashedSsn(nationalCode);
        RegisteredPublicProfile person = publicProfileRepo.findByNationalcodeAndBirthdate(
                hashedNationalCode, null
        );
        if (person != null) {
            String firstName = person.getFirstname();
            String lastName = person.getLastname();
            String fatherName = person.getFathername();
            String birthDate = person.getBirthdate();
            boolean gender = person.getGenderid();
            String body = String.format(
                    "{\n" +
                            "    \"status\": \"success\",\n" +
                            "    \"data\": {\n" +
                            "        \"estelam3TPersonInfoResult\": {\n" +
                            "            \"nin\": \"%s\",\n" +
                            "            \"name\": \"%s\",\n" +
                            "            \"family\": \"%s\",\n" +
                            "            \"fatherName\": \"%s\",\n" +
                            "            \"shenasnameNo\": \"***\",\n" +
                            "            \"shenasnameSerial\": \"***\",\n" +
                            "            \"birthDate\": \"%s\",\n" +
                            "            \"gender\": \"%s\",\n" +
                            "            \"deathStatus\": \"***\",\n" +
                            "            \"officeCode\": \"***\",\n" +
                            "            \"bookNo\": \"***\",\n" +
                            "            \"bookRow\": \"***\",\n" +
                            "            \"message\": [],\n" +
                            "            \"exceptionMessage\": [],\n" +
                            "            \"deathDate\": []\n" +
                            "        },\n" +
                            "        \"trackingInfo\": {\n" +
                            "            \"responseTime\": \"***\",\n" +
                            "            \"conversationId\": \"***\",\n" +
                            "            \"signature\": \"***\"\n" +
                            "        },\n" +
                            "        \"serviceStatus\": {\n" +
                            "            \"message\": \"***\",\n" +
                            "            \"status\": \"200\"\n" +
                            "        }\n" +
                            "    },\n" +
                            "    \"message\": \"null\"\n" +
                            "}",
                    nationalCode,
                    firstName,
                    lastName,
                    fatherName,
                    persianDateObj.toString(),
                    gender ? '1' : '2'

            );
            MultiValueMap<String, String> headers = new HttpHeaders();
            headers.put(HttpHeaders.CONTENT_TYPE, List.of("application/json"));
            return new ResponseEntity<>(
                    body, headers
                    , HttpStatus.OK
            );
        } else
            throw new Exception("data not found");
    }

}
