package br.projeto.mywallet.ServiceImpl;

import br.projeto.mywallet.DTO.BancoDTO;
import br.projeto.mywallet.Mappers.BancoMapper;
import br.projeto.mywallet.Model.Banco;
import br.projeto.mywallet.repository.IBancoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import org.mapstruct.factory.Mappers;
import static org.mockito.Mockito.*;

class BancoServiceTest {
    
    @InjectMocks
    private BancoService bancoService;

    @Mock
    private IBancoRepository bancoRepository;
    
    private final BancoMapper bancoMapper = Mappers.getMapper(BancoMapper.class);

    private Banco banco;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        banco = new Banco();
        banco.setId(1L);
        banco.setNomeBanco("Banco Teste");
        banco.setTranscacoes(new ArrayList<>());
    }

    @Test
    void criarBanco_DeveSalvarEBancoRetornado() {
        when(bancoRepository.save(any(Banco.class))).thenReturn(banco);

        BancoDTO bancoCriado = bancoService.criarBanco(bancoMapper.toDTO(banco));

        assertNotNull(bancoCriado);
        assertEquals("Banco Teste", bancoCriado.getNome());
        verify(bancoRepository, times(1)).save(banco);
    }

    @Test
    void buscarBancoPorId_DeveRetornarBancoQuandoEncontrado() {
        when(bancoRepository.findById(1L)).thenReturn(Optional.of(banco));

        BancoDTO bancoEncontrado = bancoService.buscarBancoPorId(1L);

        assertNotNull(bancoEncontrado);
        assertEquals("Banco Teste", bancoEncontrado.getNome());
        verify(bancoRepository, times(1)).findById(1L);
    }

    @Test
    void buscarBancoPorId_DeveLancarExcecaoQuandoNaoEncontrado() {
        when(bancoRepository.findById(1L)).thenReturn(Optional.empty());

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            bancoService.buscarBancoPorId(1L);
        });

        assertEquals("Banco não encontrado com ID: 1", exception.getMessage());
        verify(bancoRepository, times(1)).findById(1L);
    }

    @Test
    void listarTodosBancos_DeveRetornarListaDeBancos() {
        List<Banco> bancos = new ArrayList<>();
        bancos.add(banco);
        when(bancoRepository.findAll()).thenReturn(bancos);

        List<BancoDTO> resultado = bancoService.listarTodosBancos();

        assertNotNull(resultado);
        assertEquals(1, resultado.size());
        verify(bancoRepository, times(1)).findAll();
    }

    @Test
    void atualizarBanco_DeveAtualizarEBancoRetornado() {
        Banco bancoAtualizado = new Banco();
        bancoAtualizado.setNomeBanco("Banco Atualizado");
        bancoAtualizado.setTranscacoes(new ArrayList<>());

        when(bancoRepository.findById(1L)).thenReturn(Optional.of(banco));
        when(bancoRepository.save(any(Banco.class))).thenReturn(bancoAtualizado);

        BancoDTO resultado = bancoService.atualizarBanco(1L, bancoMapper.toDTO(bancoAtualizado));

        assertNotNull(resultado);
        assertEquals("Banco Atualizado", resultado.getNome());
        verify(bancoRepository, times(1)).findById(1L);
        verify(bancoRepository, times(1)).save(banco);
    }

    @Test
    void atualizarBanco_DeveLancarExcecaoQuandoBancoNaoEncontrado() {
        Banco bancoAtualizado = new Banco();
        bancoAtualizado.setNomeBanco("Banco Atualizado");
        bancoAtualizado.setTranscacoes(new ArrayList<>());

        when(bancoRepository.findById(1L)).thenReturn(Optional.empty());

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            bancoService.atualizarBanco(1L, bancoMapper.toDTO(bancoAtualizado));
        });

        assertEquals("Banco não encontrado com ID: 1", exception.getMessage());
        verify(bancoRepository, times(1)).findById(1L);
    }

    @Test
    void deletarBanco_DeveRemoverBancoQuandoEncontrado() {
        when(bancoRepository.findById(1L)).thenReturn(Optional.of(banco));
        doNothing().when(bancoRepository).delete(banco);

        bancoService.deletarBanco(1L);

        verify(bancoRepository, times(1)).findById(1L);
        verify(bancoRepository, times(1)).delete(banco);
    }

    @Test
    void deletarBanco_DeveLancarExcecaoQuandoBancoNaoEncontrado() {
        when(bancoRepository.findById(1L)).thenReturn(Optional.empty());

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            bancoService.deletarBanco(1L);
        });

        assertEquals("Banco não encontrado com ID: 1", exception.getMessage());
        verify(bancoRepository, times(1)).findById(1L);
    }
}
