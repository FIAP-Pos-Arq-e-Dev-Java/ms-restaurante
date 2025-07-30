package com.fiap.ms.restaurante.application.usecase.address;

import com.fiap.ms.restaurante.domain.model.AddressDomain;
import com.fiap.ms.restaurante.domain.model.TipoCozinhaDomain;

import java.util.List;

public interface FindAddressUseCase {

    List<AddressDomain> findAddress(String cidade, String estado);
}
