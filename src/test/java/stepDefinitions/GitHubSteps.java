package stepDefinitions;

import generic.components.BaseClass;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.SignInPage;
import pageObjects.UserRepoPage;

import java.util.concurrent.TimeUnit;

public class GitHubSteps extends BaseClass {
    public WebDriver driver;
    public SignInPage signInPage;
    public UserRepoPage userRepoPage;
//    WebDriverWait wait = new WebDriverWait(driver,10);

    @Given("User launch the Chrome Browser")
    public void user_launch_the_chrome_browser() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--disable-gpu");
        options.addArguments("--window-size=1400,800");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        signInPage = new SignInPage(driver);
    }

    @Given("User opens gitHub url")
    public void user_opens_git_hub_url() {
        driver.get("https://github.com");
    }

    @When("User Enter the username to search as {string}")
    public void user_enter_the_username_to_search_as(String queryUsername) {
        signInPage.enterSearchQuery("user:"+queryUsername);
    }

    @When("User Click the search button")
    public void user_click_the_search_button() throws InterruptedException {
       Thread.sleep(2000);
       signInPage.pressSearchInAllGitHub();
    }

    @Then("Page Title should be {string}")
    public void page_title_should_be(String pageTitle) {
            Assert.assertEquals(pageTitle,driver.getTitle());
    }

    @Then("Verify the number of repos is {int}")
    public void verify_the_number_of_repos_is(Integer reposCount) {
        userRepoPage = new UserRepoPage(driver);
        Assert.assertEquals("The repos count is not same as expected",reposCount,userRepoPage.getCountOnRepos());
    }
    @Then("User see {string} message")
    public void user_see_message(String errorMessage) {
        userRepoPage = new UserRepoPage(driver);
        Assert.assertEquals("The error message is not same as expected",errorMessage,userRepoPage.getErrorMessage());
    }

    @Then("Close the browser")
    public void close_the_browser() {
        driver.quit();
    }
}
