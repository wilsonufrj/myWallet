package br.projeto.mywallet.Service;

import br.projeto.mywallet.Model.FormaPagamento;
import java.util.List;

public interface IFormaPagamentoService {
    FormaPagamento criarFormaPagamento(FormaPagamento formaPagamento); // Criar
    FormaPagamento buscarFormaPagamentoPorId(Long id); // Ler por ID
    List<FormaPagamento> listarTodasFormasPagamento(); // Ler todas
    FormaPagamento atualizarFormaPagamento(Long id, FormaPagamento formaPagamento); // Atualizar
    void deletarFormaPagamento(Long id); // Deletar
}
