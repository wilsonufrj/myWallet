package br.projeto.mywallet.ServiceImpl;

import br.projeto.mywallet.DTO.CarteiraDTO;
import br.projeto.mywallet.DTO.MesDTO;
import br.projeto.mywallet.DTO.UsuarioDTO;
import br.projeto.mywallet.Mappers.CarteiraMapper;
import br.projeto.mywallet.Model.Carteira;
import br.projeto.mywallet.Model.Mes;
import br.projeto.mywallet.Model.Usuario;
import br.projeto.mywallet.Service.ICarteiraService;
import br.projeto.mywallet.repository.ICarteiraRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CarteiraServiceTest {

    @Mock
    private ICarteiraRepository carteiraRepository;

    @Mock
    private CarteiraMapper carteiraMapper;

    @InjectMocks
    private CarteiraService carteiraService;

    private Carteira carteira;
    private CarteiraDTO carteiraDTO;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        Set<Usuario> usuarios = new HashSet<>();
        List<Mes> meses = Arrays.asList(new Mes());

        
        Set<UsuarioDTO> usuariosDTO = new HashSet<>();
        List<MesDTO> mesesDTO = Arrays.asList(new MesDTO());

        carteira = new Carteira(1L, "Carteira Teste", usuarios, meses);
        carteiraDTO = new CarteiraDTO(1L, "Carteira Teste", usuariosDTO, mesesDTO);
    }

    @Test
    void criarCarteira() {
        when(carteiraMapper.toEntity(any())).thenReturn(carteira);
        when(carteiraRepository.save(any())).thenReturn(carteira);
        when(carteiraMapper.toDTO(any())).thenReturn(carteiraDTO);

        CarteiraDTO resultado = carteiraService.criarCarteira(carteiraDTO);
        assertNotNull(resultado);
        assertEquals("Carteira Teste", resultado.getNome());
    }

    @Test
    void buscarCarteiraPorId() {
        when(carteiraRepository.findById(1L)).thenReturn(Optional.of(carteira));
        when(carteiraMapper.toDTO(any())).thenReturn(carteiraDTO);

        CarteiraDTO resultado = carteiraService.buscarCarteiraPorId(1L);
        assertNotNull(resultado);
        assertEquals(1L, resultado.getId());
    }

    @Test
    void listarTodasCarteiras() {
        when(carteiraRepository.findAll()).thenReturn(Arrays.asList(carteira));
        when(carteiraMapper.toDTO(any())).thenReturn(carteiraDTO);

        List<CarteiraDTO> resultado = carteiraService.listarTodasCarteiras();
        assertFalse(resultado.isEmpty());
        assertEquals(1, resultado.size());
    }

    @Test
    void atualizarCarteira() {
        Set<UsuarioDTO> usuarios = new HashSet<>();
        List<MesDTO> meses = Arrays.asList(new MesDTO());
        CarteiraDTO carteiraAtualizada = new CarteiraDTO(1L, "Nova Carteira", usuarios, meses);

        when(carteiraRepository.findById(1L)).thenReturn(Optional.of(carteira));
        when(carteiraMapper.toEntity(any())).thenReturn(carteira);
        when(carteiraRepository.save(any())).thenReturn(carteira);
        when(carteiraMapper.toDTO(any())).thenReturn(carteiraAtualizada);

        CarteiraDTO resultado = carteiraService.atualizarCarteira(1L, carteiraAtualizada);
        assertEquals("Nova Carteira", resultado.getNome());
    }

    @Test
    void deletarCarteira() {
        when(carteiraRepository.findById(1L)).thenReturn(Optional.of(carteira));
        doNothing().when(carteiraRepository).delete(any());

        assertDoesNotThrow(() -> carteiraService.deletarCarteira(1L));
        verify(carteiraRepository, times(1)).delete(any());
    }
}
