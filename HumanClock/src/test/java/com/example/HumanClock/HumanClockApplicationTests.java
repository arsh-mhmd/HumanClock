package com.example.HumanClock;

import java.util.Optional;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

import static org.junit.Assert.assertEquals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

import com.example.HumanClock.Controller.HumanClockController;
import com.example.HumanClock.Model.ClockModel;

@SpringBootTest
class HumanClockApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	HumanClockController humanClockController;
	
	@Test
	public void TextualTimeCheck() throws Exception {
		StringBuilder numericTime = new StringBuilder("23:00");
		Optional<String> args = Optional.of(numericTime.toString());
		ResponseEntity<ClockModel> clockModel = humanClockController.getTime(args);
		assertEquals("Eleven O'Clock", clockModel.getBody().getTextualTime());
	}
	
	@Test
	public void StatusCodeCheck() throws Exception {
		StringBuilder numericTime = new StringBuilder("23:00");
		Optional<String> args = Optional.of(numericTime.toString());
		ResponseEntity<ClockModel> clockModel = humanClockController.getTime(args);
		assertEquals(200, clockModel.getStatusCode().value());
	}
	
	@Test
	public void OptionalArgumentCheck() throws Exception {
		StringBuilder numericTime = new StringBuilder();
		Optional<String> args = Optional.of(numericTime.toString());
		ResponseEntity<ClockModel> clockModel = humanClockController.getTime(args);
		assertEquals("", clockModel.getBody().getNumericTime());
		assertEquals("Invalid Time", clockModel.getBody().getTextualTime());
	}
	
	@Test
	public void NegativeTimeCheck() throws Exception {
		StringBuilder numericTime = new StringBuilder("-00:-15");
		Optional<String> args = Optional.of(numericTime.toString());
		ResponseEntity<ClockModel> clockModel = humanClockController.getTime(args);
		assertEquals(numericTime.toString(), clockModel.getBody().getNumericTime());
		assertEquals("Invalid Time", clockModel.getBody().getTextualTime());
	}
	
}
