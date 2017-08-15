package com.my.jerrychan.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by linchen on 16/2/20.
 * github:https://github.com/JerryChan123
 * e-mail:linchen0922@163.com
 */
public class Shots {
    @SerializedName("id")
    @Expose
    private Long id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("width")
    @Expose
    private Long width;
    @SerializedName("height")
    @Expose
    private Long height;
    @SerializedName("images")
    @Expose
    private Images images;
    @SerializedName("views_count")
    @Expose
    private Long viewsCount;
    @SerializedName("likes_count")
    @Expose
    private Long likesCount;
    @SerializedName("comments_count")
    @Expose
    private Long commentsCount;
    @SerializedName("attachments_count")
    @Expose
    private Long attachmentsCount;
    @SerializedName("rebounds_count")
    @Expose
    private Long reboundsCount;
    @SerializedName("buckets_count")
    @Expose
    private Long bucketsCount;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("html_url")
    @Expose
    private String htmlUrl;
    @SerializedName("attachments_url")
    @Expose
    private String attachmentsUrl;
    @SerializedName("buckets_url")
    @Expose
    private String bucketsUrl;
    @SerializedName("comments_url")
    @Expose
    private String commentsUrl;
    @SerializedName("likes_url")
    @Expose
    private String likesUrl;
    @SerializedName("projects_url")
    @Expose
    private String projectsUrl;
    @SerializedName("rebounds_url")
    @Expose
    private String reboundsUrl;
    @SerializedName("animated")
    @Expose
    private Boolean animated;
    @SerializedName("tags")
    @Expose
    private List<String> tags = new ArrayList<String>();
    @SerializedName("user")
    @Expose
    private User user;
    @SerializedName("team")
    @Expose
    private Team team;

    /**
     *
     * @return
     * The id
     */
    public Long getId() {
        return id;
    }

    /**
     *
     * @param id
     * The id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     *
     * @return
     * The title
     */
    public String getTitle() {
        return title;
    }

    /**
     *
     * @param title
     * The title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     *
     * @return
     * The description
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @param description
     * The description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     *
     * @return
     * The width
     */
    public Long getWidth() {
        return width;
    }

    /**
     *
     * @param width
     * The width
     */
    public void setWidth(Long width) {
        this.width = width;
    }

    /**
     *
     * @return
     * The height
     */
    public Long getHeight() {
        return height;
    }

    /**
     *
     * @param height
     * The height
     */
    public void setHeight(Long height) {
        this.height = height;
    }

    /**
     *
     * @return
     * The images
     */
    public Images getImages() {
        return images;
    }

    /**
     *
     * @param images
     * The images
     */
    public void setImages(Images images) {
        this.images = images;
    }

    /**
     *
     * @return
     * The viewsCount
     */
    public Long getViewsCount() {
        return viewsCount;
    }

    /**
     *
     * @param viewsCount
     * The views_count
     */
    public void setViewsCount(Long viewsCount) {
        this.viewsCount = viewsCount;
    }

    /**
     *
     * @return
     * The likesCount
     */
    public Long getLikesCount() {
        return likesCount;
    }

    /**
     *
     * @param likesCount
     * The likes_count
     */
    public void setLikesCount(Long likesCount) {
        this.likesCount = likesCount;
    }

    /**
     *
     * @return
     * The commentsCount
     */
    public Long getCommentsCount() {
        return commentsCount;
    }

    /**
     *
     * @param commentsCount
     * The comments_count
     */
    public void setCommentsCount(Long commentsCount) {
        this.commentsCount = commentsCount;
    }

    /**
     *
     * @return
     * The attachmentsCount
     */
    public Long getAttachmentsCount() {
        return attachmentsCount;
    }

    /**
     *
     * @param attachmentsCount
     * The attachments_count
     */
    public void setAttachmentsCount(Long attachmentsCount) {
        this.attachmentsCount = attachmentsCount;
    }

    /**
     *
     * @return
     * The reboundsCount
     */
    public Long getReboundsCount() {
        return reboundsCount;
    }

    /**
     *
     * @param reboundsCount
     * The rebounds_count
     */
    public void setReboundsCount(Long reboundsCount) {
        this.reboundsCount = reboundsCount;
    }

    /**
     *
     * @return
     * The bucketsCount
     */
    public Long getBucketsCount() {
        return bucketsCount;
    }

    /**
     *
     * @param bucketsCount
     * The buckets_count
     */
    public void setBucketsCount(Long bucketsCount) {
        this.bucketsCount = bucketsCount;
    }

    /**
     *
     * @return
     * The createdAt
     */
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     *
     * @param createdAt
     * The created_at
     */
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    /**
     *
     * @return
     * The updatedAt
     */
    public String getUpdatedAt() {
        return updatedAt;
    }

    /**
     *
     * @param updatedAt
     * The updated_at
     */
    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    /**
     *
     * @return
     * The htmlUrl
     */
    public String getHtmlUrl() {
        return htmlUrl;
    }

    /**
     *
     * @param htmlUrl
     * The html_url
     */
    public void setHtmlUrl(String htmlUrl) {
        this.htmlUrl = htmlUrl;
    }

    /**
     *
     * @return
     * The attachmentsUrl
     */
    public String getAttachmentsUrl() {
        return attachmentsUrl;
    }

    /**
     *
     * @param attachmentsUrl
     * The attachments_url
     */
    public void setAttachmentsUrl(String attachmentsUrl) {
        this.attachmentsUrl = attachmentsUrl;
    }

    /**
     *
     * @return
     * The bucketsUrl
     */
    public String getBucketsUrl() {
        return bucketsUrl;
    }

    /**
     *
     * @param bucketsUrl
     * The buckets_url
     */
    public void setBucketsUrl(String bucketsUrl) {
        this.bucketsUrl = bucketsUrl;
    }

    /**
     *
     * @return
     * The commentsUrl
     */
    public String getCommentsUrl() {
        return commentsUrl;
    }

    /**
     *
     * @param commentsUrl
     * The comments_url
     */
    public void setCommentsUrl(String commentsUrl) {
        this.commentsUrl = commentsUrl;
    }

    /**
     *
     * @return
     * The likesUrl
     */
    public String getLikesUrl() {
        return likesUrl;
    }

    /**
     *
     * @param likesUrl
     * The likes_url
     */
    public void setLikesUrl(String likesUrl) {
        this.likesUrl = likesUrl;
    }

    /**
     *
     * @return
     * The projectsUrl
     */
    public String getProjectsUrl() {
        return projectsUrl;
    }

    /**
     *
     * @param projectsUrl
     * The projects_url
     */
    public void setProjectsUrl(String projectsUrl) {
        this.projectsUrl = projectsUrl;
    }

    /**
     *
     * @return
     * The reboundsUrl
     */
    public String getReboundsUrl() {
        return reboundsUrl;
    }

    /**
     *
     * @param reboundsUrl
     * The rebounds_url
     */
    public void setReboundsUrl(String reboundsUrl) {
        this.reboundsUrl = reboundsUrl;
    }

    /**
     *
     * @return
     * The animated
     */
    public Boolean getAnimated() {
        return animated;
    }

    /**
     *
     * @param animated
     * The animated
     */
    public void setAnimated(Boolean animated) {
        this.animated = animated;
    }

    /**
     *
     * @return
     * The tags
     */
    public List<String> getTags() {
        return tags;
    }

    /**
     *
     * @param tags
     * The tags
     */
    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    /**
     *
     * @return
     * The user
     */
    public User getUser() {
        return user;
    }

    /**
     *
     * @param user
     * The user
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     *
     * @return
     * The team
     */
    public Team getTeam() {
        return team;
    }

    /**
     *
     * @param team
     * The team
     */
    public void setTeam(Team team) {
        this.team = team;
    }

    @Override
    public String toString() {
        return "Shots{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", width=" + width +
                ", height=" + height +
                ", images=" + images +
                ", viewsCount=" + viewsCount +
                ", likesCount=" + likesCount +
                ", commentsCount=" + commentsCount +
                ", attachmentsCount=" + attachmentsCount +
                ", reboundsCount=" + reboundsCount +
                ", bucketsCount=" + bucketsCount +
                ", createdAt='" + createdAt + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                ", htmlUrl='" + htmlUrl + '\'' +
                ", attachmentsUrl='" + attachmentsUrl + '\'' +
                ", bucketsUrl='" + bucketsUrl + '\'' +
                ", commentsUrl='" + commentsUrl + '\'' +
                ", likesUrl='" + likesUrl + '\'' +
                ", projectsUrl='" + projectsUrl + '\'' +
                ", reboundsUrl='" + reboundsUrl + '\'' +
                ", animated=" + animated +
                ", tags=" + tags +
                ", user=" + user +
                ", team=" + team +
                '}';
    }
}
