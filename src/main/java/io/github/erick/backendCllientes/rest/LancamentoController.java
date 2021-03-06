package io.github.erick.backendCllientes.rest;

import io.github.erick.backendCllientes.model.entity.Lancamento;
import io.github.erick.backendCllientes.rest.dto.InformacoesLancamentoDTO;
import io.github.erick.backendCllientes.rest.dto.LancamentoDTO;
import io.github.erick.backendCllientes.service.LancamentoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/lancamentos")
@AllArgsConstructor
public class LancamentoController {


    private final LancamentoService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Lancamento salvar(@RequestBody @Validated LancamentoDTO lancamentoDTO ){
        try {
            return  service.salvar(lancamentoDTO);

        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    };

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateLancamento(@PathVariable Integer id, @RequestBody @Validated LancamentoDTO lancamentoDTOAtualizado){
        try{
            service.updateLancamento(id, lancamentoDTOAtualizado);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteLancamento(@PathVariable Integer id){
        try {
            service.deleteLancamento(id);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }



}
