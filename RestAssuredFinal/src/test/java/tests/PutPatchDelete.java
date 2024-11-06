package tests;
import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class PutPatchDelete {
	@Test
	public void testPost() {
		Map<String, Object>map=new HashMap<String,Object>();
		
		map.put("name","Navami");
		map.put("job","Engineer");
		
		System.out.println(map);
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String jsonBody = gson.toJson(map);
		System.out.println("JSON Body: ");
		System.out.println(jsonBody);
		baseURI ="https://reqres.in/api";
		
	    given().
	     body(jsonBody).
	    when().
	     post("/users").
	    then().
	     statusCode(201)
	     .log().all();
	}
	
	@Test
	public void testPatch() {
		Map<String, Object>map=new HashMap<String,Object>();
		
		map.put("name","Navami");
		map.put("job","Engineer");
		
		System.out.println(map);
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String jsonBody = gson.toJson(map);
		System.out.println("JSON Body: ");
		System.out.println(jsonBody);
		baseURI ="https://reqres.in";
		
	    given().
	     body(jsonBody).
	    when().
	     patch("/api/users/2").
	    then().
	     statusCode(201)
	     .log().all();
	}
	
	@Test
	public void testDelete() {
	
	    when().
	      delete("/api/users/2").
	    then().
	     statusCode(204)
	     .log().all();
	}
}
