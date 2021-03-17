package log.parser.controller;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import log.parser.service.MatchService;

@RestController
@RequestMapping("api/match")
public class MatchController {

	private final MatchService matchService;
	
	@Autowired
	public MatchController(MatchService matchService) {
		this.matchService = matchService;
	}
	
	@PostMapping(consumes="text/plain")
	public ResponseEntity<Long> ingestMatch(@RequestBody @NotNull @NotBlank String payload) {
		final Long matchId = matchService.ingestMatch(payload);
        return ResponseEntity.ok(matchId);
	}
}
