package com.testtechnique.selenium.tests;

import com.testtechnique.selenium.DriverBase;
import com.testtechnique.selenium.listeners.ScreenshotListener;
import com.testtechnique.selenium.model.Tache;
import com.testtechnique.selenium.model.User;
import com.testtechnique.selenium.page_objects.CrudTache;
import com.testtechnique.selenium.page_objects.LoginPage;
import io.appium.java_client.functions.ExpectedCondition;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC02_CRUD_Tache extends DriverBase {

    private ExpectedCondition<Boolean> pageTitleStartsWith(final String searchString) {
        return driver -> driver.getTitle().toLowerCase().startsWith(searchString.toLowerCase());
    }

    @Test

        public void TC02_Crud_Tache() throws Exception {

        WebDriver driver = getDriver();
        driver.manage().window().maximize();
        LoginPage loginPage = new LoginPage();
        CrudTache crudTache = new CrudTache();
        ScreenshotListener screenshotListener = new ScreenshotListener();
        WebDriverWait wait = new WebDriverWait(driver, 5, 50);

        LOG.info("ouvrir page de connexion");
        driver.get("http://localhost:3000");
        LOG.info("entrer l'email et le mdp");
        loginPage.Login(new User().generateDefaultUser())
                .connexion();
        wait.until(loginPage.verifyLogin());

        LOG.info("ajout tache");
        crudTache.TacheInfo(new Tache().generateDefaultTache()).verifyTacheAdded();
        Thread.sleep(5000);


        LOG.info("modif tache");
        crudTache.modifTache().verifyTacheModif();
        Thread.sleep(3000);

        LOG.info("Suppr tache");
        crudTache.supprimerTache();

        LOG.info("vérifier la supression");
        Thread.sleep(3000);
        Assert.assertTrue(driver.findElements(By.xpath("//*[@id=\"root\"]/div/div/ul/li/span[1]/b")).isEmpty());
        Thread.sleep(3000);
        driver.close();
    }
}
