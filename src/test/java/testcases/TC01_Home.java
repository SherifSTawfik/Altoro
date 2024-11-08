package testcases;

import org.altoro.pages.P01_HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import retry_test.RetryAnalyser;

public class TC01_Home extends TestBase{

    @Test(priority = 1,description = "Validate Signin button navigate to login page",retryAnalyzer = RetryAnalyser.class)
    public void ValidateSiginButtonNavigateToLoginPage(){
        new P01_HomePage(driver).clickSignInButton();

        Assert.assertEquals(new P01_HomePage(driver).getLoginMessage(),"Online Banking Login");

    }
}
