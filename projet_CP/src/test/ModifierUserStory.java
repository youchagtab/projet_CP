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

public class ModifierUserStory {
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		WebDriver driver = new FirefoxDriver();
		String baseUrl = "http://localhost:8080/";
		selenium = new WebDriverBackedSelenium(driver, baseUrl);
	}

	@Test
	public void testModifierUserStory() throws Exception {
		selenium.open("/projet_CP/connexion.jsp");
		selenium.type("id=motdepasse", "password2");
		selenium.type("id=identifiant", "youssef");
		selenium.click("css=input.sansLabel");
		selenium.waitForPageToLoad("30000");
		selenium.click("name=action");
		selenium.waitForPageToLoad("30000");
		selenium.click("xpath=(//a[contains(text(),'Afficher')])[3]");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=Modifier");
		selenium.waitForPageToLoad("30000");
		selenium.type("name=description", "Vive les tests 1ere modif");
		selenium.click("css=input[type=\"submit\"]");
		selenium.waitForPageToLoad("30000");
		selenium.click("name=action");
		selenium.waitForPageToLoad("30000");
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
