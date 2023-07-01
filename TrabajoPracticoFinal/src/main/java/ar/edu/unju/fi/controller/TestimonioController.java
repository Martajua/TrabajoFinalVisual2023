package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.entity.Testimonio;
import ar.edu.unju.fi.service.ITestimonioService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("testimonio")
public class TestimonioController {
	
	/*
	 * la anotación @RequestMapping("/testimonio") indica que todas las solicitudes
	 * que comiencen con "/testimonio" serán manejadas por los métodos de este
	 * controlador. Por ejemplo, si hay un método en el controlador con la
	 * anotación @GetMapping("/listado"), se mapeará a la URL "/testimonio/listado".
	 */
	@Autowired
	private ITestimonioService testimonioService;
	
	/**
	 * Metodo que captura una peticion http en la forma de una url devuelve la
	 * pagina a mostrar.
	 * 
	 * @return
	 */
	@GetMapping("/listado")
	public String getListaTestimonios(Model model) {
		// metodos de la capa service
		return "recetas";
	}
	
	/*
	 * Carga la vista del formulario. Cuando la variable edición sea falsa se va a
	 * cargar el formulario para realizar un alta
	 * 
	 */
	
	@GetMapping("/nuevo")
	public String getNuevoTestimonio(Model model) {
		boolean edicion = false;
		//metodos de la capa service
		model.addAttribute("edicion", edicion);
		return "recetas";
	}
	
	/*
	 * Recibe los datos enviados por el formulario y realiza el alta de un registro
	 * 
	 */
	
	@PostMapping("/guardar")
	public ModelAndView getGuardarTestimonio(@Valid @ModelAttribute("testimonio") Testimonio testimonio, BindingResult result) {
	    ModelAndView modelView = new ModelAndView("testimonios");
	    if (result.hasErrors()) {
	        modelView.setViewName("testimonios");
	      //metodos de la capa service
	        modelView.addObject("testimonio", testimonio);
	        return modelView;
	    }
	    // métodos de la capa service
	    return modelView;
	}
	
	/*
	 * Carga la vista del formulario. Cuando la variable edición sea "verdadera" se
	 * carga en el formulario los datos para modificarlos de acuerdo al ID
	 * establecido
	 */
	
	@GetMapping("/modificar/{id}")
	public String getModificarTestimonio(Model model, @PathVariable(value = "id") Long id) {
		boolean edicion = true;
		//metodos de la capa service
		model.addAttribute("edicion", edicion);
		return "FORMULARIO DE Testimonios";
	}
	
	/*
	 * Aqui se reciben los datos enviados por el formularios a modificar.
	 * 
	 */
	
	@PostMapping("/modificar")
	public String modificarTestimonio(@Valid @ModelAttribute("testimonio") Testimonio testimonio, BindingResult result, Model model) {
		
		if (result.hasErrors()) {
			//metodos de la capa service
			boolean edicion = true;
			model.addAttribute("edicion", edicion);
			return "FORMULARIO DE Testimonios";
			
		}
		//metodos de la capa service
		return "redirect:/testimonio/listado";
	}
	
	/*
	 * Se elimina una receta de acuerdo al id seleccionado
	 */
	
	@GetMapping("/eliminar/{id}")
	public String getEliminarTestimonio(Model model, @PathVariable(value = "id") Long id) {
		//metodos de la capa service
		return "redirect:/testimonio/listado";
	}
}
