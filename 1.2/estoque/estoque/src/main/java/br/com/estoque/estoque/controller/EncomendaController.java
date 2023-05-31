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

import br.com.estoque.estoque.model.Encomenda;
import br.com.estoque.estoque.service.EncomendaService;

@RestController
@RequestMapping("/api/encomenda")
public class EncomendaController {
    @Autowired
    private EncomendaService service = new EncomendaService();

    @GetMapping
    public List<Encomenda>findAll(){
        return service.findAll();
    }

    @PostMapping
    public ResponseEntity<Object> save (@RequestBody Encomenda encomenda) {
        try{
            return new ResponseEntity<>(service.save(encomenda),HttpStatus.CREATED);
        }catch(Exception e){
        
            return new ResponseEntity<>("Ops! Parece que algo deu errado em nosso sistema. Pedimos desculpas pelo transtorno. Por favor, tente novamente mais tarde. Estamos trabalhando para resolver o problema o mais rápido possível. Agradecemos a sua compreensão!",
            HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    
    @PutMapping
    public ResponseEntity<Object> edit(@RequestBody Encomenda encomenda) {
        try {
            return new ResponseEntity<>(service.save(encomenda), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Houve um erro inesperado em nossa aplicação, tente novamente mais tarde!!!",
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{idencomenda}")
    public ResponseEntity<String> delete(@PathVariable("idencomenda") Long idencomenda) {
        var encomenda = service.findOne(idencomenda);
        if (encomenda.isPresent()) {
            service.delete(idencomenda);

            encomenda = service.findOne(idencomenda);
            if (encomenda.isEmpty()) {
                return new ResponseEntity<>("Encomenda removido com sucesso!!!", HttpStatus.OK);
            }
            return new ResponseEntity<>("Não foi possível remover o Encomenda!!!", HttpStatus.OK);
        }
        return new ResponseEntity<>("Encomenda não localizado!!!", HttpStatus.NOT_FOUND);
    }
}
