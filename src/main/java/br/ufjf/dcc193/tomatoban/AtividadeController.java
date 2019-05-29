package br.ufjf.dcc193.tomatoban;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AtividadeController {
    
    @RequestMapping({"","/","/index.html"})
    @ResponseBody
    public String index(){
        return "Hello World!";
    }
    
}