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

import br.com.estoque.estoque.model.Produto;
import br.com.estoque.estoque.service.ProdutoService;

@RestController
@RequestMapping("/api/produto")
public class ProdutoController {
    @Autowired
    private ProdutoService service = new ProdutoService();

    @GetMapping
    public List<Produto>findAll(){
        return service.findAll();
    }

    @PostMapping
    public ResponseEntity<Object> save (@RequestBody Produto produto) {
        try{
            return new ResponseEntity<>(service.save(produto),HttpStatus.CREATED);
        }catch(Exception e){
        
            return new ResponseEntity<>("Ops! Parece que algo deu errado em nosso sistema. Pedimos desculpas pelo transtorno. Por favor, tente novamente mais tarde. Estamos trabalhando para resolver o problema o mais rápido possível. Agradecemos a sua compreensão!",
            HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    
    @PutMapping
    public ResponseEntity<Object> edit(@RequestBody Produto produto) {
        try {
            return new ResponseEntity<>(service.save(produto), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Houve um erro inesperado em nossa aplicação, tente novamente mais tarde!!!",
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{barras}")
    public ResponseEntity<String> delete(@PathVariable("barras") Long barras) {
        var produto = service.findOne(barras);
        if (produto.isPresent()) {
            service.delete(barras);

            produto = service.findOne(barras);
            if (produto.isEmpty()) {
                return new ResponseEntity<>("Produto removido com sucesso!!!", HttpStatus.OK);
            }
            return new ResponseEntity<>("Não foi possível remover o Produto!!!", HttpStatus.OK);
        }
        return new ResponseEntity<>("Produto não localizado!!!", HttpStatus.NOT_FOUND);
    }
}
