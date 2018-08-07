package com.example.Service;

import com.example.Model.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PersonService {

        public static List<Person> findAll(){
        Random rnd=new Random();
                List<Person> people=new ArrayList<>();
                for(int i =0; i<300; i++){
                        people.add(new Person(rnd.nextLong()*5000,"Person " + i, "Surname" +i, "email" + i+"@vaadin.com"));
                }
                return people;
        }
}
