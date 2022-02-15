package com.sunglowsys.rest;

import com.sunglowsys.domain.Customer;
import com.sunglowsys.rest.util.BadRequestException;
import com.sunglowsys.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api")
public class CustomerResource {

    private final Logger log = LoggerFactory.getLogger(CustomerResource.class);

    private final CustomerService customerService;


    public CustomerResource(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/")
    public String home(Pageable pageable, Model model) {
        log.debug("REST request to get Customers : {} ", pageable.toString());
        Page<Customer> page = customerService.findAll(pageable);
        List<Customer> result = page.getContent();
        System.out.println(result);
        model.addAttribute("customer", result);
        return "index";
    }

    @GetMapping("/customers/create")
    public String createCustomerForm(Model model) {
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        return "add-customer";
    }

    @PostMapping("/customers")
    public String createCustomers(@ModelAttribute("customer") Customer customer) throws URISyntaxException {
        log.debug("REST request to create Customer : {}", customer);
        if (customer.getId() == null) {
            customerService.save(customer);
        }
        if (customer.getId() != null) {
            customerService.update(customer);
        }
        return "redirect:/api/";
    }

    @GetMapping("/_search/customers")
    public String searchCustomers(String searchText, Model model) {
        log.debug("REST request to search Customers : {}", searchText);
        List<Customer> customer = customerService.search(searchText);
        return "index";
    }

    @GetMapping("/customers/update/{id}")
    public String updateCustomer(@PathVariable Long id, Model model) {
        Customer customer = customerService.findById(id).get();
        model.addAttribute("customer", customer);
        return "add-customer";
    }

    @GetMapping("/customers/delete/{id}")
    public String deleteCustomer(@PathVariable Long id) {
        log.debug("REST request to delete Customer : {}", id);
        customerService.delete(id);
        return "redirect:/api/";
    }
}
