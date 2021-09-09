package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class UserRepoPage {
    public WebDriver driver;


    public UserRepoPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//*[@id=\"js-pjax-container\"]/div/div[3]/div/ul/li")
    @CacheLookup
    List<WebElement> reposList;

    @FindBy(className = "mb-1")
    @CacheLookup
    WebElement errorMessageText;

    public Integer getCountOnRepos(){
        return reposList.size();
    }
    public String getErrorMessage(){
        return errorMessageText.getText();
    }

}
