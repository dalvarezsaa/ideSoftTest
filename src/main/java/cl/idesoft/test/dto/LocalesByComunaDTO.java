package cl.idesoft.test.dto;

import java.io.Serializable;
import java.util.List;

public class LocalesByComunaDTO implements Serializable{
	
	private static final long serialVersionUID = -13507260156224697L;
	

	private String local_direccion;
	private String local_telefono;
	private String local_lat;
	private String local_lng;
	
	
	public String getLocal_direccion() {
		return local_direccion;
	}
	public void setLocal_direccion(String local_direccion) {
		this.local_direccion = local_direccion;
	}
	public String getLocal_telefono() {
		return local_telefono;
	}
	public void setLocal_telefono(String local_telefono) {
		this.local_telefono = local_telefono;
	}
	public String getLocal_lat() {
		return local_lat;
	}
	public void setLocal_lat(String local_lat) {
		this.local_lat = local_lat;
	}
	public String getLocal_lng() {
		return local_lng;
	}
	public void setLocal_lng(String local_lng) {
		this.local_lng = local_lng;
	}


	

    
}
