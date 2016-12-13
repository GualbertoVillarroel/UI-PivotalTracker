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

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class CreateProjectTest {
  WebDriver driver;

  @BeforeTest
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

    //Create new project "ProjectName" and "AccountName"
    ProjectPage project = newProject.createNewProject("AutomateTest", "Jala");
    assertEquals(project.getTitleProject(), "AutomateTest",
            "Error the name of the project is different.");


    //Deleting the project
    SettingsPage settings = project.clickSettings();
    settings.deleteProject();
  }

  @AfterTest
  public void close() {
    driver.quit();
  }

}