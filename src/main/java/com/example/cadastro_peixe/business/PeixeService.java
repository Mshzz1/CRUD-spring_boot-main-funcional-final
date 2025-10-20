package com.example.cadastro_peixe.business;

import com.example.cadastro_peixe.infrastructure.entitys.Peixe;
import com.example.cadastro_peixe.infrastructure.repository.PeixeRepository;
import org.springframework.stereotype.Service;

@Service

public class PeixeService {
    private final PeixeRepository repository;

    public PeixeService(PeixeRepository repository) {
        this.repository = repository;
    }

    public void salvarPeixe(Peixe peixe){
        repository.saveAndFlush(peixe);
    }

    public Peixe buscarPeixePorId(Integer id){
        return repository.findById(id).orElseThrow(
                () -> new RuntimeException("id não encontrado")
        );
    }

    public void deletarPeixePorId(Integer id){
        repository.deleteById(id);
    }

    public void atualizarPeixePorId(Integer id, Peixe peixe){
        Peixe peixeEntity = repository.findById(id).orElseThrow(
                () -> new RuntimeException("Peixe não encontrado"));

        Peixe peixeAtualizado = Peixe.builder()
                .id(peixe.getId() != null ? peixe.getId() : peixeEntity.getId())
                .especie(peixe.getEspecie() != null ? peixe.getEspecie() : peixeEntity.getEspecie())
                .observacoes(peixe.getObservacoes() != null ? peixe.getObservacoes() : peixeEntity.getObservacoes())
                .quantidade_unidades(peixe.getQuantidade_unidades() != null ? peixe.getQuantidade_unidades() : peixeEntity.getQuantidade_unidades())
                .tanque_id(peixe.getTanque_id() != null ? peixe.getTanque_id() : peixeEntity.getTanque_id())
                .build();
        repository.saveAndFlush(peixeAtualizado);
    }
}
