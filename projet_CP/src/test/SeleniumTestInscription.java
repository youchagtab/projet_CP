package test;

import com.thoughtworks.selenium.Selenium;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebDriver;
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.regex.Pattern;
import static org.apache.commons.lang3.StringUtils.join;

public class SeleniumTestInscription {
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		WebDriver driver = new FirefoxDriver();
		String baseUrl = "http://localhost:8080/";
		selenium = new WebDriverBackedSelenium(driver, baseUrl);
	}

	@Test
	public void testSelenium_test_inscription() throws Exception {
		selenium.open("/projet_CP/inscription.jsp");
		selenium.type("id=nom", "dfgfg");
		selenium.type("id=nom", "dupont");
		selenium.type("id=prenom", "narbel");
		selenium.type("id=identifiant", "selenium");
		selenium.type("id=motDePasse", "nbvcxw");
		selenium.type("id=confirmation", "nbvcxw");
		selenium.click("css=input.sansLabel");
		selenium.waitForPageToLoad("30000");
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
