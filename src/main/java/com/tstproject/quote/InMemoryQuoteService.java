package com.tstproject.quote;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class InMemoryQuoteService implements QuoteService {
    private String[] quotes = {
        "Quote 1",
        "Heroes never die",
        "Cats and dogs"
    };

    private Random random = new Random();

    @Override
    public String getQuote() {
        int index = random.nextInt(quotes.length);
        return quotes[index];
    }
}
