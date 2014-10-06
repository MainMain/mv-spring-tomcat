package metier;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pam.config.DomainAndPersistenceConfig;
import pam.entities.PamException;
import pam.metier.IMetier;

@SpringApplicationConfiguration(classes = DomainAndPersistenceConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class JUnitMetier {

  @Autowired
  @Qualifier("métier")
  private IMetier metier;

  @Test
  public void test1() {
    Assert.assertEquals(72.4, metier.getFeuilleSalaire("260124402111742", 30, 5).getElementsSalaire().getSalaireNet(), 1e-6);
    Assert.assertEquals(368.77, metier.getFeuilleSalaire("254104940426058", 150, 20).getElementsSalaire().getSalaireNet(), 1e-6);
    int code = 0;
    try {
      metier.getFeuilleSalaire("xx", 150, 20);
    } catch (PamException ex) {
      code = ex.getCode();
    }
    Assert.assertEquals(101, code);
  }
}
