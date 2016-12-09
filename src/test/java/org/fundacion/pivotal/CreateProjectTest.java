package org.fundacion.pivotal;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.fundacion.pivotal.pages.CreateProjectPage;
import org.fundacion.pivotal.pages.HomePage;
import org.fundacion.pivotal.pages.LoginPage;
import org.fundacion.pivotal.pages.ProjectPage;
import org.fundacion.pivotal.pages.SettingsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class CreateProjectTest {
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
    login.setUserName("gualy_vc@hotmail.com");
    login.clickContinue();
    login.setPassword("password123");
    HomePage home = login.clickSubmit();

    CreateProjectPage newProject = home.clickCreateProject();

    newProject.setProjectName("AutomateTest");
    newProject.clickAccountDropDownList();
    newProject.clickSelectAnAccount();
    //project.clickCreateAccount();
    //project.setAccountName("Selenium");

    ProjectPage project = newProject.clickCreate();
    assertEquals(project.getTitleProject(), "AutomateTest");

    //Deleting the project
    SettingsPage settings = project.clickSettings();
    settings.deleteProject();
  }

  @AfterClass
  public void close() {
    driver.quit();
  }

}