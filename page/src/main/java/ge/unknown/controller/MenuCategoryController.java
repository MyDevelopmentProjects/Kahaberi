package ge.unknown.controller;

import ge.unknown.data.repository.MenuCategoryRepository;
import ge.unknown.data.specification.MenuCategorySpecification;
import ge.unknown.entities.MenuCategory;
import ge.unknown.utils.GeneralUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import static ge.unknown.utils.constants.Constants.ControllerCodes.*;

@RestController
@RequestMapping("/menu-category")
public class MenuCategoryController {

    @Autowired
    private MenuCategoryRepository repository;

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public Page list(
            @RequestParam(required = false) String sort,
            @RequestParam(value = PAGE_NUMBER, required = false, defaultValue = PAGE_NUMBER_DEFAULT_VALUE) int page,
            @RequestParam(required = false, defaultValue = PAGE_SIZE_DEFAULT_VALUE) int pageSize,
            @RequestParam(required = false, defaultValue = IS_ASCENDING_DEFAULT_VALUE) boolean ascending){
        return repository.findAll(GeneralUtil.paginate(page, pageSize, ascending, sort));
    }

    @RequestMapping(value = "listByBranch", method = RequestMethod.GET)
    public Page listByBranch(
            @RequestParam(required = false) String sort,
            @RequestParam(value = PAGE_NUMBER, required = false, defaultValue = PAGE_NUMBER_DEFAULT_VALUE) int page,
            @RequestParam(required = false, defaultValue = PAGE_SIZE_DEFAULT_VALUE) int pageSize,
            @RequestParam(required = false, defaultValue = IS_ASCENDING_DEFAULT_VALUE) boolean ascending,
            @RequestParam long branchId){
        return repository.findAll(
            MenuCategorySpecification.filterByBranch(branchId),
            GeneralUtil.paginate(page, pageSize, ascending, sort)
        );
    }

    @RequestMapping(value = "listByOrganisation", method = RequestMethod.GET)
    public Page listByOrganisation(
            @RequestParam(required = false) String sort,
            @RequestParam(value = PAGE_NUMBER, required = false, defaultValue = PAGE_NUMBER_DEFAULT_VALUE) int page,
            @RequestParam(required = false, defaultValue = PAGE_SIZE_DEFAULT_VALUE) int pageSize,
            @RequestParam(required = false, defaultValue = IS_ASCENDING_DEFAULT_VALUE) boolean ascending,
            @RequestParam long organisationId){
        return repository.findAll(
                MenuCategorySpecification.filterByOrganisation(organisationId),
                GeneralUtil.paginate(page, pageSize, ascending, sort)
        );
    }

    @RequestMapping(value = "put", method = RequestMethod.POST)
    public void save(@RequestBody MenuCategory category){
        repository.save(category);
    }

    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public void delete(@RequestBody Long id){
        repository.delete(id);
    }
}
