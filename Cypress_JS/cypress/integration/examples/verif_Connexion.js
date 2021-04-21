describe('Verif cnx', () => {
    it('ouvrir page login, verifier un utilisateur incorrect', () => {

      cy.visit('http://localhost:3000/')
      cy.get('#root > div > div > div > div:nth-child(1) > input').type('test1@test.com')
      cy.get('#root > div > div > div > div:nth-child(2) > input').type('test')
      cy.get('.btn').click()
      cy.get('.alert').contains('Désolé, les identifiants sont incorrects.')

    })

    it('reconnexion avec un valide utilisateur, Verifiez la connexion avec succée', () => {

        cy.get(':nth-child(2) > .form-control').clear()
        cy.get(':nth-child(2) > .form-control').type('test@test.com')
        cy.get(':nth-child(3) > .form-control').clear()
        cy.get(':nth-child(3) > .form-control').type('test')
        cy.get('.btn').click()
        cy.contains('Liste des tâches')
      })
      

    it('cliquez sur deconnexion et verifiez la barre de navigation, La barre de navig naffiche pas deconnexion', () => {
        
        cy.get(':nth-child(3) > .nav-link').click()
        cy.get(':nth-child(3) > .nav-link').should('not.exist');

      })
  })