package com.lizo.circuitbreaker.integration;

import com.lizo.circuitbreaker.integration.domain.Cep;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "${feign.client.config.cep.feignName}", url = "${feign.client.config.cep.url}", fallback = CepIntegration.CepIntegrationFallback.class)
public interface CepIntegration {

    @GetMapping("/cep/{cep}")
    Cep get(@PathVariable("cep") final String cep);

    @Component
    class CepIntegrationFallback implements CepIntegration {

        @Override
        public Cep get(String cep) {
            Cep cepObj = new Cep();
            cepObj.setCidade("Nowhere");
            cepObj.setBairro("Noplace");
            cepObj.setEstado("Nostate");
            cepObj.setLogradouro("Nostreet");
            return cepObj;
        }
    }
}
