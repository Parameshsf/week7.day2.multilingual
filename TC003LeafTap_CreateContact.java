package testCaseExecution;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import leafTap_ReusableMethods.LeafTapCommonMethods;
import pages.LeafTap_LoginPage;

public class TC003LeafTap_CreateContact extends LeafTapCommonMethods {
	@BeforeTest
	public void setFileName() {
		// TODO Auto-generated method stub
		excelFileName = "CreateContacts";

	}

	@Test(dataProvider = "readExcel") // readExcel is the method name of retreiving excel data. As we did not provide
										// any name
	// to dataprovider, we can provide the method name directly
	public void verifyCreateContact(String lang, String uName, String pwd, String fName, String lName, String dept,
			String desc, String email) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		File file = null;
		if (lang.equalsIgnoreCase("EN")) {
			file = new File("D:\\Selenium\\Workplace\\PageObjectModel\\src\\test\\resources\\EN.properties");

		} else if (lang.equalsIgnoreCase("FR")) {
			file = new File("D:\\Selenium\\Workplace\\PageObjectModel\\src\\test\\resources\\FR.properties");
		}
		FileInputStream fs = new FileInputStream(file);
		prop.load(fs);

		LeafTap_LoginPage lp = new LeafTap_LoginPage(driver);
		lp.enterUserName(uName).enterPassword(pwd).clickLoginButton().verifyCRMSFALINK().clickCRMSFAtoCreateContact()
				.clickContactsTab().clickCreateContactLink().enterFirstName(fName).enterLastName(lName)
				.enterDepartment(dept).enterDescription(desc).enterEmail(email).clickCreateContactButton();

	}

}
