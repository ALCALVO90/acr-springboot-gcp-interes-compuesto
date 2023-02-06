package com.example.appengine.springboot.models;

public class InteresCompuestoResultadoModel {

	private String result;
	private String error;

	private InteresCompuestoResultadoModel() {
	}

	static InteresCompuestoResultadoModel withResult(String resultMessage) {
		InteresCompuestoResultadoModel apiResult = new InteresCompuestoResultadoModel();
		apiResult.result = resultMessage;
		return apiResult;
	}

	static InteresCompuestoResultadoModel withError(String errorMessage) {
		InteresCompuestoResultadoModel apiResult = new InteresCompuestoResultadoModel();
		apiResult.error = errorMessage;
		return apiResult;
	}

	public String getResult() {
		return result;
	}

	public String getError() {
		return error;
	}

}
