package com.codefellows.robobook.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Set;

// Cheat Sheet 1A: Make a User model
@Entity
public class RoboUser implements UserDetails  // Cheat Sheet 4: Implement UserDetails on your user class, filling in needed methods
{
  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  long id;
  String username;  // must be called "username" unless we do additional configuration
  String nickName;
  LocalDate birthday;
  String password;

  // Don't cascade here! The join table will update appropriately when users are removed
  @ManyToMany(mappedBy = "robotsWhoAreMyEmployees")
  Set<RoboUser> robotsWhoManageMe;

  // Don't cascade here! The join table will update appropriately when users are removed
  @ManyToMany
  @JoinTable(
    name = "managers_to_employees",
    joinColumns = {@JoinColumn(name="manager")},
    inverseJoinColumns = {@JoinColumn(name="employee")}
  )
  Set<RoboUser> robotsWhoAreMyEmployees;

  public long getId()
  {
    return id;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities()
  {
    return null;
  }

  @Override
  public String getPassword()
  {
    return password;
  }

  @Override
  public String getUsername()
  {
    return username;
  }

  public void setUsername(String username)
  {
    this.username = username;
  }

  public void setPassword(String password)
  {
    this.password = password;
  }

  public String getNickName()
  {
    return nickName;
  }

  public void setNickName(String nickName)
  {
    this.nickName = nickName;
  }

  public LocalDate getBirthday()
  {
    return birthday;
  }

  public void setBirthday(LocalDate birthday)
  {
    this.birthday = birthday;
  }

  public Set<RoboUser> getRobotsWhoManageMe()
  {
    return robotsWhoManageMe;
  }

  public void setRobotsWhoManageMe(Set<RoboUser> robotsWhoManageMe)
  {
    this.robotsWhoManageMe = robotsWhoManageMe;
  }

  public Set<RoboUser> getRobotsWhoAreMyEmployees()
  {
    return robotsWhoAreMyEmployees;
  }

  public void setRobotsWhoAreMyEmployees(Set<RoboUser> robotsWhoAreMyEmployees)
  {
    this.robotsWhoAreMyEmployees = robotsWhoAreMyEmployees;
  }

  @Override
  public boolean isAccountNonExpired()
  {
    return true;
  }

  @Override
  public boolean isAccountNonLocked()
  {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired()
  {
    return true;
  }

  @Override
  public boolean isEnabled()
  {
    return true;
  }
}
