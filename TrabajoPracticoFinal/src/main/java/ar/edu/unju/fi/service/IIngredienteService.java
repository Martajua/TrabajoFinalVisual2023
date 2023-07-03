package ar.edu.unju.fi.service;

import ar.edu.unju.fi.entity.Ingrediente;

import java.util.List;

public interface IIngredienteService {

	//region Methods
	public void addIngrediente(Ingrediente ingrediente);

	public List<Ingrediente> getAllIngredientes();

	public Ingrediente findIngredienteById(int id);

	public void deleteIngredienteByIdentifier(Ingrediente ingrediente);
	//endregion

}
