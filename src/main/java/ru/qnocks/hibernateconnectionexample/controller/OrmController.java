package ru.qnocks.hibernateconnectionexample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.qnocks.hibernateconnectionexample.dao.OwnerDao;

@Controller
@RequestMapping("/orm")
public class OrmController {

    private final OwnerDao ownerDao;

    @Autowired
    public OrmController(OwnerDao ownerDao) {
        this.ownerDao = ownerDao;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("owners", ownerDao.findAll());
        return "orm";
    }
}
