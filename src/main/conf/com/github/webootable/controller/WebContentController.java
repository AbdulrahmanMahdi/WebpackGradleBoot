package com.github.webootable.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by developerSid on 12/31/16.
 */
@Controller
public class WebContentController
{
   @RequestMapping("/")
   public String index()
   {
      return "index";
   }
}
