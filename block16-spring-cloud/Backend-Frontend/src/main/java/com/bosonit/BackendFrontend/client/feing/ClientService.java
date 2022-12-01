package com.bosonit.BackendFrontend.client.feing;

import com.bosonit.BackendFrontend.client.infrastrucutre.ClientOutputDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="client-frontend",url = "http://localhost:8080")
public interface ClientService {

    @GetMapping("client/{id}")
    public ClientOutputDto getById(@PathVariable Long id);
}
