package kodlamaIo.kodlamaIoDevs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaIo.kodlamaIoDevs.business.abstracts.ProgrammingTechnologyService;
import kodlamaIo.kodlamaIoDevs.business.requests.programmingTechnologyRequest.CreateProgrammingTechnology;
import kodlamaIo.kodlamaIoDevs.business.requests.programmingTechnologyRequest.DeleteProgrammingTechnology;
import kodlamaIo.kodlamaIoDevs.business.requests.programmingTechnologyRequest.UpdateProgrammingTechnology;
import kodlamaIo.kodlamaIoDevs.business.responses.programmingTechnologyResponse.GetListProgrammingTechnology;
import kodlamaIo.kodlamaIoDevs.business.responses.programmingTechnologyResponse.GetProgrammingTechnologyById;
import kodlamaIo.kodlamaIoDevs.entities.concretes.ProgrammingLanguage;
import kodlamaIo.kodlamaIoDevs.entities.concretes.ProgrammingTechnology;

@RestController
@RequestMapping("/api/programmingtechnologies")
public class ProgrammingTechnologiesController {

	@Autowired
	private ProgrammingTechnologyService programmingTechnologyService;
	
	@PostMapping("/add")
	public void add(@RequestBody CreateProgrammingTechnology createProgrammingTechnology) throws Exception {
		programmingTechnologyService.add(createProgrammingTechnology);
	}
	
	@DeleteMapping("/delete")
	public void delete(@RequestBody DeleteProgrammingTechnology deleteProgrammingTechnology) throws Exception {
		programmingTechnologyService.delete(deleteProgrammingTechnology);
	}
	
	@PutMapping("/update")
	public void update(@RequestBody UpdateProgrammingTechnology updateProgrammingTechnology) throws Exception {
		programmingTechnologyService.update(updateProgrammingTechnology);
	}
	
	@GetMapping("/getall")
	public List<GetListProgrammingTechnology> getAll(){
		return programmingTechnologyService.getAll();
	}
	
	@GetMapping("getbyid")
	public GetProgrammingTechnologyById getById(int id) throws Exception {
		return programmingTechnologyService.getProgrammingTechnologyId(id);
	}
}
