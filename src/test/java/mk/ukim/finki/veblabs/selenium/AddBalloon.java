package mk.ukim.finki.veblabs.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class AddBalloon extends AbstractPage {
    public AddBalloon(WebDriver driver) {
        super(driver);
    }

    private WebElement name;
    private WebElement desc;
    private WebElement manufacturer;
    private WebElement submit;

    public static BalloonPage addProduct(WebDriver driver, String ime, String description, String idManu) {
        get(driver, "/balloons/add-form");
        AddBalloon addOrEditProduct = PageFactory.initElements(driver, AddBalloon.class);
        addOrEditProduct.name.sendKeys(ime);
        addOrEditProduct.desc.sendKeys(description);
        addOrEditProduct.manufacturer.click();
        addOrEditProduct.manufacturer.findElement(By.xpath("//option[. = '" + idManu + "']")).click();
        addOrEditProduct.submit.click();
        return PageFactory.initElements(driver, BalloonPage.class);
    }

}
