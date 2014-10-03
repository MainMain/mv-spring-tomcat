package pam.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Import;

@EnableAutoConfiguration
@Import({ DomainAndPersistenceConfig.class, WebConfig.class})
public class AppConfig {

}
