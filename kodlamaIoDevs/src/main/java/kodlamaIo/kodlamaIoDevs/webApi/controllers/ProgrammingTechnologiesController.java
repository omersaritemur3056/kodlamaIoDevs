package kodlamaIo.kodlamaIoDevs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaIo.kodlamaIoDevs.business.abstracts.ProgrammingTechnologyService;
import kodlamaIo.kodlamaIoDevs.entities.concretes.ProgrammingLanguage;
import kodlamaIo.kodlamaIoDevs.entities.concretes.ProgrammingTechnology;

@RestController
@RequestMapping("/api/programmingtechnologies")
public class ProgrammingTechnologiesController {

	@Autowired
	private ProgrammingTechnologyService programmingTechnologyService;
	
	@PostMapping("/add")
	public void add(@RequestBody ProgrammingTechnology programmingTechnology) throws Exception {
		programmingTechnologyService.add(programmingTechnology);
	}
	
//	@DeleteMapping("/delete")
//	public void delete(@RequestParam int id) throws Exception {
//		programmingLanguageService.delete(id);
//	}
	
//	@PutMapping("/update")
//	public void update(@RequestBody ProgrammingLanguage programmingLanguage) throws Exception {
//		programmingLanguageService.update(programmingLanguage);
//	}
	
	@GetMapping("/getall")
	public List<ProgrammingTechnology> getAll(){
		return programmingTechnologyService.getAll();
	}
	
	@GetMapping("getbyid")
	public ProgrammingTechnology getById(int id) {
		return programmingTechnologyService.getProgrammingTechnologyId(id);
	}
}
