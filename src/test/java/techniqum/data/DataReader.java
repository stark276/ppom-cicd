package techniqum.data;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataReader {
	
	public List<HashMap<String, String>> getJsonDataTOMap() throws IOException {
		
		
		// read json and convert to string
		String jsonContent =FileUtils.readFileToString(new File(System.getProperty("user.for")+ "//src//test//java//techniqum//data//PurchaseOrder.json"), StandardCharsets.UTF_8);
		
		//Convert String to Hashmap via Jackson Databind
		
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>> (){
			//{map, map1}
			
	});
		
		return data;
	}
}
