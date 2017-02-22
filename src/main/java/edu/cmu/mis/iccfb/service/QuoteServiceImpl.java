package edu.cmu.mis.iccfb.service;

import java.util.ArrayList;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import edu.cmu.mis.iccfb.model.Author;
import edu.cmu.mis.iccfb.model.Quote;


public class QuoteServiceImpl implements QuoteServiceCustom {
    
    @Autowired
    private QuoteService quoteService;
    
    
    
   
    @Override    
    public Author[] listName() {
       
        ArrayList<Quote> quotes = new ArrayList<Quote>();
        
        for (Quote q: this.quoteService.findAll() ) {
                 quotes.add(q);
        }
        
        ArrayList<Author> names = new ArrayList<Author>();
        
        for (int i=0; i< quotes.size(); i++) {
        	  int check=0;
        	for (int j=0; j< i;j++) {
        		if (quotes.get(i).getAuthor().getName().equals(quotes.get(j).getAuthor().getName())) {
               	 check=1;
                }
          	}
        	 if (check==0) {
        		 Author au = new Author();
        		 au.setName(quotes.get(i).getAuthor().getName());
        		 au.setId(quotes.get(i).getAuthor().getId());
        		 names.add(au);
        	 }      
        }
        return names.toArray(new Author[names.size()]);
    }
}

