package stepdef;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Stepdifinition {
	WebElement[] list1;
	int size;
	int digit1;
	String str[] = new String[3];
	String[] arrStr;
	boolean b;

	@Given("user hit the url")
	public void user_hit_the_url() {
		Hooks.driver.get("http://seleniumtableassignment.s3-website-us-west-2.amazonaws.com");

	}

	@When("the only details of black bears are displayed on the Bear Table")
	public void the_only_details_of_black_bears_are_displayed_on_the_bear_table() {
		List<WebElement> list = Hooks.driver
				.findElements(By.xpath("//table[@class='adap-table'][1]//th[2]//following::tbody[1]//td[1]"));
		int rowSize = list.size();
		System.out.println(rowSize);
		for (WebElement element : list) {
			System.out.println(element.getText());
		}
		// List<WebElement> list1 = Hooks.driver
		// .findElements(By.xpath("//table[@class='adap-table'][1]//th[2]//following::tbody[1]//td[2]"));
		size = Hooks.driver.findElements(By.xpath("//table[@class='adap-table']//td[text()='Black']")).size();

		int columnsize = list.size();
		System.out.println(columnsize);

	}

	@Then("Assert that all the rows have the value black for color column")
	public void assert_that_all_the_rows_have_the_value_black_for_color_column() {
		Assert.assertEquals(size, 3);

	}

	@When("get the details from weight column of cat table")
	public void get_the_details_from_weight_column_of_cat_table() {
		int i = 0;
		List<WebElement> catCount = Hooks.driver.findElements(By.xpath(
				"//table[@class='adap-table']//following-sibling::table//tbody//tr//child::td[contains(text(),'lbs')]"));
		for (WebElement cat : catCount) {
			// str[i] = s.getText();
			// arrStr = str[i].split(" ");
			String s = cat.getText();
			s = s.replace(" lbs.", "");
			System.out.println(s);
			digit1 = Integer.parseInt(s.trim());
			System.out.println(digit1);
		}

		/*
		 * if (Integer.parseInt(arrStr[0]) < 15) { b = true; } else { b = false; break;
		 * }
		 * 
		 * i++; }
		 */

		// System.out.println(b);
	}

	@Then("Assert that all the rows have the value less than {int} lbs for weight column")
	public void assert_that_all_the_rows_have_the_value_less_than_lbs_for_weight_column(Integer digit1) {
		Assert.assertTrue(digit1 < 15);

	}

	@When("get the description details from starwar table")
	public void get_the_description_details_from_starwar_table() {
		List<WebElement> list5 = Hooks.driver
				.findElements(By.xpath("//table[@class='adap-table'][3]//th[1]//following::tbody[1]//td[2]"));
		int column5 = list5.size();
		System.out.println(column5);
		for (WebElement element5 : list5) {
			System.out.println(element5.getText());
			String s1 = element5.getText();
			int s2 = s1.length();
			System.out.println("number of characters in given string " + s2);
			if (s2 < 350) {
				b = true;
			} else {
				b = false;
			}

		}
		System.out.println(b);
	}

	@Then("the values in the Description column has less than {int} characters")
	public void the_values_in_the_description_column_has_less_than_characters(Integer int1) {
		Assert.assertTrue(b);

	}

}
