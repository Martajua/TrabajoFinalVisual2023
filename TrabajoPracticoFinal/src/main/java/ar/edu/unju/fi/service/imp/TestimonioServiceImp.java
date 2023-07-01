package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Testimonio;
import ar.edu.unju.fi.repository.ITestimonioRepository;
import ar.edu.unju.fi.service.ITestimonioService;

@Service
public class TestimonioServiceImp implements ITestimonioService {

	@Autowired
	private Testimonio testimonio;

	@Autowired
	private ITestimonioRepository testimonioRepository;

	@Override
	public void addTestimonio(Testimonio testimonio) {

		testimonioRepository.save(testimonio);
	}

	@Override
	public List<Testimonio> getAllTestimonios() {
		List<Testimonio> testimonio = testimonioRepository.findByEstado(true);
		return testimonio;
	}

	@Override
	public void deleteTestimonioById(Testimonio testimonio) {
		testimonio.setEstado(false);
		testimonioRepository.save(testimonio);

	}

	@Override
	public Testimonio findTestimonioById(Integer id) {
		testimonio = testimonioRepository.findById(id).get();
		return testimonio;
	}

}
