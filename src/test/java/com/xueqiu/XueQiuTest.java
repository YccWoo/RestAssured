package com.xueqiu;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


public class XueQiuTest {

    private AndroidDriver driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName","Android");
        desiredCapabilities.setCapability("deviceName","192.168.56.101:5555");
        desiredCapabilities.setCapability("appPackage","com.xueqiu.android");
        desiredCapabilities.setCapability("appActivity",".view.WelcomeActivityAlias");
        desiredCapabilities.setCapability("noReset",false);
        desiredCapabilities.setCapability("unicodeKeyboard",true);
        desiredCapabilities.setCapability("resetKeyboard",true);
        desiredCapabilities.setCapability("automationName","UiAutomator2");
        desiredCapabilities.setCapability("recreateChromeDriverSessions", "True");
        desiredCapabilities.setCapability("chromedriverExecutableDir","/Users/jianshunsun/studyspace/WuYanChao/chromedrivers/2.23");
        desiredCapabilities.setCapability("showChromedriverLog",true);

        URL remoteUrl = new URL("http://localhost:4723/wd/hub");
        driver = new AndroidDriver(remoteUrl, desiredCapabilities);

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }

    @Test
    public void testWebview() throws InterruptedException {

        Thread.sleep(2000);
        driver.findElementById("com.xueqiu.android:id/agree").click();
        Thread.sleep(2000);

        driver.findElementByXPath("//*[contains(@text,'交易') and contains(@resource-id,'com.xueqiu.android:id/tab_name')]").click();

        Thread.sleep(5000);
        System.out.println(driver.getContextHandles());
        System.out.println("the current context is: "+driver.getContext());

        //driver.findElementByXPath("//*[contains(@text,'行情') and contains(@resource-id,'com.xueqiu.android:id/tab_name')]").click();
        //System.out.println(driver.getContextHandles());
        //System.out.println("当前上下文"+driver.getContext());

       // driver.context("WEBVIEW_com.xueqiu.android");
       // driver.findElementByXPath("//*[@id=\"my-money\"]/div[2]/div[2]/button[1]").click();
        System.out.println("切换后上下文"+driver.getContext());

        //driver.findElementById("com.xueqiu.android:id/page_type_fund").click();
        //Thread.sleep(5000);
        //driver.findElementByXPath("//*[@content-desc='已有蛋卷基金账户登录']").click();

        //driver.context(driver.getContextHandles().toArray()[1].toString());

        ;
            /*

            //等待元素
//        AndroidElement fund = (AndroidElement) new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.id("com.xueqiu.android:id/page_type_fund")));
//        fund.click();
           System.out.println(driver.getContextHandles());

           driver.context("WEBVIEW_com.xueqiu.android");

//        driver.findElementByXPath("//*[@content-desc='已有蛋卷基金账户登录']").click();//在native环境下用
            driver.findElementByXPath("//*[contains[@content-desc,'安全卡确保交易资金安全']").click(); //webview环境下使用
            driver.context("NATIVE_APP");
//        AndroidElement input_phone = (AndroidElement) new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"telno\"]")));
//        input_phone.sendKeys("11122223333");

//        driver.findElementByXPath("//*[@id='telno']").sendKeys("11122223333");
//        driver.findElementByXPath("//*[@id='code']").sendKeys("1234");
//        driver.findElementByXPath("//*[@id='next']").click();

            Thread.sleep(5000);
            driver.context("WEBVIEW_com.xueqiu.android");
            System.out.println("上下文"+driver.getContext());
            System.out.println("页面元素"+driver.getPageSource());
            driver.findElementByXPath("//*[@id='telno']").sendKeys("11122223333");
           driver.findElementByXPath("//*[@id='code']").sendKeys("1234");
           driver.findElementByXPath("//*[@id='next']").click();
            //driver.findElement(By.id("telno")).sendKeys("11122221111");
            //driver.findElement(By.id("code")).sendKeys("222222");
            //driver.findElementByXPath("//*[@id='next']").click();
*/
    }
    @AfterClass
    public void teardown(){
        driver.quit();
    }



    }

