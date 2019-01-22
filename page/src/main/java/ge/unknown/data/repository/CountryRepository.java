package ge.unknown.data.repository;

import ge.unknown.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by user on 4/14/18.
 */
@Repository
public interface CountryRepository extends JpaRepository<Country, Long>{
}
