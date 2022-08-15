package com.todolistapp;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class ToDoPage {
	
	WebDriver driver;
	
	By enteraTodoTextField = By.className("todo-name-input");
	
	By clearAll = By.xpath("//*[contains(text(),'Clear All')]");
	
	By addButton = By.tagName("Button");
	
	By title = By.tagName("h1");
	
	By toDoFirstElement = By.xpath("//*[@id=\"root\"]/div/ul/li[1]");
	
	By toDolistItems = By.tagName("li");
	
	By toDolist = By.className("todo-list");
	
	public ToDoPage(WebDriver driver){
		this.driver = driver;
	}
		
//		Add a task to to do list
		public void addTask(String task) {
			driver.findElement(enteraTodoTextField).clear();
			driver.findElement(enteraTodoTextField).sendKeys(task);
			driver.findElement(addButton).click();
		}

//      Clear all tasks from to do list
		public void clearallTask() {
			driver.findElement(clearAll).click();
		}
		//Check if Page title is displayed
		public Boolean isPageTitleDisplayed() {
			return driver.findElement(title).isDisplayed();
		}
//      To get all the To do task list	
		public List<String> getToDoList() {
			List<String> todoTaskList = new ArrayList<String>();

			List<WebElement> todolist = driver.findElements(toDolistItems);
			
			
			if(todolist.size() > 0) {
				for (WebElement wb:todolist) {
					todoTaskList.add(wb.getText());
							
				}
			}
			
							
			return todoTaskList;
		}
		
}
	
	
	
	
	
	
	
	
	
	
	
	
	
//	WebDriver driver;
//
//	public ToDoPage(WebDriver driver){
//
//        this.driver = driver;
//		//This initElements method will create all WebElements
//        PageFactory.initElements(driver, this);
//	
//	}
////	Using page factory @FindBy for identifying web elements
//	
//	
//	@FindBy(xpath="//*[@class=todo-name-input]")
//	WebElement enteraTodoTextField;
//	
//	@FindBy(xpath="//*[text=Clear All]")
//	WebElement clearAll;
//	
//	@FindBy(xpath="//*[@id=\"root\"]/div/div[2]/div[1]/button")
//	WebElement addButton;
//	
//	@FindBy(tagName="h1")
//	WebElement title;
//	
//	@FindBy(xpath="//*[@class=todo-list]")
//	List<WebElement> toDoList;
//
//	
//
//	
//	
//
////	Add a task to to do list
//	public void addTask(String task) {
//		enteraTodoTextField.sendKeys(task);
//	}
//// Clear all tasks from to do list
//	public void clearallTask() {
//		clearAll.click();
//	}
//	
//	public Boolean isPageTitleDisplayed() {
//		return title.isDisplayed();
//	}
//	
//	public List<WebElement> getToDoList() {
//		
//		return toDoList;
//		}
			
		
	
	

