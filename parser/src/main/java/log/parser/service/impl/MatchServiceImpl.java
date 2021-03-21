package log.parser.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import log.parser.service.MatchParser;
import log.parser.service.MatchService;

@Service
public class MatchServiceImpl implements MatchService, MatchParser {
	
	@Autowired
    public MatchServiceImpl() {
    }
	
	@Override
	public String upload(String payload) {	
		
		UUID uuid = UUID.randomUUID();
        String matchId = uuid.toString();
        
		String[] lineList = payload.split("\\r?\\n");
		
		for(String line: lineList) {
			parse(matchId, line);
		}
		
		System.out.println("MATCH_ID: "+matchId);
		return matchId;
		
	}
	
	@Override
	public void parse(String matchId, String logEntry) {
		parseLogEntry(matchId, logEntry);
	}
	
	private void parseLogEntry(String matchId, String logEntry) {
		String regexPattern="";
    	boolean found = false;
    	
    	ArrayList<String> dbList = new ArrayList<String>();
    	
    	HashMap<String,String> regexMap = new HashMap<String, String>();
    	
    	regexMap.put("hit", "\\[(\\d{2}):(\\d{2}):(\\d{2}).(\\d{3})\\]\\snpc_dota_hero_(\\S+)\\shits\\snpc_dota_hero_(\\S+)\\swith\\s(\\S+)\\sfor\\s(\\d+)\\s");
    	regexMap.put("kill", "\\[(\\d{2}):(\\d{2}):(\\d{2}).(\\d{3})\\]\\snpc_dota_hero_(\\S+)\\sis\\skilled\\sby\\snpc_dota_hero_(\\S+)");
    	regexMap.put("buy", "\\[(\\d{2}):(\\d{2}):(\\d{2}).(\\d{3})\\]\\snpc_dota_hero_(\\S+)\\sbuys\\sitem\\sitem_(\\S+)");
    	regexMap.put("cast", "\\[(\\d{2}):(\\d{2}):(\\d{2}).(\\d{3})\\]\\snpc_dota_hero_(\\S+)\\scasts\\sability\\s(\\S+)");
    	
    	
    	for(Map.Entry<String,String> entry : regexMap.entrySet())
    	{
    		Pattern pattern = Pattern.compile(entry.getKey());
    		Matcher matcher = pattern.matcher(logEntry);
    		  		
    		if (matcher.find())
    		{
    			regexPattern = entry.getValue();
    			pattern = Pattern.compile(regexPattern);
    			matcher = pattern.matcher(logEntry);
    			
    			dbList.add(entry.getKey());
				dbList.add(matchId);
				
    	    	while(matcher.find())
    			{
    				int groupCount = matcher.groupCount(); 
    				
    				for (int i = 1; i <= groupCount; i++) {		
    					dbList.add(matcher.group(i));
    	            }
    				
    				saveDatabase(dbList);    				
    				found=true;
    			}
    			if(!found) {
    				System.out.println("Regex-Match not found for: " + logEntry);
    			}
    		}
    	}
	}
	
	private void saveDatabase(ArrayList<String> dbList) {
		
	}

	

}
