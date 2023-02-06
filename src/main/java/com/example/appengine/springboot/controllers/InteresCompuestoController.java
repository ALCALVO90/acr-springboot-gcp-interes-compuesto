package com.example.appengine.springboot.controllers;

import static com.example.appengine.springboot.models.InteresCompuestoConstructorModel.getResult;

//import java.math.BigDecimal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.appengine.springboot.models.InteresCompuestoResultadoModel;

//LOCALHOST
//http://localhost:8080/servicios/calculomontofinal?saldoInicial=5000&tasaDeInteres=21&tiempo=5
//http://localhost:8080/servicios/calculointerescompuesto?saldoInicial=5000&tasaDeInteres=21&tiempo=5

//GCP
//https://acr-interes-compuesto.uc.r.appspot.com/servicios/calculomontofinal?saldoInicial=5000&tasaDeInteres=21&tiempo=5
//https://acr-interes-compuesto.uc.r.appspot.com/servicios/calculointerescompuesto?saldoInicial=5000&tasaDeInteres=21&tiempo=5


@RestController
@RequestMapping("/servicios")
public class InteresCompuestoController {
	
	@GetMapping("/calculomontofinal")
	public InteresCompuestoResultadoModel metodoMontoFinal(
			@RequestParam double saldoInicial,
			@RequestParam double tasaDeInteres,
			@RequestParam double tiempo) {
		
		double montoFinal;
		
		montoFinal = Math.pow(1.0 + tasaDeInteres / 100, tiempo) * saldoInicial;
		
		return getResult(montoFinal);
	}
	
	@GetMapping("/calculointerescompuesto")
	public InteresCompuestoResultadoModel metodoInteresCompuesto(
			@RequestParam double saldoInicial,
			@RequestParam double tasaDeInteres,
			@RequestParam double tiempo) {
		
		double interesCompuesto;
		
		interesCompuesto = (Math.pow(1.0 + tasaDeInteres / 100, tiempo) * saldoInicial)-(saldoInicial);
		
		return getResult(interesCompuesto);
	}
	

}
