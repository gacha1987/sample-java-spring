package hello.hello.service;

import hello.hello.domain.Customer;
import hello.hello.domain.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> search(String search) {
        if (search == null || search.isEmpty()) {
            return this.customerRepository.findAll();
        }
        return this.customerRepository.findByNameLike(search);
    }

    public void save(String name, int age) {
        Customer customer = new Customer();
        customer.setName(name);
        customer.setAge(age);
        this.customerRepository.save(customer);
    }
}
