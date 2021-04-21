Cypress est le plus souvent comparé au sélénium, cependant Cypress est à la fois fondamentalement et architecturalement différent. 

Les tests de Cypress ne sont écrits qu'en javascript. 

Cypress fonctionne sur n'importe quel framework front-end ou site Web.

Pour commencer:

1-suivre les etapes dans ce lien pour installer Cypress: https://docs.cypress.io/guides/getting-started/installing-cypress#yarn-add
2-pour ouvrir cypress utilisez cette commande : ./node_modules/.bin/cypress run 
3-executer le test case de verif_Connexion sous ce path : TestTechnique/Cypress_JS/cypress/integration/examples/


Etapes de test verif_Connexion:

1\ouvrir page login
2\verifiez avec un utilisateur incorrect
3\reconnexion avec un valide utilisateur
4\Verifiez la connexion avec succée
5\cliquez sur deconnexion
6\Verifiez la barre de navigation (La barre de navig naffiche pas deconnexion)