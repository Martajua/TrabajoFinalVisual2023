package ar.edu.unju.fi.controller;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import ar.edu.unju.fi.entity.IndiceMasaCorporal;
import ar.edu.unju.fi.entity.Usuario;
import ar.edu.unju.fi.service.IIndiceMasaCorporalService;
import ar.edu.unju.fi.service.IRegistroService;
import jakarta.validation.Valid;

@Controller

@RequestMapping("/servicio")
public class ServicioController {

	@Autowired
	private IIndiceMasaCorporalService imcService;
	@Autowired
	private IRegistroService registroserviceRepository;

	/**
	 * Metodo que captura una peticion http en la forma de una url devuelve la
	 * pagina a mostrar.
	 */

	@GetMapping("/nuevoIMC")
    public String getInicioServicios(Model model) {
        IndiceMasaCorporal imc = new IndiceMasaCorporal(); // Crear un objeto IndiceMasaCorporal vacío
        model.addAttribute("imc", imc); // Agregar el objeto imc como atributo de la solicitud
        return "servicio_IMC";
    }

	@PostMapping("/calcular-imc")
	public String calcularImc(@Valid @ModelAttribute IndiceMasaCorporal imc, @RequestParam("peso") float peso,
			@RequestParam("idUsuario") Long idUsuario, BindingResult result, Model model) {
		Optional<Usuario> usuarioOptional = registroserviceRepository.buscarUsuarioById(idUsuario);

		if (result.hasErrors() || !usuarioOptional.isPresent()) {
			model.addAttribute("imc", imc);
			model.addAttribute("error", "Error al calcular el IMC");
			return "servicio_IMC";
		}

		Usuario usuario = usuarioOptional.get();
		String resultadoImc = usuario.calcularImc(peso);
		imc.setFechaImc(LocalDate.now());
		imc.setUsuario(usuario);
		imc.setEstado(true);
		imcService.addIMC(imc);

		model.addAttribute("imc", imc);
		model.addAttribute("resultadoImc", resultadoImc);
		model.addAttribute("registrosImc", imcService.getAllImcByUsuario(usuario));
		return "servicio_IMC";
	}
}
