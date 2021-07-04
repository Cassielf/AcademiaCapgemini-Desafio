package br.capgemini.calculadora;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Calculadora {

	private double investimento;

	public Calculadora() {

	}

	public Calculadora(double investimento) {
		this.investimento = investimento;
	}

	// quantidade máxima de visualizações

	public int qtMaxVisualizacao(double investimento) {
		int qtMaxVisualizacao = 0;
		for (int k = 0; k < investimento; k++) {
			if (investimento % 2 != 0) {
				qtMaxVisualizacao = (int) ((investimento - 1) * 30);
			} else {
				qtMaxVisualizacao = (int) (investimento * 30);
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
	public int seqVisualizacaoTotal(int compartilhamento) {
		int visualizacaoTotal = compartilhamento * 40;
		return visualizacaoTotal;
	}

	public double getInvestimento() {
		return investimento;
	}

	public void setInvestimento(double investimento) {
		this.investimento = investimento;
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
