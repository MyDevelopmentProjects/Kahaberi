package ge.unknown.data.repository;

import ge.unknown.entities.MenuCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuCategoryRepository extends JpaRepository<MenuCategory, Long>, JpaSpecificationExecutor<MenuCategory> {
}