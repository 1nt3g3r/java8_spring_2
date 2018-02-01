package com.tstproject.web.controller;

import com.tstproject.db.entity.Quote;
import com.tstproject.db.repository.QuoteRepository;
import com.tstproject.quote.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class QuoteController {
    @Autowired
    @Qualifier("databaseQuoteService")
    private QuoteService quoteService;

    @Autowired
    private QuoteRepository quoteRepository;

    @RequestMapping("/quote/show")
    public String showQuote(ModelMap modelMap) {
        modelMap.put("quote", quoteService.getQuote());
        return "quote";
    }

    @RequestMapping(value = "/quote/add", method = RequestMethod.GET)
    public String addQuote(ModelMap modelMap, @RequestParam("quote") String quote) {
        quoteRepository.save(new Quote(quote));

        modelMap.put("quote", quote);
        modelMap.put("quoteCount", quoteRepository.count());
        return "quote-added";
    }

    @RequestMapping(value = "/quote/delete/{id}", method = RequestMethod.GET)
    public String deleteQuote(ModelMap modelMap, @PathVariable("id") String id) {
        quoteRepository.delete(Long.parseLong(id));
        modelMap.put("quoteCount", quoteRepository.count());
        return "quote-deleted";
    }
}
