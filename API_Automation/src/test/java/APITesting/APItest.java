package APITesting;
import static io.restassured.RestAssured.*;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
public class APItest {
	
	@Test(dataProvider = "getdata")
	public void testgetrequest(String country) {
		
		String responce = given().baseUri("https://restcountries.com/v3.1").
		when().get("/translation/"+country).
		then().assertThat().statusCode(200).extract().response().asString();
		System.out.println(responce);
		JsonPath js = new JsonPath(responce);
		Assert.assertTrue((js.getString("name.common[0]").equals("Germany")));
		
	}
	@DataProvider(name = "getdata")
	public Object[][] getexceldata() throws IOException{
		
		return ExcelReader.getdatafromexcel("C:\\Users\\Administrator\\eclipse-workspace\\API_Automation\\src\\test\\java\\resource\\Testdata.xlsx" , "Sheet1");
	}
}
