package tests;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class PostNegative {
	@Test
  public void postNeg() {
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("name","@12");
		map.put("job","leader");
		Gson gson= new GsonBuilder().setPrettyPrinting().create();
		String jsonBody = gson.toJson(map);
		System.out.println("JSON Body: ");
		System.out.println(jsonBody);
	  baseURI="https://reqres.in/";
	  given().
	   body(jsonBody).
	  when().
	    post("api/login").
	  then().
	   statusCode(400).
	   log().all();
	    
  }
}
