package com.plazti.platzimarker.persistence;

import com.plazti.platzimarker.domain.DoPurchase;
import com.plazti.platzimarker.domain.repository.DoPurchaseRepository;
import com.plazti.platzimarker.persistence.crud.CompraCrudRepository;
import com.plazti.platzimarker.persistence.entity.Compra;
import com.plazti.platzimarker.persistence.mapper.PurchaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CompraRepository implements DoPurchaseRepository {

    @Autowired
    private CompraCrudRepository compraCrudRepository;

    @Autowired
    private PurchaseMapper mapper;


    @Override
    public List<DoPurchase> getAll() {
        return  mapper.toDoPurchaseList((List<Compra>) compraCrudRepository.findAll());
    }

    @Override
    public Optional<List<DoPurchase>> getByClient(String clientId) {
        return compraCrudRepository.findByIdCliente(clientId)
                .map(puch -> mapper.toDoPurchaseList(puch));
    }

    @Override
    public DoPurchase save(DoPurchase purchase) {
        Compra compra = mapper.toCompra(purchase);
        //tenemos que garantizar que toda esta info se va a guardar en cascada,
        //para esto tenemos que estar seguros de que compra conoce los productos, y los productos
        //conocen a que compras pertenecen
        compra.getProductos().forEach(p -> p.setCompra(compra));

        return mapper.toDoPurchase(compraCrudRepository.save(compra));
    }
}
