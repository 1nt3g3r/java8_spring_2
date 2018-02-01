package com.tstproject.web.controller;

import com.tstproject.db.entity.Cat;
import com.tstproject.db.repository.CatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CatController {
    @Autowired
    private CatRepository catRepository;

    @RequestMapping("/cat/catsWithSpaces")
    public @ResponseBody List<Cat> catsWithSpaces() {
        return catRepository.getCatsWithSpaces();
    }

    @RequestMapping(value = "/cat/listAll", method = RequestMethod.GET)
    public @ResponseBody List<Cat> listCats() {
        return catRepository.findAll();
    }

    @RequestMapping(value = "/cat/add", method = RequestMethod.GET)
    public @ResponseBody String add(@RequestParam("catName") String catName) {
        Cat cat = new Cat();
        cat.setName(catName);

        catRepository.save(cat);

        return catName + " was added!";
    }

    @RequestMapping(value = "/cat/className", method = RequestMethod.GET)
    public @ResponseBody String catRepositoryClassName() {
        return catRepository.getClass().getCanonicalName();
    }
}
