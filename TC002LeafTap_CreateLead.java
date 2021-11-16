package testCaseExecution;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.collections4.bag.SynchronizedSortedBag;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import leafTap_ReusableMethods.LeafTapCommonMethods;
import pages.LeafTap_LoginPage;

public class TC002LeafTap_CreateLead extends LeafTapCommonMethods {
	@BeforeTest
	public void setFileName() {
		// TODO Auto-generated method stub
		excelFileName = "CreateLead";

	}

	@Test(dataProvider = "readExcel") // readExcel is the method name used for DataProvider
	// We can give like the above only when DataProvider(indices = 0) used in the
	// DataProvider declaration
	// @Test(dataProvider = "createLead")
	public void verifyCreateLead(String lang, String userName, String password, String compName, String fName,
			String lName, String source, String mktCamp, String fNameLocal, String lNameLocal, String title,
			String dept, String Industry, String ownership, String desc, String impNote, String empCount,
			String countryCode, String areaCode, String phNo, String email, String country, String state, String city,
			String postalCode) throws InterruptedException, IOException {
		File propFile = null;
		if (lang.equalsIgnoreCase("EN")) {
			// Accessing the file
			propFile = new File("D:\\Selenium\\Workplace\\PageObjectModel\\src\\test\\resources\\EN.properties");

		} else if (lang.equalsIgnoreCase("FR")) {
			System.out.println("The language is french");
			// Accessing the files
			propFile = new File("D:\\Selenium\\Workplace\\PageObjectModel\\src\\test\\resources\\FR.properties");
		}
		FileInputStream fs = new FileInputStream(propFile);
		// loading the property file
		prop.load(fs);

		LeafTap_LoginPage lp = new LeafTap_LoginPage(driver);// Passing driver as an argument for constructor
		lp.enterUserName(userName)
		.enterPassword(password)
		.clickLoginButton()
		.verifyCRMSFALINK()
		.clickCRMSFALink()
		.clickLeadsTab()
		.clickleadsLink()
		.enterCompName(compName)
		.enterFirstName(fName)
		.enterLastName(lName)
		.selectSource(source)
		.selectMarketingCampaign(mktCamp)
		.enterFirstNameLocal(fNameLocal)
		.enterLastNameLocal(lNameLocal)
		.enterTitle(title)
		.enterDepartment(dept)
		.selectIndustry(Industry)
		.selectOwnership(ownership)
		.enterDescription(desc)
		.enterImportantNote(impNote)
		.enterNumberofEmp(empCount)
		.enterCountryCode(countryCode)
		.enterAreaCode(areaCode)
		.enterPhoneNumber(phNo)
		.enterEmail(email)
		.selectCountry(country)
		.selectState(state)
		.enterCity(city)
		.enterPostalCode(postalCode)
		.clickCreateLeadButton();

	}

}
