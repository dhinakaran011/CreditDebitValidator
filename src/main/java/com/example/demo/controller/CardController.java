package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.CardDAO;
import com.example.demo.model.CardModel;

@Controller
public class CardController{
    @Autowired
    CardDAO crdao;
    
    @RequestMapping("index")
    public String index(){
        return "index.jsp";
    }

    @RequestMapping("gettingData")
    public String details(CardModel cmodel){

        long atm = cmodel.getAtm();
        
        String str = Long.toString(atm);
        char[] arr = str.toCharArray();
        int[] orgarr = new int[arr.length];

        for(int i=0;i<orgarr.length;i++){
            orgarr[i] = (int)(arr[i]);
        }
       
        for(int i=orgarr.length-1;i>=0;i-=2){
            orgarr[i] *= 2;
        }
        
        for(int i=0;i<orgarr.length;i++){
                int sum = orgarr[i]%10 + orgarr[i]/10;
                orgarr[i] = sum;
        }
        int res = 0;
        for(int i=0;i<orgarr.length;i++){
            res += orgarr[i];
        }
        if(res%9 == 0){
           // valid = "this is valid";
           cmodel.setValid("this is valid");
        }
        else{
            //valid = "this is not valid";
            cmodel.setValid("this not valid");
        }
        
        
        crdao.save(cmodel);
        return "index.jsp";
    }

     @RequestMapping("DisplayData")
     public ModelAndView displayData(CardModel cdm){
         long atm = cdm.getAtm();
         Optional<CardModel> opt = crdao.findById(atm);
         CardModel e1 = opt.get();
       





         ModelAndView mav = new ModelAndView("validation.jsp");
         mav.addObject("bank_details", e1);
         return mav;
    }

}