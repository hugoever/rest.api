package py.edu.ucsa.jweb.rest.api.dto;

public class ErrorDTO {
	private String mensajeError;
	
	public ErrorDTO(String mensajeError) {
		this.mensajeError=mensajeError;
	}
	
	public String getMensajeError() {
		return mensajeError;
	}
}
