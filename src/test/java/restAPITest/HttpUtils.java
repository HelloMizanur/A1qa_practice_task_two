package restAPITest;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Map;
public class HttpUtils {
    private static ObjectMapper objectMapper = new ObjectMapper();
    public static HttpResponse<JsonNode> get(String baseUrl, String path, Map<String, Object> params) throws UnirestException {
        return Unirest.get(baseUrl + path)
                .queryString(params)
                .asJson();
}
    public static HttpResponse<JsonNode> post(String baseUrl, String path, Object requestBody) throws UnirestException, JsonProcessingException {
            String requestBodyString = objectMapper.writeValueAsString(requestBody);
            return Unirest.post(baseUrl + path)
                    .header("Content-Type", "application/json")
                    .body(requestBodyString)
                    .asJson();       
    }   
}