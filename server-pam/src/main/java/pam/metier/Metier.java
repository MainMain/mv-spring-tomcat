package pam.metier;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pam.entities.*;
import pam.repositories.CotisationRepository;
import pam.repositories.EmployeRepository;
import pam.repositories.IndemniteRepository;

import java.util.ArrayList;
import java.util.List;

@Service("métier")
public class Metier implements IMetier {

    // répositories
    @Autowired
    private CotisationRepository cotisationRepository;
    @Autowired
    private EmployeRepository employeRepository;
    @Autowired
    private IndemniteRepository indemniteRepository;

    private double CSGRDS;
    private double CSGD;
    private double SECU;
    private double RETRAITE;
    private double ENTRETIENJOUR;
    private double REPASJOUR;
    private double BASEHEURE;
    private double INDEMNITES_CP;

    @Override
    public List<Employe> getEmployes() {

        try {
            return Lists.newArrayList(employeRepository.findAll());
        } catch (Exception e) {
            return new ArrayList<Employe>();
        }
    }

    @Override
    public FeuilleSalaire getFeuilleSalaire(String SS, double ht, int jt) {

        // variables locales pour les calculs
        double salaireBase;
        double salaireFinal;
        double totalCotisation;
        double totalIndemnites;

        System.out.println(SS);

        // On vérifie s'il y a un employé
        if (!employeRepository.findBySS(SS).iterator().hasNext())
        {
            throw new pam.entities.PamException("Pas d'employé correspondant à ce SS", 101);
        }

        System.out.println(SS);
        // on récupère l'employé
        Employe emp = employeRepository.findBySS(SS).iterator().next();

        // Get indemintes de cet employé
        Indemnite indemnites = emp.getIndemnite();

        // Get cotisations
        Cotisation cotisations = cotisationRepository.findAll().iterator().next();

        ENTRETIENJOUR = indemnites.getEntretienJour();
        REPASJOUR = indemnites.getRepasJour();
        INDEMNITES_CP = indemnites.getIndemnitesCP();
        BASEHEURE = indemnites.getBaseHeure();


        CSGRDS = cotisations.getCsgrds();
        CSGD = cotisations.getCsgd();
        SECU = cotisations.getSecu();
        RETRAITE = cotisations.getRetraite();

        // calculs
        salaireBase = (ht * BASEHEURE) * (1 + (INDEMNITES_CP / 100));

        // cotisations
        totalCotisation = salaireBase * (CSGRDS + CSGD + SECU + RETRAITE) / 100;
        totalIndemnites = jt * (ENTRETIENJOUR + REPASJOUR);

        salaireFinal = salaireBase - totalCotisation + totalIndemnites;

        double indemEntretien = ENTRETIENJOUR * jt;
        double indemRepas = REPASJOUR * jt;

        ElementsSalaire es = new ElementsSalaire(salaireBase, totalCotisation, indemEntretien, indemRepas, salaireFinal);
        FeuilleSalaire fs = new FeuilleSalaire(emp, cotisations, es);

        return fs;
    }
}
