package ge.unknown.controller;

import ge.unknown.data.repository.LanguageRepository;
import ge.unknown.entities.Language;
import ge.unknown.utils.GeneralUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import static ge.unknown.utils.constants.Constants.ControllerCodes.*;

/**
 * Created by user on 4/22/18.
 */
@RestController
@RequestMapping("/language")
public class LanguageController {

    @Autowired
    private LanguageRepository languageRepository;

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public Page<Language> list(
            @RequestParam(required = false) String sort,
            @RequestParam(value = PAGE_NUMBER, required = false, defaultValue = PAGE_NUMBER_DEFAULT_VALUE) int page,
            @RequestParam(required = false, defaultValue = PAGE_SIZE_DEFAULT_VALUE) int pageSize,
            @RequestParam(required = false, defaultValue = IS_ASCENDING_DEFAULT_VALUE) boolean ascending){
        return languageRepository.findAll(GeneralUtil.paginate(page, pageSize, ascending, sort));
    }

    @RequestMapping(value = "put", method = RequestMethod.POST)
    public void save(@RequestBody Language language){
        languageRepository.save(language);
    }

    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public void delete(@RequestBody Long id){
        languageRepository.delete(id);
    }
}
