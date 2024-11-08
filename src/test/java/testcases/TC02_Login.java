package testcases;

import org.altoro.pages.P02_LoginPage;
import org.altoro.util.Utility;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import retry_test.RetryAnalyser;

import java.io.IOException;

public class TC02_Login extends TestBase{

    String username=Utility.getJsonData(System.getProperty("user.dir")+"/src/test/resources/TestFiles/logindata.json","username");
    String password=Utility.getJsonData(System.getProperty("user.dir")+"/src/test/resources/TestFiles/logindata.json","password");;

    String loginMSG_FR=Utility.getExcelData(1,0,"ar");

    public TC02_Login() throws IOException, ParseException {
    }

    @Test(priority = 1,description = "Check Login With Valid Data", retryAnalyzer = RetryAnalyser.class)
    public void ValidateLoginWithValidData(){

        new P02_LoginPage(driver).enterUserName(username).enterPassword(password).clickLogin();

        Assert.assertTrue(new P02_LoginPage(driver).getUserMessage().contains(loginMSG_FR));
    }
}
