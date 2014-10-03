package pam.boot;

import org.springframework.boot.SpringApplication;
import pam.config.AppConfig;

public class BootWeb {
  public static void main(String[] args) {
    SpringApplication.run(AppConfig.class, args);
  }

}
