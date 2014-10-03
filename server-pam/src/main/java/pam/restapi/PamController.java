package pam.restapi;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
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
    mapper=converter.getObjectMapper();
  }

}
