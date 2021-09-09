package pageObjects;

import generic.components.Utilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.swing.text.Element;


public class SignInPage{
    public WebDriver driver;


    public SignInPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "q")
    @CacheLookup
    WebElement queryField;

    @FindBy(xpath = "//li[@id='jump-to-suggestion-search-global']/a[1]/div[3]/span[2]")
    @CacheLookup
    WebElement searchAllGitHubButton;

    public void enterSearchQuery(String inputQuery) {
        queryField.sendKeys(inputQuery);
    }

    public void pressSearchInAllGitHub() {
        searchAllGitHubButton.click();
    }



}
