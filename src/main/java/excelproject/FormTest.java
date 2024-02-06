package excelproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class FormTest {
	@Test(dataProvider = "driveTest", dataProviderClass = DataProvide.class)
	public void fillForm(String testType, String idMonth, String idDay, String idYear, String borough, String block,
			String lots, String address, String contactUmb, String email, String filePath) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://outreached.wufoo.com/forms/whv8t011qzb1r7/");
		driver.manage().window().maximize();
		Select select = new Select(driver.findElement(By.id("Field50")));
		select.selectByVisibleText(testType);
		driver.findElement(By.id("Field1-1")).sendKeys(idMonth);
		driver.findElement(By.id("Field1-2")).sendKeys(idDay);
		driver.findElement(By.id("Field1")).sendKeys(idYear);
		Select s = new Select(driver.findElement(By.id("Field88")));
		s.selectByVisibleText(borough);

		driver.findElement(By.id("Field94")).sendKeys(block);
		driver.findElement(By.id("Field96")).sendKeys(lots);
		driver.findElement(By.id("Field92")).sendKeys(address);
		driver.findElement(By.id("Field17")).sendKeys(contactUmb.substring(0, 3));
		driver.findElement(By.id("Field17-1")).sendKeys(contactUmb.substring(3, 6));
		driver.findElement(By.id("Field17-2")).sendKeys(contactUmb.substring(6, 10));
		driver.findElement(By.id("Field18")).sendKeys(email);
		if (filePath != "") {
			driver.findElement(By.id("Field45")).sendKeys(filePath);

		}
		// driver.findElement(By.id("saveForm")).click();
//		String targetURL = "https://outreached.wufoo.com/confirm/backflow-test-form-online-submission/";
//		try {
//		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		    wait.until(ExpectedConditions.urlToBe(targetURL));
//		    
//		} catch (Exception e) {
//
//		   System.exit(0);
//		}

		driver.quit();
	}
}
