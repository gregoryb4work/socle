package fr.gba.socle.generique.metaparameter.client;

import org.springframework.cloud.netflix.feign.FeignClient;

import fr.gba.socle.generique.metaparameter.resource.MetaParameterResource;

@FeignClient(name = "metaparameter-service", url = "localhost:19000")
public interface MetaParameterWSRestClient extends MetaParameterResource {

}
