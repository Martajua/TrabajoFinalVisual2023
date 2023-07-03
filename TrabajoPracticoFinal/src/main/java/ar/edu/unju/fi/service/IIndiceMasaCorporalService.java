package ar.edu.unju.fi.service;

import ar.edu.unju.fi.entity.IndiceMasaCorporal;

import java.util.List;

public interface IIndiceMasaCorporalService {

	public void addTestimonio(IndiceMasaCorporal masaCorporal);

	public List<IndiceMasaCorporal> getAllImc();

	public void deleteImcById(IndiceMasaCorporal masaCorporal);

	public IndiceMasaCorporal findIndiceMasaCorporalById(Integer id);

}
