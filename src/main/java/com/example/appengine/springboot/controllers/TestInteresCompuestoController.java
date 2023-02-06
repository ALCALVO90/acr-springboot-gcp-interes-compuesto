package com.example.appengine.springboot.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class TestInteresCompuestoController {
	
	//Rutas Locales
	//http://localhost:8080/montofinal/5000/21/5
	//http://localhost:8080/interescompuesto/5000/21/5
	//http://localhost:8080/calculomontofinal?saldoInicial=5000&tasaDeInteres=21&tiempo=5
	//http://localhost:8080/calculointerescompuesto?saldoInicial=5000&tasaDeInteres=21&tiempo=5

	//Rutas GCP
	//https://acr-interes-compuesto.uc.r.appspot.com/montofinal/5000/21/5
	//https://acr-interes-compuesto.uc.r.appspot.com/interescompuesto/5000/21/5
	//https://acr-interes-compuesto.uc.r.appspot.com/calculomontofinal?saldoInicial=5000&tasaDeInteres=21&tiempo=5
	//https://acr-interes-compuesto.uc.r.appspot.com/calculointerescompuesto?saldoInicial=5000&tasaDeInteres=21&tiempo=5
	
	
	//@PathVariable
	@GetMapping(path="montofinal/{saldoInicial}/{tasaDeInteres}/{tiempo}")
	public Double metodoMontoFinal(@PathVariable Double saldoInicial, @PathVariable Double tasaDeInteres, @PathVariable Double tiempo) {
		
		double montoFinal;
		
		montoFinal = Math.pow(1.0 + tasaDeInteres / 100, tiempo) * saldoInicial;
		
		return montoFinal;
	}
	
	
	@GetMapping(path="interescompuesto/{saldoInicial}/{tasaDeInteres}/{tiempo}") 
	public Double metodoInteresCompuesto(@PathVariable Double saldoInicial, @PathVariable Double tasaDeInteres, @PathVariable Double tiempo) {
		
		double interesCompuesto;
		
		interesCompuesto = (Math.pow(1.0 + tasaDeInteres / 100, tiempo) * saldoInicial)-(saldoInicial);
		
		return interesCompuesto;
	}
	
	
	//@RequestParam
	@GetMapping("/calculomontofinal")
	public Double metodoMontoFinalRequest(@RequestParam (value="saldoInicial") double saldoInicial, 
			                  @RequestParam (value="tasaDeInteres") double tasaDeInteres,
			                  @RequestParam (value="tiempo") double tiempo) {
		
		double montoFinal;
		
		montoFinal = Math.pow(1.0 + tasaDeInteres / 100, tiempo) * saldoInicial;
		
		return montoFinal;
	}
	
	@GetMapping("/calculointerescompuesto")
	public Double metodoInteresCompuestoRequest(@RequestParam (value="saldoInicial") double saldoInicial, 
			                  @RequestParam (value="tasaDeInteres") double tasaDeInteres,
			                  @RequestParam (value="tiempo") double tiempo) {
		
		double interesCompuesto;
		
		interesCompuesto = (Math.pow(1.0 + tasaDeInteres / 100, tiempo) * saldoInicial)-(saldoInicial);
		
		return interesCompuesto;
	}
	
}
