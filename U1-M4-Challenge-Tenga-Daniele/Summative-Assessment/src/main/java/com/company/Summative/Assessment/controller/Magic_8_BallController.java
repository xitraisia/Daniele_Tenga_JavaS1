package com.company.Summative.Assessment.controller;

import com.company.Summative.Assessment.model.Magic_8_Ball;
import com.company.Summative.Assessment.model.Quote;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

@RestController
public class Magic_8_BallController {

    private List<Magic_8_Ball> magic;

    public Magic_8_BallController() {

        magic = new ArrayList<>();

        magic.add(new Magic_8_Ball("As I see it, yes.",1));
        magic.add(new Magic_8_Ball("Ask again later.",2));
        magic.add(new Magic_8_Ball("Don't count on it.",3));
        magic.add(new Magic_8_Ball("It is certain.",4));
        magic.add(new Magic_8_Ball("It is decidedly so.",5));
        magic.add(new Magic_8_Ball("My sources say no.",6));


    }
    //URI: /magic
    //Method: POST
    //Request Body: Question
    //Response Body: Answer
    @RequestMapping(value = "/magic",method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Magic_8_Ball createMagic(@Valid @RequestBody Magic_8_Ball magic_8_ball){

        Random random = new Random(); //randomizes answers

        //make the parameter equal the randomized answers
        magic_8_ball = magic.get(random.nextInt(magic.size()));


        return magic_8_ball;
    }
}
