package br.edu.up.sistemapedido.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Conexao {
	
   static EntityManagerFactory emf = Persistence.createEntityManagerFactory("aulaweb2020");
	
   public static EntityManagerFactory getInstance() {
	   return emf;
   }
}
