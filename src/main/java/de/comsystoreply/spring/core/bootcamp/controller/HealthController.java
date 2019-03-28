package de.comsystoreply.spring.core.bootcamp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

/**
 * Controller providing a very basic health check. At the moment it can only be used to check if the application is
 * handling any requests at all.
 */
@RestController
@RequestMapping(value = "/health", produces = APPLICATION_JSON_UTF8_VALUE)
public class HealthController {

    @GetMapping
    public ResponseEntity<Map<String, Object>> get() {
        /*
         * For more control over the generated result it is normally common practice to use dedicated model classes
         * for the returned entity. This was not done here as the response is to simple to justify the overhead of an
         * dedicated class.
         */
        Map<String, Object> healthInfo = new HashMap<>();
        healthInfo.put("status", "up");

        return ResponseEntity.ok(healthInfo);
    }
}
