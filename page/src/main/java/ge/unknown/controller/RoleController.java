package ge.unknown.controller;

import ge.unknown.data.repository.RoleRepository;
import ge.unknown.entities.Role;
import ge.unknown.utils.GeneralUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import static ge.unknown.utils.constants.Constants.ControllerCodes.*;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleRepository repository;

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public Page<Role> list(
            @RequestParam(required = false) String sort,
            @RequestParam(value = PAGE_NUMBER, required = false, defaultValue = PAGE_NUMBER_DEFAULT_VALUE) int page,
            @RequestParam(required = false, defaultValue = PAGE_SIZE_DEFAULT_VALUE) int pageSize,
            @RequestParam(required = false, defaultValue = IS_ASCENDING_DEFAULT_VALUE) boolean ascending){
        return repository.findAll(GeneralUtil.paginate(page, pageSize, ascending, sort));
    }

    @RequestMapping(value = "put", method = RequestMethod.POST)
    public void save(@RequestBody Role role){
        repository.save(role);
    }

    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public void delete(@RequestBody Long id){
        repository.delete(id);
    }
}
