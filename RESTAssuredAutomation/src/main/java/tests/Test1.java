package tests;
import io.restassured.RestAssured;
import org.testng.annotations.Test; 
public class Test1 {

	@Test
	public void test() {
		
		RestAssured.get("https://reqres.in/api/users?page=2");
		
	}
}
