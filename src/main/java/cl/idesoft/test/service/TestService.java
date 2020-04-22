package cl.idesoft.test.service;

import java.util.List;

import cl.idesoft.test.dto.LocalesByComunaDTO;

public interface TestService {
	
	List<LocalesByComunaDTO> getDatosLocalesByLocal(String id_region);
	
	
	

}
