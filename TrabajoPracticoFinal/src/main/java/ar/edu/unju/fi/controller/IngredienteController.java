package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.entity.Ingrediente;
import ar.edu.unju.fi.service.IIngredienteService;
import jakarta.validation.Valid;

@Controller

@RequestMapping("/ingrediente")
public class IngredienteController {
	
	@Autowired
	private IIngredienteService ingredienteService;

	@GetMapping("/listado")
	public String getListaIngredientes(Model model) {
		model.addAttribute("ingredientes", ingredienteService.getAllIngredientes());
		return "ingredientes";
	}
	
	
	/*
	 * Carga la vista del formulario. Cuando la variable edición sea falsa se va a
	 * cargar el formulario para realizar un alta
	 */

	@GetMapping("/nuevo")
	public String getNuevoIngrediente(Model model) {
		boolean edicion = false;
		model.addAttribute("ingrediente",ingredienteService.getIngrediente());
		model.addAttribute("edicion", edicion);
		return "form_ingrediente";
	}
	
	/*
	 * Recibe los datos enviados por el formulario y realiza el alta de un registro
	 */
	
	@PostMapping("/guardar")
	public ModelAndView getGuardarIngrediente(@Valid @ModelAttribute("ingrediente") Ingrediente ingrediente,
			BindingResult result) {
		ModelAndView modelView = new ModelAndView("ingredientes");
		if (result.hasErrors()) {
			modelView.setViewName("form_ingrediente");
			modelView.addObject("ingrediente", ingrediente);
			return modelView;
		}
		ingrediente.setEstado(true);
		ingredienteService.addModIngrediente(ingrediente);
		modelView.addObject("ingredientes", ingredienteService.getAllIngredientes());
		return modelView;
	}
	
	/*
	 * Carga la vista del formulario. Cuando la variable edición sea "verdadera" se
	 * carga en el formulario los datos para modificarlos de acuerdo al ID
	 * establecido
	 */
	
	@GetMapping("/modificar/{id}")
	public String getModificarIngrediente(Model model, @PathVariable(value = "id") Long id) {
		boolean edicion = true;
		Ingrediente ingredienteEncontrado= ingredienteService.findIngredienteById(id);
		// metodos de la capa service
		model.addAttribute("ingrediente",ingredienteEncontrado);
		model.addAttribute("edicion", edicion);
		return "form_ingrediente";
	}
	
	/* Aqui se reciben los datos enviados por el formularios a modificar y se modifican los datos
	 * del ingrediente existente. */

	@PostMapping("/modificar")
	public String modificarIngrediente(@Valid @ModelAttribute("ingrediente") Ingrediente ingrediente, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			// métodos de la capa service
			boolean edicion = true;
			model.addAttribute("edicion", edicion);
			return "form_ingredientes";
		}
		ingredienteService.addModIngrediente(ingrediente);
		return "redirect:/ingrediente/listado";
	}
	
	/* Se elimina un registro de acuerdo al id seleccionado */

	@GetMapping("/eliminar/{id}")
	public String getEliminarIngrediente(Model model, @PathVariable(value = "id") Long id) {
		Ingrediente ingredienteEncontrado = ingredienteService.findIngredienteById(id);
		ingredienteService.deleteIngredienteById(ingredienteEncontrado);
		return "redirect:/ingrediente/listado";
	}
		
}
