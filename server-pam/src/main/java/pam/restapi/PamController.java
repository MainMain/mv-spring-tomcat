package pam.restapi;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pam.entities.Employe;
import pam.entities.PamException;
import pam.helpers.Static;
import pam.metier.FeuilleSalaire;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
public class PamController {

    @Autowired
    private ApplicationModel application;
    @Autowired
    MappingJackson2HttpMessageConverter converter;

    // liste de messages
    private List<String> messages;
    // mapper JSON
    private ObjectMapper mapper;

    @PostConstruct
    public void init() {
        // messages d'erreur de l'application
        messages = application.getMessages();
        // mapper JSON
        mapper = converter.getObjectMapper();
    }

    @RequestMapping(value = "/employes", method = RequestMethod.GET)
    public EmployesResponse getEmployes() {
        EmployesResponse response = new EmployesResponse();
        try
        {
            response.setEmployés(application.getEmployes());
        }
        catch(PamException ex) {
            response.setErreur(4);
            response.setEmployés(new ArrayList<Employe>());
        }

        // sérialisation de la réponse
        SimpleBeanPropertyFilter employeFilter = SimpleBeanPropertyFilter.serializeAllExcept("indemnite");
        mapper.setFilters(new SimpleFilterProvider().addFilter("employeFilter", employeFilter));

        return response;
    }

    @RequestMapping(value = "/salaire/{SS}/{ht}/{jt}", method = RequestMethod.GET)
    public FeuilleSalaireResponse getFeuilleSalaire(
            @PathVariable("SS") String SS,
            @PathVariable("ht") int ht,
            @PathVariable("jt") int jt)
    {
        FeuilleSalaireResponse response = new FeuilleSalaireResponse();
        try
        {
            response.setFeuilleSalaire(application.getFeuilleSalaire(SS, ht, jt));
        }
        catch (PamException ex ) {
            response.setErreur(3);
            response.setFeuilleSalaire(new FeuilleSalaire());
        }

        SimpleBeanPropertyFilter employeFilter = SimpleBeanPropertyFilter.serializeAllExcept();
        mapper.setFilters(new SimpleFilterProvider().addFilter("employeFilter", employeFilter));
        return response;

    }
}
