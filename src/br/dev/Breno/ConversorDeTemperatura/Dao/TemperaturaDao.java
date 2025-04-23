package br.dev.Breno.ConversorDeTemperatura.Dao;

import java.util.Scanner;

import br.dev.Breno.ConversorDeTemperatura.model.Temperatura;

public class TemperaturaDao {
	public static void CriarTemperatura() {
		Temperatura temperatura = new Temperatura();

		Scanner leitor = new Scanner(System.in);

		System.out.println("Qual a temperatura em graus Celsius?");
		temperatura.setCelsius(leitor.nextDouble());
		System.out.println("Você deseja converter em fahreinheit ou Kelvin");
		
		temperatura.converterParaFahreinheit();
		
		temperatura.converterParaKelvin();
		
		temperatura.exibirDados();

	}

}
