package hello.hello.controller;

import hello.hello.domain.Customer;
import hello.hello.domain.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;

    @RequestMapping("/")
    public @ResponseBody String greeting() {
        return "Hello World";
    }

    @GetMapping(path="/add")
    public @ResponseBody String addCustomer(@RequestParam String name, @RequestParam int age) {
        Customer customer = new Customer();
        customer.setName(name);
        customer.setAge(age);
        customerRepository.save(customer);
        return "Saved";
    }
}
