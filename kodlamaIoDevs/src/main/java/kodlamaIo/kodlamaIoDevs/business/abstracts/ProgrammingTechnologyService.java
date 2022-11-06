package kodlamaIo.kodlamaIoDevs.business.abstracts;

import java.util.List;

import kodlamaIo.kodlamaIoDevs.business.requests.programmingTechnologyRequest.CreateProgrammingTechnology;
import kodlamaIo.kodlamaIoDevs.business.requests.programmingTechnologyRequest.DeleteProgrammingTechnology;
import kodlamaIo.kodlamaIoDevs.business.requests.programmingTechnologyRequest.UpdateProgrammingTechnology;
import kodlamaIo.kodlamaIoDevs.business.responses.programmingTechnologyResponse.GetListProgrammingTechnology;
import kodlamaIo.kodlamaIoDevs.business.responses.programmingTechnologyResponse.GetProgrammingTechnologyById;

public interface ProgrammingTechnologyService {

	void add(CreateProgrammingTechnology createProgrammingTechnology) throws Exception;
	void delete(DeleteProgrammingTechnology deleteProgrammingTechnology) throws Exception;
	void update(UpdateProgrammingTechnology updateProgrammingTechnology) throws Exception;
	
	List<GetListProgrammingTechnology> getAll();
	GetProgrammingTechnologyById getProgrammingTechnologyId(int id) throws Exception;
}
