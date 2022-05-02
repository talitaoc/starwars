package br.com.bootcamp.starwars.tddstarwars.controller;

import br.com.bootcamp.starwars.tddstarwars.model.Jedi;
import br.com.bootcamp.starwars.tddstarwars.service.JediService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/starwars")
public class JediController {
    private static final Logger logger = LogManager.getLogger(JediController.class);

    private final JediService jediService;

    public JediController(JediService jediService) {
        this.jediService = jediService;
    }

    @GetMapping("/jedi/{id}")
    public ResponseEntity<Jedi> getJedi(@PathVariable int id) {

        return new ResponseEntity<>(jediService.findById(id), HttpStatus.OK);

    }

    @PostMapping("/jedi")
    public ResponseEntity<Jedi> saveJedi(@RequestBody Jedi jedi) {

        return new ResponseEntity<>(jediService.save(jedi), HttpStatus.CREATED);

    }

    @PutMapping(path = "/jedi/{id}")
    public ResponseEntity<Jedi> updateProduct(@RequestBody Jedi jedi, @PathVariable int id) {

        Jedi jediReplace = jediService.findById(id);
        jedi.setId(id);
        jedi.setName(jedi.getName());
        jedi.setVersion(jedi.getVersion());
        jedi.setStrenght(jedi.getStrenght());

        jediService.save(jediReplace);

        logger.info("Update was a success {} ", jediReplace);

        return new ResponseEntity<>(jediReplace, HttpStatus.OK);


    }

    @DeleteMapping(path = "/jedi/{id}")
    public ResponseEntity<Void> deleteJedi(@PathVariable int id){

        logger.info("Deleting Jedi with ID {}", id);

        Jedi existingJedi = jediService.findById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}
