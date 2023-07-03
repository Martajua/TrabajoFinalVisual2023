package ar.edu.unju.fi.controller;

import ar.edu.unju.fi.entity.Ingrediente;
import ar.edu.unju.fi.entity.Receta;
import ar.edu.unju.fi.service.IIngredienteService;
import ar.edu.unju.fi.service.IRecetaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/recetas")
public class RecetaController {

	//region Dependencies
	@Autowired
	private IRecetaService recetaService;

	@Autowired
	private IIngredienteService ingredienteService;

	@Autowired
	private Receta unaReceta;

	@Autowired
	private Ingrediente unIngrediente;
	//endregion

	//region Methods
	@GetMapping("/listado")
	public ModelAndView getListaRecetasPage() {

		ModelAndView modelAndView = new ModelAndView();

		modelAndView.setViewName("recetas");
		modelAndView.addObject(
				"listaRecetas",
				recetaService.getAllRecetas()
		);
		modelAndView.addObject(
				"listaIngredientes",
				ingredienteService.getAllIngredientes()
		);

		return modelAndView;
	}

	@GetMapping("/nuevo")
	public ModelAndView getNuevaRecetaPage() {

		ModelAndView modelAndView = new ModelAndView();
		boolean edicion = false;

		unaReceta = new Receta();
		modelAndView.setViewName("nuevaReceta");
		modelAndView.addObject("receta", unaReceta);
		modelAndView.addObject(
				"listaIngredientes",
				ingredienteService.getAllIngredientes()
		);
		modelAndView.addObject("editar", edicion);

		return modelAndView;
	}

	@PostMapping("/guardar")
	public ModelAndView getGuardarRecetaPage(
			@Valid @ModelAttribute(value = "receta") Receta receta,
			BindingResult resultadoValidacion
	) {

		ModelAndView modelAndView = new ModelAndView();

		if (resultadoValidacion.hasErrors()) {
			modelAndView.setViewName("nuevaReceta");
			modelAndView.addObject(
					"listaIngredientes",
					ingredienteService.getAllIngredientes()
			);
		} else {
//			receta.setIngredientes();
			recetaService.addReceta(receta);

			modelAndView.setViewName("redirect:/recetas/listado");
			modelAndView.addObject(
					"listaRecetas",
					recetaService.getAllRecetas()
			);
			modelAndView.addObject(
					"listaIngredientes",
					ingredienteService.getAllIngredientes()
			);
	    }

		return modelAndView;
	}

	@GetMapping("/modificar/{id}")
	public ModelAndView getModificarRecetaPage(@PathVariable(value = "id") int id) {

		ModelAndView modelAndView = new ModelAndView();
		boolean edicion = true;

		unaReceta = recetaService.findRecetaById(id);
		modelAndView.setViewName("nuevaReceta");
		modelAndView.addObject("receta", unaReceta);
		modelAndView.addObject("editar", edicion);

		return modelAndView;
	}

	@GetMapping("/eliminar/{id}")
	public ModelAndView getEliminarRecetaPage(@PathVariable(value = "id") int id) {

		ModelAndView modelAndView = new ModelAndView();

		modelAndView.setViewName("redirect:/recetas/listado");
		recetaService.deleteRecetaById(recetaService.findRecetaById(id));

		return modelAndView;
	}
	//endregion

}
