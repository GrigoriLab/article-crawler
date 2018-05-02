package com.ArticleCrawler.service;

import com.ArticleCrawler.data.ArticleEntity;
import com.ArticleCrawler.data.ArticleRepository;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class CrawlerService {



    public void crawl(String url){

        try {
            Document document = Jsoup.connect(url).get();

            String name = document.select("#firstHeading").text();
            System.out.println(name);

            ArticleEntity articleEntity = new ArticleEntity();
            articleEntity.setName(name);

            ArticleRepository.getArticles().add(articleEntity);

            System.out.println(ArticleRepository.getArticles().get(0).getName());


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
