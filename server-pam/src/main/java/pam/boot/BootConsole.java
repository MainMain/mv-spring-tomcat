package pam.boot;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pam.config.DomainAndPersistenceConfig;
import pam.entities.Employe;
import pam.metier.IMetier;

import java.util.List;

public class BootConsole {
  // le boot
  public static void main(String[] args) {
    // configuration Spring
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DomainAndPersistenceConfig.class);
    // couche [métier]
    IMetier métier = context.getBean("métier",IMetier.class);
    // liste des employés
    List<Employe> employés = métier.getEmployes();
    display("Employés", employés);
    // salaire
    Employe employé = employés.get(0);
    String SS = employé.getSS();
    double ht = 150;
    int jt = 20;
    System.out.println(String.format("Salaire de %s %s (%s, %s, %s) : %s", employé.getPrenom(), employé.getNom(), SS, ht, jt,
      métier.getFeuilleSalaire(SS, ht, jt)));
    // fermeture du contexte Spring
    context.close();
  }

  // méthode utilitaire - affiche les éléments d'une collection
  private static <T> void display(String message, Iterable<T> elements) {
    System.out.println(message);
    for (T element : elements) {
      System.out.println(element);
    }
  }

}
