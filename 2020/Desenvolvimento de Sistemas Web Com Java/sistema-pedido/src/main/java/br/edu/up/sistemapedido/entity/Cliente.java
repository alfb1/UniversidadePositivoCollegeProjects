package br.edu.up.sistemapedido.entity;

import java.util.ArrayList;


public class Cliente {
  private String nome;
  private String cpf;
  private String email;
  private String idade;
  private String login;
  
   
public String getIdade() {
	return idade;
}
public void setIdade(String idade) {
	this.idade = idade;
}
public String getLogin() {
	return login;
}
public void setLogin(String login) {
	this.login = login;
}
public String getNome() {
	return nome;
}
public void setNome(String nome) {
	this.nome = nome;
}
public String getCpf() {
	return cpf;
}
public void setCpf(String cpf) {
	this.cpf = cpf;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
  
  
}
