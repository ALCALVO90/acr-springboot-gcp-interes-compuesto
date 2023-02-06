package com.example.appengine.springboot.models;

import java.math.BigDecimal;

public class InteresCompuestoConstructorModel {

	private InteresCompuestoConstructorModel() {
	}

	public static InteresCompuestoResultadoModel getResult(Object result) {
		return InteresCompuestoResultadoModel.withResult(result.toString());
	}

	public static InteresCompuestoResultadoModel getResult(BigDecimal result) {
		return InteresCompuestoResultadoModel.withResult(result.toPlainString());
	}

	public static InteresCompuestoResultadoModel getResultFromError(String errorMessage) {
		return InteresCompuestoResultadoModel.withError(errorMessage);
	}

}
