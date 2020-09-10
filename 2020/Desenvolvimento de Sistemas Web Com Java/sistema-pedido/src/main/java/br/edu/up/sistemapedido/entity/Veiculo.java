package br.edu.up.sistemapedido.entity;

public class Veiculo {
	private String placa;
	private String marca;
	private String cidade;
	private String uf;
	private int anoFabricacao;
	private int anoModelo;
	private String chassi;
	private String combustivel;
	private String cor;
	private String potencia;
	private String opcionais;
	
	private boolean manual;
	private boolean chaveReserva;
	private boolean macaco;
	private boolean triangulo;
	private boolean step;
	private boolean chaveRoda;

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public int getAnoFabricacao() {
		return anoFabricacao;
	}

	public void setAnoFabricacao(int anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}

	public int getAnoModelo() {
		return anoModelo;
	}

	public void setAnoModelo(int anoModelo) {
		this.anoModelo = anoModelo;
	}

	public String getChassi() {
		return chassi;
	}

	public void setChassi(String chassi) {
		this.chassi = chassi;
	}

	public String getCombustivel() {
		return combustivel;
	}

	public void setCombustivel(String combustivel) {
		this.combustivel = combustivel;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getPotencia() {
		return potencia;
	}

	public void setPotencia(String potencia) {
		this.potencia = potencia;
	}

	public String getOpcionais() {
		return opcionais;
	}

	public void setOpcionais(String opcionais) {
		this.opcionais = opcionais;
	}

	public boolean isManual() {
		return manual;
	}

	public void setManual(boolean manual) {
		this.manual = manual;
	}

	public boolean isChaveReserva() {
		return chaveReserva;
	}

	public void setChaveReserva(boolean chaveReserva) {
		this.chaveReserva = chaveReserva;
	}

	public boolean isMacaco() {
		return macaco;
	}

	public void setMacaco(boolean macaco) {
		this.macaco = macaco;
	}

	public boolean isTriangulo() {
		return triangulo;
	}

	public void setTriangulo(boolean triangulo) {
		this.triangulo = triangulo;
	}

	public boolean isStep() {
		return step;
	}

	public void setStep(boolean step) {
		this.step = step;
	}

	public boolean isChaveRoda() {
		return chaveRoda;
	}

	public void setChaveRoda(boolean chaveRoda) {
		this.chaveRoda = chaveRoda;
	}

}
