package tests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import io.restassured.http.ContentType;

public class PatchAndDelete {
	@Test
    public void patch() {
    	Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Map<String, Object> map=new HashMap<String,Object>();

        map.put("lastName","Mali");
        String jsonBody = gson.toJson(map);
       
        
        baseURI ="http://localhost:3000"; 
        given().
    	contentType(ContentType.JSON)
    	.accept(ContentType.JSON)
    	.body(jsonBody)
    	.when()
    	.patch("/users/4")
    	.then()
    	.statusCode(200).
    	log().all();
	}
    
    @Test
    public void delete() {
    
       
        
        baseURI ="http://localhost:3000"; 
        when().
          delete("/users/3").
        then().
          statusCode(404);
	}
}
