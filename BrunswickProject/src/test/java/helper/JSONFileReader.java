package helper;

import java.io.FileReader;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JSONFileReader {
	private String salutation;
	private String firstName;
	private String lastName;
	private String email;
	private String country;
	private String city;
	private String phone;

	public JSONFileReader(String jsonFilePath) {
		JSONParser parser = new JSONParser();
		System.out.println("json File Path: " + jsonFilePath);
		try (FileReader fileReader = new FileReader(jsonFilePath)) {
			Object obj = parser.parse(fileReader);
			JSONObject jsonObject = (JSONObject) obj;

			salutation = (String) jsonObject.get("salutation");
			firstName = (String) jsonObject.get("firstName");
			lastName = (String) jsonObject.get("lastName");
			email = (String) jsonObject.get("email");
			country = (String) jsonObject.get("country");
			city = (String) jsonObject.get("city");
			phone = (String) jsonObject.get("phone");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getSalutation() {
		return salutation;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public String getCountry() {
		return country;
	}

	public String getCity() {
		return city;
	}

	public String getPhone() {
		return phone;
	}

}