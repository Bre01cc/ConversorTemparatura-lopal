package br.dev.Breno.ConversorDeTemperatura.gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import br.dev.Breno.ConversorDeTemperatura.model.Temperatura;

public class TelaTemperatura {
	private JTextField textCelsius;
	private JLabel labelCelsius;
	private JButton buttonFahreinheit;
	private JButton buttonKelvin;
	private JLabel labelResultado;
	private JLabel labelMensagemErro;
	private String tituloDaTela;

	public void criarTelaConversor(String tituloDaTela) {
		this.tituloDaTela = tituloDaTela;
		JFrame tela = new JFrame();
		tela.setTitle(this.tituloDaTela);
		tela.setSize(500, 400);// definindo o tamanho da tela
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tela.setResizable(false);
		tela.setLayout(null);

		Container container = tela.getContentPane();

		// Inicializando o JLabel
		labelCelsius = new JLabel();
		labelCelsius.setText("Temperatura em graus Celsius:");
		labelCelsius.setBounds(50, 40, 300, 40);

		textCelsius = new JTextField();
		textCelsius.setBounds(50, 70, 310, 25);

		buttonFahreinheit = new JButton();
		buttonFahreinheit.setText("FAHRENHEIT");
		buttonFahreinheit.setBounds(50, 100, 150, 40);

		buttonKelvin = new JButton();
		buttonKelvin.setText("KELVIN");
		buttonKelvin.setBounds(210, 100, 150, 40);

		labelResultado = new JLabel();
		labelResultado.setFont(new Font("Arial",1, 18));
		labelResultado.setBounds(150, 150, 250, 60);
		labelResultado.setVisible(false);

		labelMensagemErro = new JLabel();
		labelMensagemErro.setText("DADOS FORNECIDOS CONTEM ERROS");
		labelMensagemErro.setForeground(Color.RED);
		labelMensagemErro.setBounds(100, 175, 250, 60);
		labelMensagemErro.setVisible(false);
	

		container.add(labelCelsius);
		container.add(textCelsius);
		container.add(buttonFahreinheit);
		container.add(buttonKelvin);
		container.add(labelResultado);
		container.add(labelMensagemErro);
		
		buttonFahreinheit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
//			String celsiusL= textCelsius.getText();
//			
//			double celsiusLDouble = Double.parseDouble(celsiusL);
//			Temperatura temperatura = new Temperatura();
//			temperatura.setCelsius(celsiusLDouble);
//			temperatura.converterParaFahreinheit();
//			labelResultado.setVisible(true);
				
		
			}
		

	});
		buttonKelvin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
//			String celsiusL= textCelsius.getText();
//			
//			double celsiusLDouble = Double.parseDouble(celsiusL);
//			Temperatura temperatura = new Temperatura();
//			temperatura.setCelsius(celsiusLDouble);
//			temperatura.converterParaFahreinheit();
//			labelResultado.setVisible(true);
				textCelsius.requestFocus();
				
		
			}
		

	});
		
		
		
		

		tela.setVisible(true);

	}

}
