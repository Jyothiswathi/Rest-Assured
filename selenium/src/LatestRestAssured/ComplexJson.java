package LatestRestAssured;

import file.Payload;
import io.restassured.path.json.JsonPath;

public class ComplexJson {

	public static void main(String[] args) {

		JsonPath js = new JsonPath(Payload.complexJson());
		// total number of courses
		int totalCourses = js.getInt("courses.size()");
		// System.out.println(totalCourses);
		// print purchase ammount
		int purchaseAmount = js.getInt("dashboard.purchaseAmount");
		// System.out.println(purchaseAmount);
		// print title of first course
		String titleOfFirstCourse = js.get("courses[0].title");
		// System.out.println(titleOfFirstCourse);
		// print all course titles and respective prices
		for (int i = 0; i < totalCourses; i++) {
			String eachCourse = js.get("courses[" + i + "].title");
			// System.out.println(eachCourse);
			int eachPrice = js.getInt("courses[" + i + "].price");
			// System.out.println(eachPrice);
		}

		// print number of copies sold by a RPA course
		for (int i = 0; i < totalCourses; i++) {
			if (js.get("courses[" + i + "].title").equals("RPA")) {
				int RPACopies = js.getInt("courses[" + i + "].copies");
				System.out.println(RPACopies);
			}
		}
		// print all the prices equal to purchase amount
		int sum = 0;
		boolean isEqual = false;

		for (int i = 0; i < totalCourses; i++) {
			int eachPrice = js.getInt("courses[" + i + "].price");
			int eachCopy = js.getInt("courses[" + i + "].copies");
			int AllPriceOFEachCourse = eachPrice * eachCopy;
			sum = sum + AllPriceOFEachCourse;

		}

		if (sum == js.getInt("dashboard.purchaseAmount")) {
			isEqual = true;
			System.out.println("Success");
		} else {
			System.out.println("failure");

		}

	}

}
