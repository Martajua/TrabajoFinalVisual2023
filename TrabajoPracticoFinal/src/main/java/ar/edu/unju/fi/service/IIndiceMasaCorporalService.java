package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entity.IndiceMasaCorporal;
import ar.edu.unju.fi.entity.Usuario;

public interface IIndiceMasaCorporalService {

	public void addIMC(IndiceMasaCorporal masaCorporal);

	public List<IndiceMasaCorporal> getAllImc();

	public void deleteImcById(IndiceMasaCorporal masaCorporal);

	public IndiceMasaCorporal findIndiceMasaCorporalById(Integer id);
	
	
	List<IndiceMasaCorporal> getAllImcByUsuario(Usuario usuario);
}
