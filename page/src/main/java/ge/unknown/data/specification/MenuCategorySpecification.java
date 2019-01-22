package ge.unknown.data.specification;

import ge.unknown.entities.MenuCategory;
import org.springframework.data.jpa.domain.Specification;

public class MenuCategorySpecification {

    /**
     * ფილიალის მიხედვით ფილტრავს კატეგორიას
     * @param branchId
     * @return
     */
    public static Specification<MenuCategory> filterByBranch(Long branchId){
        return (root, criteriaQuery, criteriaBuilder) -> {
            if(branchId != null){
                return  criteriaBuilder.equal(
                    root.get("branch").get("id"),
                    branchId
                );
            }
            return null;
        };
    }


    /**
     * ორგანიზაციის მიხედვით ფილტრავს კატეგორიას
     * @param organisationId
     * @return
     */
    public static Specification<MenuCategory> filterByOrganisation(Long organisationId){
        return (root, criteriaQuery, criteriaBuilder) -> {
            if(organisationId != null){
                return  criteriaBuilder.equal(
                    root.get("branch").get("organisation").get("id"),
                    organisationId
                );
            }
            return null;
        };
    }
}
