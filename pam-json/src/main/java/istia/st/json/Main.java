package istia.st.json;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {
  // l'outil de sérialisation / désérialisation
  static ObjectMapper mapper = new ObjectMapper();

  public static void main(String[] args) throws IOException {
    // création d'une personne
    Personne paul = new Personne("Denis", "Paul", 40);
    // affichage Json
    String json = mapper.writeValueAsString(paul);
    System.out.println("Json=" + json);
    // instanciation Personne à partir du Json
    Personne p = mapper.readValue(json, Personne.class);
    // affichage personne
    System.out.println("Personne=" + p);
    // un tableau
    Personne virginie = new Personne("Radot", "Virginie", 20);
    Personne[] personnes = new Personne[]{paul, virginie};
    // affichage Json
    json = mapper.writeValueAsString(personnes);
    System.out.println("Json personnes=" + json);
    // dictionnaire
    Map<String, Personne> hpersonnes = new HashMap<String, Personne>();
    hpersonnes.put("1", paul);
    hpersonnes.put("2", virginie);
    // affichage Json
    json = mapper.writeValueAsString(hpersonnes);
    System.out.println("Json hpersonnes=" + json);
  }
}
