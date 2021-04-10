package guru.springframework.msscbreweryclient.web.client;

import guru.springframework.msscbreweryclient.web.model.CustomerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomerClientTest {

    @Autowired
    private CustomerClient client;

    @Test
    void getCustomer() {
        CustomerDto customer = client.getCustomer(UUID.randomUUID());

        assertNotNull(customer);
    }

    @Test
    void createCustomer() {
        CustomerDto customer = CustomerDto.builder().build();
        URI customerUri = client.createCustomer(customer);
        assertNotNull(customerUri);
    }

    @Test
    void updateCustomer() {
        CustomerDto customer = CustomerDto.builder().build();
        UUID id = UUID.randomUUID();
        client.updateCustomer(customer, id);
    }

    @Test
    void deleteCustomer() {
        client.deleteCustomer(UUID.randomUUID());
    }
}