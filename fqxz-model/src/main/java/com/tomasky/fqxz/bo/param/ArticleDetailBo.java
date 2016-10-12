package com.tomasky.fqxz.bo.param;

/**
 * Create by jame
 * Date: 2016/10/11 14:45
 * Version: 1.0
 * Description: 阐述
 */
public class ArticleDetailBo {
    private Long articleId;
    private Long innId;

    public ArticleDetailBo() {
        super();
    }

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public Long getInnId() {
        return innId;
    }

    public void setInnId(Long innId) {
        this.innId = innId;
    }
}
