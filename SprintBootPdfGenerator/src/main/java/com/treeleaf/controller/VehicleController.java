package com.treeleaf.controller;

import com.treeleaf.payload.response.VehicleDetailsResponse;
import com.treeleaf.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.treeleaf.payload.request.VehicleRequest;
import com.treeleaf.services.IVehicleService;

import java.util.ArrayList;

@RestController
@RequestMapping("/api")
public class VehicleController {
	
	@Autowired
	IVehicleService vehicleService;


	@PostMapping("/vehicle")
	@PreAuthorize("hasRole('ADMIN')")
	ResponseEntity<?> addVehicle(@RequestBody VehicleRequest vechileRequest){
		return vehicleService.add(vechileRequest);
	}

	@GetMapping("/vehicle")
	@PreAuthorize("hasRole('ADMIN')")
	ResponseEntity<?> getAll(){
		return vehicleService.getAll();
	}


}
