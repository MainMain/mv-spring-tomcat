package pam.client.dao;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pam.client.entities.Employe;
import pam.client.entities.FeuilleSalaire;
import pam.client.entities.PamException;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class Dao implements IDao {

  // client REST
  private final RestTemplate restTemplate;
  // délai d'attente maximal
  private int timeout;
  // URL du service REST
  private String urlServiceRest;

  // constructeur
  public Dao() {
    // on crée un objet [RestTemplate]
    restTemplate = new RestTemplate();
    // on le configure - il doit être capable de gérer la chaîne JSON qu'il va recevoir
    restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
  }

  private void checkResponsiveness(String urlService) {
    // on crée l'URI du service distant
    String url = urlService.replace("{", "").replace("}", "");
    // on vérifie que [url] ressemble à une URL
    URI service = null;
    boolean erreur = false;
    try {
      service = new URI(url);
      erreur = service.getHost() == null && service.getPort() == -1;
    } catch (URISyntaxException ex) {
      erreur = true;
    }
    // erreur ?
    if (erreur) {
      throw new PamException(String.format("Format d'URL incorrect [%s]", url),100);
    }
    // on se connecte au service
    Socket client = null;
    try {
      // on se connecte au service avec attente maximale définie par configuration
      client = new Socket();
      client.connect(new InetSocketAddress(service.getHost(), service.getPort()), timeout);
    } catch (Exception e) {
      throw new PamException("Le service distant n'a pas répondu assez vite", e,101);
    } finally {
      // on libère les ressources
      if (client != null) {
        try {
          client.close();
        } catch (IOException ex) {
          Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
    }
  }


  @Override
  public List<Employe> getEmployes() {
    // on vérifie que le serveur distant répond assez vite
    // une exception est lancée sinon
    checkResponsiveness(urlServiceRest);
    // on interroge le service
    String urlService = String.format("%s/%s", urlServiceRest, "employes");
    EmployesResponse response = restTemplate.getForObject(urlService, EmployesResponse.class);
    // on analyse la réponse
    int erreur = response.getErreur();
    if (erreur == 0) {
      return response.getEmployés();
    } else {
      throw new PamException(getMessageFromMessages(response.getMessages()),103);
    }
  }

  private String getMessageFromMessages(List<String> messages) {
    StringBuffer buffer = new StringBuffer();
    for (String message : messages) {
      buffer.append(message + "\n");
    }
    return buffer.toString();
  }

  @Override
  public FeuilleSalaire getFeuilleSalaire(String SS, double ht, int jt) {
    return null;
  }

  // délai d'attente maximal
  public void setTimeout(int millis) {
    this.timeout = millis;
  }

  @Override
  public void setUrlServiceRest(String urlServiceRest) {
    this.urlServiceRest = urlServiceRest;
  }

}
