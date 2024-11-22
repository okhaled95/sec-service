package org.sid.secservice.service;

import org.sid.secservice.entities.AppRole;
import org.sid.secservice.entities.AppUser;
import org.sid.secservice.repository.AppRoleRepository;
import org.sid.secservice.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AccountServiceImpl implements AccountService
{
  final AppRoleRepository appRoleRepository;
  final AppUserRepository appUserRepository;

  public AccountServiceImpl(AppRoleRepository appRoleRepository, AppUserRepository appUserRepository)
  {
    this.appRoleRepository = appRoleRepository;
    this.appUserRepository = appUserRepository;
  }

  @Override
  public AppUser addNewUser(AppUser appuser)
  {
    return appUserRepository.save(appuser);
  }

  @Override
  public AppRole addNewRole(AppRole appRole)
  {
    return appRoleRepository.save(appRole);
  }

  @Override
  public void addRoleToUser(String username, String rolename)
  {
    AppUser appuser = appUserRepository.findByusername(username);
    AppRole approle = appRoleRepository.findByrolename(rolename);
    appuser.getApproles().add(approle);

  }

  @Override
  public AppUser loadUserByName(String username)
  {
    return appUserRepository.findByusername(username);
  }

  @Override
  public List<AppUser> loadUsers()
  {
    return appUserRepository.findAll();
  }
}
