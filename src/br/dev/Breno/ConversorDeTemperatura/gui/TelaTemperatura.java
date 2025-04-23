package br.dev.Breno.ConversorDeTemperatura.gui;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class TelaTemperatura {
	private JTextArea textCelsius;
	private JLabel labelCelsius;
	private JLabel labelResultado;
	private JButton buttonFahreinheit;
	private JButton buttonKelvin;
	public JTextArea getTextCelsius() {
		return textCelsius;
	}
	public void setTextCelsius(JTextArea textCelsius) {
		this.textCelsius = textCelsius;
	}
	public JLabel getLabelCelsius() {
		return labelCelsius;
	}
	public void setLabelCelsius(JLabel labelCelsius) {
		this.labelCelsius = labelCelsius;
	}
	public JLabel getLabelResultado() {
		return labelResultado;
	}
	public void setLabelResultado(JLabel labelResultado) {
		this.labelResultado = labelResultado;
	}
	public JButton getButtonFahreinheit() {
		return buttonFahreinheit;
	}
	public void setButtonFahreinheit(JButton buttonFahreinheit) {
		this.buttonFahreinheit = buttonFahreinheit;
	}
	public JButton getButtonKelvin() {
		return buttonKelvin;
	}
	public void setButtonKelvin(JButton buttonKelvin) {
		this.buttonKelvin = buttonKelvin;
	}
	
	
	
	
}
