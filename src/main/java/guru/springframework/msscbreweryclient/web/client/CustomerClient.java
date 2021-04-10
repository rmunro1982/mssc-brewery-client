package guru.springframework.msscbreweryclient.web.client;

import guru.springframework.msscbreweryclient.web.model.CustomerDto;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

@Component
@ConfigurationProperties(prefix = "gsf.client", ignoreUnknownFields = false)
public class CustomerClient {

    @Setter
    private String apihost;
    private final String apiPath = "/api/v1/customers";

    private RestTemplate restTemplate;

    public CustomerClient(RestTemplateBuilder templateBuilder) {
        restTemplate = templateBuilder.build();
    }

    public CustomerDto getCustomer(UUID uuid){
        return restTemplate.getForObject(apihost + apiPath + "/" + uuid.toString(), CustomerDto.class);
    }

    public URI createCustomer(CustomerDto customerDto) {
        return restTemplate.postForLocation(apihost + apiPath, customerDto);
    }

    public void updateCustomer(CustomerDto customerDto, UUID uuid) {
        restTemplate.put(apihost + apiPath + "/" + uuid.toString(), customerDto);
    }

    public void deleteCustomer(UUID uuid) {
        restTemplate.delete(apihost + apiPath + "/" + uuid.toString());
    }
}
