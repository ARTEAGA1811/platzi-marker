package com.plazti.platzimarker.domain.service;

import com.plazti.platzimarker.domain.DoPurchase;
import com.plazti.platzimarker.domain.repository.DoPurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//Nuestros servicios son negociadores entre el repositorio y los controladores
@Service
public class PurchaseService {
    @Autowired
    private DoPurchaseRepository doPurchaseRepository;

    public List<DoPurchase> getAll(){
        return doPurchaseRepository.getAll();
    }
    public Optional<List<DoPurchase>> getByClient(String clientId){
        return doPurchaseRepository.getByClient(clientId);
    }
    public DoPurchase save(DoPurchase purchase){
        return doPurchaseRepository.save(purchase);
    }
}
