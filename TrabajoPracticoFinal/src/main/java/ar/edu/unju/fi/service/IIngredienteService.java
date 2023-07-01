package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entity.Ingrediente;


public interface IIngredienteService {
	public void addIngrediente(Ingrediente ingrediente);

	public List<Ingrediente> getAllIngredientes();

	public void deleteIngredienteById(Ingrediente ingrediente);

	public Ingrediente findTestimonioById(Integer id);
}
