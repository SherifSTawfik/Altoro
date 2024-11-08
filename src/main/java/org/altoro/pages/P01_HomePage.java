package org.altoro.pages;

import org.altoro.actions.CustomDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.altoro.pages.PageBase.shortWait;

public class P01_HomePage {

    WebDriver driver;

    public P01_HomePage(WebDriver driver){
        this.driver=driver;
    }

    private final By SIGNIN_BUTTON=By.xpath("//*[@id=\"LoginLink\"]");

    public P01_HomePage clickSignInButton(){
        shortWait(driver).until(ExpectedConditions.elementToBeClickable(SIGNIN_BUTTON));
//        driver.findElement(SIGNIN_BUTTON).click();
        new CustomDecorator(driver,SIGNIN_BUTTON).click();
        return this;
    }
    public String getLoginMessage(){
        return driver.findElement(By.xpath("//h1[normalize-space()='Online Banking Login']")).getText();
    }

}
