package org.sid.secservice;

import org.sid.secservice.entities.AppRole;
import org.sid.secservice.entities.AppUser;
import org.sid.secservice.service.AccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import java.util.ArrayList;

@SpringBootApplication
public class SecServiceApplication
{

  public static void main(String[] args)
  {
    SpringApplication.run(SecServiceApplication.class, args);
  }

  @Bean
  CommandLineRunner start(AccountService acc)
  {
    return args -> {
      acc.addNewRole((new AppRole(null, "USER")));
      acc.addNewRole((new AppRole(null, "ADMIN")));
      acc.addNewRole((new AppRole(null, "CUSTOMER_MANAGER")));
      acc.addNewRole((new AppRole(null, "PRODUCT_MANAGER")));
      acc.addNewRole((new AppRole(null, "BILLS_MANAGER")));

      acc.addNewUser(new AppUser(null, "user1", "1234", new ArrayList<>()));
      acc.addNewUser(new AppUser(null, "admin", "1234", new ArrayList<>()));
      acc.addNewUser(new AppUser(null, "user2", "1234", new ArrayList<>()));
      acc.addNewUser(new AppUser(null, "user3", "1234", new ArrayList<>()));

      acc.addRoleToUser("user1", "USER");
      acc.addRoleToUser("admin", "USER");
      acc.addRoleToUser("admin", "ADMIN");
      acc.addRoleToUser("user2", "USER");
      acc.addRoleToUser("user2", "CUSTOMER_MANAGER");
      acc.addRoleToUser("user3", "PRODUCT_MANAGER");


    };
  }

}
