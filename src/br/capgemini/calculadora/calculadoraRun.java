package br.capgemini.calculadora;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

public class calculadoraRun {

	public static void main(String[] args) {

		JOptionPane.showMessageDialog(null,
				"Calculadora de alcance de anúncio, verifique aqui a quantidade de visualizacoes que seu anuncio terá!");
		Calculadora calc = new Calculadora();

		double inv = Double.parseDouble(JOptionPane.showInputDialog("Quanto voce pretende investir? "));
		calc.setInvestimento(inv);

		int qtviz = calc.qtMaxVisualizacao(inv);
		System.out.println(qtviz);
		int tclick = calc.totalClick(qtviz);
		System.out.println(tclick);
		int cmp = calc.compartilha(tclick);
		System.out.println(cmp);
		int seqviz = calc.seqVisualizacaoTotal(cmp);
		System.out.println(seqviz);

		JOptionPane.showMessageDialog(null, "Seu anuncio pode alcancar " + seqviz + " visualizacoes");

		// Gravar arquivos em um .txt
		List<String> texto = new ArrayList<String>();
		texto.add("Investimento");
		texto.add(String.valueOf(inv));
		texto.add("Quantidade de visualizacoes");
		texto.add(String.valueOf(qtviz));
		texto.add("Total de cliques");
		texto.add(String.valueOf(tclick));
		texto.add("Total de compartilhamentos");
		texto.add(String.valueOf(cmp));
		texto.add("Total de visualizacoes");
		texto.add(String.valueOf(seqviz));

		try {
			calc.gravaTextoEmArquivo(texto, "arquivoCalc.txt");
			JOptionPane.showMessageDialog(null, "Dados gravados com sucesso!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

}
