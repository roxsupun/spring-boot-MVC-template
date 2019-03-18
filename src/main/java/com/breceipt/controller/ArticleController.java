package com.breceipt.controller;

import com.breceipt.entity.Article;
import com.breceipt.service.IArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
@RequestMapping(value = "/article")
public class ArticleController {

    @Autowired
    IArticleService articleService;

    /**
     * get all Articles
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView list() {
        ModelAndView model = new ModelAndView("article_list");
        List<Article> articleList = articleService.getAllArticles();
        model.addObject("articleList", articleList);

        return model;
    }

    /**
     * add new Articles
     * @return
     */
    @RequestMapping(value = "/addArticle/", method = RequestMethod.GET)
    public ModelAndView addArticle() {
        ModelAndView model = new ModelAndView();

        Article article = new Article();
        model.addObject("articleForm", article);
        model.setViewName("article_form");

        return model;
    }

    /**
     * edit Articles
     * @param id
     * @return
     */
    @RequestMapping(value = "/updateArticle/{id}", method = RequestMethod.GET)
    public ModelAndView editArticle(@PathVariable Integer id) {
        ModelAndView model = new ModelAndView();

        Article article = articleService.getArticleById(id);
        model.addObject("articleForm", article);
        model.setViewName("article_form");

        return model;
    }


    /**
     * Save Article
     * @param article
     * @return
     */
    @RequestMapping(value = "/saveArticle", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute("articleForm") Article article) {
        articleService.addOrUpdateArticle(article);

        return new ModelAndView("redirect:/article/list");
    }

    /**
     * delete Article
     * @param id
     * @return
     */
    @RequestMapping(value = "/deleteArticle/{id}", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable("id") Integer id) {
        articleService.deleteArticle(id);

        return new ModelAndView("redirect:/article/list");
    }
} 