package com.ArticleCrawler;

import com.ArticleCrawler.service.CrawlerService;

public class ArticleCrawler {

    private static CrawlerService crawlerService = new CrawlerService();

    public static void main(String[] args) {

        crawlerService.crawl(args[0]);
    }
}
