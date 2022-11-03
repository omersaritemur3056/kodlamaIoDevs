package kodlamaIo.kodlamaIoDevs.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaIo.kodlamaIoDevs.entities.concretes.ProgrammingTechnology;

public interface ProgrammingTechnologyRepository extends JpaRepository<ProgrammingTechnology, Integer> {

	
}
