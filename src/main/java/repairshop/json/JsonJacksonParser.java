package repairshop.json;

import java.io.File;
import java.io.IOException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonJacksonParser {
	
	public static <T> T readJsonFile(File jsonFile, Class<T> valueType) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(jsonFile, valueType);
    }
}
