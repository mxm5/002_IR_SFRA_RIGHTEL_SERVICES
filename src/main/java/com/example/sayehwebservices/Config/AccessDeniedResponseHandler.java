package com.example.sayehwebservices.Config;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class AccessDeniedResponseHandler implements AccessDeniedHandler {


    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                       AccessDeniedException e) throws IOException {

        HttpHeaders headers = new HttpHeaders(
        );
        headers.put("cause", List.of(
                e.getCause()!=null?e.getCause().toString():""
        ));
        headers.put("ip",
                List.of(
                        httpServletRequest.getRemoteAddr()
                )
        );
        ResponseEntity<String> response = new ResponseEntity(e.getCause(), headers, HttpStatus.FORBIDDEN);
        OutputStream out = httpServletResponse.getOutputStream();
        ObjectMapper mapper = new ObjectMapper();
        httpServletResponse.setStatus(403);
        httpServletResponse.setContentType("application/json");
        mapper.writeValue(out, response);
        out.flush();
    }
}

