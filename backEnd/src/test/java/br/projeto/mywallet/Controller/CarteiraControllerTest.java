package br.projeto.mywallet.Controller;

import br.projeto.mywallet.DTO.CarteiraDTO;
import br.projeto.mywallet.DTO.MesDTO;
import br.projeto.mywallet.DTO.UsuarioDTO;
import br.projeto.mywallet.Service.ICarteiraService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CarteiraControllerTest {

    @Mock
    private ICarteiraService carteiraService;

    @InjectMocks
    private CarteiraController carteiraController;

    private CarteiraDTO carteiraDTO;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        Set<UsuarioDTO> usuarios = new HashSet<>();
        List<MesDTO> meses = Arrays.asList(new MesDTO());
        carteiraDTO = new CarteiraDTO(1L, "Carteira Teste", usuarios, meses);
    }

    @Test
    void criarCarteira() {
        when(carteiraService.criarCarteira(any(CarteiraDTO.class))).thenReturn(carteiraDTO);
        ResponseEntity<CarteiraDTO> response = carteiraController.criarCarteira(carteiraDTO);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(carteiraDTO, response.getBody());
    }

    @Test
    void buscarCarteiraPorId() {
        when(carteiraService.buscarCarteiraPorId(1L)).thenReturn(carteiraDTO);
        ResponseEntity<CarteiraDTO> response = carteiraController.buscarCarteiraPorId(1L);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(carteiraDTO, response.getBody());
    }

    @Test
    void buscaCarteiraPorUsuario() {
        List<CarteiraDTO> listaCarteiras = Arrays.asList(carteiraDTO);
        when(carteiraService.buscaCarteiraPorUsuario("UsuarioTeste")).thenReturn(listaCarteiras);
        ResponseEntity<List<CarteiraDTO>> response = carteiraController.buscaCarteiraPorUsuario("UsuarioTeste");
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(1, response.getBody().size());
    }

    @Test
    void listarTodasCarteiras() {
        List<CarteiraDTO> listaCarteiras = Arrays.asList(carteiraDTO);
        when(carteiraService.listarTodasCarteiras()).thenReturn(listaCarteiras);
        ResponseEntity<List<CarteiraDTO>> response = carteiraController.listarTodasCarteiras();
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(1, response.getBody().size());
    }

    @Test
    void atualizarCarteira() {
        CarteiraDTO carteiraAtualizada = new CarteiraDTO(1L, "Carteira Atualizada", new HashSet<>(), Arrays.asList(new MesDTO()));
        when(carteiraService.atualizarCarteira(eq(1L), any(CarteiraDTO.class))).thenReturn(carteiraAtualizada);
        ResponseEntity<CarteiraDTO> response = carteiraController.atualizarCarteira(1L, carteiraAtualizada);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(carteiraAtualizada, response.getBody());
    }

    @Test
    void deletarCarteira() {
        doNothing().when(carteiraService).deletarCarteira(1L);
        ResponseEntity<Void> response = carteiraController.deletarCarteira(1L);
        assertEquals(204, response.getStatusCodeValue());
        verify(carteiraService, times(1)).deletarCarteira(1L);
    }
}
