package org.fundacion.pivotal.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;


public class CreateProjectPage {

  WebDriver driver;

  @FindBy(css = "input.tc-project-name__input")
  WebElement projectName;

  @FindBy(css = "button.tc-create-project-footer__button.tc-create-project-footer__button--submit")
  WebElement createBtn;

  @FindBy(css = "div.tc-account-selector__header")
  WebElement accountSelectotDdb;

  @FindBy(css = "div.tc-account-selector__options")
  WebElement selector;

  public CreateProjectPage(WebDriver driver) {
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

  public void selectAccount(String accountName) {
    WebElement account = selector.findElement(By.xpath("//div[text()= '" + accountName + "']"));
    account.click();
  }

  public void clickCreate() {
    createBtn.click();
  }

  /**
   * Create a new project.
   * @param projectName name of the project to be created
   * @param accountName acoount with witch the project will be created
   * @return an instance of ProjectPage
   */
  public ProjectPage createNewProject(String projectName, String accountName) {
    setProjectName(projectName);
    clickAccountDropDownList();
    selectAccount(accountName);
    clickCreate();
    return new ProjectPage(this.driver);
  }

}
