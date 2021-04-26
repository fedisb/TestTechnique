const {Builder, By, Key, until} = require('selenium-webdriver');

describe('TC_VerifCnx_CrudTache', () => {
 
  var driver = new Builder().forBrowser('firefox').build();
  var assert = require('assert');     
  
  
  beforeAll(async() => {
    await  driver.get('http://localhost:3000/');    
    })


  it('ouvrir page login, verifier l"alerte pour un utilisateur incorrect', async () => {
    
    console.log('input email incorrect');
    await driver.findElement(By.css('#root > div > div > div > div:nth-child(1) > input')).sendKeys('test1@test.com');    
    
    console.log('input pwd incorrect');
    await driver.findElement(By.css('#root > div > div > div > div:nth-child(2) > input')).sendKeys('test');
 
    console.log('clique envoyer');
    await driver.findElement(By.css('.btn')).click();
  
    console.log('verifier alert');
    assert.strictEqual( await driver.findElement(By.css('#root > div > div > div > div.alert.alert-danger')).getText(), 'Désolé, les identifiants sont incorrects.' ,'verifier l"alert');
     
    
  })
  it('reconnexion avec un valide utilisateur, Verifiez la connexion avec succée', async () => {
    console.log('get url');
    await driver.get('http://localhost:3000/');
    
    console.log('login avec un correcte utilisateur');
    await driver.findElement(By.css('#root > div > div > div > div:nth-child(1) > input')).sendKeys('test@test.com');
    await driver.findElement(By.css('#root > div > div > div > div:nth-child(2) > input')).sendKeys('test');
    await driver.findElement(By.css('.btn')).click();

    console.log('verifier Liste des tâches exist');
    assert.strictEqual(await driver.findElement(By.css('#root > div > div > h2:nth-child(1)')).getText(), 'Liste des tâches' ,'verifier la connexion avec succée');
     
  })

  it('cliquez sur deconnexion et verifiez la barre de navigation, La barre de navig n"affiche pas deconnexion', async () => {
    console.log('cliquer sur deconnexion');
    await driver.findElement(By.css(':nth-child(3) > .nav-link')).click();
    
    console.log('verifier la deconnexion');
    assert.notStrictEqual(await driver.findElement(By.css('#navbarSupportedContent > ul > li:nth-child(3) > a')).getText(), 'Déconnexion' ,'verifier la deconnexion avec succée');
  
  });

  
  it('ajouter, modifier et supprimer une tache, verifier la suppression', async () => {
   
      console.log('login');
      await driver.findElement(By.css('#root > div > div > div > div:nth-child(1) > input')).sendKeys('test@test.com');
      await driver.findElement(By.css('#root > div > div > div > div:nth-child(2) > input')).sendKeys('test');
      await driver.findElement(By.css('.btn')).click();
     
      console.log('ajouter une tache');
      await driver.findElement(By.css('#root > div > div > div.row > div:nth-child(1) > input')).sendKeys('test1');
      await driver.findElement(By.css('#root > div > div > div.row > div:nth-child(2) > input')).sendKeys('test1');
      await driver.findElement(By.css('#root > div > div > div.row > div:nth-child(3) > button')).click();
     
      console.log('ajouter une autre tache');
      await driver.findElement(By.css('#root > div > div > div.row > div:nth-child(1) > input')).sendKeys('test2');
      await driver.findElement(By.css('#root > div > div > div.row > div:nth-child(2) > input')).sendKeys('test2');
      await driver.findElement(By.css('#root > div > div > div.row > div:nth-child(3) > button')).click();
     
      console.log('modifier la tache: mettre la tache completée');
      await driver.findElement(By.css('#root > div > div > ul > li > span:nth-child(2) > div')).click();
     
      console.log('supprimer la tache');
      await driver.findElement(By.css('#root > div > div > ul > li > span:nth-child(1) > a')).click();

       
      console.log('verifier la suppression de la tache test1');
      assert.notStrictEqual(await driver.findElement(By.css('#root > div > div > ul > li:nth-child(1) > span:nth-child(1) > b')).getText(), 'test1' ,'verifier la suppression de la tache test1');
  
    });

  
  afterAll(async()=> {
    await driver.quit()
    }) 

  });
