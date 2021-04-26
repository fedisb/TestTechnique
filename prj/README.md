Pour commencer :

- Installer :   Node JS et Node Package Manager (npm) 
		Pilote Web Selenium : npm install selenium-webdriver
		Module de package Jest :npm init --y
					npm install -g Jest 
					npm install --save-dev jest
		Pilote de navigateur : par exemple chromedriver, geckodriver
Démarrer vos tests:
 
Vous pouvez  tester en exécutant la commande: npm run test



TC_VerifCnx_CrudTache : 
 
1-ouvrir page login, verifier l"alerte pour un utilisateur incorrect', async () => {
    
    input email incorrect
    input pwd incorrect
    clique envoyer
    verifier alert


2-reconnexion avec un valide utilisateur, Verifiez la connexion avec succée

    get url
    login avec un correcte utilisateur
    verifier Liste des tâches exist

3-cliquez sur deconnexion et verifiez la barre de navigation, La barre de navig n"affiche pas deconnexion
  
    cliquer sur deconnexion
    verifier la deconnexion
  
4-ajouter, modifier et supprimer une tache, verifier la suppression
   
      login
      ajouter une tache
      ajouter une autre tache
      modifier la tache: mettre la tache completée
      supprimer la tache
      verifier la suppression de la tache test1

