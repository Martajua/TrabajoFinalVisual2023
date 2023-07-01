package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import ar.edu.unju.fi.entity.IndiceMasaCorporal;
import ar.edu.unju.fi.entity.Usuario;
import ar.edu.unju.fi.service.IIndiceMasaCorporalService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/imc")
public class ServicioController {
	
	/*
	 * la anotación @RequestMapping("/imc") indica que todas las solicitudes
	 * que comiencen con "/servicio" serán manejadas por los métodos de este
	 * controlador. Por ejemplo, si hay un método en el controlador con la
	 * anotación @GetMapping("/listado"), se mapeará a la URL "/imc/listado".
	 */
	
	@Autowired
	private IIndiceMasaCorporalService imcService;
	
	/**
	 * Metodo que captura una peticion http en la forma de una url devuelve la
	 * pagina a mostrar.
	 * 
	 * @return
	 */
	
	@GetMapping("/inicioServicios")
	public String getInicioServicios() {
		return "servicios";
	}
	
	/**
	 * recibe un id y muestra en la vista los registros de IMC de una persona.
	 * @param model
	 * @param id
	 * @return
	 */
	@GetMapping("/listado/{id}")
	public String getListaIMCPage(Model model, @PathVariable(value = "id") Long id) {
		//metodos de la capa service
		return "VISTA DE REGISTROS IMC";
	}
	
	/**
	 * La función de este método es mostrar la página para calcular el IMC 
	 * del usuario correspondiente al id de usuario proporcionado.
	 * @param id
	 * @param model
	 * @param usuario
	 * @return
	 */
	@GetMapping("/calcular/{id}")
    public String calcularIMC(@PathVariable(value = "id") Long id, Model model, Usuario usuario) {
          //metodos de la capa service
        return "calcular_imc";
    }
	
	/**
	 * Este método recibe el código de usuario como parte de la URL, captura los datos enviados en el
	 * formulario como un objeto de la entidad IndiceMasaCorporal, realiza la validación de dicho objeto y
	 * maneja los errores de validación. Luego, agrega el objeto "imc" y otros datos al modelo para ser
	 * utilizados en la vista correspondiente.
	 * @param id
	 * @param imc
	 * @param result
	 * @param model
	 * @return
	 */
	
	@PostMapping("/calcular/{id}")
    public String guardarIMC(@Valid @PathVariable(value = "id") Long id, @ModelAttribute("imc")  IndiceMasaCorporal imc,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
        	//metodos de la capa service
            return "calcular_imc";
        }
        
      //metodos de la capa service
        
        return "redirect:/imc/listado";
    }
}
