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
		tela.setResizable(false);
		tela.setLayout(null);

		Container container = tela.getContentPane();
		container.setBackground(Color.blue);
//		tela.setBackground(Color.red);

		// TEXTO
		labelCelsius = new JLabel();
		// Criando objeto JLabel
		labelCelsius.setText("Temperatura em graus Celsius:");
		labelCelsius.setBounds(50, 40, 300, 40);
		// Definindo o tamanho do JLabel

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

		// KELVIN
		buttonKelvin = new JButton();
		// criando objeto JButton
		buttonKelvin.setText("KELVIN");
		// Definindo nome do botão
		buttonKelvin.setBounds(210, 100, 150, 40);
		// Definindo tamanho e posição do botão kelvin.

		// RESULTADOS
		labelResultado = new JLabel();
		labelResultado.setFont(new Font("Arial", 1, 18));
		labelResultado.setBounds(140, 140, 250, 60);
		// Definindo a posição onde o resultado estará visivel
		labelResultado.setVisible(false);
		// Só será visivel quando clicar em um dos botões se celsius for valido

		// ERRO
		labelMensagemErro = new JLabel();
		// Criando objeto JLabel
		labelMensagemErro.setForeground(Color.red);
		// Definindo a cor da mensagem de erro para vermelho
		Font fonte = new Font("courier New", Font.ITALIC, 20);
		labelMensagemErro.setFont(fonte);
		// Definindo a fonte da mensagens
		labelMensagemErro.setBounds(100, 160, 370, 60);
		labelMensagemErro.setVisible(false);
		// Só estará visivel quando ocorrer um erro

		// Adicionando os componentes no Painel de conteúdo do JFrame
		container.add(labelCelsius);
		container.add(textCelsius);
		container.add(buttonFahrenheit);
		container.add(buttonKelvin);
		container.add(labelResultado);
		container.add(labelMensagemErro);

		// FAHRENHEIT
		buttonFahrenheit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// os comandos try e catch é parecido com if e else, try vai rodar o codigo e se
				// não for possivel o catch vai exibir a mensagem de erro
				try {
					labelMensagemErro.setVisible(false);
					// quando for valido a mensagem anterior de erro ficará invisivel

					String celsiusL = textCelsius.getText();
					double celsiusLDouble = Double.parseDouble(celsiusL);
					// as duas linhas a cima são para converter uma String em double
					Temperatura temperatura = new Temperatura();
					// Criando objeto temperatura
					temperatura.setCelsius(celsiusLDouble);
					// Inserindo o valor de celsius, após String ser convertida em double

					if (temperatura.getCelsius() > -274) {
						labelResultado.setVisible(true);
						
						double fahreinheit = temperatura.converterParaFahrenheit();
						labelResultado.setText(String.format("%.2f", fahreinheit) + "FAHRENHEIT");
						
						// criando uma variavel para armazenar o converter fahreinheit temperatura
						// Mensagem que será exibida, tendo uma formatação nos números decimais
					} else {
//						labelResultado.setVisible(false);
						labelResultado.setVisible(false);
						labelMensagemErro.setText("CELSIUS INVALIDO");
						labelMensagemErro.setVisible(true);

						// Verificando se celsius é valido para realizar a conversão se não exibir uma
						// mensagem de erro
					}

					// Deixando visivel o resultado
					textCelsius.requestFocus();

				} catch (NumberFormatException erro) {
					labelResultado.setVisible(false);
					// Quando ocorrer um erro o resultado anterior ficará invisivel

					labelMensagemErro.setBounds(55, 140, 370, 60);
					labelMensagemErro.setText("FORMATO INSERIDO INVALIDO");
					// Quando os comandos no try não poderem ser executados o labelMensagemErro será
					// visivel
					labelMensagemErro.setVisible(true);

				}
			}

		});
		// KELVIN
		buttonKelvin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					labelMensagemErro.setVisible(false);
					// quando for valido a mensagem anterior de erro ficará invisivel
					String celsiusL = textCelsius.getText();
					double celsiusLDouble = Double.parseDouble(celsiusL);
					// as duas linhas a cima são para converter uma String em double
					Temperatura temperatura = new Temperatura();
					// Criando objeto temperatura
					temperatura.setCelsius(celsiusLDouble);

					double kelvin = temperatura.converterParaKelvin();
					// criando uma variavel para armazenar o converter para kelvin temperatura

					if (temperatura.getCelsius() > -274) {
						labelResultado.setText(String.format("%.2f", kelvin) + "KELVIN");
					} else {
						labelResultado.setVisible(false);
						labelMensagemErro.setText("CELSIUS INVALIDO");
						labelMensagemErro.setVisible(true);
						// Verificando se celsius é valido para realizar a conversão se não exibir uma
						// mensagem de erro
					}
					textCelsius.requestFocus();
					labelResultado.setVisible(true);

				} catch (NumberFormatException erro) {
					labelResultado.setVisible(false);
					// Quando ocorrer um erro o resultado anterior ficará invisivel
					labelMensagemErro.setBounds(55, 140, 370, 60);
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
