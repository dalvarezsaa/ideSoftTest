package cl.idesoft.test.service.impl;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.impl.client.HttpClients;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import cl.idesoft.test.dto.LocalesByComunaDTO;
import cl.idesoft.test.dto.LocalesDTO;
import cl.idesoft.test.service.TestService;

@Service
public class TestServiceImp implements TestService{
	
	final static Logger logg = Logger.getLogger(TestServiceImp.class);
	
	@Autowired
	private Environment env;
	
	@Override
	public List<LocalesByComunaDTO> getDatosLocalesByLocal(String id_region){
		
		logg.info("TestServiceImp.getDatosLocalesByLocal start");
		List<LocalesByComunaDTO> listaRetorno = new ArrayList<LocalesByComunaDTO>();
		String url = env.getProperty("url.servicio");
		
		ClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory(HttpClients.createDefault());
        RestTemplate restTemplate = new RestTemplate(requestFactory);
        
        String respuesta = restTemplate.getForObject(url, String.class, id_region);
        
        Gson g = new Gson();
        Type userListType = new TypeToken<ArrayList<LocalesDTO>>(){}.getType();
        ArrayList<LocalesDTO> listaLocales = g.fromJson(respuesta, userListType);  
        
        listaLocales.forEach(dato -> {
        	LocalesByComunaDTO dto = new LocalesByComunaDTO();
        	dto.setLocal_direccion(dato.getLocal_direccion());
        	dto.setLocal_telefono(dato.getLocal_telefono());
        	dto.setLocal_lat(dato.getLocal_lat());
        	dto.setLocal_lng(dato.getLocal_lng());
        	
        	listaRetorno.add(dto);
        	
        });
		
        logg.info("TestServiceImp.getDatosLocalesByLocal end");
		return listaRetorno;
	}
	
}
