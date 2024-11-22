package org.sid.secservice.service;

import org.sid.secservice.entities.AppRole;
import org.sid.secservice.entities.AppUser;
import java.util.List;

public interface AccountService
{


  AppUser addNewUser(AppUser appuser);
  AppRole addNewRole(AppRole appRole);
  void addRoleToUser(String username,String rolename);
  AppUser loadUserByName(String username);
  List<AppUser> loadUsers();

}
