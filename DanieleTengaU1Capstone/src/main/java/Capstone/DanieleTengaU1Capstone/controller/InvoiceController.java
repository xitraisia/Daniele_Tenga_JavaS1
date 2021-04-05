package Capstone.DanieleTengaU1Capstone.controller;

import Capstone.DanieleTengaU1Capstone.model.Games;
import Capstone.DanieleTengaU1Capstone.model.Invoice;
import Capstone.DanieleTengaU1Capstone.service.GameStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class InvoiceController {

    @Autowired
    GameStoreService gameStoreService;


    @RequestMapping(value = "/invoice", method = RequestMethod.POST)
    @PostMapping("/invoice")
    @ResponseStatus(HttpStatus.CREATED)
    public Invoice createInvoice(@RequestBody @Valid Invoice invoice){
        return gameStoreService.addInvoice(invoice);
    }

}
