package com.testtechnique.selenium.tests;

import com.testtechnique.selenium.DriverBase;
import com.testtechnique.selenium.listeners.ScreenshotListener;
import com.testtechnique.selenium.model.User;
import com.testtechnique.selenium.page_objects.LoginPage;
import io.appium.java_client.functions.ExpectedCondition;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TC01_Verif_Connexion extends DriverBase {

    private ExpectedCondition<Boolean> pageTitleStartsWith(final String searchString) {
        return driver -> driver.getTitle().toLowerCase().startsWith(searchString.toLowerCase());
    }


        @Test
        public void verif_Connexion_Deconnexion() throws Exception {

            WebDriver driver = getDriver();
            driver.manage().window().maximize();
            LoginPage loginPage = new LoginPage();
            ScreenshotListener screenshotListener = new ScreenshotListener();

            LOG.info("Ouvrir la page de connexion");
            driver.get("http://localhost:3000");

            LOG.info("Login avec un incorrect utilisateur");
            loginPage.Login(new User().generateDefaultUser1())
                    .connexion();

            LOG.info("le message d'erreur est affiché");
            WebDriverWait wait = new WebDriverWait(driver, 5, 50);
            wait.until(loginPage.verifMsgErr());

            LOG.info("reconnexion avec un valide utilisateur");
            loginPage.Login(new User().generateDefaultUser())
                    .connexion();

            LOG.info("Verifiez la connexion avec succée");
            wait.until(loginPage.verifyLogin());

            LOG.info("cliquez sur deconnexion et verifiez la barre de navigation");
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            Assert.assertEquals(loginPage.verifyDeconnexion(), Boolean.TRUE);

        }
}
