package com.tstproject.quote;

import com.tstproject.db.entity.Quote;
import com.tstproject.db.repository.QuoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class DatabaseQuoteService implements QuoteService {
    @Autowired
    private QuoteRepository quoteRepository;

    private Random random = new Random();

    @Override
    public String getQuote() {
        List<Quote> allQuotes = quoteRepository.findAll();
        if (allQuotes.size() == 0) {
            return "No quotes :(";
        }

        int index = random.nextInt(allQuotes.size());

        Quote quote = allQuotes.get(index);
        return quote.getText() + ", ID=" + quote.getId();
    }
}
