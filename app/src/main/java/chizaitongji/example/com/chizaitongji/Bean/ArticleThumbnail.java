package chizaitongji.example.com.chizaitongji.Bean;

import java.util.Date;

public class ArticleThumbnail {
    private String imageURL;//图片资源ID
    private String title;//文章标题
    private String abstraction;//文章简介
    private String articleURL;
    private String date;

    public ArticleThumbnail(String imageURL, String title, String abstraction, String articleURL, String date) {
        this.imageURL = imageURL;
        this.title = title;
        this.abstraction = abstraction;
        this.articleURL = articleURL;
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getArticleURL() {
        return articleURL;
    }

    public void setArticleURL(String articleURL) {
        this.articleURL = articleURL;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAbstraction() {
        return abstraction;
    }

    public void setAbstraction(String abstraction) {
        this.abstraction = abstraction;
    }


}
