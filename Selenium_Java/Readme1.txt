Selenium WebDriver est un framework web qui vous permet d’exécuter des tests multi-navigateurs. 
Cet outil est utilisé pour automatiser les tests d’applications Web pour vérifier qu’il fonctionnent correctement.

Pour commencer :

- Installer Java
- Télécharger un ide (Intellij,eclipse... )
- Télécharger et configurer Selenium WebDriver (ChromeDriver NB: il faut que la version soit compatible avec votre version chrome)
 
Démarrer vos tests: 

path tests: src/test/java/com/mdweb/selenium/tests

Tests :TC01_Verif_Connexion

1.       Ouvrir la page de connexion
2.       Login avec un incorrect utilisateur
3.       Vérifier le message d'erreur est affiché
4.       Reconnexion avec un valide utilisateur
5.       Vérifier la connexion avec succès
6.       Déconnexion et vérification de la barre de navigation 

TC02_CRUD_Tache

1.       Ouvrir page de connexion
2.       Entrez l'email et le mdp
3.       Ajouter une tâche
4.       Modifier cette tâche
5.       Vérifier la modification
6.       Supprimer et vérifier la suppression de cette tâche 