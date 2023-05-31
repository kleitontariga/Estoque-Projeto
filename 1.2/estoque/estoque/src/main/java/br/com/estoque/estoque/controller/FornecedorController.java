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

import br.com.estoque.estoque.model.Fornecedor;
import br.com.estoque.estoque.service.FornecedorService;

@RestController
@RequestMapping("/api/fornecedor")
public class FornecedorController {
    @Autowired
    private FornecedorService service = new FornecedorService();

    @GetMapping
    public List<Fornecedor>findAll(){
        return service.findAll();
    }

    @PostMapping
    public ResponseEntity<Object> save (@RequestBody Fornecedor fornecedor) {
        try{
            return new ResponseEntity<>(service.save(fornecedor),HttpStatus.CREATED);
        }catch(Exception e){
        
            return new ResponseEntity<>("Ops! Parece que algo deu errado em nosso sistema. Pedimos desculpas pelo transtorno. Por favor, tente novamente mais tarde. Estamos trabalhando para resolver o problema o mais rápido possível. Agradecemos a sua compreensão!",
            HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    
    @PutMapping
    public ResponseEntity<Object> edit(@RequestBody Fornecedor fornecedor) {
        try {
            return new ResponseEntity<>(service.save(fornecedor), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Houve um erro inesperado em nossa aplicação, tente novamente mais tarde!!!",
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{idfornecedor}")
    public ResponseEntity<String> delete(@PathVariable("idfornecedor") Long idfornecedor) {
        var fornecedor = service.findOne(idfornecedor);
        if (fornecedor.isPresent()) {
            service.delete(idfornecedor);

            fornecedor = service.findOne(idfornecedor);
            if (fornecedor.isEmpty()) {
                return new ResponseEntity<>("Fornecedor removido com sucesso!!!", HttpStatus.OK);
            }
            return new ResponseEntity<>("Não foi possível remover o Fornecedor!!!", HttpStatus.OK);
        }
        return new ResponseEntity<>("Fornecedor não localizado!!!", HttpStatus.NOT_FOUND);
    }
}
