package br.dev.Breno.ConversorDeTemperatura.model;

public class Temperatura {
	private double celsius;
	private double fahreinheit;
	private double kelvin;

	public double getCelsius() {
		return celsius;
	}

	public void setCelsius(double celsius) {
		this.celsius = celsius;
	}

	public double converterParaKelvin() {
		kelvin = celsius + 273.15;
		return kelvin;

	}

	public double converterParaFahreinheit() {
		fahreinheit = celsius * 1.8 + 32;
		return fahreinheit;

	}
//	 public String resposta;

	public void exibirDados() {
		System.out.println("Celsius:" + celsius);
		System.out.println("");
		System.out.println("Convertando para fahreinheit:" + fahreinheit);
		System.out.println("");
		System.out.println("Convertando para kelvin:" + kelvin);

	}

}
