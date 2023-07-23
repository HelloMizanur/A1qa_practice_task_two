//package restAPITest;
//
//import com.mashape.unirest.http.HttpResponse;
//import com.mashape.unirest.http.JsonNode;
//import com.mashape.unirest.http.exceptions.UnirestException;
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import java.util.Map;
//
//public class ApiClient {
//
//    private static ObjectMapper objectMapper = new ObjectMapper();
//
//    public static HttpResponse<JsonNode> get(String baseUrl, String path, Map<String, Object> params) {
//        try {
//            return HttpUtils.get(baseUrl, path, params);
//        } catch (UnirestException e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//    public static HttpResponse<JsonNode> post(String baseUrl, String path, Object requestBody) {
//        try {
//            return HttpUtils.post(baseUrl, path, requestBody);
//        } catch (UnirestException | JsonProcessingException e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//}
