package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Ingrediente;

import ar.edu.unju.fi.repository.IIngredienteRepository;
import ar.edu.unju.fi.service.IIngredienteService;

@Service
public class IIngredienteServiceImp implements IIngredienteService {

	@Autowired
	private Ingrediente ingrediente;

	@Autowired
	private IIngredienteRepository ingredienteRepository;

	@Override
	public void addIngrediente(Ingrediente ingrediente) {
		ingredienteRepository.save(ingrediente);
	}

	@Override
	public List<Ingrediente> getAllIngredientes() {
		List<Ingrediente> ingrediente = ingredienteRepository.findByEstado(true);
		return ingrediente;
	}

	@Override
	public void deleteIngredienteById(Ingrediente ingrediente) {
		ingrediente.setEstado(false);
		ingredienteRepository.save(ingrediente);

	}

	@Override
	public Ingrediente findTestimonioById(Integer id) {
		ingrediente = ingredienteRepository.findById(id).get();
		return ingrediente;
	}

}
