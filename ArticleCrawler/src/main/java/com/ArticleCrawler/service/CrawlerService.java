package com.ArticleCrawler.service;

import com.ArticleCrawler.data.ArticleEntity;
import com.ArticleCrawler.data.ArticleRepository;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.sql.*;

public class CrawlerService {



    public void crawl(String url){

        Connection c = null;
        Statement stmt = null;


        try {
            Document document = Jsoup.connect(url).get();

            String name = document.select("#firstHeading").text();
            String imageUrl = document.select(".infobox a img").attr("src");
            String imagePath = "image-path";
            System.out.println("Article name = " + name);
            System.out.println("Image url = " + imageUrl);
            System.out.println("Image path = " + imagePath);

            try {
                Class.forName("org.sqlite.JDBC");
                c = DriverManager.getConnection("jdbc:sqlite:crawler.db");
                c.setAutoCommit(false);
                System.out.println("Opened database successfully");

                stmt = c.createStatement();
                String sql = "CREATE TABLE ARTICLE " +
                        "(NAME           TEXT    NOT NULL, " +
                        "IMAGE_URL           TEXT    NOT NULL, " +
                        "IMAGE_PATH           TEXT    NOT NULL)";

                try{
                    stmt.executeUpdate(sql);
                }
                catch (Exception e){
                    System.out.println("Table exist");
                }

                sql = "INSERT INTO ARTICLE (NAME,IMAGE_URL,IMAGE_PATH) " +
                        "VALUES ('" +
                        name +
                        "', '" +
                        imageUrl +
                        "', '" +
                        imagePath +
                        "' );";

                stmt.executeUpdate(sql);

                stmt.close();
                c.commit();
                c.close();

            } catch ( Exception e ) {
                System.err.println( e.getClass().getName() + ": " + e.getMessage() );
                System.exit(0);
            }


            ArticleEntity articleEntity = new ArticleEntity();
            articleEntity.setName(name);

            ArticleRepository.getArticles().add(articleEntity);

            //System.out.println(ArticleRepository.getArticles().get(0).getName());


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
