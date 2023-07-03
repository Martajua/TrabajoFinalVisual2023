package ar.edu.unju.fi.service.imp;

import ar.edu.unju.fi.entity.IndiceMasaCorporal;
import ar.edu.unju.fi.repository.IIndiceMasaCorporalRepository;
import ar.edu.unju.fi.service.IIndiceMasaCorporalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("indiceMasaCorporalServiceImp")
public class IndiceMasaCorporalServiceImp implements IIndiceMasaCorporalService {

	@Autowired
	private IndiceMasaCorporal indiceMasaCorporal;
	
	@Autowired
	private IIndiceMasaCorporalRepository indiceMasaCorporalRepository;
	
	@Override
	public void addTestimonio(IndiceMasaCorporal indiceMasaCorporal) {
		indiceMasaCorporalRepository.save(indiceMasaCorporal);
	}

	@Override
	public List<IndiceMasaCorporal> getAllImc() {
		List<IndiceMasaCorporal> imc = indiceMasaCorporalRepository.findByEstado(true);
		return imc;
	}

	@Override
	public void deleteImcById(IndiceMasaCorporal indiceMasaCorporal) {
		indiceMasaCorporal.setEstado(false);
		indiceMasaCorporalRepository.save(indiceMasaCorporal);
	}

	@Override
	public IndiceMasaCorporal findIndiceMasaCorporalById(Integer id) {
		indiceMasaCorporal = indiceMasaCorporalRepository.findById(id).get();
		return indiceMasaCorporal;
	}

}
