package com.company.Summative.Assessment.controller;

import com.company.Summative.Assessment.model.Quote;
import com.company.Summative.Assessment.model.Word;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
public class WordController {

    private List<Word> word;

    public WordController() {
        word = new ArrayList<>();

        word.add(new Word("Quixotic","not sensible about practical matters.",1));
        word.add(new Word("Ken","range of what one can know or understand",2));
        word.add(new Word("abject","(of a person or their behavior) completely without pride or dignity; self-abasing.",3));
        word.add(new Word("jejune","something that is uninteresting or insignificant",4));
        word.add(new Word("latibule","a hiding place; a place of safety and comfort",5));
        word.add(new Word("gorgonize","to have a paralyzing or mesmerizing effect on someone",6));
        word.add(new Word("philocalist","a lover of beauty; someone who finds and appreciates beauty in all things.",7));
        word.add(new Word("enigmatic","difficult to understand or explain",8));
        word.add(new Word("sonder","the realization that each passerby has a life as vivid and complex as your own",9));
        word.add(new Word("meraki","to do something with soul, creativity, or love to put something of yourself into your work.",10));
    }

    //URI: /word
    //Method: GET
    //Request Body: None
    //Response Body: Definition
    @RequestMapping(value = "/word",method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Word getWord(){
        Random random = new Random(); //randomizes quotes

        Word randomElement = word.get(random.nextInt(word.size()));
        return randomElement;
    }
}
