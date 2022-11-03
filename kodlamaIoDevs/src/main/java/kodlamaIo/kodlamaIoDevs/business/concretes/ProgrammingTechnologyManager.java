package kodlamaIo.kodlamaIoDevs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaIo.kodlamaIoDevs.business.abstracts.ProgrammingTechnologyService;
import kodlamaIo.kodlamaIoDevs.dataAccess.abstracts.ProgrammingTechnologyRepository;
import kodlamaIo.kodlamaIoDevs.entities.concretes.ProgrammingTechnology;

@Service
public class ProgrammingTechnologyManager implements ProgrammingTechnologyService {

	@Autowired
	private ProgrammingTechnologyRepository programmingTechnologyRepository;

	@Override
	public void add(ProgrammingTechnology programmingTechnology) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ProgrammingTechnology> getAll() {
		// TODO Auto-generated method stub
		return programmingTechnologyRepository.findAll();
	}

	@Override
	public ProgrammingTechnology getProgrammingTechnologyId(int id) {
		// TODO Auto-generated method stub
		return programmingTechnologyRepository.getById(id);
	}
	
	
}
