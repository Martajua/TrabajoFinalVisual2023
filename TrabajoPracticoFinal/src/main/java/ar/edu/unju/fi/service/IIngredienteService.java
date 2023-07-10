
package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entity.Ingrediente;

public interface IIngredienteService {
	
	void addModIngrediente(Ingrediente ingrediente);

	List<Ingrediente> getAllIngredientes();

	void deleteIngredienteById(Ingrediente ingrediente);

	Ingrediente findIngredienteById(Long id);
	
	Ingrediente getIngrediente();
}
