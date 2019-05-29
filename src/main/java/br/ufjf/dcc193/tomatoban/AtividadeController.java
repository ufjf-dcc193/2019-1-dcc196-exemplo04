package br.ufjf.dcc193.tomatoban;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/atividade")
public class AtividadeController {
    @Autowired
    AtividadeRepository atvRepo;

    @RequestMapping({ "", "/", "/index.html" })
    public ModelAndView atividadeIndex() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("atividade-index");
        mv.addObject("nome", "Fulano");
        return mv;
    }

    @RequestMapping("/nova.html")
    public String nova(){

            return "atividade-form-new.html";
    }

    @RequestMapping(value="/criar.html", method=RequestMethod.POST)
    public String criar(Atividade atividade){
            atvRepo.save(atividade);
            return "redirect:listar.html";
    }

}