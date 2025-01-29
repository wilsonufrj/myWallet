package br.projeto.mywallet.Controller;

import br.projeto.mywallet.DTO.CarteiraDTO;
import br.projeto.mywallet.Service.ICarteiraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/carteiras")
public class CarteiraController {

    @Autowired
    private ICarteiraService carteiraService;

    // Criar nova carteira
    @PostMapping
    public ResponseEntity<CarteiraDTO> criarCarteira(@RequestBody CarteiraDTO carteiraDTO) {
        return ResponseEntity.ok(carteiraService.criarCarteira(carteiraDTO));
    }

    // Buscar carteira por ID
    @GetMapping("/{id}")
    public ResponseEntity<CarteiraDTO> buscarCarteiraPorId(@PathVariable Long id) {
        return ResponseEntity.ok(carteiraService.buscarCarteiraPorId(id));
    }

    // Listar todas as carteiras
    @GetMapping
    public ResponseEntity<List<CarteiraDTO>> listarTodasCarteiras() {
        return ResponseEntity.ok(carteiraService.listarTodasCarteiras());
    }

    // Atualizar carteira
    @PutMapping("/{id}")
    public ResponseEntity<CarteiraDTO> atualizarCarteira(@PathVariable Long id, @RequestBody CarteiraDTO carteiraAtualizada) {
        return ResponseEntity.ok(carteiraService.atualizarCarteira(id, carteiraAtualizada));
    }

    // Deletar carteira
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCarteira(@PathVariable Long id) {
        carteiraService.deletarCarteira(id);
        return ResponseEntity.noContent().build();
    }
}
