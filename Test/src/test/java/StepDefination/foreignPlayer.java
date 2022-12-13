package StepDefination;

import io.cucumber.java.en.*;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

import org.junit.Assert;

public class foreignPlayer {

	Response res;
	JsonPath js;
	int foreignPlayer;

	@Given("Add Team RCB Payload")
	public void add_Team_RCB_Payload() {
		String res = ((Object) given().body("{\r\n" + "  \"name\": \"Royal Challengers Bangalore\",\r\n"
				+ "  \"location\": \"Bangalore\",\r\n" + "  \"player\": [\r\n" + "    {\r\n"
				+ "      \"name\": \"Faf Du Plessis\",\r\n" + "      \"country\": \"South Africa\",\r\n"
				+ "      \"role\": \"Batsman\",\r\n" + "      \"price-in-crores\": \"7\"\r\n" + "    },\r\n"
				+ "    {\r\n" + "      \"name\": \"Virat Kohli\",\r\n" + "      \"country\": \"India\",\r\n"
				+ "      \"role\": \"Batsman\",\r\n" + "      \"price-in-crores\": \"15\"\r\n" + "    },\r\n"
				+ "    {\r\n" + "      \"name\": \"Glenn Maxwell\",\r\n" + "      \"country\": \"Australia\",\r\n"
				+ "      \"role\": \"Batsman\",\r\n" + "      \"price-in-crores\": \"11\"\r\n" + "    },\r\n"
				+ "    {\r\n" + "      \"name\": \"Mohammad Siraj\",\r\n" + "      \"country\": \"India\",\r\n"
				+ "      \"role\": \"Bowler\",\r\n" + "      \"price-in-crores\": \"7\"\r\n" + "    },\r\n"
				+ "    {\r\n" + "      \"name\": \"Harshal Patel\",\r\n" + "      \"country\": \"India\",\r\n"
				+ "      \"role\": \"Bowler\",\r\n" + "      \"price-in-crores\": \"10.75\"\r\n" + "    },\r\n"
				+ "    {\r\n" + "      \"name\": \"Wanindu Hasaranga\",\r\n" + "      \"country\": \"Srilanka\",\r\n"
				+ "      \"role\": \"Bowler\",\r\n" + "      \"price-in-crores\": \"10.75\"\r\n" + "    },\r\n"
				+ "    {\r\n" + "      \"name\": \"Dinesh Karthik\",\r\n" + "      \"country\": \"India\",\r\n"
				+ "      \"role\": \"Wicket-keeper\",\r\n" + "      \"price-in-crores\": \"5.5\"\r\n" + "    },\r\n"
				+ "    {\r\n" + "      \"name\": \"Shahbaz Ahmed\",\r\n" + "      \"country\": \"India\",\r\n"
				+ "      \"role\": \"All-Rounder\",\r\n" + "      \"price-in-crores\": \"2.4\"\r\n" + "    },\r\n"
				+ "    {\r\n" + "      \"name\": \"Rajat Patidar\",\r\n" + "      \"country\": \"India\",\r\n"
				+ "      \"role\": \"Batsman\",\r\n" + "      \"price-in-crores\": \"0.20\"\r\n" + "    },\r\n"
				+ "    {\r\n" + "      \"name\": \"Josh Hazlewood\",\r\n" + "      \"country\": \"Australia\",\r\n"
				+ "      \"role\": \"Bowler\",\r\n" + "      \"price-in-crores\": \"7.75\"\r\n" + "    },\r\n"
				+ "    {\r\n" + "      \"name\": \"Mahipal Lomror\",\r\n" + "      \"country\": \"India\",\r\n"
				+ "      \"role\": \"Bowler\",\r\n" + "      \"price-in-crores\": \"7.75\"\r\n" + "    }\r\n"
				+ "  ]\r\n" + "}")).toString();

		js = new JsonPath(res);
		int count = js.getInt("player.size()");
		for (int i = 0; i < count; i++) {
			String playerName = js.getString("player["+i+"].name");
			if (js.get("player[" + i + "].name!=player[\" + i + \"].country=India")) {
				String Name = js.get("player[\"+i+\"].name");
				System.out.println(Name);
				int foreignPlayer = Name.length();
				System.out.println(foreignPlayer);

			}
		}

	}

	@Then("validate team has only {int} fireign player")
	public void validate_team_has_only_fireign_player(Integer int1) {

		Assert.assertEquals(foreignPlayer, 4);
	}

}
