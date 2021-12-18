package ru.qnocks.hibernateconnectionexample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.qnocks.hibernateconnectionexample.dao.ContributionDao;
import ru.qnocks.hibernateconnectionexample.dao.GardenDao;

@Controller
@RequestMapping("/jdbc")
public class JdbcController {

    private final ContributionDao contributionDao;

    @Autowired
    public JdbcController(ContributionDao contributionDao) {
        this.contributionDao = contributionDao;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("contributions", contributionDao.findAll());
        return "jdbc";
    }
}
