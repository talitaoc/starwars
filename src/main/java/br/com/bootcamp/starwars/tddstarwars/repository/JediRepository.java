package br.com.bootcamp.starwars.tddstarwars.repository;

import br.com.bootcamp.starwars.tddstarwars.model.Jedi;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JediRepository extends JpaRepository<Jedi, Long> {


    Jedi findById(int id);

    boolean existsById(int id);

    List<Jedi> findAll();

    boolean update(Jedi jedi);

    Jedi save(Jedi jedi);

    boolean delete(int id);
}
