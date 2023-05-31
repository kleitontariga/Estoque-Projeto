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

import br.com.estoque.estoque.model.Cliente;
import br.com.estoque.estoque.service.ClienteService;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {
    @Autowired
    private ClienteService service = new ClienteService();

    @GetMapping
    public List<Cliente>findAll(){
        return service.findAll();
    }

    @PostMapping
    public ResponseEntity<Object> save (@RequestBody Cliente cliente) {
        try{
            return new ResponseEntity<>(service.save(cliente),HttpStatus.CREATED);
        }catch(Exception e){
        
            return new ResponseEntity<>("Ops! Parece que algo deu errado em nosso sistema. Pedimos desculpas pelo transtorno. Por favor, tente novamente mais tarde. Estamos trabalhando para resolver o problema o mais rápido possível. Agradecemos a sua compreensão!",
            HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    
    @PutMapping
    public ResponseEntity<Object> edit(@RequestBody Cliente cliente) {
        try {
            return new ResponseEntity<>(service.save(cliente), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Houve um erro inesperado em nossa aplicação, tente novamente mais tarde!!!",
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{idcliente}")
    public ResponseEntity<String> delete(@PathVariable("idcliente") Long idcliente) {
        var cliente = service.findOne(idcliente);
        if (cliente.isPresent()) {
            service.delete(idcliente);

            cliente = service.findOne(idcliente);
            if (cliente.isEmpty()) {
                return new ResponseEntity<>("Cliente removido com sucesso!!!", HttpStatus.OK);
            }
            return new ResponseEntity<>("Não foi possível remover o Cliente!!!", HttpStatus.OK);
        }
        return new ResponseEntity<>("Cliente não localizado!!!", HttpStatus.NOT_FOUND);
    }
}
