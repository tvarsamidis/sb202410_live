package gr.codehub.sb.controller;

import gr.codehub.sb.domain.Customer;
import gr.codehub.sb.service.CustomerService;
import gr.codehub.sb.service.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("{customerId}")
    public Customer findCustomerById(@PathVariable long customerId){
        Customer response = customerService.findCustomerById(customerId);
        return response;
    }

    @GetMapping("/all")
    public List<Customer> findAllCustomers(){
        List<Customer> response = customerService.findAllCustomers();
        return response;
    }

    @GetMapping("/search")
    public List<Customer> findCustomerRange(@RequestParam Long from, @RequestParam(required = false) Long to){
        List<Customer> response = customerService.findCustomerRange(from, to);
        return response;
    }
}
