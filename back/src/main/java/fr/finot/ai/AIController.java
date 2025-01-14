package fr.finot.ai;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/ai")
public class AIController {

    @Value("${fastapi.url}")
    private String fastApiUrl;

    @PostMapping("/hello")
    public String hello(@RequestBody HashMap<String, String> data) {
        RestTemplate restTemplate = new RestTemplate();
        String url = fastApiUrl + "/process-data";

        // Extracting the input data as a string
        String inputData = data.get("data");

        // Creating the request payload
        Map<String, Object> requestPayload = new HashMap<>();
        requestPayload.put("data", inputData);  // Send the data as a plain string

        ResponseEntity<String> response = restTemplate.postForEntity(url, requestPayload, String.class);

        return response.getBody();
    }

}
