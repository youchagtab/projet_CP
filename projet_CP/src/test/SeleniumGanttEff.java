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

public class SeleniumGanttEff {
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		WebDriver driver = new FirefoxDriver();
		String baseUrl = "http://localhost:8080/";
		selenium = new WebDriverBackedSelenium(driver, baseUrl);
	}

	@Test
	public void testSeleniumGanttEff() throws Exception {
		selenium.open("/projet_CP/connexion.jsp");
		selenium.type("id=motdepasse", "PASSWORD");
		selenium.type("id=identifiant", "Olivier");
		selenium.click("css=input.sansLabel");
		selenium.waitForPageToLoad("30000");
		selenium.click("xpath=(//a[contains(text(),'Afficher')])[4]");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=sprint 1");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=Affecter");
		selenium.waitForPageToLoad("30000");
		selenium.type("xpath=(//input[@name='debut'])[2]", "0");
		selenium.type("xpath=(//input[@name='duree'])[2]", "3");
		selenium.click("xpath=(//input[@value='Affecter'])[2]");
		selenium.waitForPageToLoad("30000");
		selenium.click("xpath=(//a[contains(text(),'Affecter')])[2]");
		selenium.waitForPageToLoad("30000");
		selenium.select("xpath=(//select[@name='idUtilisateur'])[2]", "label=Constans Olivier");
		selenium.type("xpath=(//input[@name='debut'])[2]", "0");
		selenium.type("xpath=(//input[@name='duree'])[2]", "2");
		selenium.click("xpath=(//input[@value='Affecter'])[2]");
		selenium.waitForPageToLoad("30000");
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
