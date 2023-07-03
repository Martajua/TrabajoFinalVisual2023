package ar.edu.unju.fi.service;

import ar.edu.unju.fi.entity.Testimonio;

import java.util.List;

public interface ITestimonioService {

	public void addTestimonio(Testimonio testimonio);

	public List<Testimonio> getAllTestimonios();

	public void deleteTestimonioById(Testimonio testimonio);

	public Testimonio findTestimonioById(Integer id);

}
