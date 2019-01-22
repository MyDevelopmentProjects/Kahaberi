package ge.unknown.controller;

import ge.unknown.data.repository.CountryRepository;
import ge.unknown.entities.Country;
import ge.unknown.utils.GeneralUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import static ge.unknown.utils.constants.Constants.ControllerCodes.*;

/**
 * Created by user on 4/14/18.
 */
@RestController
@RequestMapping("/country")
public class CountryController {

    @Autowired
    private CountryRepository repository;

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public Page<Country> list(
            @RequestParam(required = false) String sort,
            @RequestParam(value = PAGE_NUMBER, required = false, defaultValue = PAGE_NUMBER_DEFAULT_VALUE) int page,
            @RequestParam(required = false, defaultValue = PAGE_SIZE_DEFAULT_VALUE) int pageSize,
            @RequestParam(required = false, defaultValue = IS_ASCENDING_DEFAULT_VALUE) boolean ascending){
        return repository.findAll(GeneralUtil.paginate(page, pageSize, ascending, sort));
    }

    @RequestMapping(value = "put", method = RequestMethod.POST)
    public void save(@RequestBody Country country){
        repository.save(country);
    }

    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public void delete(@RequestBody Long id){
        repository.delete(id);
    }
}
