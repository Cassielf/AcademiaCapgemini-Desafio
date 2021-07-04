package br.capgemini.cadastro;

import java.io.IOException;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

public class cadastroRun {

	public static void main(String[] args) {

		JOptionPane.showMessageDialog(null, "Seja bem-vindo(a) ao cadastro de anuncios da DivulgaTudo");

		Cadastro cad = new Cadastro();

		// Cadastro de anuncio
		String nomeNovo = JOptionPane.showInputDialog("Digite o nome do anuncio: ");
		cad.setNome(nomeNovo);

		String clienteNovo = JOptionPane.showInputDialog("Digite o nome do cliente: ");
		cad.setCliente(clienteNovo);

		double investimentoDia = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor investido por dia: "));
		cad.setInvestimentoDia(investimentoDia);

		// O input de data tem que ter barra ao inves de hifen!!!!
		DateTimeFormatter formatoI = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate dataInicio = LocalDate.parse(JOptionPane.showInputDialog("Digite a data de inicio: "), formatoI);
		cad.setDataInicio(dataInicio);

		DateTimeFormatter formatoT = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate dataTerminio = LocalDate.parse(JOptionPane.showInputDialog("Digite a data de teminio: "), formatoT);
		cad.setDataTerminio(dataTerminio);

		JOptionPane.showMessageDialog(null, "Cadastro finalizado com sucesso!");

		String relatorio = JOptionPane.showInputDialog("Deseja imprimir o relatório? (S/N)");
		if (relatorio.equalsIgnoreCase("S")) {

			// Relatorio
			// valor investido
			double v = cad.valorTotal(dataInicio, dataTerminio, investimentoDia);
			JOptionPane.showMessageDialog(null, "O valor total investido é de R$ " + v);

			// quantidade maxima de visualizacoes
			int qtvz = cad.qtMaxVisualizacao(v);
			JOptionPane.showMessageDialog(null, "A quantidade maxima de visualizacoes é de : " + qtvz);

			// quantidade máxima de cliques
			int qtclk = cad.totalClick(qtvz);
			JOptionPane.showMessageDialog(null, "Quantidade maxima de cliques: " + qtclk);

			// quantidade máxima de compartilhamentos
			int qtcmp = cad.compartilha(qtclk);
			JOptionPane.showMessageDialog(null, "Quantidade maxima de compartilhamentos: " + qtcmp);

			// visualizacoes geradas a partir do compartilhamento
			int seqvisualizacao = cad.seqVisualizacaoTotal(qtcmp);
			JOptionPane.showMessageDialog(null,
					"A projecao de visualizacoes geradas a partir de compartilhamento é de: " + seqvisualizacao);

			// Gravar arquivos em um .txt
			String grava = JOptionPane.showInputDialog("Deseja gravar os dados? (S/N)");
			if (grava.equalsIgnoreCase("S")) {

				List<String> texto = new ArrayList<String>();

				texto.add("Nome do anuncio");
				texto.add(nomeNovo);
				texto.add("Nome do cliente");
				texto.add(clienteNovo);
				texto.add("Investimento");
				texto.add(String.valueOf(investimentoDia));
				texto.add("Quantidade de visualizacoes");
				texto.add(String.valueOf(qtvz));
				texto.add("Total de cliques");
				texto.add(String.valueOf(qtclk));
				texto.add("Total de compartilhamentos");
				texto.add(String.valueOf(qtcmp));
				texto.add("Total de visualizacoes");
				texto.add(String.valueOf(seqvisualizacao));

				try {
					cad.gravaTextoEmArquivo(texto, "arquivo.txt");
					JOptionPane.showMessageDialog(null, "Dados gravados com sucesso!");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			} else if (grava.equalsIgnoreCase("N")) {
				JOptionPane.showMessageDialog(null, "Aplicacao encerrada, dados não gravados.");
			} else {
				JOptionPane.showMessageDialog(null, "Opcao inválida, digite novamente.");
			}

		} else {
			JOptionPane.showConfirmDialog(null, "Programa finalizado");
		}
	}
}
