package com.testtechnique.selenium.page_objects;

import com.lazerycode.selenium.util.Query;
import com.testtechnique.selenium.DriverBase;
import com.testtechnique.selenium.model.Tache;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;

import static com.lazerycode.selenium.util.AssignDriver.initQueryObjects;

public class CrudTache {

    private final Query inputNomTache= new Query().defaultLocator(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[1]/input"));
    private final Query inputDescTache = new Query().defaultLocator(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[2]/input"));
    private final Query btnAjouter = new Query().defaultLocator(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[3]/button"));
    private final Query tacheAjoutee = new Query().defaultLocator(By.xpath("//*[@id=\"root\"]/div/div/ul/li/span[1]/b"));
    private final Query modifStat = new Query().defaultLocator(By.xpath("//*[@id=\"root\"]/div/div/ul/li/span[2]/div"));
    private final Query btnSupprimer = new Query().defaultLocator(By.xpath("//*[@id=\"root\"]/div/div/ul/li/span[1]/a"));

    public static final Logger LOG = (Logger) LogManager.getLogger(DriverBase.class);

    public CrudTache() throws Exception {
        initQueryObjects(this, DriverBase.getDriver());
    }

    public CrudTache TacheInfo(Tache tache) throws Exception {

        LOG.info("remplissez les champs obligatoires");

        inputNomTache.findWebElement().clear();
        inputNomTache.findWebElement().sendKeys(tache.getNomTache());

        inputDescTache.findWebElement().clear();
        inputDescTache.findWebElement().sendKeys(tache.getDesciptionTache());

        return this;
    }

    public CrudTache verifyTacheAdded() throws Exception {
        LOG.info("cliquez sur bouton ajouter");
        btnAjouter.findWebElement().click();
        Thread.sleep(3000);
        LOG.info("vérifier la notification: Dossier ajouté avec succès");
        if (tacheAjoutee.findWebElement().isEnabled()) {
            String TacheAjoutee = tacheAjoutee.findWebElement().getText();
            String TacheExpected = "Test_Tache";
            Assert.assertEquals(TacheAjoutee, TacheExpected);
        }

        return this;
    }
    ///Modifier dossier

    public CrudTache modifTache () throws InterruptedException {
        LOG.info("modifier tache");
        Thread.sleep(3000);
        modifStat.findWebElement().click();
       return this;
    }


    public CrudTache verifyTacheModif()  throws InterruptedException {
        LOG.info("vérifier la modification");
        Thread.sleep(3000);
        String StatutAct = modifStat.findWebElement().getText();
        String TacheExpected = "Complétée";
        Assert.assertEquals(StatutAct, TacheExpected);
        return this ;
    }

    public CrudTache supprimerTache () throws InterruptedException {
        LOG.info("cliquez sur le bouton supprimer");
        Thread.sleep(3000);
        btnSupprimer.findWebElement().click();
        return this;
    }

}




