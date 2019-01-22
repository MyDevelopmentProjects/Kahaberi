package ge.unknown.controller;

import ge.unknown.data.repository.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by user on 4/14/18.
 */
@Controller
public class HomeController {

    @Autowired
    private LanguageRepository languageRepository;

    @Autowired
    private MessageSource messageSource;

    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String home(Model model) {
        return "index";
    }

    @RequestMapping(value = {"/page/{pageName}"}, method = RequestMethod.GET)
    public String page(Model model, @PathVariable(value = "pageName") String pageName) {
        return "partials/" + pageName;
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String admin(Model model) {
        return "security/index";
    }


    private String getLocalizedMessage(String key) {
        return messageSource.getMessage(key, null, LocaleContextHolder.getLocale());
    }


}