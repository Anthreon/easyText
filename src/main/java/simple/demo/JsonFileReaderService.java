package simple.demo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;

@Service
public class JsonFileReaderService {

    private final ObjectMapper objectMapper;

    public JsonFileReaderService(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public FoodClass readJsonFile() throws IOException {
        ClassPathResource resource = new ClassPathResource("products.json");

        try (InputStream inputStream = resource.getInputStream()) {
            return objectMapper.readValue(inputStream, FoodClass.class);
        }
    }
}