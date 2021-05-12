package Capstone.DanieleTengaU1Capstone.service;

import Capstone.DanieleTengaU1Capstone.dao.*;
import Capstone.DanieleTengaU1Capstone.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class GameStoreService {

    ConsolesDao consolesDao;
    GamesDao gamesDao;
    InvoiceDao invoiceDao;
    ProcessingFeeDao processingFeeDao;
    SalesTaxRateDao salesTaxRateDao;
    TshirtsDao tshirtsDao;

    @Autowired
    public GameStoreService(ConsolesDao consolesDao, GamesDao gamesDao, InvoiceDao invoiceDao, ProcessingFeeDao processingFeeDao, SalesTaxRateDao salesTaxRateDao, TshirtsDao tshirtsDao) {
        this.consolesDao = consolesDao;
        this.gamesDao = gamesDao;
        this.invoiceDao = invoiceDao;
        this.processingFeeDao = processingFeeDao;
        this.salesTaxRateDao = salesTaxRateDao;
        this.tshirtsDao = tshirtsDao;
    }
    @Transactional
    public Consoles saveConsoles(Consoles consoles){
        return consolesDao.addConsole(consoles);
    }
    public void updateConsole(Consoles consoles) {
        consolesDao.updateConsole(consoles);
    }
    public List<Consoles> getAllConsoles (){
        return consolesDao.getAllConsoles();
    }
    public Consoles getConsolebyId(int id) {
       return consolesDao.getConsole(id);
    }
    public List<Consoles> getConsoleByManufacturer(String manufacturerId) {
        return consolesDao.getConsoleByManufacturer(manufacturerId);
    }
    public void removeConsole(int id) {
        consolesDao.deleteConsole(id);
    }

    @Transactional
    public Games saveGames(Games games){
        return gamesDao.addGames(games);
    }

    public void updateGames(Games games)
    {
        gamesDao.updateGame(games);
    }
    public List<Games> getAllGames(){
        return gamesDao.getAllGame();
    }
    public Games getGamebyId(int id) {
        return gamesDao.getGame(id);
    }

    public List<Games> getGameByStudio(String studioId) {
        return gamesDao.getGamesByStudio(studioId);
    }

    public List<Games> getGameByEsrb(String esrbId) {
        return gamesDao.getGamesByStudio(esrbId);
    }

    public List<Games> getGameByTitle(String titleId) {
        return gamesDao.getGamesByTitle(titleId);
    }
    public void removeGame(int id) {
        gamesDao.getGame(id);
    }


    @Transactional
    public Tshirt saveTshirt(Tshirt tshirt){
        return tshirtsDao.addTshirt(tshirt);
    }

    public void updateTshirt(Tshirt tshirt)
    {
        tshirtsDao.updateTshirt(tshirt);
    }
    public List<Tshirt> getAllTshirts(){
        return tshirtsDao.getAllTshirts();
    }

    public Tshirt getTshirtbyId(int id) {
        return tshirtsDao.getTshirt(id);
    }

    public List<Tshirt> getTshirtByColor(String colorId) {
        return tshirtsDao.getTshirtBycolor(colorId);
    }

    public List<Tshirt> getTshirtBySize(String sizeId) {
        return tshirtsDao.getTshirtBycolor(sizeId);
    }

    public void removeTshirt(int id) {
        tshirtsDao.getTshirt(id);
    }

//    @Transactional
//    public Invoice saveInvoice(Invoice invoice){
//        return invoiceDao.addInvoice(invoice);
//    }
    public Invoice getInvoice(Invoice invoice) {
        return invoiceDao.addInvoice(invoice);
    }
    @Transactional
    public Invoice addInvoice(Invoice userInput){//purchasing item is the invoice.... dduuuhhh

        userInput.setName(userInput.getName());
        userInput.setStreet(userInput.getStreet());
        userInput.setCity(userInput.getCity());
        userInput.setState(userInput.getState());
        userInput.setZipcode(userInput.getZipcode());
        userInput.setItem_type(userInput.getItem_type());
        userInput.setItem_id(userInput.getItem_id());
        userInput.setQuantity(userInput.getQuantity());


        //First get the processing fee using the userInput's item_type,
        //and we're going to pass that item_type into the getProcessingFee dao function

        ProcessingFee fee = processingFeeDao.getProcessingFee(userInput.getItem_type());

        //Next get the Sales Tax Rate using the userInput's state,
        //and we're going to pass that state into the getSalesTaxRate dao function

        SalesTaxRate rate = salesTaxRateDao.getSalesTaxRate(userInput.getState());

        //After this, we're going to parse the item type in either a switch or an if chain
        //EXAMPLE: if(userInput.getItem_Type().equalsIgnoreCase("t-shirts") then call the tshirt dao function for find by id
        //We then take that item object, grab the price, and plug that into the invoice's unit price variable

        /*
         * figures out the subtotal (quantity * unit price) and puts that on the invoice
         * figures out the tax (subtotal * state tax rate) and puts that on the invoice
         * figures out the processing fee (looks up in processing fee table, and applies any other business rules)
         *                                                  and puts that on the invoice
         * figures out the total (subtotal  + tax + processing fee) and puts that on the invoice
         *
         * puts the new invoice in the database
         *
         * returns the invoice
         */


        // figures out the subtotal (quantity * unit price) and puts that on the invoice


        if(userInput.getItem_type().equalsIgnoreCase("t-shirt")){
            userInput.setUnit_price(tshirtsDao.getTshirt(userInput.getItem_id()).getPrice());
        }
        else if(userInput.getItem_type().equalsIgnoreCase("games")){
            userInput.setUnit_price(tshirtsDao.getTshirt(userInput.getItem_id()).getPrice());
        }
        else if(userInput.getItem_type().equalsIgnoreCase("console")){
            userInput.setUnit_price(tshirtsDao.getTshirt(userInput.getItem_id()).getPrice());
        }

        //From there, we now have all of the information necessary to calculate the subtotal and total using price, quantity, processing fee, and taxes

        userInput.setSubtotal(findSubtotal(userInput.getQuantity(), userInput.getUnit_price())); //unit price multiplied by quantity //I created methods below and then called it here
        userInput.setTax(findTax(userInput.getSubtotal(),rate.getRate())); //rate multiplied by subtotal
        userInput.setProcessing_fee(fee.getFee()); //gotten from the dao call (plus additional 15.49 if quantity is > 10)
        if(userInput.getQuantity()> 10){
            userInput.setProcessing_fee(new BigDecimal("15.49").add(fee.getFee()));
        }
        userInput.setTotal(userInput.getSubtotal().add(userInput.getTax().add(userInput.getProcessing_fee()))); //add the subtotal, tax, and processing fee together

//        return userInput;
        return invoiceDao.addInvoice(userInput);
    }


    public BigDecimal findSubtotal(int quantity, BigDecimal unitPrice){

        BigDecimal bd = new BigDecimal(quantity);

        return unitPrice.multiply(bd);
    }

    public BigDecimal findTax(BigDecimal subtotal, BigDecimal taxRate){
        return subtotal.multiply(taxRate);
    }

    private Consoles buildConsole(Consoles consoles) {

        consoles.setConsole_id(consoles.getConsole_id());
        consoles.setPrice(consoles.getPrice());
        consoles.setQuantity(consoles.getQuantity());
        consoles.setProcessor(consoles.getProcessor());
        consoles.setModel(consoles.getModel());
        consoles.setMemory_amount(consoles.getMemory_amount());
        consoles.setManufacturer(consoles.getManufacturer());

        return consoles;
    }

//    private Games buildGame(Games games) {
//
//        games.setGame_id(games.getGame_id());
//        games.setTitle(games.getTitle());
//        games.setEsrb_rating(games.getEsrb_rating());
//        games.setDescription(games.getDescription());
//        games.setStudio(games.getStudio());
//        games.setPrice(games.getPrice());
//        games.setQuantity(games.getQuantity());
//
//        return games;
//    }
    private Tshirt buildTshirt(Tshirt tshirt) {

        tshirt.setTshirt_Id(tshirt.getTshirt_Id());
        tshirt.setColor(tshirt.getColor());
        tshirt.setSize(tshirt.getSize());
        tshirt.setDescription(tshirt.getDescription());
        tshirt.setQuantity(tshirt.getQuantity());

        return tshirt;
    }
    private Invoice buildInvoice(Invoice invoice){
        invoice.setQuantity(invoice.getQuantity());
        invoice.setProcessing_fee(invoice.getProcessing_fee());
        invoice.setInvoice_id(invoice.getInvoice_id());
        invoice.setSubtotal(invoice.getSubtotal());
        invoice.setTotal(invoice.getTotal());
        invoice.setTax(invoice.getTax());
        invoice.setUnit_price(invoice.getUnit_price());
        invoice.setZipcode(invoice.getZipcode());
        invoice.setState(invoice.getState());
        invoice.setStreet(invoice.getStreet());
        invoice.setName(invoice.getName());
        invoice.setCity(invoice.getCity());

        return invoice;
    }
}
