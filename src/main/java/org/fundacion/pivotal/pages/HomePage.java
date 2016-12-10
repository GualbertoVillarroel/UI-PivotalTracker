package org.fundacion.pivotal.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;


public class HomePage {

  private WebDriver driver;

  @FindBy(css = "div.tc_header_text_logo")
  WebElement titleLogo;

  @FindBy(css = ".button.button--actionButton")
  WebElement createProjectBtn;

  public HomePage(WebDriver driver) {
    this.driver = driver;
    AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 100);
    PageFactory.initElements(factory, this);
  }

  public NewProjectPage clickCreateProject() {
    createProjectBtn.click();
    return new NewProjectPage(this.driver);
  }

  public WebElement getTitleLogo(){
    return titleLogo;
  }


}
