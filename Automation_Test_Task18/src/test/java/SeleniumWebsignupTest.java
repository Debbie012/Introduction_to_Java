import org.openqa.selenium.By;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SeleniumWebsignupTest {
    //import selenium WebDriver
    private WebDriver driver;

    @BeforeTest
    public void start() throws InterruptedException {
        //Locate where the chromedriver is
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");

        //1. Open your chrome browser
        driver = new ChromeDriver();
        //2. Input your selenium Demo page URL https://selenium-blog.herokuapp.com/
        driver.get("https://selenium-blog.herokuapp.com/");
        //Test 1. Verify the user inputs the right URL and is on the right page
        if (driver.getCurrentUrl().contains("https://selenium-blog.herokuapp.com/"))
            //Pass
            System.out.println("Correct Webpage");
        else
            //Fail
            System.out.println("Wrong Webpage");

        Thread.sleep(5000);
        //3. Maximize the browser
        driver.manage().window().maximize();
        //4. Click on signup button to open the signup page
        driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
        Thread.sleep(5000);
    }

    @Test (priority = 0)
    public void positiveSignup() throws InterruptedException {

        //5. Input your username on the username field
        driver.findElement(By.id("user_username")).sendKeys("Debbie31");
        //6. Input your email on the email field
        driver.findElement(By.id("user_email")).sendKeys("debbienti31@mailinator.com");
        //7. Locate the password field and input your password on the password field
        driver.findElement(By.id("user_password")).sendKeys("greenfingers");
        //8. Click on the signup button
        driver.findElement(By.id("submit")).click();
        Thread.sleep(5000);
    }
        @Test (priority = 1)
        public void clickUser1Item() throws InterruptedException {
        //9. Click on user1 item on the list page
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/ul/div/div/li[1]/a")).click();
        //Test 2.Verify that when user clicks on the signup button, the user is directed to the signup page
        String expectedUrl = "https://selenium-blog.herokuapp.com/signup";
        String actualUrl = driver.getCurrentUrl();
                if(actualUrl.contains(expectedUrl))
                    //Pass
                    System.out.println("Correct Webpage");
                else
                    //Fail
                    System.out.println("Wrong Webpage");
                Thread.sleep(5000);
        }

        @Test (priority = 2)
        public void verifyItem() throws InterruptedException {
            //Test 9. Verify that the page title (AlphaBlog) is present
            //10. Search for an item (Using Python with Selenium) and confirm it is present
            driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div/div[1]/a")).click();
            String expectedPageUrl = "https://selenium-blog.herokuapp.com/users/1";
            String actualPageUrl = driver.getCurrentUrl();
            if (actualPageUrl.contains(expectedPageUrl))
                //Pass
                System.out.println("Correct Webpage");
            else
                //Fail
                System.out.println("Wrong Webpage");
            Thread.sleep(5000);
        }

        @Test (priority = 3)
        public void logoutSuccessfully(){

                //11. Click on logout
            driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[3]/a")).click();
        //Test 10. Verify that when the user logout, he/she is directed back to the home page
            String expectedTitle = "Selenium Blog";
            String actualTitle = driver.getTitle();
            if(actualTitle.contains(expectedTitle))
                //Pass
                System.out.println("Correct Title");
            else
                //Fail
                System.out.println("Wrong Title");
    }

    @Test (priority = 4)
    public void negativeSignup() throws InterruptedException {
        // Test 3. Verify that user cannot signup with username less than 3 characters
        // 5. Input your username on the username field
        //4. Click on signup button to open the signup page
        driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
        Thread.sleep(5000);
        driver.findElement(By.id("user_username")).sendKeys("De");

        if (errorMsg.contains("Username name must be atleast 3 characters long"))
            System.out.println();


        
        Thread.sleep(5000);

        //Test 4. Verify user cannot signup with invalid email address
        //6. Input your email on the email field
        driver.findElement(By.id("user_email")).sendKeys("debbienti28@malinator.com");
        //Test 5.  Verify user cannot login with password less than or equal to one character
        //7. Locate the password field and input your password on the password field
        driver.findElement(By.id("user_password")).sendKeys("g");
        //Test 6.  Verify user cannot signup with either/all of the fields blank

        //8. Click on the signup button
        driver.findElement(By.id("submit")).click();
        Thread.sleep(5000);
    }

    @AfterTest
    public void closeBrowser(){
        //12. Quit the browser
        driver.quit();
    }

}
