package org.fundacion.pivotal;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.fundacion.pivotal.pages.NewProjectPage;
import org.fundacion.pivotal.pages.HomePage;
import org.fundacion.pivotal.pages.LoginPage;
import org.fundacion.pivotal.pages.ProjectPage;
import org.fundacion.pivotal.pages.SettingsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
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
    HomePage home = login.logintoPivotalTracker("gualy_vc@hotmail.com", "password123");

    NewProjectPage newProject = home.clickCreateProject();
    ProjectPage project = newProject.createNewProjectPivotalTracker("AutomateTest");
    assertEquals(project.getTitleProject(), "AutomateTest");

    //Deleting the project
    SettingsPage settings = project.clickSettings();
    home = settings.deleteProject();

    WebDriverWait wait = new WebDriverWait(driver, 20);
    wait.until(ExpectedConditions.visibilityOf(home.getTitleLogo()));

  }

  @AfterClass
  public void close() {
    driver.quit();
  }

}