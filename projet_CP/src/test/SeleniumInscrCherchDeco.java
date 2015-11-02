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

public class SeleniumInscrCherchDeco {
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		WebDriver driver = new FirefoxDriver();
		String baseUrl = "http://localhost:8080/";
		selenium = new WebDriverBackedSelenium(driver, baseUrl);
	}

	@Test
	public void testSeleniumInscrCherchDeco() throws Exception {
		selenium.open("/projet_CP/connexion.jsp");
		selenium.click("css=button");
		selenium.waitForPageToLoad("30000");
		selenium.type("id=nom", "hgui");
		selenium.type("id=prenom", "hkui");
		selenium.type("id=identifiant", "yutres");
		selenium.type("id=motDePasse", "azer");
		selenium.type("id=confirmation", "azer");
		selenium.click("css=input.sansLabel");
		selenium.waitForPageToLoad("30000");
		selenium.click("name=action");
		selenium.waitForPageToLoad("30000");
		selenium.click("css=form > input[name=\"action\"]");
		selenium.waitForPageToLoad("30000");
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
