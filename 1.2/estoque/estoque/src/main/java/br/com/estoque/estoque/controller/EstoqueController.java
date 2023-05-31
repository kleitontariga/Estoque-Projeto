package br.com.estoque.estoque.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.estoque.estoque.model.Estoque;
import br.com.estoque.estoque.service.EstoqueService;

@RestController
@RequestMapping("/api/estoque")
public class EstoqueController {
    @Autowired
    private EstoqueService service = new EstoqueService();

    @GetMapping
    public List<Estoque>findAll(){
        return service.findAll();
    }

    @PostMapping
    public ResponseEntity<Object> save (@RequestBody Estoque estoque) {
        try{
            return new ResponseEntity<>(service.save(estoque),HttpStatus.CREATED);
        }catch(Exception e){
        
            return new ResponseEntity<>("Ops! Parece que algo deu errado em nosso sistema. Pedimos desculpas pelo transtorno. Por favor, tente novamente mais tarde. Estamos trabalhando para resolver o problema o mais rápido possível. Agradecemos a sua compreensão!",
            HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    
    @PutMapping
    public ResponseEntity<Object> edit(@RequestBody Estoque estoque) {
        try {
            return new ResponseEntity<>(service.save(estoque), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Houve um erro inesperado em nossa aplicação, tente novamente mais tarde!!!",
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{idestoque}")
    public ResponseEntity<String> delete(@PathVariable("idestoque") Long idestoque) {
        var estoque = service.findOne(idestoque);
        if (estoque.isPresent()) {
            service.delete(idestoque);

            estoque = service.findOne(idestoque);
            if (estoque.isEmpty()) {
                return new ResponseEntity<>("Estoque removido com sucesso!!!", HttpStatus.OK);
            }
            return new ResponseEntity<>("Não foi possível remover o Estoque!!!", HttpStatus.OK);
        }
        return new ResponseEntity<>("Estoque não localizado!!!", HttpStatus.NOT_FOUND);
    }
}
