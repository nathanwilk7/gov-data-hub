package govdatahub;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class EntityStatController {
    @Autowired
    private EntityStatService entityStatService;
    private DatabaseService databaseService;

    @RequestMapping(value="/entity_stats/{id}", method=RequestMethod.GET)
    public EntityStat getEntityStat (@PathVariable("id") long id) throws Exception {
        return entityStatService.getEntityStat(id);
    }

    @RequestMapping(value="/entity_stats", method=RequestMethod.GET)
    public List<EntityStat> listEntityStats () throws Exception {
        return entityStatService.listEntityStats();
    }

    @RequestMapping(value="/entity_stats", method=RequestMethod.POST)
    public void createEntityStat (@RequestBody EntityStat entityStat) throws Exception {
        entityStatService.createEntityStat(entityStat);
    }

    @RequestMapping(value="/entity_stats_bulk", method=RequestMethod.POST)
    public void createEntityStats (@RequestBody List<EntityStat> entityStats) throws Exception {
        entityStatService.createEntityStats(entityStats);
    }
}
