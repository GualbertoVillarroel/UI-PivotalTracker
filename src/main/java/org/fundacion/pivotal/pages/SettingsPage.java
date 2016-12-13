package org.fundacion.pivotal.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SettingsPage {
  private WebDriver driver;

  @FindBy(id = "project_name")
  WebElement projectName;

  @FindBy(css = ".save_bar__submit")
  WebElement saveBtn;

  @FindBy(id = "delete_link")
  WebElement deleteLnk;

  @FindBy(id = "confirm_delete")
  WebElement deleteBtn;

  public SettingsPage(WebDriver driver) {
    this.driver = driver;
    AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 100);
    PageFactory.initElements(factory, this);
  }

  public void setProjectName(String projectName) {
    this.projectName.clear();
    this.projectName.sendKeys(projectName);
  }

  public void clickSave() {
    saveBtn.click();
  }

  public void clickDeleteLnk() {
    deleteLnk.click();
  }

  public void clickDeleteBtn() {
    deleteBtn.click();
  }

  public By getTitleProject(String projectNameChanged){
    return By.xpath(
            ".//*[@id='shared_header']/div/div/header/ul/li[2]/div/h1/a/div[text() ='"
                    + projectNameChanged + "']");
  }


  /**
   * Delete a project.
   *
   * @return an instance of HomePage
   */
  public HomePage deleteProject() {
    //Move the scrollView until delete is visible
    JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
    jsExecutor.executeScript("arguments[0].scrollIntoView();", deleteLnk);

    clickDeleteLnk();
    clickDeleteBtn();
    HomePage home = new HomePage(driver);

    WebDriverWait wait = new WebDriverWait(driver, 20);
    wait.until(ExpectedConditions.visibilityOf(home.getTitleLogo()));
    return home;
  }

  public void editProjectName(String projectName) {
    setProjectName(projectName);
    clickSave();

    WebDriverWait wait = new WebDriverWait(driver, 20);
    wait.until(ExpectedConditions.visibilityOfElementLocated(getTitleProject(projectName)));
  }


}