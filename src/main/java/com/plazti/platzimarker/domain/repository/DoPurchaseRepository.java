package com.plazti.platzimarker.domain.repository;

import com.plazti.platzimarker.domain.DoPurchase;

import java.util.List;
import java.util.Optional;

public interface DoPurchaseRepository {
    List<DoPurchase> getAll();
    Optional<List<DoPurchase>> getByClient(String clientId);
    DoPurchase save(DoPurchase purchase);
}
