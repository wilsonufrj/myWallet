package br.projeto.mywallet.Service;

import br.projeto.mywallet.Model.Banco;
import java.util.List;

public interface IBancoService {
    Banco criarBanco(Banco banco); // Criar
    Banco buscarBancoPorId(Long id); // Ler por ID
    List<Banco> listarTodosBancos(); // Ler todos
    Banco atualizarBanco(Long id, Banco banco); // Atualizar
    void deletarBanco(Long id); // Deletar
}
