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
import java.util.Objects;

@RestController
@RequestMapping("/ai")
public class AIController {

    @Value("${fastapi.url}")
    private String fastApiUrl;

    @PostMapping("/request")
    public String hello(@RequestBody HashMap<String, String> data) {
        RestTemplate restTemplate = new RestTemplate();
        String url = fastApiUrl + "/request";

        Map<String, Object> requestPayload = new HashMap<>();
        requestPayload.put("data", data.get("data"));

        ResponseEntity<HashMap> response = restTemplate.postForEntity(url, requestPayload, HashMap.class);

        // Return the "result" field from the response
        return Objects.requireNonNull(response.getBody()).get("result").toString();
    }

}
