package mk.ukim.finki.veblabs.selenium;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.junit.Assert;

import java.util.List;

@Getter
public class BalloonPage extends AbstractPage {
    public BalloonPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = "tr[class=balloon]")
    private List<WebElement> BalloonRows;
    @FindBy(id = "dodadi")
    private List<WebElement> addBalloon;
    @FindBy(id = "izmeni")
    private List<WebElement> editBalloon;
    @FindBy(id = "izbrisi")
    private List<WebElement> deleteBalloon;

    public static BalloonPage to(WebDriver driver) {
        get(driver, "/balloons");
        return PageFactory.initElements(driver, BalloonPage.class);
    }
    public void assertElements(int balloonNumber, int deleteButtons, int editButtons, int addButtons) {
        Assert.assertEquals("rows do not match", balloonNumber, this.getBalloonRows().size());
        Assert.assertEquals("delete do not match", deleteButtons, this.getDeleteBalloon().size());
        Assert.assertEquals("edit do not match", editButtons, this.getEditBalloon().size());
        Assert.assertEquals("add do not match", addButtons, this.getAddBalloon().size());
    }
}