package com.upc.eccomerce.services;

import com.upc.eccomerce.entities.Reto;
import com.upc.eccomerce.exception.OrderNotFoundException;
import com.upc.eccomerce.repository.RetosRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class RetosService {
    private RetosRepository retosRepository;

    public RetosService(RetosRepository retosRepository){
        this.retosRepository = retosRepository;
    }

    public Reto getRetoById(Integer id){
        return retosRepository.findById(id)
                .orElseThrow(()->new OrderNotFoundException("La actividad grupal no existe"));
    }

    public Reto createdRetos(Reto retos){
        return retosRepository.save(retos);
    }

    public Reto updateRetos(Reto retos){

        Reto retoFromDb = this.getRetoById(retos.getId());

        retoFromDb.setId(retos.getId());
        retoFromDb.setActivity_owner_id(retos.getActivity_owner_id());
        retoFromDb.setActivity_id(retos.getActivity_id());
        retoFromDb.setSender_id(retos.getSender_id());
        retoFromDb.setRecipient_id(retos.getRecipient_id());

        return retosRepository.save(retos);
    }
    @Transactional
    public void deleteRetos(Integer retosId){

        Reto retos = this.getRetoById(retosId);

        retosRepository.delete(retos);
    }
}
