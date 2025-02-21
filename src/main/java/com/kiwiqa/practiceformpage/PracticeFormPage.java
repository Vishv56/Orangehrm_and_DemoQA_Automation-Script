package com.kiwiqa.practiceformpage;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PracticeFormPage
{
	WebDriver driver;
	Actions action;
	Robot robot;


	// Locators
	By webFirstName = By.xpath("//*[@id='firstName']");
	By webLastName = By.xpath("//*[@id='lastName']");
	By webEmailID = By.xpath("//*[@id='userEmail']");
	public By webGenderMale = By.xpath("//*[text()='Male']");
	By webPhoneNumber = By.xpath("//*[@id='userNumber']");
	By webClickBobTextBox = By.xpath("//*[@id='dateOfBirthInput']");
	By webYearDrop = By.xpath("//select[@class='react-datepicker__year-select']");
	By webMonthDrop = By.xpath("//select[@class='react-datepicker__month-select']");
	By webDateDrop =By.xpath("//*[@role='option']");
	By webClickSubjectTextBox = By.xpath("//*[@id='subjectsInput']");
	public By webReadingHobby =By.xpath("//label[text()='Reading']");
	By webUploadPic=By.xpath("//*[@id='uploadPicture']");
	By webCurrentAddress=By.xpath("//*[@id='currentAddress']");
	By WebClickState =By.xpath("//*[@id='state']/child::div");
	By WebClickCity =By.xpath("//*[@id='city']/child::div");
	By WebClickSubmit =By.xpath("//*[@id='submit']");

	// Constructor to initialize the driver
	public PracticeFormPage(WebDriver driver,Actions action,Robot robot) 
	{
		this.driver = driver;
		this.action =action;
		this.robot =robot;
	}


	public void zoomIn(int n)
	{
		for (int i = 0; i <n; i++) 
		{
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_SUBTRACT);
			robot.keyRelease(KeyEvent.VK_SUBTRACT);
			robot.keyRelease(KeyEvent.VK_CONTROL);
		}
	}

	public void openUrl(String webUrl)
	{
		driver.get(webUrl);
	}
	// Method to set the first name
	public void setFirstName(String firstNameValue)
	{
		driver.findElement(webFirstName).sendKeys(firstNameValue);
	}

	// Method to set the last name
	public void setLastName(String lastNameValue) 
	{
		driver.findElement(webLastName).sendKeys(lastNameValue);
	}

	// Method to set the email ID
	public void setEmailID(String emailIDValue) 
	{
		driver.findElement(webEmailID).sendKeys(emailIDValue);
	}

	// Method to click the male gender radio button
	public void setGenderMale() 
	{
		driver.findElement(webGenderMale).click();
	}

	// Method to set the phone number
	public void setPhoneNumber(String phoneNumberValue) 
	{
		driver.findElement(webPhoneNumber).sendKeys(phoneNumberValue);
	}

	public void clickdobTextFiled()
	{
		driver.findElement(webClickBobTextBox).click();
	}
	public void setYear(String yearName)
	{
		WebElement selectYearDrop =driver.findElement(webYearDrop);
		Select selectYears = new Select(selectYearDrop);
		selectYears.selectByVisibleText(yearName);
	}
	public void setMonth(String monthNameValue)
	{
		WebElement selectMonthDrop =driver.findElement(webMonthDrop);
		Select selectMonth = new Select(selectMonthDrop );
		selectMonth.selectByVisibleText(monthNameValue);
	}

	public void setDate(String DateValue)
	{
		List<WebElement> allDates = driver.findElements(webDateDrop);

		for(WebElement obj : allDates)
		{
			String text = obj.getText();
			if(text.equals(DateValue))
			{
				obj.click();
				break;
			}
		}

	}

	public void SetSubject(String subject1Value ,String subject2Value)
	{
		WebElement textBox = driver.findElement(webClickSubjectTextBox);
		textBox.click();
		action.sendKeys(subject1Value,Keys.ENTER).perform();
		action.sendKeys(subject2Value,Keys.ENTER).perform();

	}
	public void setReadingHobby()
	{
		driver.findElement(webReadingHobby).click();
	}
	public void setPic(String picName)
	{
		driver.findElement(webUploadPic).sendKeys("C:\\Users\\Anmol\\Downloads\\"+picName);
	}
	public void setCurrentAddress(String currentAddressValue)
	{
		driver.findElement(webCurrentAddress).sendKeys(currentAddressValue);
	}
	public void setState(String stateNameValue)
	{
		WebElement textBox =driver.findElement(WebClickState);
		textBox .click();
		//textBox.sendKeys(stateName);
		//textBox.sendKeys(Keys.ENTER);
		action.sendKeys(stateNameValue,Keys.ENTER).perform();

	}

	public void setCity(String cityNameValue)
	{
		WebElement textBox =driver.findElement(WebClickCity);
		textBox .click();
		action.sendKeys(cityNameValue,Keys.ENTER).perform();

	}
	public void clickSubmitButton()
	{
		driver.findElement(WebClickSubmit).click();
	}

	public void verifyText(ArrayList<Object> objValue ) 
	{
		for(int i =0 ;i<objValue.size();i++)
		{
			if(objValue.get(i).equals(driver.findElement(By.xpath("//tbody//tr["+(i+1)+"]//td[last()]")).getText()))
			{
				System.out.println("value is match for  : " +driver.findElement(By.xpath("//tbody//tr["+(i+1)+"]//td[1]")).getText());
			}
			else
			{

				System.out.println(" value is  not match for : " +driver.findElement(By.xpath("//tbody//tr["+(i+1)+"]//td[1]")).getText() );
			}

		}
	}


}
