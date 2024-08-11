package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;
import java.util.Objects;

import static utilities.ReusableMethods.*;

public class AmazonStepDefinition {
    AmazonPage amazonPage = new AmazonPage(); //locatelere ulasmak için olusturduğum obje
    @Given("kullanici amazon sayfasina gider")
    public void kullanici_amazon_sayfasina_gider() {
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        try {
            amazonPage.cerez.click();
        } catch (NoSuchElementException e){
            System.err.println("!!!CEREZ CIKMADI!!!");
        }
    }

    @And("anasayfanin acildigini dogrular")
    public void anasayfanin_acildigini_dogrular() {
        Assert.assertTrue(Driver.getDriver().getTitle().contains("Amazon.com.tr"));
    }

    @Then("searchboxta {string} kelimesini aratir")
    public void searchboxtaSamsungKelimesiniAratir(String str) {
        amazonPage.aramaKutusu.sendKeys(str + Keys.ENTER);
    }

    @And("acilan sayfada aratilan samsung kelimesi icin sonuc bulundugunu dogrular")
    public void acilanSayfadaAratilanSamsungKelimesiIcinSonucBulundugunuDogrular() {
        Assert.assertTrue(amazonPage.sonucYazisiDogrulama.getText().contains("samsung"));

        try {
            amazonPage.cerez.click();
        } catch (NoSuchElementException e){
            System.err.println("!!!CEREZ CIKMADI!!!");
        }
    }
    @Then("arama sonuclarindan ikinci sayfaya tiklar")
    public void aramaSonuclarindanIkinciSayfayaTiklar() {
        scroll(amazonPage.aramaSonuclariIkinciSayfa);
        amazonPage.aramaSonuclariIkinciSayfa.click();
        bekle(2);
    }

    @And("ikinci sayfada oldugunu dogrular")
    public void ikincisayfadaOldugunuDogrular() {
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("pg_2"));
    }

    @When("ustten besinci satir birinci sutun icerisindeki urune tiklar")
    public void usttenBesinciSatirBirinciSutunIcerisindekiUruneTiklar() {
    bekle(5); //burda beklememin amacı ikinci sayfa acıldıktan sonra besinci satır birinci sütunda hangi öğe var manuel scroll yapıp o ürünü görüyorum.dogru locasyona tıklayıp tıklamadığına bakıyorum.
        List<WebElement> samsungUrunleri = Driver.getDriver().findElements(By.cssSelector("a > .a-size-base-plus.a-color-base.a-text-normal"));
        samsungUrunleri.get(20).click();
        //System.out.println("besinci satir birinci sıradaki ürün= " + samsungUrunleri.get(20).getText());
    }

    @And("urun sayfasinda oldugunu dogrular") // Bazı ürünlerde ürün fotografı veya acıklama yazısı büyük olduğu için simdial butonu altta kalıyor.bunu çözmek için scrol islemi yaptım
    public void urunSayfasindaOldugunuDogrular() throws InterruptedException {
        bekle(2);
        try {
            scroll(amazonPage.simdiAlButton);
            Assert.assertTrue(amazonPage.simdiAlButton.isDisplayed());
        } catch (NoSuchElementException e){
            System.err.println("!!!SİMDİ AL BUTONU GÖRÜNMEDİ!!!");
        }
    }

    @Then("urunu sepete ekler")  // Bazı ürünlerde ürün fotografı veya acıklama yazısı büyük olduğu için sepete ekle butonu altta kalıyor.bunu çözmek için scrol islemi yaptım
    public void urunuSepeteEkler() {
        try {
            scroll(amazonPage.sepeteEkle);
            amazonPage.sepeteEkle.click();
        } catch (NoSuchElementException e){
            System.err.println("!!!SEPETE EKLE BUTONU GÖRÜNMEDİ!!!");
        }
    }

    @And("sepet sayfasinda oldugunu dogrular")
    public void sepetSayfasindaOldugunuDogrular() {

        Assert.assertTrue(amazonPage.sepeteEklendiYazisi.isDisplayed());
    }

    @Then("logoya tiklayip anasayfaya geri doner")
    public void logoyaTiklayipAnasayfayaGeriDoner() {
        amazonPage.logo.click();
    }

    @And("anasayfada oldugunu dogrular")
    public void anasayfadaOldugunuDogrular() {
        Assert.assertTrue(Driver.getDriver().getTitle().contains("Amazon.com.tr"));
    }

    @And("sayfayi kapatir")
    public void sayfayiKapatir() {
        sayfayiKapat();

   }
}
