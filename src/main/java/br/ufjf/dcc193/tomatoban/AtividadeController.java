package br.ufjf.dcc193.tomatoban;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/atividade")
public class AtividadeController {
    
    @RequestMapping({"","/","/index.html"})
    public ModelAndView atividadeIndex(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("atividade-index");
        mv.addObject("nome", "Fulano");
        return mv;
    }
    
}