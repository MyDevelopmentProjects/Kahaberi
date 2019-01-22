package ge.unknown.controller;

import ge.unknown.data.repository.ServerVariableRepository;
import ge.unknown.entities.ServerVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by user on 4/22/18.
 */
@RestController
@RequestMapping("server-variable")
public class ServerVariableController {

    @Autowired
    private ServerVariableRepository serverVariableRepository;

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public Page<ServerVariable> list(@PageableDefault Pageable pageable){
        return serverVariableRepository.findAll(pageable);
    }

    @RequestMapping(value = "put", method = RequestMethod.POST)
    public void save(@RequestBody ServerVariable serverVariable){
        serverVariableRepository.save(serverVariable);
    }

    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public void delete(@RequestBody Long id){
        serverVariableRepository.delete(id);
    }
}
