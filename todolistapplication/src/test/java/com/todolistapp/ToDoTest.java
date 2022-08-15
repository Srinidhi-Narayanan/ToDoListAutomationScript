package com.todolistapp;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;


public class ToDoTest{
	WebDriver driver;
	
  
  @Test(priority=1)
  public void C1VerifyTodoApplicationhLaunch() {
	  ToDoPage toDoPage = new ToDoPage(driver);
	  Boolean ActualValue = toDoPage.isPageTitleDisplayed();
	  Boolean Expected= true;
	  Assert.assertEquals(ActualValue, Expected);
  }
  @Parameters({"C2"})
  @Test(priority=2)
  public void C2VerifyTaskAddition(String C2) {
	  ToDoPage toDoPage = new ToDoPage(driver);
	  toDoPage.addTask(C2);
	  List<String> Todolist = toDoPage.getToDoList();
	  Assert.assertEquals( Todolist.contains(C2), true);
	  
  }
  @Parameters({"C3"})
  @Test(priority=3)
  public void C3VerifyTaskRemoval(String C3) {
	  ToDoPage toDoPage = new ToDoPage(driver);
	  toDoPage.addTask(C3);
	  driver.findElement(By.xpath("//*[contains(text(),'"+C3+"')]")).click();
	  List<String> Todolist = toDoPage.getToDoList();
	  Assert.assertEquals( Todolist.contains(C3), false);
  
	  
	  
  }
  @Parameters({"C4"})
  @Test(priority=4)
  public void C6VerifyClearAll(String C4) {
	  ToDoPage toDoPage = new ToDoPage(driver);
	  toDoPage.addTask(C4);
	  toDoPage.clearallTask();
	  List<String>  Todolist = toDoPage.getToDoList();
	  Assert.assertTrue( Todolist.isEmpty());
  }
  

  @Parameters({"C16"})
  @Test(priority=5)
  public void C16VerifyWhitespacesNotAdded(String C16) {
	  ToDoPage toDoPage = new ToDoPage(driver);
	  String Trimmedinput = C16.trim();
	  toDoPage.addTask(Trimmedinput);
	  String ActualOutput =driver.findElement(By.xpath("//*[contains(text(),'"+Trimmedinput+"')]")).getText();
	  Assert.assertNotEquals(ActualOutput, C16);
	  
  }
  


  @Parameters({"browser"})
  @BeforeClass
  public void beforeSuite(String browser) throws IOException  {
	  String FilePath = "./config.properties";
	  File file = new File (FilePath);
	  FileInputStream inp = new FileInputStream(file);
	  Properties prop = new Properties();
	  prop.load(inp);
	  String workspacepath = prop.getProperty("WORKSAPCE_PATH");
	  if (browser.equalsIgnoreCase("Chrome")) {
		  System.setProperty("webdriver.chrome.driver",workspacepath);
		  driver = new ChromeDriver();
	  }
	  if (browser.equalsIgnoreCase("Gecko")) {
		  System.setProperty("webdriver.gecko.driver",workspacepath);
		  driver = new FirefoxDriver();
	  }
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.get(prop.getProperty("baseurl"));
  }
	 
	  
  

  @AfterClass
  public void afterSuite() {
	  driver.close();
  }

}
