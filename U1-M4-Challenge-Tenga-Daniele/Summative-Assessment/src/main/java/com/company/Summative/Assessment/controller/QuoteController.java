package com.company.Summative.Assessment.controller;

import com.company.Summative.Assessment.model.Quote;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class QuoteController {

    private List<Quote> quote;

    public QuoteController() {
        quote = new ArrayList<>();

        quote.add(new Quote("Alvin Toffler","The illiterate of the 21st century will not be those who cannot read and write, but those who cannot learn, unlearn, and relearn.",1));
        quote.add(new Quote("Charlotte Eriksson", "So many people will tell you ”no”, and you need to find something you believe in so hard that you just smile and tell them ”watch me”. Learn to " +
                "take rejection as motivation to prove people wrong. Be unstoppable. Refuse to give up, no matter what. It’s the best skill you can ever learn.",2));
        quote.add(new Quote("Daniele Tenga","I used to tell myself I wasn't THAT kind of smart. Don't ever tell yourself you're not THAT kind of smart. You end up short selling yourself.",3));
        quote.add(new Quote("Erin Hanson","“There is freedom waiting for you, On the breezes of the sky, And you ask What if I fall? Oh but my darling, What if you fly?",4));
        quote.add(new Quote("Milton Berie", "If oppurtunity doesn't knock, Build a door.",5));
        quote.add(new Quote("Albert Einstein","Anyone who has never made a mistkae has never tried anything new.",6));
        quote.add(new Quote("Lao Tzu","being deeply loved by someone gives you strength, while loving someone deeply gives you courage.",7));
        quote.add(new Quote("Criss Jami","As long as I am breathing, in my eyes, I am just beginning.",8));
        quote.add(new Quote("Shakespear","I cried when I had no shoes, but I stopped crying when I saw a man without legs. Life is full of blessings, sometime we don't value it.",9));
        quote.add(new Quote("C.S. Lewis","“To love at all is to be vulnerable. Love anything and your heart will be wrung and possibly broken. If you want to make sure of keeping it intact " +
                "you must give it to no one, not even an animal. Wrap it carefully round with hobbies and little luxuries; avoid all entanglements. Lock it up safe in the casket or coffin of your selfishness. " +
                "But in that casket, safe, dark, motionless, airless, it will change. It will not be broken; it will become unbreakable, impenetrable, irredeemable. To love is to be vulnerable.”",10));
    }
    //URI: /quote
    //Method: GET
    //Request Body: None
    //Response Body: Quote
    //Your service must contain at least 10 quotes. Quotes must be served up at random.
    @RequestMapping(value = "/quote",method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Quote getQuote(){
        Random random = new Random(); //randomizes quotes

        Quote randomElement = quote.get(random.nextInt(quote.size()));
        return randomElement;
    }
}
