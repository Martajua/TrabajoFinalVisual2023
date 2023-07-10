package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entity.Receta;

public interface IRecetaService {

	public void addModReceta(Receta receta);

	public List<Receta> getAllRecetas();

	public void deleteRecetaById(Receta receta);

	public Receta findRecetaById(Long id);

	Receta getReceta();
	
	public List<Receta> mostrarCategoria(String palabraClave);
}
