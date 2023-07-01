package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entity.Receta;

public interface IRecetaService {

	public void addReceta(Receta receta);

	public List<Receta> getAllRecetas();

	public void deleteRecetaById(Receta receta);

	public Receta findRecetaById(Integer id);
}
