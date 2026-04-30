package com.starter.app.controller;

import com.starter.app.model.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173") // React dev server
public class HelloController {

    @GetMapping("/health")
    public ResponseEntity<ApiResponse<Map<String, Object>>> health() {
        return ResponseEntity.ok(ApiResponse.success(Map.of(
                "status", "UP",
                "timestamp", LocalDateTime.now().toString(),
                "service", "Spring React Starter"
        )));
    }

    @GetMapping("/hello")
    public ResponseEntity<ApiResponse<String>> hello(
            @RequestParam(defaultValue = "World") String name) {
        return ResponseEntity.ok(ApiResponse.success("Hello, " + name + "! 👋"));
    }

    @PostMapping("/echo")
    public ResponseEntity<ApiResponse<Object>> echo(@RequestBody Object body) {
        return ResponseEntity.ok(ApiResponse.success(body));
    }
}
