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
    public List<Entity> listEntities (@RequestParam(value="name", required=false) String name, @RequestParam(value="type", required=false) String type) throws Exception {
        if (name != null && type != null) {
            List<Entity> entities = new ArrayList<Entity>();
            entities.add(entityService.getEntityByNameAndType(name, type));
            return entities;
        } else if (name == null && type == null) {
            return entityService.listEntities();
        }
        throw new Exception("Need name and type");
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
