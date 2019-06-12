package br.ufjf.dcc193.tomatoban;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/atividade")
public class AtividadeController {
    final Map<Integer, String> dificuldades = new HashMap<Integer, String>(){{
        put(1, "Muito Fácil");
        put(2, "Fácil");
        put(3, "Moderado");
        put(4, "Difícil");
        put(5, "Muito Difícil");
    }};

    @Autowired
    AtividadeRepository atvRepo;

    @RequestMapping({ "", "/", "/index.html" })
    public ModelAndView atividadeIndex() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("atividade-index");
        mv.addObject("nome", "Fulano");
        return mv;
    }

    @RequestMapping(value="/nova.html", method = RequestMethod.GET)
    public ModelAndView nova(){
            Atividade atividade = new Atividade();
            ModelAndView mv = new ModelAndView();
            mv.setViewName("atividade-form-new");
            mv.addObject("atividade", atividade);
            mv.addObject("opcoes", dificuldades.entrySet());
            return mv;
    }

    @PostMapping(value = "/criar.html")
    public ModelAndView criar(@Valid Atividade atividade, BindingResult binding) {
        ModelAndView mv = new ModelAndView();
        if (binding.hasErrors()) {
            mv.setViewName("atividade-form-new");
            mv.addObject("atividade", atividade);
            return mv;
        }
        atvRepo.save(atividade);
        mv.setViewName("redirect:listar.html");
        return mv;
    }

    @GetMapping(value = "/listar.html")
    public ModelAndView listar() {
        List<Atividade> atividades = atvRepo.findAll();
        
        ModelAndView mv = new ModelAndView();
        mv.setViewName("atividade-list.html");
        mv.addObject("atividades", atividades);
        return mv;
    }
    
    @GetMapping(value = "/por-dificuldade.html")
    public ModelAndView listarPorDificuldade(@RequestParam Integer min, @RequestParam Integer max) {
        List<Atividade> atividades = atvRepo.findByDificuldadeBetween(min, max);
        
        ModelAndView mv = new ModelAndView();
        mv.setViewName("atividade-list-dif.html");
        mv.addObject("atividades", atividades);
        mv.addObject("opcoes", dificuldades.entrySet());
        mv.addObject("min", min);
        mv.addObject("max", max);
        return mv;
    }

}