package com.example.HumanClock.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.HumanClock.Model.ClockModel;
import com.example.HumanClock.Service.HumanClockService;

/**
 * HumanClockController allows to convert digital time to human readable form.
 * 
 * @author Arshath Mohammed
 *
 */
@RestController
@RequestMapping("/clock")
public class HumanClockController {

	
	/**getTime is used to get convert numeric into human readable form.
	 * 
	 * @return ClockModel
	 */
	@Autowired
	private HumanClockService humanClockService;
	
	@GetMapping("/getTime")
	public ResponseEntity<ClockModel> getTime(@RequestParam Optional<String> args) {
		ClockModel clock = args.isPresent() ? humanClockService.getTime(args.get()) : new ClockModel("", "Invalid Time");
		return new ResponseEntity<ClockModel>(clock, HttpStatus.OK);
	}
	
}

