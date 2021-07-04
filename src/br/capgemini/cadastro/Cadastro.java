package br.capgemini.cadastro;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class Cadastro {

	private String nome;
	private String cliente;
	private LocalDate dataInicio;
	private LocalDate dataTerminio;
	private double investimentoDia;

	public Cadastro() {
	}

	public Cadastro(String nome, String cliente, LocalDate dataInicio, LocalDate dataTerminio, double investimentoDia) {
		this.nome = nome;
		this.cliente = cliente;
		this.dataInicio = dataInicio;
		this.dataTerminio = dataTerminio;
		this.investimentoDia = investimentoDia;
	}

	// valor total investido

	public double valorTotal(LocalDate dataInicio, LocalDate dataTerminio, double investimentoDia) {
		double dias = ChronoUnit.DAYS.between(dataInicio, dataTerminio);
		double valorTotal = dias * investimentoDia;
		return valorTotal;
	}

	// quantidade máxima de visualizações

	public int qtMaxVisualizacao(double valorTotal) {
		int qtMaxVisualizacao = 0;
		for (int k = 0; k < valorTotal; k++) {
			if (valorTotal % 2 != 0) {
				qtMaxVisualizacao = (int) ((valorTotal - 1) * 30);
			} else {
				qtMaxVisualizacao = (int) (valorTotal * 30);
			}

		}
		return qtMaxVisualizacao;
	}
	// quantidade máxima de cliques

	public int totalClick(double qtMaxVisualizacao) {
		int qtClick = 0;
		for (int k = 0; k < qtMaxVisualizacao; k++) {
			if (qtMaxVisualizacao % 100 == 0) {
				qtClick += 12;
			}
		}
		int totalClick = qtClick / 100;
		return totalClick;
	}

	// quantidade máxima de compartilhamentos

	public int compartilha(int qtClick) {
		int compart = 0;
		for (int k = 0; k < qtClick; k++) {
			if (k % 20 == 0) {
				compart += 3;
			}

		}
		int compartilhamento = (compart / 20) / 3;
		return compartilhamento;
	}
	
	// sequencia de compartilhamentos e visualizacoes 
	public int seqVisualizacaoTotal(int compart) {
		int visualizacaoTotal = ((compart / 20) / 3) * 40;
		return visualizacaoTotal;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}

	public LocalDate getDataTerminio() {
		return dataTerminio;
	}

	public void setDataTerminio(LocalDate dataTerminio) {
		this.dataTerminio = dataTerminio;
	}

	public double getInvestimentoDia() {
		return investimentoDia;
	}

	public void setInvestimentoDia(double investimentoDia) {
		this.investimentoDia = investimentoDia;
	}

	public void gravaTextoEmArquivo(List<String> texto, String arquivo) throws IOException {
		BufferedWriter gravador = null;
		try {
			gravador = new BufferedWriter(new FileWriter(arquivo));
			for (String s : texto) {
				gravador.write(s + "\n");
			}
		} finally {
			if (gravador != null) {
				gravador.close();
			}
		}
	}

}
