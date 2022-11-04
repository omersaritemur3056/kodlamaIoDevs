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
import org.springframework.web.client.HttpClientErrorException.BadRequest;

import kodlamaIo.kodlamaIoDevs.business.abstracts.ProgrammingLanguageService;
import kodlamaIo.kodlamaIoDevs.business.requests.programmingLanguageRequest.CreateProgrammingLanguage;
import kodlamaIo.kodlamaIoDevs.business.requests.programmingLanguageRequest.DeleteProgrammingLanguage;
import kodlamaIo.kodlamaIoDevs.business.requests.programmingLanguageRequest.UpdateProgrammingLanguage;
import kodlamaIo.kodlamaIoDevs.business.responses.programmingLanguageResponse.GetListProgrammingLanguage;
import kodlamaIo.kodlamaIoDevs.business.responses.programmingLanguageResponse.GetProgrammingLanguageById;
import kodlamaIo.kodlamaIoDevs.entities.concretes.ProgrammingLanguage;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/programminglanguages")
public class ProgrammingLanguagesController {

	
	private final ProgrammingLanguageService programmingLanguageService;

	@Autowired
	public ProgrammingLanguagesController(ProgrammingLanguageService programmingLanguageService) {
		super();
		this.programmingLanguageService = programmingLanguageService;
	}
	
	
	@PostMapping("/add")
	public void add(@RequestBody CreateProgrammingLanguage createProgrammingLanguage) throws Exception {
		programmingLanguageService.add(createProgrammingLanguage);
	}
	
	@DeleteMapping("/delete")
	public void delete(@RequestBody DeleteProgrammingLanguage deleteProgrammingLanguage) throws Exception {
		programmingLanguageService.delete(deleteProgrammingLanguage);
	}
	
	@PutMapping("/update")
	public void update(@RequestBody UpdateProgrammingLanguage updateProgrammingLanguage) throws Exception {
		programmingLanguageService.update(updateProgrammingLanguage);
	}
	
	@GetMapping("/getall")
	public List<GetListProgrammingLanguage> getAll(){
		return programmingLanguageService.getAll();
	}
	
	@GetMapping("getbyid")
	public GetProgrammingLanguageById getById(int id) throws Exception {
		return programmingLanguageService.getProgrammingLanguageById(id);
	}
	
}
