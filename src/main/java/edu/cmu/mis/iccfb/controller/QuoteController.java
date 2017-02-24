package edu.cmu.mis.iccfb.controller;

//import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.cmu.mis.iccfb.model.Author;
import edu.cmu.mis.iccfb.model.Quote;
import edu.cmu.mis.iccfb.service.AuthorService;
import edu.cmu.mis.iccfb.service.QuoteService;

@RestController
public class QuoteController {
    
    @Autowired
    private QuoteService quoteService;
    
    @Autowired
    private AuthorService authorService;
    
    @RequestMapping("/api/author/list")
    public Author[] list() {    	
      return quoteService.listName();
    }
    
    @RequestMapping(value = "/api/author", method = RequestMethod.POST)
    public void saveQuote(@RequestBody Quote quote) {
            authorService.save(quote.getAuthor());
    }
    
}
