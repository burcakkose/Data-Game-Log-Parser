package log.parser.service;

import java.util.ArrayList;

public interface MatchService {
	
	Long ingestMatch(String payload);
	void parseLogEntry(Long matchId, String logEntry);  
    void saveDatabase(ArrayList<String> record);
}
