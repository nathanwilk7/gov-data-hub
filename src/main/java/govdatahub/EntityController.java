package govdatahub;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class EntityController {
    @Autowired
    private EntityService entityService;
    private DatabaseService databaseService;

    @RequestMapping(value="/entities", method=RequestMethod.GET)
    public List<Entity> listEntities () throws Exception {
        return entityService.listEntities();
    }

    @RequestMapping(value="/entities", method=RequestMethod.POST)
    public void createEntity (@RequestBody Entity entity) throws Exception {
        entityService.createEntity(entity);
    }
}
