package restAPITest;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.exceptions.UnirestException;
public class Task2Tests {
	static JsonReaderFile JsonReader = new JsonReaderFile();
	private final String url = JsonReader.JsonReader("config.json", "/url");
	private final String Base_URL = url;
	private final String posts = JsonReader.JsonReader("config.json", "/post");
	private final String id = JsonReader.JsonReader("data.json", "/id");
	private final String post99 = JsonReader.JsonReader("config.json", "/post99");
	private final String userId = JsonReader.JsonReader("data.json", "/userId");
	
	private final String titled = JsonReader.JsonReader("data.json", "/title");
	private final String body = JsonReader.JsonReader("data.json", "/body");
	private final String post150 = JsonReader.JsonReader("config.json", "/post150");
	private final String userN = JsonReader.JsonReader("config.json", "/users");
	private final String id3 = JsonReader.JsonReader("data.json", "/id");
	private final String eBody = JsonReader.JsonReader("data.json", "/Example_body");
	private final String AlaxExample = JsonReader.JsonReader("data.json", "/AlaxExample");
	private final String id6 = JsonReader.JsonReader("data.json", "/id");
    private final String posts1 = JsonReader.JsonReader("config.json", "/post");
    private final String body1 = JsonReader.JsonReader("data.json", "/body");
    private final String titled1 = JsonReader.JsonReader("data.json", "/title");
    private final String userId1 = JsonReader.JsonReader("data.json", "/userId");
	@Test
	public void test1() throws UnirestException {
		
		HttpResponse<JsonNode> response = HttpUtils.get(Base_URL, posts, null);
		int statusCode = response.getStatus();
		Assert.assertEquals(StatusCode.OK.getCode(), statusCode);
		JSONArray responseBody = response.getBody().getArray();
		Assert.assertNotNull(responseBody);
		Assert.assertTrue(responseBody instanceof JSONArray); // Check if the response body is in JSON format
		List<Integer> postIds = new ArrayList<>();
		for (int i = 0; i < responseBody.length(); i++) {
			
			int postId = responseBody.getJSONObject(i).getInt(id);
			postIds.add(postId);
		}
		List<Integer> sortedIds = new ArrayList<>(postIds);
		sortedIds.sort(Integer::compareTo);
		Assert.assertEquals(sortedIds, postIds);
		// Test 2
		
		HttpResponse<JsonNode> response1 = HttpUtils.get(Base_URL, post99, null);
		int statusCode1 = response1.getStatus();
		Assert.assertEquals(StatusCode.OK.getCode(), statusCode1);
		JSONObject post = response1.getBody().getObject();
		Assert.assertNotNull(post);
	
		Assert.assertEquals(10, post.getInt(userId));
		
		Assert.assertEquals(99, post.getInt(id));
		
		Assert.assertFalse(post.getString(titled).isEmpty());
		
		Assert.assertFalse(post.getString(body).isEmpty());
		//Test 3
	
		HttpResponse<JsonNode> response2 = HttpUtils.get(Base_URL, post150, null);
		int statusCode2 = response2.getStatus();
		Assert.assertEquals(StatusCode.NOT_FOUND.getCode(), statusCode2); // Verify status code is 404
		JsonNode responseBody2 = response2.getBody();
		JSONObject jsonObject = responseBody2.getObject();
		Assert.assertNotNull(jsonObject);
		Assert.assertEquals(0, jsonObject.length());// Verify response body is empty
		// Test 5
	
		HttpResponse<JsonNode> response3 = HttpUtils.get(Base_URL, userN, null);
		int statusCode3 = response3.getStatus();
		Assert.assertEquals(StatusCode.OK.getCode(), statusCode3);
		// Retrieve the list of users from the response
		JsonNode responseBody3 = response3.getBody();
		JSONArray users = responseBody3.getArray();
		// Find the user with id 5 and verify the information
		JSONObject user5 = null;
		for (int i = 0; i < users.length(); i++) {
			JSONObject user = users.getJSONObject(i);
		
			if (user.getInt(id3) == 5) {
				user5 = user;
				break;
			}
		}
		Assert.assertEquals(user5.getInt("id"), 5);
		Assert.assertEquals(user5.getString("name"), "Chelsey Dietrich");
		Assert.assertEquals(user5.getString("username"), "Kamren");
		Assert.assertEquals(user5.getString("email"), "Lucio_Hettinger@annie.ca");
		Assert.assertEquals(user5.getJSONObject("address").getString("street"), "Skiles Walks");
		Assert.assertEquals(user5.getJSONObject("address").getString("suite"), "Suite 351");
		Assert.assertEquals(user5.getJSONObject("address").getString("city"), "Roscoeview");
		Assert.assertEquals(user5.getJSONObject("address").getString("zipcode"), "33263");
		Assert.assertEquals(user5.getJSONObject("address").getJSONObject("geo").getString("lat"), "-31.8129");
		Assert.assertEquals(user5.getJSONObject("address").getJSONObject("geo").getString("lng"), "62.5342");
		Assert.assertEquals(user5.getString("phone"), "(254)954-1289");
		Assert.assertEquals(user5.getString("website"), "demarco.info");
		Assert.assertEquals(user5.getJSONObject("company").getString("name"), "Keebler LLC");
		Assert.assertEquals(user5.getJSONObject("company").getString("catchPhrase"),"User-centric fault-tolerant solution");
		Assert.assertEquals(user5.getJSONObject("company").getString("bs"), "revolutionize end-to-end systems");
		//Test 6
		HttpResponse<JsonNode> response4 = HttpUtils.get(Base_URL, "/users/5", null);
		int statusCode4 = response4.getStatus();
		Assert.assertEquals(StatusCode.OK.getCode(), statusCode4);
		JsonNode responseBody4 = response4.getBody();
		JSONObject user = responseBody4.getObject();
		Assert.assertEquals(user.getInt("id"), 5);
		Assert.assertEquals(user.getString("name"), "Chelsey Dietrich");
		Assert.assertEquals(user.getString("username"), "Kamren");
		Assert.assertEquals(user.getString("email"), "Lucio_Hettinger@annie.ca");
		Assert.assertEquals(user.getJSONObject("address").getString("street"), "Skiles Walks");
		Assert.assertEquals(user.getJSONObject("address").getString("suite"), "Suite 351");
		Assert.assertEquals(user.getJSONObject("address").getString("city"), "Roscoeview");
		Assert.assertEquals(user.getJSONObject("address").getString("zipcode"), "33263");
		Assert.assertEquals(user.getJSONObject("address").getJSONObject("geo").getString("lat"), "-31.8129");
		Assert.assertEquals(user.getJSONObject("address").getJSONObject("geo").getString("lng"), "62.5342");
		Assert.assertEquals(user.getString("phone"), "(254)954-1289");
		Assert.assertEquals(user.getString("website"), "demarco.info");
		Assert.assertEquals(user.getJSONObject("company").getString("name"), "Keebler LLC");
		Assert.assertEquals(user.getJSONObject("company").getString("catchPhrase"),"User-centric fault-tolerant solution");
		Assert.assertEquals(user.getJSONObject("company").getString("bs"), "revolutionize end-to-end systems");
		// post test
		try {
	        PostModel postModel = new PostModel();	        
	        postModel.setBody(eBody);	       
	        postModel.setTitle(AlaxExample);
	        postModel.setUserId(1);	       
	        HttpResponse<JsonNode> response5= HttpUtils.post(Base_URL, posts1, postModel);
	        String n201 = JsonReader.JsonReader("data.json", "/n201");
	        int num201 = Integer.parseInt(n201);
	        Assert.assertEquals(response5.getStatus(),num201);
	            // Verify the correctness of the created post data	            
//	            Assert.assertEquals(response.getBody().getObject().getInt("id"), 101);         
	            Assert.assertEquals(response5.getBody().getObject().getString(body1), eBody);	           
	            Assert.assertEquals(response5.getBody().getObject().getString(titled1), AlaxExample);	           
	            Assert.assertEquals(response5.getBody().getObject().getInt(userId1), 1);
			}catch(JsonProcessingException j) {
				j.printStackTrace();
			}
			catch( UnirestException u) {
				u.printStackTrace();
			}
		}
}