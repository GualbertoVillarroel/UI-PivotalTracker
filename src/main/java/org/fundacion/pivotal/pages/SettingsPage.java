package org.fundacion.pivotal.pages;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class SettingsPage {
  private WebDriver driver;

  @FindBy(id = "delete_link")
  WebElement deleteLnk;

  @FindBy(id = "confirm_delete")
  WebElement deleteBtn;

  public SettingsPage(WebDriver driver) {
    this.driver = driver;
    AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 100);
    PageFactory.initElements(factory, this);
  }

  public void clickDeleteLnk() {
    deleteLnk.click();
  }

  public void clickDeleteBtn() {
    deleteBtn.click();
  }

  public HomePage deleteProject() {
    //Move the scrollView until delete is visible
    JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
    jsExecutor.executeScript("arguments[0].scrollIntoView();", deleteLnk);

    clickDeleteLnk();
    clickDeleteBtn();
    return new HomePage(driver);
  }
}