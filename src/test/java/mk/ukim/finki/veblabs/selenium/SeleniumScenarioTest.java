package mk.ukim.finki.veblabs.selenium;


import mk.ukim.finki.veblabs.model.Manufacturer;
import mk.ukim.finki.veblabs.model.User;
import mk.ukim.finki.veblabs.service.ManufacturerService;
import mk.ukim.finki.veblabs.service.UserService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class SeleniumScenarioTest {
    private HtmlUnitDriver driver;
    private static boolean dataInitialized = false;
    @Autowired
    ManufacturerService manufacturerService;
    @Autowired
    UserService userService;
    private static Manufacturer m1;
    private static User user;
    private static String username = "bojan";
    private static String pw = "bojan";
    private void initData()
    {
        if (!dataInitialized) {

            m1 = manufacturerService.save("m1", "m1","asd");
            dataInitialized = true;
        }

    }
    @BeforeEach
    public void setup()
    {
        this.driver=new HtmlUnitDriver(true);
        initData();
    }
    @AfterEach
    public void destroy()
    {
        if(this.driver!=null)
        {
            this.driver.close();
        }
    }
    @Test
    public void testScenario() throws Exception
    {
        BalloonPage balloonPage=BalloonPage.to(this.driver);
        balloonPage.assertElements(0,0,0,0);
        LoginPage loginPage=LoginPage.openLogin(this.driver);
        balloonPage= LoginPage.doLogin(this.driver,username,pw,loginPage);
        balloonPage.assertElements(0,0,0,1);
        balloonPage=AddBalloon.addProduct(this.driver,"ime","opis",m1.getName());
        balloonPage.assertElements(1,1,1,1);

    }


}
