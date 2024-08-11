package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import javax.swing.text.html.CSS;
import java.util.List;

public class AmazonPage {
    public AmazonPage() {
        PageFactory.initElements(Driver.getDriver(),this);  //bu classa driverı getir
    }
    @FindBy(css = "#twotabsearchtextbox")
    public WebElement aramaKutusu;


    @FindBy(css = "#sp-cc-rejectall-link")
    public WebElement cerez;


     @FindBy(xpath = "//div[@class='a-section a-spacing-small a-spacing-top-small']")
    public WebElement sonucYazisiDogrulama;

     @FindBy(css = ".s-pagination-item.s-pagination-button[aria-label='2 sayfasına git']")
    public WebElement aramaSonuclariIkinciSayfa;

     @FindBy(css = "span.s-pagination-item.s-pagination-selected[aria-label='Geçerli sayfa, sayfa 2']")
    public WebElement gecerliSayfaDogrulama;

    //"[data-component-id=\"42\"]")
    //.sg-col-inner :nth-of-type(33)
    //div[data-asin='B08B4GLDWL'] img.s-image
    @FindBy(css =".sg-col-inner :nth-of-type(33)")
            public WebElement besinciSatirBirinciSira;


    @FindBy(css ="#buy-now-button")
            public WebElement simdiAlButton;

    @FindBy(css = "[id=\"add-to-cart-button\"]")
    public WebElement sepeteEkle;

    @FindBy(css = ".a-size-medium-plus.a-color-base.sw-atc-text.a-text-bold")
    public WebElement sepeteEklendiYazisi;

    @FindBy(css = "#nav-logo-sprites")
    public WebElement logo;



}
