package org.fundacion.pivotal.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;


public class NewProjectPage {

  WebDriver driver;

  @FindBy(css = "input.tc-project-name__input")
  WebElement projectName;

  @FindBy(css = "button.tc-create-project-footer__button.tc-create-project-footer__button--submit")
  WebElement createBtn;

  @FindBy(css = "div.tc-account-selector__header")
  WebElement accountSelectotDdb;

  @FindBy(css = ".tc-account-selector__option-account-name")
  WebElement accountSelector;

  @FindBy(css = "div.tc-account-selector__create-account-icon")
  WebElement createAccountIconBtn;

  @FindBy(css = "input.tc-account-creator__name")
  WebElement accountName;

  public NewProjectPage(WebDriver driver) {
    this.driver = driver;
    AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 100);
    PageFactory.initElements(factory, this);
  }

  public void setProjectName(String name) {
    projectName.sendKeys(name);
  }

  public void clickAccountDropDownList() {
    accountSelectotDdb.click();
  }

  public void clickSelectAnAccount() {
    accountSelector.click();
  }

  public void clickCreateAccount() {
    createAccountIconBtn.click();
  }

  public void setAccountName(String name) {
    accountName.sendKeys(name);
  }

  public void clickCreate() {
    createBtn.click();
  }

  public ProjectPage createNewProjectPivotalTracker(String projectName){
    setProjectName(projectName);
    clickAccountDropDownList();
    clickSelectAnAccount();
    clickCreate();
    return new ProjectPage(this.driver);
  }

}
