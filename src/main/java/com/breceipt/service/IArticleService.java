package com.breceipt.service;

import java.util.List;

import com.breceipt.entity.Article;

public interface IArticleService {
     List<Article> getAllArticles();
     Article getArticleById(int articleId);
     void addOrUpdateArticle(Article article);
     void deleteArticle(int articleId);
}
