
package com.lab.tourist.controller;

import com.lab.tourist.dto.TouristUpdateRequest;
import com.lab.tourist.entity.Tourist;
import com.lab.tourist.repository.TouristRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/tourists")
public class TouristController {

    private final TouristRepository touristRepository;

    public TouristController(TouristRepository touristRepository) {
        this.touristRepository = touristRepository;
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTourist(
            @PathVariable Long id,
            @RequestBody TouristUpdateRequest request) {

        Tourist tourist = touristRepository.findById(id).orElse(null);

        if (tourist == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("message", "Tourist not found with ID: " + id));
        }

        if (request.getContactNumber() != null) {
            tourist.setContactNumber(request.getContactNumber());
        }

        if (request.getEmail() != null) {
            tourist.setEmail(request.getEmail());
        }

        if (request.getVisitedDestination() != null) {
            tourist.setVisitedDestination(request.getVisitedDestination());
        }

        if (request.getHotelName() != null) {
            tourist.setHotelName(request.getHotelName());
        }

        Tourist updatedTourist = touristRepository.save(tourist);

        return ResponseEntity.ok(updatedTourist);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTourist(@PathVariable Long id) {

        Tourist tourist = touristRepository.findById(id).orElse(null);

        if (tourist == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("message", "Tourist not found with ID: " + id));
        }

        return ResponseEntity.ok(tourist);
    }
}
