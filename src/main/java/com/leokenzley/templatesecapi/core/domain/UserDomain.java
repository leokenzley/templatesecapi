package com.leokenzley.templatesecapi.core.domain;

/**
 * UserDomain class represents a user entity with properties such as id, name, email, and cpf.
 * It provides constructors, getters, and setters for these properties.
 */
public class UserDomain {
  private Long id;
  private String name;
  private String email;
  private String cpf;

  /**
   * Default constructor for UserDomain.
   */
  public UserDomain() {
  }

  /**
   * Parameterized constructor for UserDomain.
   *
   * @param id    the unique identifier of the user
   * @param name  the name of the user
   * @param email the email address of the user
   * @param cpf   the CPF (Cadastro de Pessoas Físicas) of the user
   */
  public UserDomain(Long id, String name, String email, String cpf) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.cpf = cpf;
  }

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
