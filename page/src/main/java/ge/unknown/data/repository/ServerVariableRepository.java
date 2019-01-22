package ge.unknown.data.repository;

import ge.unknown.entities.ServerVariable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by user on 4/22/18.
 */
@Repository
public interface ServerVariableRepository extends JpaRepository<ServerVariable, Long> {
    ServerVariable findByServerKey(String param);
}
