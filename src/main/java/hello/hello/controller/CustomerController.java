package hello.hello.controller;

import hello.hello.domain.Customer;
import hello.hello.domain.CustomerRepository;
import hello.hello.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerService customerService;

    @RequestMapping("/")
    public String index() {
        return "customer/index";
    }

    @GetMapping("/list")
    public String list(Model model, @RequestParam(required = false, defaultValue="") String search) {
        String searcString = search.isEmpty() ? "all" : search;
        model.addAttribute("customers", this.customerService.search(search));
        model.addAttribute("search", searcString);
        return "customer/list";
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
