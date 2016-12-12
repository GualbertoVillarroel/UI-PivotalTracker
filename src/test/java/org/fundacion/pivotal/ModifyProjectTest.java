package org.fundacion.pivotal;

import java.util.concurrent.TimeUnit;

import org.fundacion.pivotal.pages.*;
import org.fundacion.pivotal.pages.ProjectPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class ModifyProjectTest {
  WebDriver driver;

  @BeforeClass
  public void setup() {
    System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    driver.manage().window().maximize();
    driver.get("https://www.pivotaltracker.com/signin");
  }

  @Test
  public void testCreateProject() {

    LoginPage login = new LoginPage(driver);

    //Login using "User" and "Password"
    HomePage home = login.loginPivotalTracker("gualy_vc@hotmail.com", "password123");
    CreateProjectPage newProject = home.clickCreateProject();

    //Create a new project using "ProjectName" and "AccountName"
    String projectName = "AutomateTest";
    ProjectPage project = newProject.createNewProject(projectName, "Jala");

    //Change the name of the project
    String projectNameChanged = "TestNameChanged";
    SettingsPage settings = project.clickSettings();
    settings.editProjectName(projectNameChanged);
    assertTrue(driver.findElement(By.xpath(".//*[@id='shared_header']/div/div/header/ul/li[2]/div/h1/a/div[text() ='"
            + projectNameChanged + "']")).isDisplayed(), "Error the name of the project is different.");


    //Deleting the project
    settings.deleteProject();
  }

  @AfterClass
  public void close() {
    driver.quit();
  }

}