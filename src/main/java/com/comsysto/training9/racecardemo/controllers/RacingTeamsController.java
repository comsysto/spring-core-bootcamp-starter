package com.comsysto.training9.racecardemo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()
public class RacingTeamsController {

  @GetMapping("/helloworld")
  public String helloWorld(){

    return "hello world";
  }


}
