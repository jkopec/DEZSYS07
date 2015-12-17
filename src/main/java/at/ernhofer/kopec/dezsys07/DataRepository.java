
package at.ernhofer.kopec.dezsys07;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "data", path = "data")
public interface DataRepository extends MongoRepository<Data, String> {

	List<Data> findBySuchbegriff(@Param("suchbegriff") String suchbegriff);
	
}
