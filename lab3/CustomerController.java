package com.example.lab1;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CustomerController {
    private List<Customer> customers = new ArrayList<Customer>();

    public CustomerController(){
        customers.add(new Customer("1010","John","Male", 25));
        customers.add(new Customer("1018","Peter","Male", 24));
        customers.add(new Customer("1019","Sara","Female", 23));
        customers.add(new Customer("1110","Rose","Female", 23));
        customers.add(new Customer("1001","Emma","Female", 30));
    }

    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    public List<Customer> getCustomers(){
        return customers;
    }

    @RequestMapping(value = "/customerbyid/{id}", method = RequestMethod.GET)
    public Customer getCustomerByID(@PathVariable("id") String ID){
        for (Customer customer : customers) {
            if (customer.getID().equals(ID)) {
                return customer;
            }
        }
        return null;
    }

    @RequestMapping(value = "/customerbyname/{n}", method = RequestMethod.GET)
    public Customer getCustomerByName(@PathVariable("n") String name){
        for (Customer customer : customers) {
            if(customer.getName().equals(name)) {
                return customer;
            }
        }
        return null;
    }

    @RequestMapping(value = "/customerDelByid/{id}", method = RequestMethod.DELETE)
    public boolean delCustomerByID(@PathVariable("id") String ID){
        for (Customer customer : customers) {
            if(customer.getID().equals(ID)) {
                customers.remove(customer);
                return true;
            }
        }
        return false;
    }

    @RequestMapping(value = "/customerDelByname/{n}", method = RequestMethod.DELETE)
    public boolean delCustomerByName(@PathVariable("n") String name){
        for (Customer customer : customers) {
            if(customer.getName().equals(name)) {
                customers.remove(customer);
                return true;
            }
        }
        return false;
    }

    @RequestMapping(value = "/addCustomer", method = RequestMethod.GET)
    public boolean addCustomer(@RequestParam("ID") String ID, @RequestParam("n") String name, @RequestParam("s") String sex, @RequestParam("a") int age) {
        customers.add(new Customer(ID, name, sex, age));
        return true;
    }

    @RequestMapping(value = "/addCustomer2", method = RequestMethod.POST)
    public boolean addCustomer2(@RequestParam("ID") String ID, @RequestParam("n") String name, @RequestParam("s") String sex, @RequestParam("a") int age) {
        customers.add(new Customer(ID, name, sex, age));
        return true;
    }
}
