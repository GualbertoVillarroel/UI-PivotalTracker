package org.fundacion.pivotal.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;


public class LoginPage {

  private WebDriver driver;

  @FindBy(id = "credentials_username")
  WebElement userName;

  @FindBy(id = "credentials_password")
  WebElement password;

  @FindBy(css = "input.app_signin_action_button")
  WebElement continueBtn;

  @FindBy(css = "input.app_signin_action_button")
  WebElement submitBtn;


  public LoginPage(WebDriver driver) {
    this.driver = driver;
    AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 100);
    PageFactory.initElements(factory, this);
  }

  public void setUserName(String userNameStr) {
    userName.sendKeys(userNameStr);
  }

  public void setPassword(String pass) {
    password.sendKeys(pass);
  }

  public void clickContinue() {
    continueBtn.click();
  }

  public HomePage clickSubmit() {
    submitBtn.click();
    return new HomePage(driver);
  }

}