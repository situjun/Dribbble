package com.my.jerrychan.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by linchen on 16/2/19.
 * github:https://github.com/JerryChan123
 * e-mail:linchen0922@163.com
 */
@DatabaseTable(tableName = "tb_user")
public class User {
    @DatabaseField(columnName = "id",id = true)
    @SerializedName("id")
    @Expose
    private long id;

    @SerializedName("name")
    @Expose
    @DatabaseField(columnName = "name")
    private String name;

    @DatabaseField(columnName = "username")
    @SerializedName("username")
    @Expose
    private String username;

    @DatabaseField(columnName = "html_url")
    @SerializedName("html_url")
    @Expose
    private String htmlUrl;

    @DatabaseField(columnName = "avatar_url")
    @SerializedName("avatar_url")
    @Expose
    private String avatarUrl;

    @SerializedName("bio")
    @Expose
    private String bio;

    @SerializedName("location")
    @Expose
    private String location;

    @SerializedName("links")
    @Expose
    private Links links;

    @SerializedName("buckets_count")
    @Expose
    private int bucketsCount;

    @SerializedName("comments_received_count")
    @Expose
    private int commentsReceivedCount;

    @SerializedName("followers_count")
    @Expose
    @DatabaseField(columnName = "followers_count")
    private int followersCount;

    @DatabaseField(columnName = "followings_count")
    @SerializedName("followings_count")
    @Expose
    private int followingsCount;

    @SerializedName("likes_count")
    @Expose
    private int likesCount;

    @SerializedName("likes_received_count")
    @Expose
    private int likesReceivedCount;

    @SerializedName("projects_count")
    @Expose
    private int projectsCount;

    @SerializedName("rebounds_received_count")
    @Expose
    private int reboundsReceivedCount;

    @SerializedName("shots_count")
    @Expose
    private int shotsCount;

    @SerializedName("teams_count")
    @Expose
    private int teamsCount;

    @SerializedName("can_upload_shot")
    @Expose
    private boolean canUploadShot;

    @SerializedName("type")
    @Expose
    private String type;

    @SerializedName("pro")
    @Expose
    private boolean pro;

    @DatabaseField(columnName = "buckets_url")
    @SerializedName("buckets_url")
    @Expose
    private String bucketsUrl;

    @DatabaseField(columnName = "followers_url")
    @SerializedName("followers_url")
    @Expose
    private String followersUrl;


    @DatabaseField(columnName = "following_url")
    @SerializedName("following_url")
    @Expose
    private String followingUrl;

    @DatabaseField(columnName = "likes_url")
    @SerializedName("likes_url")
    @Expose
    private String likesUrl;

    @SerializedName("projects_url")
    @Expose
    private String projectsUrl;

    @DatabaseField(columnName = "shots_url")
    @SerializedName("shots_url")
    @Expose
    private String shotsUrl;

    @SerializedName("teams_url")
    @Expose
    private String teamsUrl;

    @SerializedName("created_at")
    @Expose
    private String createdAt;

    @DatabaseField(columnName = "updated_at")
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;

    /**
     *
     * @return
     * The id
     */
    public long getId() {
        return id;
    }

    /**
     *
     * @param id
     * The id
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     *
     * @return
     * The name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     * The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     * The username
     */
    public String getUsername() {
        return username;
    }

    /**
     *
     * @param username
     * The username
     */
    public void setUsername(String username) {
        this.username = username;
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
     * The avatarUrl
     */
    public String getAvatarUrl() {
        return avatarUrl;
    }

    /**
     *
     * @param avatarUrl
     * The avatar_url
     */
    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    /**
     *
     * @return
     * The bio
     */
    public String getBio() {
        return bio;
    }

    /**
     *
     * @param bio
     * The bio
     */
    public void setBio(String bio) {
        this.bio = bio;
    }

    /**
     *
     * @return
     * The location
     */
    public String getLocation() {
        return location;
    }

    /**
     *
     * @param location
     * The location
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     *
     * @return
     * The links
     */
    public Links getUserLinks() {
        return links;
    }

    /**
     *
     * @param links
     * The links
     */
    public void setUserLinks(Links links) {
        this.links = links;
    }

    /**
     *
     * @return
     * The bucketsCount
     */
    public int getBucketsCount() {
        return bucketsCount;
    }

    /**
     *
     * @param bucketsCount
     * The buckets_count
     */
    public void setBucketsCount(int bucketsCount) {
        this.bucketsCount = bucketsCount;
    }

    /**
     *
     * @return
     * The commentsReceivedCount
     */
    public int getCommentsReceivedCount() {
        return commentsReceivedCount;
    }

    /**
     *
     * @param commentsReceivedCount
     * The comments_received_count
     */
    public void setCommentsReceivedCount(int commentsReceivedCount) {
        this.commentsReceivedCount = commentsReceivedCount;
    }

    /**
     *
     * @return
     * The followersCount
     */
    public int getFollowersCount() {
        return followersCount;
    }

    /**
     *
     * @param followersCount
     * The followers_count
     */
    public void setFollowersCount(int followersCount) {
        this.followersCount = followersCount;
    }

    /**
     *
     * @return
     * The followingsCount
     */
    public int getFollowingsCount() {
        return followingsCount;
    }

    /**
     *
     * @param followingsCount
     * The followings_count
     */
    public void setFollowingsCount(int followingsCount) {
        this.followingsCount = followingsCount;
    }

    /**
     *
     * @return
     * The likesCount
     */
    public int getLikesCount() {
        return likesCount;
    }

    /**
     *
     * @param likesCount
     * The likes_count
     */
    public void setLikesCount(int likesCount) {
        this.likesCount = likesCount;
    }

    /**
     *
     * @return
     * The likesReceivedCount
     */
    public int getLikesReceivedCount() {
        return likesReceivedCount;
    }

    /**
     *
     * @param likesReceivedCount
     * The likes_received_count
     */
    public void setLikesReceivedCount(int likesReceivedCount) {
        this.likesReceivedCount = likesReceivedCount;
    }

    /**
     *
     * @return
     * The projectsCount
     */
    public int getProjectsCount() {
        return projectsCount;
    }

    /**
     *
     * @param projectsCount
     * The projects_count
     */
    public void setProjectsCount(int projectsCount) {
        this.projectsCount = projectsCount;
    }

    /**
     *
     * @return
     * The reboundsReceivedCount
     */
    public int getReboundsReceivedCount() {
        return reboundsReceivedCount;
    }

    /**
     *
     * @param reboundsReceivedCount
     * The rebounds_received_count
     */
    public void setReboundsReceivedCount(int reboundsReceivedCount) {
        this.reboundsReceivedCount = reboundsReceivedCount;
    }

    /**
     *
     * @return
     * The shotsCount
     */
    public int getShotsCount() {
        return shotsCount;
    }

    /**
     *
     * @param shotsCount
     * The shots_count
     */
    public void setShotsCount(int shotsCount) {
        this.shotsCount = shotsCount;
    }

    /**
     *
     * @return
     * The teamsCount
     */
    public int getTeamsCount() {
        return teamsCount;
    }

    /**
     *
     * @param teamsCount
     * The teams_count
     */
    public void setTeamsCount(int teamsCount) {
        this.teamsCount = teamsCount;
    }

    /**
     *
     * @return
     * The canUploadShot
     */
    public boolean isCanUploadShot() {
        return canUploadShot;
    }

    /**
     *
     * @param canUploadShot
     * The can_upload_shot
     */
    public void setCanUploadShot(boolean canUploadShot) {
        this.canUploadShot = canUploadShot;
    }

    /**
     *
     * @return
     * The type
     */
    public String getType() {
        return type;
    }

    /**
     *
     * @param type
     * The type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     *
     * @return
     * The pro
     */
    public boolean isPro() {
        return pro;
    }

    /**
     *
     * @param pro
     * The pro
     */
    public void setPro(boolean pro) {
        this.pro = pro;
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
     * The followersUrl
     */
    public String getFollowersUrl() {
        return followersUrl;
    }

    /**
     *
     * @param followersUrl
     * The followers_url
     */
    public void setFollowersUrl(String followersUrl) {
        this.followersUrl = followersUrl;
    }

    /**
     *
     * @return
     * The followingUrl
     */
    public String getFollowingUrl() {
        return followingUrl;
    }

    /**
     *
     * @param followingUrl
     * The following_url
     */
    public void setFollowingUrl(String followingUrl) {
        this.followingUrl = followingUrl;
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
     * The shotsUrl
     */
    public String getShotsUrl() {
        return shotsUrl;
    }

    /**
     *
     * @param shotsUrl
     * The shots_url
     */
    public void setShotsUrl(String shotsUrl) {
        this.shotsUrl = shotsUrl;
    }

    /**
     *
     * @return
     * The teamsUrl
     */
    public String getTeamsUrl() {
        return teamsUrl;
    }

    /**
     *
     * @param teamsUrl
     * The teams_url
     */
    public void setTeamsUrl(String teamsUrl) {
        this.teamsUrl = teamsUrl;
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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", htmlUrl='" + htmlUrl + '\'' +
                ", avatarUrl='" + avatarUrl + '\'' +
                ", bio='" + bio + '\'' +
                ", location='" + location + '\'' +
                ", links=" + links +
                ", bucketsCount=" + bucketsCount +
                ", commentsReceivedCount=" + commentsReceivedCount +
                ", followersCount=" + followersCount +
                ", followingsCount=" + followingsCount +
                ", likesCount=" + likesCount +
                ", likesReceivedCount=" + likesReceivedCount +
                ", projectsCount=" + projectsCount +
                ", reboundsReceivedCount=" + reboundsReceivedCount +
                ", shotsCount=" + shotsCount +
                ", teamsCount=" + teamsCount +
                ", canUploadShot=" + canUploadShot +
                ", type='" + type + '\'' +
                ", pro=" + pro +
                ", bucketsUrl='" + bucketsUrl + '\'' +
                ", followersUrl='" + followersUrl + '\'' +
                ", followingUrl='" + followingUrl + '\'' +
                ", likesUrl='" + likesUrl + '\'' +
                ", projectsUrl='" + projectsUrl + '\'' +
                ", shotsUrl='" + shotsUrl + '\'' +
                ", teamsUrl='" + teamsUrl + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                '}';
    }
}