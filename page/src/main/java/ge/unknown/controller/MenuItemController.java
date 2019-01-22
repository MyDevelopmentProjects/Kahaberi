package ge.unknown.controller;

import ge.unknown.data.repository.MenuItemRepository;
import ge.unknown.data.specification.MenuItemSpecification;
import ge.unknown.entities.MenuItem;
import ge.unknown.utils.GeneralUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import static ge.unknown.utils.constants.Constants.ControllerCodes.*;
import static ge.unknown.utils.constants.Constants.ControllerCodes.IS_ASCENDING_DEFAULT_VALUE;

@RestController
@RequestMapping("/menu-item")
public class MenuItemController {

    @Autowired
    private MenuItemRepository repository;

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public Page list(
            @RequestParam(required = false) String sort,
            @RequestParam(value = PAGE_NUMBER, required = false, defaultValue = PAGE_NUMBER_DEFAULT_VALUE) int page,
            @RequestParam(required = false, defaultValue = PAGE_SIZE_DEFAULT_VALUE) int pageSize,
            @RequestParam(required = false, defaultValue = IS_ASCENDING_DEFAULT_VALUE) boolean ascending){
        return repository.findAll(GeneralUtil.paginate(page, pageSize, ascending, sort));
    }

    @RequestMapping(value = "detail", method = RequestMethod.GET)
    public MenuItem detail(@RequestParam Long id){
        return repository.findOne(id);
    }

    @RequestMapping(value = "listByBranch", method = RequestMethod.GET)
    public Page listByBranch(
            @RequestParam(required = false) String sort,
            @RequestParam(value = PAGE_NUMBER, required = false, defaultValue = PAGE_NUMBER_DEFAULT_VALUE) int page,
            @RequestParam(required = false, defaultValue = PAGE_SIZE_DEFAULT_VALUE) int pageSize,
            @RequestParam(required = false, defaultValue = IS_ASCENDING_DEFAULT_VALUE) boolean ascending,
            @RequestParam long branchId){
        return repository.findAll(
                MenuItemSpecification.filterByBranch(branchId),
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
                MenuItemSpecification.filterByOrganisation(organisationId),
                GeneralUtil.paginate(page, pageSize, ascending, sort)
        );
    }

    @RequestMapping(value = "put", method = RequestMethod.POST)
    public void save(@RequestBody MenuItem menuItem){
        repository.save(menuItem);
    }

    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public void delete(@RequestBody Long id){
        repository.delete(id);
    }
}
