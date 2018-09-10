package govdatahub;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class EntityController {
    @Autowired
    private EntityService entityService;
    private DatabaseService databaseService;

    @RequestMapping(value="/entities/{id}", method=RequestMethod.GET)
    public Entity getEntity (@PathVariable("id") long id) throws Exception {
        return entityService.getEntity(id);
    }

    @RequestMapping(value="/entities", method=RequestMethod.GET)
    public List<Entity> listEntities () throws Exception {
        return entityService.listEntities();
    }

    @RequestMapping(value="/entities", method=RequestMethod.POST)
    public void createEntity (@RequestBody Entity entity) throws Exception {
        entityService.createEntity(entity);
    }

    @RequestMapping(value="/entities/{id}/stats", method=RequestMethod.GET)
    public List<EntityStat> listEntityStats (@PathVariable("id") long id, @RequestParam(value="include_stats", required=false) Long[] statsToInclude) throws Exception {
        statsToInclude = (statsToInclude == null) ? new Long[]{} : statsToInclude;
        return entityService.listEntityStats(id, statsToInclude);
    }
}
