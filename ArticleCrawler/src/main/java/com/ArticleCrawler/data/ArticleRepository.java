package com.ArticleCrawler.data;

import java.util.ArrayList;
import java.util.List;

public class ArticleRepository {


    private static List<ArticleEntity> articles = new ArrayList<ArticleEntity>();

    public static List<ArticleEntity> getArticles(){
        return articles;
    }


}
