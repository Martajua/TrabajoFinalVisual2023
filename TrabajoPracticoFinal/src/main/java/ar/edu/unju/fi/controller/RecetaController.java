package ar.edu.unju.fi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.entity.Receta;
import ar.edu.unju.fi.service.ICommonService;
import ar.edu.unju.fi.service.IIngredienteService;
import ar.edu.unju.fi.service.IRecetaService;
import jakarta.validation.Valid;

@Controller

@RequestMapping("/receta")
public class RecetaController {

	/*
	 * la anotación @RequestMapping("/receta") indica que todas las solicitudes que
	 * comiencen con"/registro" serán manejadas por los métodos de este controlador.
	 * Por ejemplo, si hay un método en el controlador con la
	 * anotación @GetMapping("/listado"), se mapeará a la URL"/receta/listado".
	 */

	@Autowired
	private IRecetaService recetaService;
	
	@Autowired
	private ICommonService commonService;
	
	@Autowired
	private IIngredienteService ingredienteService;
	
	/**
	 * Metodo que captura una peticion http en la forma de una url devuelve la
	 * pagina a mostrar.
	 * 
	 * @return
	 */
	
	@GetMapping("/listado")
	public String getListaRecetas(Model model, @RequestParam(value = "palabraClave", required = false) String palabraClave) {
	    List<Receta> recetas;
	    if (palabraClave != null) {
	        recetas = recetaService.mostrarCategoria(palabraClave);
	    } else {
	        recetas = recetaService.getAllRecetas();
	    }
	    model.addAttribute("recetas", recetas);
	    model.addAttribute("categorias", commonService.getCategorias());
	    return "recetas";
	}
	
	
	/**
	 * recibe la peticion para acceder a la pagina de la tabla de recetas
	 * @param model
	 * @return retorna a la pagina de gestion de recetas
	 */
	@GetMapping("/gestion")
	public String gestionRecetas(Model model) {
		model.addAttribute("recetas", recetaService.getAllRecetas());
		return "gestion_recetas";
	}
	/*
	 * Carga la vista del formulario.Cuando la variable edición sea falsa se va a
	 * cargar el formulario para realizar un alta
	 */

	@GetMapping("/nuevo")
	public String getNuevaReceta(Model model) {
	    boolean edicion = false;
	    Receta nuevaReceta = new Receta(); // Crear una nueva instancia de Receta
	    model.addAttribute("receta", nuevaReceta);
	    model.addAttribute("receta", recetaService.getReceta());
	    model.addAttribute("categorias", commonService.getCategorias());
	    model.addAttribute("listaIngredientes",ingredienteService.getAllIngredientes());
	    model.addAttribute("edicion", edicion);
	    return "form_receta";
	}

	/*
	 * Recibe los datos enviados por el formulario y realiza el alta de una receta
	 */

	@PostMapping("/guardar")

	public ModelAndView getGuardarReceta(@Valid @ModelAttribute("receta") Receta receta, BindingResult result) {
		ModelAndView modelView = new ModelAndView("gestion_recetas");
		if (result.hasErrors()) {
			modelView.setViewName("form_receta");
			modelView.addObject("categorias",commonService.getCategorias());
			modelView.addObject("listaIngredientes",ingredienteService.getAllIngredientes());
			modelView.addObject("receta", receta);
			return modelView;
		}
		receta.setEstado(true);
		recetaService.addModReceta(receta);
		modelView.addObject("recetas",recetaService.getAllRecetas());
		return modelView;
	}

	/*
	 * Carga la vista del formulario.Cuando la variable edición sea"verdadera" se
	 * carga en el formulario los datos para modificarlos de acuerdo al ID
	 * establecido
	 */
	
	@GetMapping("/modificar/{id}")
	public String getModificarReceta(Model model, @PathVariable(value = "id") Long id) {
		boolean edicion = true;
		Receta recetaEncontrada = recetaService.findRecetaById(id);
		model.addAttribute("receta", recetaEncontrada);
		model.addAttribute("categorias", commonService.getCategorias());
		model.addAttribute("listaIngredientes", ingredienteService.getAllIngredientes());
		model.addAttribute("edicion", edicion);
		return "form_receta";
	}
	
	
	/*
	 * Aqui se reciben los datos enviados por el formularios a modificar.
	 */

	  @PostMapping("/modificar/{id}")
	  public String modificarReceta(@Valid @ModelAttribute("receta") Receta receta, BindingResult result, Model model, @PathVariable(value = "id") Long id) {

		if (result.hasErrors()) {
			boolean edicion = true;
			model.addAttribute("categorias", commonService.getCategorias());
			model.addAttribute("listaIngredientes",ingredienteService.getAllIngredientes());
			model.addAttribute("edicion", edicion);
			return "form_receta";
		}
		recetaService.addModReceta(receta);
		return "redirect:/receta/gestion";
	}

	/* Se elimina una receta de acuerdo al id seleccionado */

	@GetMapping("/eliminar/{id}")

	public String getEliminarReceta(Model model, @PathVariable(value = "id") Long id) {
		Receta recetaEncontrada = recetaService.findRecetaById(id);
		recetaService.deleteRecetaById(recetaEncontrada);
		return "redirect:/receta/gestion";
	}
}
