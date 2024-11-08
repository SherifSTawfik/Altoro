package org.altoro.pages;

import org.altoro.actions.CustomDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.altoro.pages.PageBase.shortWait;

public class P02_LoginPage {

    WebDriver driver;

    public P02_LoginPage(WebDriver driver){
        this.driver=driver;
    }

    private final By USERNAME_TEXT=By.xpath("//input[@id='uid']");
    private final By PASSWORD_TEXT=By.xpath("//input[@id='passw']");
    private final By LOGIN_BUTTON=By.xpath("//input[@name='btnSubmit']");

   public P02_LoginPage enterUserName(String username){
       shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(USERNAME_TEXT));
       new CustomDecorator(driver,this.USERNAME_TEXT).sendKeys(username);
       return this;
   }
    public P02_LoginPage enterPassword(String password){
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(PASSWORD_TEXT));
        new CustomDecorator(driver,this.PASSWORD_TEXT).sendKeys(password);
        return this;
    }
    public P02_LoginPage clickLogin(){
        shortWait(driver).until(ExpectedConditions.elementToBeClickable(LOGIN_BUTTON));
        new CustomDecorator(driver,this.LOGIN_BUTTON).click();
        return this;
    }

    public String getUserMessage(){
       return driver.findElement(By.xpath("//h1[normalize-space()='Hello Admin User']")).getText();
    }
}
