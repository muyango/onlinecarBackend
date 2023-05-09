package com.bernice.onlineCarTrade.Controller;


import com.bernice.onlineCarTrade.Model.TransactionEntity;
import com.bernice.onlineCarTrade.Model.carCustomer;
import com.bernice.onlineCarTrade.Model.carEntity;
import com.bernice.onlineCarTrade.Repository.CustomerRepo;
import com.bernice.onlineCarTrade.Repository.carRepo;
import com.bernice.onlineCarTrade.Repository.transactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/cartrade")
public class carTradeController {

    @Autowired
    carRepo repo;
    @Autowired
    CustomerRepo custrepo;
    @Autowired
    transactionRepo trepo;
    @RequestMapping(path = "/getcars",method= RequestMethod.GET)
    public ResponseEntity<List<carEntity>> getAllcars()
    {
        List<carEntity>list=repo.findAll();
        if(list.isEmpty())
        {
            System.out.println("empty table");
            return new ResponseEntity<List<carEntity>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<carEntity>>(list, HttpStatus.OK);
    }

    @RequestMapping(path = "/addcar",method=RequestMethod.POST)
    public ResponseEntity<carEntity>savecar(@RequestBody carEntity ca)
    {
        repo.save(ca);
        return new ResponseEntity<>(ca,HttpStatus.CREATED);
    }

    @RequestMapping(value = "getonecar/{id}",method=RequestMethod.GET)
    public ResponseEntity<carEntity>getonecar(@PathVariable("id")int id)
    {
        carEntity ca=repo.findById(id).get();
        return new ResponseEntity<carEntity>(ca,HttpStatus.OK);
    }
    @RequestMapping(value = "deleteCar/{id}",method=RequestMethod.DELETE)
    public ResponseEntity<Void>DeleteCar(@PathVariable("id")int id)
    {
        repo.deleteById(id);
        return new ResponseEntity<Void>(HttpStatus.GONE);
    }

    //carCustomers

    @RequestMapping(path = "/addcustomer",method=RequestMethod.POST)
    public ResponseEntity<carCustomer>saveCustomer(@RequestBody carCustomer cus)
    {
        custrepo.save(cus);
        return new ResponseEntity<>(cus,HttpStatus.CREATED);
    }

    @RequestMapping(path = "/getcustomer",method= RequestMethod.GET)
    public ResponseEntity<List<carCustomer>> getAllcustomers()
    {
        List<carCustomer>list=custrepo.findAll();
        if(list.isEmpty())
        {
            System.out.println("empty table");
            return new ResponseEntity<List<carCustomer>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<carCustomer>>(list, HttpStatus.OK);
    }

    @RequestMapping(path = "/gettransactions",method= RequestMethod.GET)
    public ResponseEntity<List<TransactionEntity>> getAllTransactions()
    {
        List<TransactionEntity>list=trepo.findAll();
        if(list.isEmpty())
        {
            System.out.println("empty table");
            return new ResponseEntity<List<TransactionEntity>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<TransactionEntity>>(list, HttpStatus.OK);
    }

    @RequestMapping(path = "/addtransaction",method=RequestMethod.POST)
    public ResponseEntity<TransactionEntity>saveTransaction(@RequestBody TransactionEntity ca)
    {
        trepo.save(ca);
        return new ResponseEntity<>(ca,HttpStatus.CREATED);
    }
}
