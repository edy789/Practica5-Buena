package Dominio;

public class ExtrasVehiTurismos {
	private int identificador;
	private String descripcion;

	
	public ExtrasVehiTurismos(int identificador, String descripcion) {
		this.identificador = identificador;
		this.descripcion = descripcion;
	}

	public int getIdentificador() {
		return identificador;
	}

	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	@Override
	public String toString() {
		return "ExtrasVehiTurismos [identificador=" + identificador + ", descripcion=" + descripcion + "]";
	}
	
	
	
}
