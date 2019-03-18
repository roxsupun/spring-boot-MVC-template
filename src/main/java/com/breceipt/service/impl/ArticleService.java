package com.breceipt.service.impl;

import com.breceipt.entity.Article;
import com.breceipt.repository.ArticleRepository;
import com.breceipt.service.IArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
@Transactional
public class ArticleService implements IArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    @Override
    public Article getArticleById(int articleId) {
        return articleRepository.findById(articleId).get();
    }

    @Override
    public List<Article> getAllArticles() {
        return (List<Article>) articleRepository.findAll();
    }

    @Override
    public void addOrUpdateArticle(Article article) {
        articleRepository.save(article);
    }

    @Override
    public void deleteArticle(int articleId) {
        articleRepository.deleteById(articleId);
    }
}
