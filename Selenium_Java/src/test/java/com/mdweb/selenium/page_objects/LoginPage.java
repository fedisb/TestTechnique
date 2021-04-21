package com.mdweb.selenium.page_objects;

import com.mdweb.selenium.DriverBase;
import com.mdweb.selenium.model.User;
import com.lazerycode.selenium.util.Query;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;

import static com.mdweb.selenium.page_objects.CrudTache.LOG;
import static com.lazerycode.selenium.util.AssignDriver.initQueryObjects;

public class LoginPage {

    private final Query inputUserEmail = new Query().defaultLocator(By.xpath("//*[@id=\"root\"]//input[@type=\"email\"]"));
    private final Query inputPwd = new Query().defaultLocator(By.xpath("//*[@id=\"root\"]//input[@type=\"password\"]"));
    private final Query btnEnvoyer = new Query().defaultLocator(By.xpath("//*[@id=\"root\"]//input[@type=\"submit\"]"));
    private final Query btnDeconnexion = new Query().defaultLocator(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/li[3]/a"));
    private final Query verifBarreNavig = new Query().defaultLocator(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/li[3]/a"));
    private final Query msgError = new Query().defaultLocator(By.xpath("//*[@id=\"root\"]/div/div/div/div[1]"));


    public LoginPage() throws Exception {
        initQueryObjects(this, DriverBase.getDriver());
    }
    public LoginPage Login(User user) {

        inputUserEmail.findWebElement().clear();
        inputUserEmail.findWebElement().sendKeys(user.getUserEmail());
        inputPwd.findWebElement().clear();
        inputPwd.findWebElement().sendKeys(user.getPassword());

        return this;
    }

    public LoginPage connexion() {

        LOG.info("cliquez sur le bouton de connexion");
        btnEnvoyer.findWebElement().click();
        return this;
    }


    public ExpectedCondition<Boolean> verifMsgErr() throws InterruptedException {
        Thread.sleep(2000);
        return  driver -> msgError.findWebElement().isDisplayed();
    }

    public ExpectedCondition<Boolean> verifyLogin() throws InterruptedException {
        Thread.sleep(2000);
        return  driver -> verifBarreNavig.findWebElement().isDisplayed();
    }


    public Boolean verifyDeconnexion(){
        btnDeconnexion.findWebElement().click();

        LOG.info("La barre de navig n'affiche pas deconnexion");

        try
        {
            if(btnDeconnexion.findWebElement().isDisplayed())
                return false;
            else
            {
                LOG.info("element not displayed");
                return true;
            }
        }
        catch(Exception e)
        {
            return false;
        }

    }

}


