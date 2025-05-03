package br.dev.Breno.ConversorDeTemperatura.model;

public class Temperatura {
	private double celsius;

	// Criando get e set
	public double getCelsius() {

		return celsius;
	}

	public void setCelsius(double celsius) {
		// celsisius não pode ser menor que -273.15, já que esse valor é o zero absoluto
		if (celsius >= -273.15) {
			this.celsius = celsius;
		} else {
			System.out.println("Erro");
		}

	}

//Criando métodos de conversões
	public double converterParaKelvin() {
		double kelvin = celsius + 273.15;
		return kelvin;
	}

	public double converterParaFahrenheit() {
		double fahreinheit = celsius * 1.8 + 32;
		return fahreinheit;

	}

}
