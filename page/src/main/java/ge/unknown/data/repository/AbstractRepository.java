package ge.unknown.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@NoRepositoryBean
interface AbstractRepository<T, ID extends Serializable> extends JpaRepository<T, ID> {
    public List<T> findByNamedQuery(String name );
    public List<T> findByNamedQueryAndParams( String name, Map<String, Object> params );
    public T findOneByNamedQuery( String name );
    public T findOneByNamedQueryAndParams( String name, Map<String, Object> params );
}
