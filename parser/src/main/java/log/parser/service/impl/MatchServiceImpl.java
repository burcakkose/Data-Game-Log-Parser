package log.parser.service.impl;

import java.security.SecureRandom;
import java.util.ArrayList;

import log.parser.service.MatchService;

public class MatchServiceImpl implements MatchService {

//	@Autowired
//	private MatchRepositoryImpl repo;
	
	
	@Override
	public Long ingestMatch(String payload) {
		SecureRandom random = new SecureRandom();
		long matchId = Math.abs(random.nextLong());
		String[] lineList = payload.split("\\r?\\n");
		
		for(String line: lineList) {
			parseLogEntry(matchId, line);
		}
		
		System.out.println("MATCH_ID: "+matchId);
		return matchId;
		
	}

	@Override
	public void parseLogEntry(Long matchId, String logEntry) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveDatabase(ArrayList<String> record) {
		// TODO Auto-generated method stub
		
	}

}
