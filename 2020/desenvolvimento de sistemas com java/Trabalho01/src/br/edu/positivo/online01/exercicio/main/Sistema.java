package br.edu.positivo.online01.exercicio.main;

import br.edu.positivo.online01.exercicio.controllers.VendaController;


/**
 * Classe principal do sistema de vendas
 * 
 * @author Andre Luiz Freitas Brito
 * @author Franccescoly Emmanuel Camargo
 *
 */
public class Sistema {
	
	public static void main(String[] args) {
		VendaController venda = new VendaController();
		venda.displayMenuPrincipal();
	}



}
