package br.projeto.mywallet.Controller;

import br.projeto.mywallet.exception.BancoJaExisteException;
import br.projeto.mywallet.exception.BancoNaoEncontradoException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 *
 * @author wilsonramos
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(BancoNaoEncontradoException.class)
    public ResponseEntity<ProblemDetail> handleBancoNaoEncontradoException(BancoNaoEncontradoException ex) {
        return createProblemDetail(HttpStatus.NOT_FOUND, "Banco não encontrado", ex.getMessage());
    }

    @ExceptionHandler(BancoJaExisteException.class)
    public ResponseEntity<ProblemDetail> handleBancoJaExisteException(BancoJaExisteException ex) {
        return createProblemDetail(HttpStatus.CONFLICT, "Banco já existe", ex.getMessage());
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ProblemDetail> handleRuntimeException(RuntimeException ex) {
        logger.error("Erro interno no servidor: ", ex);

        return createProblemDetail(
                HttpStatus.INTERNAL_SERVER_ERROR,
                "Erro interno no servidor",
                ex.getMessage());
    }

    private ResponseEntity<ProblemDetail> createProblemDetail(HttpStatus status, String title, String detail) {
        ProblemDetail problemDetail = ProblemDetail.forStatus(status);
        problemDetail.setTitle(title);
        problemDetail.setDetail(detail);

        return ResponseEntity.status(status).body(problemDetail);
    }

}
