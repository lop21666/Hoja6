package uvg.edu.common;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapInstanceCreator {
	
	public Map getInstance(String typeMap) {
		Map mymap;
		
		switch(typeMap) {
		case "HashMap":
			mymap = new HashMap<String, String>();
			break;
		
		case "TreeMap":
			mymap = new TreeMap<String, String>();
			break;
			
		case "LinkedHashMap":
			mymap = new LinkedHashMap<String, String>();
			break;
			
		default:
			mymap = null;
			break;
		}
		return mymap;
	}

}
