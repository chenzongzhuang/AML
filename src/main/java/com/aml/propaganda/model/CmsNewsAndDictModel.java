package com.aml.propaganda.model;

import com.aml.sys.entity.Dict;

import java.util.Date;

/**
 * Created by hb on 2017/10/24.
 */
public class CmsNewsAndDictModel {
    /**
     * 标识ID
     */
    private Integer id;

    /**
     * 栏目ID
     */
    private String channelId;

    /**
     * 标题
     */
    private String title;

    /**
     * 内容
     */
    private String content;

    /**
     * 是否发布
     */
    private String isPublish;

    /**
     * 发布人
     */
    private String publisher;

    /**
     * 发布时间
     */
    private Date publishTime;

    /**
     * 是否新
     */
    private String isNew;

    /**
     * 访问次数
     */
    private String visitCount;

    /**
     * 是否滚动
     */
    private String isScorll;

    /**
     * 是否显示
     */
    private String isDisplay;

    /**
     * 审核人
     */
    private String auditer;

    /**
     * 审核时间
     */
    private Date auditTime;

    /**
     * 关键词
     */
    private String keyword;

    /**
     * 发布类型
     */
    private String publishType;

    /**
     * 开始时间
     */
    private Date begDate;

    /**
     * 截至时间
     */
    private Date endDate;

    /**
     * 作者
     */
    private String author;

    /**
     * 栏目名称
     */
    private Dict dict;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getIsPublish() {
        return isPublish;
    }

    public void setIsPublish(String isPublish) {
        this.isPublish = isPublish;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public String getIsNew() {
        return isNew;
    }

    public void setIsNew(String isNew) {
        this.isNew = isNew;
    }

    public String getVisitCount() {
        return visitCount;
    }

    public void setVisitCount(String visitCount) {
        this.visitCount = visitCount;
    }

    public String getIsScorll() {
        return isScorll;
    }

    public void setIsScorll(String isScorll) {
        this.isScorll = isScorll;
    }

    public String getIsDisplay() {
        return isDisplay;
    }

    public void setIsDisplay(String isDisplay) {
        this.isDisplay = isDisplay;
    }

    public String getAuditer() {
        return auditer;
    }

    public void setAuditer(String auditer) {
        this.auditer = auditer;
    }

    public Date getAuditTime() {
        return auditTime;
    }

    public void setAuditTime(Date auditTime) {
        this.auditTime = auditTime;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getPublishType() {
        return publishType;
    }

    public void setPublishType(String publishType) {
        this.publishType = publishType;
    }

    public Date getBegDate() {
        return begDate;
    }

    public void setBegDate(Date begDate) {
        this.begDate = begDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Dict getDict() {
        return dict;
    }

    public void setDict(Dict dict) {
        this.dict = dict;
    }
}
