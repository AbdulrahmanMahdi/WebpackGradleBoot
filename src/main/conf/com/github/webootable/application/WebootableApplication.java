package com.github.webootable.application;

import com.github.webootable.configuration.ApplicationConfiguration;
import org.springframework.boot.SpringApplication;

/**
 * Created by developerSid on 12/28/16.
 */
public class WebootableApplication
{
   public static void main(String[] args)
   {
      SpringApplication.run(ApplicationConfiguration.class, args);
   }
}
