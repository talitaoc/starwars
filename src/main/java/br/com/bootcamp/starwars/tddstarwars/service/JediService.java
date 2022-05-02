package br.com.bootcamp.starwars.tddstarwars.service;

import br.com.bootcamp.starwars.tddstarwars.model.Jedi;
import br.com.bootcamp.starwars.tddstarwars.repository.JediRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Objects;

@Service
public class JediService {

    private static final Logger logger = LogManager.getLogger(JediService.class);

    private final JediRepository jediRepository;

    public JediService(JediRepository jediRepository) {

        this.jediRepository = jediRepository;
    }

    public Jedi findById(int id) {

        if(Objects.isNull(id)){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Jedi not found.");
        }
        logger.info("Find Jedi with id: {}", id);
        return jediRepository.findById(id);
    }

    public List<Jedi> findAll() {
        logger.info("Find all Jedis on Galaxy");
        return jediRepository.findAll();
    }

    public Jedi save(Jedi jedi) {

        if(jediRepository.existsById(jedi.getId())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Jedi not found.");
        }

        logger.info("Save Jedi to the database: {}", jedi);
        return jediRepository.save(jedi);
    }

    public Jedi update(Jedi jedi) {

        boolean updated = false;

        if(jediRepository.existsById(jedi.getId())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Jedi not found.");
        }
        logger.info("Update jedi to the database: {}", jedi);

        Jedi savedProduct = this.save(jedi);

        return savedProduct;

    }

    public boolean delete(Long id) {
        return true;
    }
}
