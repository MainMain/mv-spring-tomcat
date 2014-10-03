package dao;

import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pam.config.DomainAndPersistenceConfig;
import pam.entities.Cotisation;
import pam.entities.Employe;
import pam.entities.Indemnite;
import pam.repositories.CotisationRepository;
import pam.repositories.EmployeRepository;
import pam.repositories.IndemniteRepository;

import java.util.List;

@SpringApplicationConfiguration(classes = DomainAndPersistenceConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class JUnitDao {

  // repositories
  @Autowired
  private EmployeRepository employeRepository;
  @Autowired
  private IndemniteRepository indemniteRepository;
  @Autowired
  private CotisationRepository cotisationRepository;

  @Before()
  public void clean() {
    log("clean------------------------");
    // on vide la base
    employeRepository.deleteAll();
    cotisationRepository.deleteAll();
    indemniteRepository.deleteAll();
  }

  // logs
  private static void log(String message) {
    System.out.println("----------- " + message);
  }

  // tests
  @Test
  public void test01() {
    log("test01---------------------");
    // liste des cotisations
    List<Cotisation> cotisations = Lists.newArrayList(cotisationRepository.findAll());
    int nbCotisations = cotisations.size();
    // on ajoute une cotisation
    Cotisation cotisation = cotisationRepository.save(new Cotisation(3.49, 6.15, 9.39, 7.88));
    // on la demande
    cotisation = cotisationRepository.findOne(cotisation.getId());
    // vérification
    Assert.assertNotNull(cotisation);
    Assert.assertEquals(3.49, cotisation.getCsgrds(), 1e-6);
    Assert.assertEquals(6.15, cotisation.getCsgd(), 1e-6);
    Assert.assertEquals(9.39, cotisation.getSecu(), 1e-6);
    Assert.assertEquals(7.88, cotisation.getRetraite(), 1e-6);
    // on la modifie
    cotisation.setCsgrds(-1);
    cotisation.setCsgd(-1);
    cotisation.setRetraite(-1);
    cotisation.setSecu(-1);
    Cotisation cotisation2 = cotisationRepository.save(cotisation);
    // vérifications
    Assert.assertEquals((long) cotisation.getVersion() + 1, (long) cotisation2.getVersion());
    Assert.assertEquals(-1, cotisation2.getCsgrds(), 1e-6);
    Assert.assertEquals(-1, cotisation2.getCsgd(), 1e-6);
    Assert.assertEquals(-1, cotisation2.getRetraite(), 1e-6);
    Assert.assertEquals(-1, cotisation2.getSecu(), 1e-6);
    // on demande l'élément modifié
    Cotisation cotisation3 = cotisationRepository.findOne(cotisation2.getId());
    // vérifications
    Assert.assertEquals(cotisation3.getVersion(), cotisation2.getVersion());
    Assert.assertEquals(-1, cotisation3.getCsgrds(), 1e-6);
    Assert.assertEquals(-1, cotisation3.getCsgd(), 1e-6);
    Assert.assertEquals(-1, cotisation3.getRetraite(), 1e-6);
    Assert.assertEquals(-1, cotisation3.getSecu(), 1e-6);
    // on supprime l'élément
    cotisationRepository.delete(cotisation3);
    // vérifications
    Cotisation cotisation4 = cotisationRepository.findOne(cotisation3.getId());
    Assert.assertNull(cotisation4);
    cotisations = Lists.newArrayList(cotisationRepository.findAll());
    Assert.assertEquals(nbCotisations, cotisations.size());
  }

  @Test
  public void test02() {
    log("test02-------------------");
    // liste des indemnités
    List<Indemnite> indemnites = Lists.newArrayList(indemniteRepository.findAll());
    int nbIndemnites = indemnites.size();
    // on ajoute une Indemnite
    Indemnite indemnite = indemniteRepository.save(new Indemnite(1, 1.93, 2, 3, 12));
    // on la demande
    indemnite = indemniteRepository.findOne(indemnite.getId());
    // vérification
    Assert.assertNotNull(indemnite);
    Assert.assertEquals(1, indemnite.getIndice());
    Assert.assertEquals(1.93, indemnite.getBaseHeure(), 1e-6);
    Assert.assertEquals(2, indemnite.getEntretienJour(), 1e-6);
    Assert.assertEquals(3, indemnite.getRepasJour(), 1e-6);
    Assert.assertEquals(12, indemnite.getIndemnitesCP(), 1e-6);
    // on la modifie
    indemnite.setIndice(0);
    indemnite.setBaseHeure(0);
    indemnite.setEntretienJour(0);
    indemnite.setRepasJour(0);
    indemnite.setIndemnitesCP(0);
    Indemnite indemnite2 = indemniteRepository.save(indemnite);
    // vérifications
    Assert.assertEquals((long) indemnite.getVersion() + 1, (long) indemnite2.getVersion());
    Assert.assertEquals(0, indemnite.getIndice());
    Assert.assertEquals(0, indemnite.getBaseHeure(), 1e-6);
    Assert.assertEquals(0, indemnite.getEntretienJour(), 1e-6);
    Assert.assertEquals(0, indemnite.getRepasJour(), 1e-6);
    Assert.assertEquals(0, indemnite.getIndemnitesCP(), 1e-6);
    // on demande l'élément modifié
    Indemnite indemnite3 = indemniteRepository.findOne(indemnite2.getId());
    // vérifications
    Assert.assertEquals(indemnite3.getVersion(), indemnite2.getVersion());
    Assert.assertEquals(0, indemnite.getIndice());
    Assert.assertEquals(0, indemnite.getBaseHeure(), 1e-6);
    Assert.assertEquals(0, indemnite.getEntretienJour(), 1e-6);
    Assert.assertEquals(0, indemnite.getRepasJour(), 1e-6);
    Assert.assertEquals(0, indemnite.getIndemnitesCP(), 1e-6);
    // on supprime l'élément
    indemniteRepository.delete(indemnite3);
    // vérifications
    Indemnite indemnite4 = indemniteRepository.findOne(indemnite3.getId());
    Assert.assertNull(indemnite4);
    indemnites = Lists.newArrayList(indemniteRepository.findAll());
    Assert.assertEquals(nbIndemnites, indemnites.size());
  }

  @Test
  public void test03() {
    log("test03----------------------");
    // on crée une Indemnite
    Indemnite indemnite = indemniteRepository.save(new Indemnite(1, 1.93, 2, 3, 12));
    // liste des employés
    List<Employe> employes = Lists.newArrayList(employeRepository.findAll());
    int nbEmployes = employes.size();
    // on ajoute un employe
    Employe employe = employeRepository.save(new Employe("254104940426058", "Jouveinal", "Marie", "5 rue des oiseaux", "St Corentin", "49203",
      indemnite));
    // on le demande
    employe = employeRepository.findOne(employe.getId());
    // vérification
    Assert.assertNotNull(employe);
    Assert.assertEquals("254104940426058", employe.getSS());
    Assert.assertEquals("Jouveinal", employe.getNom());
    Assert.assertEquals("Marie", employe.getPrenom());
    Assert.assertEquals("5 rue des oiseaux", employe.getAdresse());
    Assert.assertEquals("St Corentin", employe.getVille());
    Assert.assertEquals("49203", employe.getCodePostal());
    Assert.assertEquals((long) indemnite.getId(), (long) employe.getIdIndemnite());
    // on le modifie
    employe.setSS("x");
    employe.setNom("x");
    employe.setPrenom("x");
    employe.setAdresse("x");
    employe.setVille("x");
    employe.setCodePostal("x");
    Employe employe2 = employeRepository.save(employe);
    // vérifications
    Assert.assertEquals((long) employe.getVersion() + 1, (long) employe2.getVersion());
    Assert.assertEquals("x", employe.getSS());
    Assert.assertEquals("x", employe.getSS());
    Assert.assertEquals("x", employe.getPrenom());
    Assert.assertEquals("x", employe.getAdresse());
    Assert.assertEquals("x", employe.getVille());
    Assert.assertEquals("x", employe.getCodePostal());
    Assert.assertEquals((long) indemnite.getId(), (long) employe.getIdIndemnite());
    // on demande l'élément modifié
    Employe employe3 = employeRepository.findOne(employe2.getId());
    // vérifications
    Assert.assertEquals(employe3.getVersion(), employe2.getVersion());
    // on supprime l'employé
    employeRepository.delete(employe3);
    // vérifications
    Employe employe4 = employeRepository.findOne(employe3.getId());
    Assert.assertNull(employe4);
    employes = Lists.newArrayList(employeRepository.findAll());
    Assert.assertEquals(nbEmployes, employes.size());
    // on supprime l'indemnite
    indemniteRepository.delete(indemnite);
    // vérifications
    Indemnite indemnite2 = indemniteRepository.findOne(indemnite.getId());
    Assert.assertNull(indemnite2);
  }

  @Test
  public void test04() {
    log("test04");
    // on crée une Indemnite
    Indemnite indemnite = indemniteRepository.save(new Indemnite(1, 1.93, 2, 3, 12));
    // on ajoute un employe
    Employe employe = employeRepository.save(new Employe("254104940426058", "Jouveinal", "Marie", "5 rue des oiseaux", "St Corentin", "49203",
      indemnite));
    // on le demande
    employe = employeRepository.findBySS(employe.getSS()).iterator().next();
    // vérifications
    Assert.assertNotNull(employe);
    Assert.assertEquals("254104940426058", employe.getSS());
    Assert.assertEquals("Jouveinal", employe.getNom());
    Assert.assertEquals("Marie", employe.getPrenom());
    Assert.assertEquals("5 rue des oiseaux", employe.getAdresse());
    Assert.assertEquals("St Corentin", employe.getVille());
    Assert.assertEquals("49203", employe.getCodePostal());
    Assert.assertEquals(indemnite, employe.getIndemnite());
    // on cherche un employé inexistant
    Boolean existe = employeRepository.findBySS("xx").iterator().hasNext();
    // vérification
    Assert.assertFalse(existe);
    // on supprime le 1er employé
    employeRepository.delete(employe);
    // vérifications
    Employe employe3 = employeRepository.findOne(employe.getId());
    Assert.assertNull(employe3);
    // on supprime l'indemnite
    indemniteRepository.delete(indemnite);
    // vérifications
    Indemnite indemnite2 = indemniteRepository.findOne(indemnite.getId());
    Assert.assertNull(indemnite2);
  }

  @Test
  public void test05() {
    log("test05-------------------------------");
    // on crée deux indemnités avec le même indice
    // enfreint la contrainte d'unicité de l'indice
    boolean erreur = false;
    Indemnite indemnite1 = null;
    Indemnite indemnite2 = null;
    Throwable th = null;
    try {
      indemnite1 = indemniteRepository.save(new Indemnite(1, 1.93, 2, 3, 12));
      indemnite2 = indemniteRepository.save(new Indemnite(1, 1.93, 2, 3, 12));
      erreur = false;
    } catch (Throwable th1) {
      erreur = true;
      th = th1;
    }
    // vérifications
    Assert.assertTrue(erreur);
    // chaîne des exceptions
    System.out.println("Chaîne des exceptions --------------------------------------");
    while (th != null) {
      System.out.println(th.getClass().getName());
      th = th.getCause();
    }
    // la 1ère indemnité a du être persistée
    Indemnite indemnite = indemniteRepository.findOne(indemnite1.getId());
    // vérification
    Assert.assertNotNull(indemnite);
    Assert.assertEquals(1, indemnite.getIndice());
    Assert.assertEquals(1.93, indemnite.getBaseHeure(), 1e-6);
    Assert.assertEquals(2, indemnite.getEntretienJour(), 1e-6);
    Assert.assertEquals(3, indemnite.getRepasJour(), 1e-6);
    Assert.assertEquals(12, indemnite.getIndemnitesCP(), 1e-6);
    // la seconde indemnité n'a pas du être persistée
    List<Indemnite> indemnites = Lists.newArrayList(indemniteRepository.findAll());
    int nbIndemnites = indemnites.size();
    Assert.assertEquals(nbIndemnites, 1);
  }

  @Test
  public void test06() {
    log("test06------------------------------");
    // on crée deux employés avec le même n° SS
    // enfreint la contrainte d'unicité sur le n° SS
    boolean erreur = true;
    Employe employe1 = null;
    Employe employe2 = null;
    Indemnite indemnite1 = null;
    Indemnite indemnite2 = null;
    Throwable th = null;
    try {
      indemnite1 = new Indemnite(1, 1.93, 2, 3, 12);
      indemnite2 = new Indemnite(2, 2.1, 2.1, 3.1, 15);
      indemnite1 = indemniteRepository.save(indemnite1);
      indemnite2 = indemniteRepository.save(indemnite2);
      employe1 = employeRepository.save(new Employe("254104940426058", "Jouveinal", "Marie", "5 rue des oiseaux", "St Corentin", "49203", indemnite1));
      employe2 = employeRepository.save(new Employe("254104940426058", "Jouveinal", "Marie", "5 rue des oiseaux", "St Corentin", "49203", indemnite2));
      erreur = false;
    } catch (Throwable th1) {
      th = th1;
    }
    // vérifications
    Assert.assertTrue(erreur);
    // chaîne des exceptions
    System.out.println("Chaîne des exceptions --------------------------------------");
    System.out.println(th.getClass().getName());
    while (th.getCause() != null) {
      th = th.getCause();
      System.out.println(th.getClass().getName());
    }
    // le 1er employé a du être persisté
    Employe employe = employeRepository.findOne(employe1.getId());
    // vérification
    Assert.assertNotNull(employe);
    Assert.assertEquals("254104940426058", employe.getSS());
    Assert.assertEquals("Jouveinal", employe.getNom());
    Assert.assertEquals("Marie", employe.getPrenom());
    Assert.assertEquals("5 rue des oiseaux", employe.getAdresse());
    Assert.assertEquals("St Corentin", employe.getVille());
    Assert.assertEquals("49203", employe.getCodePostal());
    Assert.assertEquals((long) indemnite1.getId(), (long) employe.getIdIndemnite());
    // le 2ème employé n'a pas du être persisté
    List<Employe> employes = Lists.newArrayList(employeRepository.findAll());
    int nbEmployes = employes.size();
    Assert.assertEquals(1, nbEmployes);
  }

  @Test
  public void test07() {
    log("test07-----------------------------");
    // on crée deux employés avec le même n° SS (le second avec edit au lieu de create)
    // enfreint la contrainte d'unicité sur le n0 SS
    boolean erreur = false;
    Employe employe1 = null;
    Employe employe2 = null;
    Indemnite indemnite1 = null;
    Indemnite indemnite2 = null;
    Throwable th = null;
    try {
      indemnite1 = new Indemnite(1, 1.93, 2, 3, 12);
      indemnite2 = new Indemnite(2, 2.1, 2.1, 3.1, 15);
      indemnite1 = indemniteRepository.save(indemnite1);
      indemnite2 = indemniteRepository.save(indemnite2);
      employe1 = employeRepository.save(new Employe("254104940426058", "Jouveinal", "Marie", "5 rue des oiseaux", "St Corentin", "49203", indemnite1));
      employe2 = employeRepository.save(new Employe("254104940426058", "Jouveinal", "Marie", "5 rue des oiseaux", "St Corentin", "49203", indemnite2));
    } catch (Throwable th1) {
      erreur = true;
      th = th1;
    }
    // vérifications
    Assert.assertTrue(erreur);
    // chaîne des exceptions
    System.out.println("Chaîne des exceptions --------------------------------------");
    System.out.println(th.getClass().getName());
    while (th.getCause() != null) {
      th = th.getCause();
      System.out.println(th.getClass().getName());
    }
    // le 1er employé a du être persisté
    Employe employe = employeRepository.findOne(employe1.getId());
    // vérification
    Assert.assertNotNull(employe);
    Assert.assertEquals("254104940426058", employe.getSS());
    Assert.assertEquals("Jouveinal", employe.getNom());
    Assert.assertEquals("Marie", employe.getPrenom());
    Assert.assertEquals("5 rue des oiseaux", employe.getAdresse());
    Assert.assertEquals("St Corentin", employe.getVille());
    Assert.assertEquals("49203", employe.getCodePostal());
    Assert.assertEquals((long) indemnite1.getId(), (long) employe.getIdIndemnite());
    // le 2ème employé n'a pas du être persisté
    List<Employe> employes = Lists.newArrayList(employeRepository.findAll());
    int nbEmployes = employes.size();
    Assert.assertEquals(1, nbEmployes);
  }

  @Test
  public void test08() {
    log("test08------------------------");
    // supprimer un employé qui n'existe pas ne provoque pas d'exception
    // il est ajouté puis détruit
    Indemnite indemnite1 = new Indemnite(1, 1.93, 2, 3, 12);
    indemnite1 = indemniteRepository.save(indemnite1);
    employeRepository.delete(new Employe("xyz", "Jouveinal", "Marie", "5 rue des oiseaux", "St Corentin", "49203", indemnite1));
  }

  @Test
  public void test09() {
    log("test09----------------------------------");
    // modifier un employé sans avoir la bonne version
    Throwable th = null;
    boolean erreur = false;
    try {
      Indemnite indemnite1 = new Indemnite(1, 1.93, 2, 3, 12);
      indemnite1 = indemniteRepository.save(indemnite1);
      Employe employe1 = new Employe("xyz", "Jouveinal", "Marie", "5 rue des oiseaux", "St Corentin", "49203", indemnite1);
      employe1 = employeRepository.save(employe1);
      employe1.setSS("ttt");
      Employe employe2 = employeRepository.save(employe1);
      employe1.setSS("abcd");
      Employe employe3 = employeRepository.save(employe1);
    } catch (Exception ex) {
      th = ex;
      erreur = true;
    }
    // vérifications
    Assert.assertTrue(erreur);
    // chaîne des exceptions
    System.out.println("Chaîne des exceptions --------------------------------------");
    while (th != null) {
      System.out.println(th.getClass().getName());
      th = th.getCause();
    }
  }

  @Test
  public void test10() {
    log("test10--------------------");
    // supprimer un employé sans avoir la bonne version
    boolean erreur = false;
    Throwable th = null;
    try {
      Indemnite indemnite1 = new Indemnite(1, 1.93, 2, 3, 12);
      indemnite1 = indemniteRepository.save(indemnite1);
      Employe employe1 = new Employe("xyz", "Jouveinal", "Marie", "5 rue des oiseaux", "St Corentin", "49203", indemnite1);
      employe1 = employeRepository.save(employe1);
      employe1.setSS("ttt");
      Employe employe2 = employeRepository.save(employe1);
      employeRepository.delete(employe1);
    } catch (Exception ex) {
      erreur = true;
      th = ex;
    }
    // vérifications
    Assert.assertTrue(erreur);
    // chaîne des exceptions
    System.out.println("Chaîne des exceptions --------------------------------------");
    while (th != null) {
      System.out.println(th.getClass().getName());
      th = th.getCause();
    }
  }


}
