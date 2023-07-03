package ar.edu.unju.fi.service;

import ar.edu.unju.fi.entity.Receta;

import java.util.List;

public interface IRecetaService {

	//region Methods
	public void addReceta(Receta receta);

	public List<Receta> getAllRecetas();

	public Receta findRecetaById(int id);

	public void deleteRecetaById(Receta receta);
	//endregion Methods

}
