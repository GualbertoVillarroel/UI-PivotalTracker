package org.fundacion.pivotal.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class ProjectPage {

  private WebDriver driver;

  @FindBy(css = ".raw_context_name")
  WebElement titleProject;

  @FindBy(xpath = ".//*[@id='view34']/div[1]/div/div[1]/header/div/a[3]/span")
  WebElement settingsMenuItem;

  public ProjectPage(WebDriver driver) {
    this.driver = driver;
    AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 100);
    PageFactory.initElements(factory, this);
  }

    public String getTitleProject() {
    return titleProject.getText();
  }

  public SettingsPage clickSettings() {
    settingsMenuItem.click();
    return new SettingsPage(driver);
  }

}