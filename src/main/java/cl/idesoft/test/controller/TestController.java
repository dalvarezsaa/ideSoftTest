package cl.idesoft.test.controller;





import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.idesoft.test.dto.LocalesByComunaDTO;
import cl.idesoft.test.service.TestService;



@RestController
@RequestMapping(value = "/idesoft/test")
public class TestController {
	
	@Autowired
	private TestService testService;
	
	final static Logger logg = Logger.getLogger(TestController.class);
	
	 @GetMapping(value = "/localesporcomuna/{id_region}", 
			 produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
	 )
	 	public List<LocalesByComunaDTO> getLocalesByComuna(@PathVariable("id_region") String id_region){
		 	logg.info("TestController.getLocalesByComuna start");
		 	List<LocalesByComunaDTO> res = testService.getDatosLocalesByLocal(id_region);
		 	logg.info("TestController.getLocalesByComuna fin");
		 	return res;
	        
	    }
}
