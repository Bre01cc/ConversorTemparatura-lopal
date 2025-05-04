package br.dev.Breno.ConversorDeTemperatura.gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import br.dev.Breno.ConversorDeTemperatura.model.Temperatura;

public class TelaConversor {
	// Atributos da classe TelaTemperatura
	private JTextField textCelsius;
	private JLabel labelCelsius;
	private JButton buttonFahrenheit;
	private JButton buttonKelvin;
	private JLabel labelResultado;
	private JLabel labelMensagemErro;
	private String tituloDaTela;

	// método da classe TelaTemperatura
	public void criarTelaConversor(String tituloDaTela) {
		this.tituloDaTela = tituloDaTela;
		JFrame tela = new JFrame();
		// Criando um objeto JFrame
		tela.setTitle(this.tituloDaTela);
		tela.setSize(420, 400);
		// definindo o tamanho da tela
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Encerrar o programa quando a janela for fechada
		tela.setResizable(false);
		// A janela não vai poder ser redimensionanda
		tela.setLayout(null);
		// Desativando o gerenciamento de layout do JFrame, permitindo posionamento
		// manual dos componentes da tela com coordenadas

		Container container = tela.getContentPane();
		container.setBackground(Color.orange);
		// Definindo cor de fundo do conversor

		// TEXTO
		labelCelsius = new JLabel();
		// Criando objeto JLabel
		labelCelsius.setText("Temperatura em graus Celsius:");
		labelCelsius.setBounds(50, 40, 300, 40);
		// Definindo o tamanho do JLabel
		labelCelsius.setForeground(Color.WHITE);
		// Definindo cor do texto

		// CAIXA DE DIGITAÇÃO
		textCelsius = new JTextField();
		// Criando objeto JTextField
		textCelsius.setBounds(50, 70, 310, 25);
		// Definindo o tamanho e posição da caixa de texto celsius

		// FEHRANHEIT
		buttonFahrenheit = new JButton();
		// Criando objeto JButton
		buttonFahrenheit.setText("FAHRENHEIT");
		// Defnindo nome do botão
		buttonFahrenheit.setBounds(50, 100, 150, 40);
		// Definindo o tamanho e posição do botão Fahreinheit
		buttonFahrenheit.setBackground(Color.yellow);
		// Definindo cor do button

		// KELVIN
		buttonKelvin = new JButton();
		// Criando objeto JButton
		buttonKelvin.setText("KELVIN");
		// Defnindo nome do botão
		buttonKelvin.setBounds(210, 100, 150, 40);
		// Definindo tamanho e posição do botão kelvin.
		buttonKelvin.setBackground(Color.yellow);
		// Definindo cor do button

		// RESULTADOS
		labelResultado = new JLabel();
		// Criando objeto JLabel
		labelResultado.setFont(new Font("Arial", 1, 22));
		// Definindo fonte do resultado
		labelResultado.setBounds(108, 140, 250, 60);
		// Definindo a posição onde o resultado estará visível
		labelResultado.setForeground(Color.WHITE);
		// Definindo cor do resultado
		labelResultado.setVisible(false);
		// Só será visível quando clicar em um dos botões, caso celsius for valido

		// ERRO
		labelMensagemErro = new JLabel();
		// Criando objeto JLabel
		labelMensagemErro.setFont(new Font("Arial", 1, 18));
		// Definindo fonte
		labelMensagemErro.setForeground(Color.RED);
		// Definindo a cor da mensagem de erro para vermelho
		labelMensagemErro.setVisible(false);
		// Só estará visível quando ocorrer um erro

		// Adicionando os componentes no Painel de conteúdo do JFrame
		container.add(labelCelsius);
		container.add(textCelsius);
		container.add(buttonFahrenheit);
		container.add(buttonKelvin);
		container.add(labelResultado);
		container.add(labelMensagemErro);

		// FAHRENHEIT AÇÃO DO BUTTON
		buttonFahrenheit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// os comandos try e catch de certa forma se parece com if e else, comandos
				// serão executados e se ocorrer uma exeção o catch vai exibir a mensagem de
				// erro. Try e catch são ultilizados para tratar exeções.

				try {
					labelMensagemErro.setVisible(false);
					// Mensagem de erro vai estar invisível
					String celsiusL = textCelsius.getText();
					// Criando uma varialvel String que vai armazenar o texto digitado na tela

					String celsiusL1 = celsiusL.replace(',', '.');
					// Convertendo virgulas em ponto

					double celsiusLDouble = Double.parseDouble(celsiusL1);
					// converter uma String em double

					// Criando uma condição para o valor de celsius para que só assim ele possa
					// converter
					if (celsiusLDouble >= -273.15) {
                    //o valor que vai ser convertido em double precisa ser igual ou maior que -273.15
						Temperatura temperatura = new Temperatura();
						// Criando objeto temperatura
						temperatura.setCelsius(celsiusLDouble);
						// Inserindo o valor em celsius, após String ser convertida em double
						double fahreinheit = temperatura.converterParaFahrenheit();
						// criando uma variavel para armazenar o converter para Fahrenheit
						labelResultado.setText(String.format("%.2f", fahreinheit) + "FAHRENHEIT");
						// Mensagem que será exibida, tendo uma formatação nos números decimais
						labelResultado.setVisible(true);
						// Tornando o resultado visível
					} else {
						labelResultado.setVisible(false);
						// Deixando o resultado invisivel
						labelMensagemErro.setText("CELSIUS INVALIDO");
						// Definindo mensagem de erro
						labelMensagemErro.setBounds(125, 140, 370, 60);
						// Definindo localização da mensagem de erro
						labelMensagemErro.setVisible(true);
						// Tornando a mensagem de erro visível

						// Verificando se celsius é valido para realizar a conversão se não exibir uma
						// mensagem de erro
					}
				} catch (NumberFormatException erro) {
					labelResultado.setVisible(false);
					// Quando ocorrer um erro o resultado anterior ficará invisivel
					labelMensagemErro.setBounds(55, 140, 370, 60);
					// Definindo localização da mensagem de erro
					labelMensagemErro.setText("FORMATO INSERIDO INVALIDO");
					// Quando os comandos no try não poderem ser executados o labelMensagemErro será
					// visível
					labelMensagemErro.setVisible(true);
					// Tornando a mensagem de erro visível

				}
			}

		});
		// KELVIN AÇÃO DO BUTTON
		buttonKelvin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {

					labelMensagemErro.setVisible(false);
					// quando for valido a mensagem anterior de erro ficará invisível
					String celsiusL = textCelsius.getText();
					// Criando uma varialvel String que vai armazenar o texto digitado na tela

					String celsiusL1 = celsiusL.replace(',', '.');
					// substituindo vírgula para ponto
					double celsiusLDouble = Double.parseDouble(celsiusL1);
					// converter uma String em double
					// Criando uma condição para o valor de celsius para que só assim ele possa
					// converter
					if (celsiusLDouble >= -273.15) {
						Temperatura temperatura = new Temperatura();
						// Criando objeto temperatura

						temperatura.setCelsius(celsiusLDouble);
						// Inserindo o valor em celsius, após String ser convertida em double

						double kelvin = temperatura.converterParaKelvin();
						// criando variavel que vai guadar o converterParaKelvin
						labelResultado.setText(String.format("%.2f", kelvin) + "KELVIN");
						// Mensagem que será exibida, tendo uma formatação nos números decimais
						labelResultado.setVisible(true);
						// Tornando o resultado visivel
					} else {
						labelResultado.setVisible(false);
						// Deixando o resultado invisível
						labelMensagemErro.setBounds(125, 140, 370, 60);
						// Definindo localização da mensagem de erro
						labelMensagemErro.setText("CELSIUS INVALIDO");
						// Definindo mensagem de erro
						labelMensagemErro.setVisible(true);
						// Verificando se celsius é valido para realizar a conversão se não exibir uma
						// mensagem de erro
					}
					textCelsius.requestFocus();
				} catch (NumberFormatException erro) {
					labelResultado.setVisible(false);
					// Quando ocorrer um erro o resultado anterior ficará invisível
					labelMensagemErro.setBounds(55, 140, 370, 60);
					// Definindo localização da mensagem de erro
					labelMensagemErro.setText("FORMATO INSERIDO INVALIDO");
					// Verificando se celsius é valido para realizar a conversão se não exibir uma
					// mensagem de erro
					labelMensagemErro.setText("FORMATO INSERIDO INVALIDO");
					// Verificando se celsius é valido para realizar a conversão se não exibir uma
					// mensagem de erro
					labelMensagemErro.setVisible(true);
					// Quando os comandos no try não poderem ser executados o labelMensagemErro será
					// visivel

				}

			}

		});

		tela.setVisible(true);

	}
}
