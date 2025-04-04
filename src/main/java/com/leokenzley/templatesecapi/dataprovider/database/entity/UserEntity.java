package com.leokenzley.templatesecapi.dataprovider.database.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

/**
 * Entity class representing a user in the database.
 * This class is mapped to the "users" table in the database.
 */
@Entity
@Table(name = "USERS")
public class UserEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @NotNull(message = "campo nome não pode ser nulo")
  @NotEmpty(message = "campo nome não pode ser vazio")
  private String name;
  @NotNull(message = "campo email não pode ser nulo")
  @NotEmpty(message = "campo email não pode ser vazio")
  private String email;
  @NotNull(message = "campo CPF não pode ser nulo")
  @NotEmpty(message = "campo CPF não pode ser vazio")
  private String cpf;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }
}
