package org.generation.brazil.artemis.usuario;

import org.generation.brazil.artemis.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class UsuarioController {

    @Autowired
    // "Instanciando" o Repository
    private UsuarioRepository repository;

    // CREATE
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/usuarios")
    public Usuario save(@RequestBody Usuario usuario) {
        return repository.save(usuario);
    }

    // READ
    @GetMapping("/usuarios")
    public List<Usuario> findAll() {
        return repository.findAll();
    }

    @GetMapping("/usuarios/{id}")
    public Optional<Usuario> findById(@PathVariable Long id) {
        return repository.findById(id);
    }

    @PostMapping("/usuarios/nome")
    public List<Usuario> findByName(@RequestParam String nome) {
        return repository.findByNome(nome);
    }

    // UPDATE

    @PutMapping("/produtos/{id}")
    public Usuario update(@PathVariable Long id, @RequestBody Usuario usuario)
            throws ResourceNotFoundException {

        return repository.findById(id).map(x -> {
            x.setNome(usuario.getNome());
            x.setEmail(usuario.getLogin());
            return repository.save(x);
        }).orElseThrow(() ->
                new ResourceNotFoundException("Não existe produto cadastrado com o id: " + id));
    }

    // DELETE
    @DeleteMapping("/produtos/{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }

}
