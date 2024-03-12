package saludar.restcontroller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SaludoRestController {
	
	@GetMapping("/saludar")
	public Map<String, String> saludar() {
		Map<String, String> mapa = new HashMap<String, String>();
		mapa.put("mensaje","Hola me llamo Ivancito");
		return mapa;
	}
	
	
	
}
