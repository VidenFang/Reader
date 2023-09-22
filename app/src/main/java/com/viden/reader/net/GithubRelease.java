package com.viden.reader.net;

import com.google.gson.annotations.SerializedName;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

public class GithubRelease implements Serializable {
    @Serial
    private static final long serialVersionUID = 4176007804695080094L;
    @SerializedName("url")
    private String url;
    @SerializedName("assets_url")
    private String assetsUrl;
    @SerializedName("upload_url")
    private String uploadUrl;
    @SerializedName("html_url")
    private String htmlUrl;
    @SerializedName("id")
    private Integer id;
    @SerializedName("author")
    private AuthorDTO author;
    @SerializedName("node_id")
    private String nodeId;
    @SerializedName("tag_name")
    private String tagName;
    @SerializedName("target_commitish")
    private String targetCommitish;
    @SerializedName("name")
    private String name;
    @SerializedName("draft")
    private Boolean draft;
    @SerializedName("prerelease")
    private Boolean prerelease;
    @SerializedName("created_at")
    private String createdAt;
    @SerializedName("published_at")
    private String publishedAt;
    @SerializedName("assets")
    private List<AssetsDTO> assets;
    @SerializedName("tarball_url")
    private String tarballUrl;
    @SerializedName("zipball_url")
    private String zipballUrl;
    @SerializedName("body")
    private String body;
    @SerializedName("reactions")
    private ReactionsDTO reactions;
    @SerializedName("mentions_count")
    private Integer mentionsCount;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAssetsUrl() {
        return assetsUrl;
    }

    public void setAssetsUrl(String assetsUrl) {
        this.assetsUrl = assetsUrl;
    }

    public String getUploadUrl() {
        return uploadUrl;
    }

    public void setUploadUrl(String uploadUrl) {
        this.uploadUrl = uploadUrl;
    }

    public String getHtmlUrl() {
        return htmlUrl;
    }

    public void setHtmlUrl(String htmlUrl) {
        this.htmlUrl = htmlUrl;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public AuthorDTO getAuthor() {
        return author;
    }

    public void setAuthor(AuthorDTO author) {
        this.author = author;
    }

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public String getTargetCommitish() {
        return targetCommitish;
    }

    public void setTargetCommitish(String targetCommitish) {
        this.targetCommitish = targetCommitish;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getDraft() {
        return draft;
    }

    public void setDraft(Boolean draft) {
        this.draft = draft;
    }

    public Boolean getPrerelease() {
        return prerelease;
    }

    public void setPrerelease(Boolean prerelease) {
        this.prerelease = prerelease;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public List<AssetsDTO> getAssets() {
        return assets;
    }

    public void setAssets(List<AssetsDTO> assets) {
        this.assets = assets;
    }

    public String getTarballUrl() {
        return tarballUrl;
    }

    public void setTarballUrl(String tarballUrl) {
        this.tarballUrl = tarballUrl;
    }

    public String getZipballUrl() {
        return zipballUrl;
    }

    public void setZipballUrl(String zipballUrl) {
        this.zipballUrl = zipballUrl;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public ReactionsDTO getReactions() {
        return reactions;
    }

    public void setReactions(ReactionsDTO reactions) {
        this.reactions = reactions;
    }

    public Integer getMentionsCount() {
        return mentionsCount;
    }

    public void setMentionsCount(Integer mentionsCount) {
        this.mentionsCount = mentionsCount;
    }

    public static class AuthorDTO implements Serializable {
        @Serial
        private static final long serialVersionUID = -3314755439108109066L;
        @SerializedName("login")
        private String login;
        @SerializedName("id")
        private Integer id;
        @SerializedName("node_id")
        private String nodeId;
        @SerializedName("avatar_url")
        private String avatarUrl;
        @SerializedName("gravatar_id")
        private String gravatarId;
        @SerializedName("url")
        private String url;
        @SerializedName("html_url")
        private String htmlUrl;
        @SerializedName("followers_url")
        private String followersUrl;
        @SerializedName("following_url")
        private String followingUrl;
        @SerializedName("gists_url")
        private String gistsUrl;
        @SerializedName("starred_url")
        private String starredUrl;
        @SerializedName("subscriptions_url")
        private String subscriptionsUrl;
        @SerializedName("organizations_url")
        private String organizationsUrl;
        @SerializedName("repos_url")
        private String reposUrl;
        @SerializedName("events_url")
        private String eventsUrl;
        @SerializedName("received_events_url")
        private String receivedEventsUrl;
        @SerializedName("type")
        private String type;
        @SerializedName("site_admin")
        private Boolean siteAdmin;

        public String getLogin() {
            return login;
        }

        public void setLogin(String login) {
            this.login = login;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getNodeId() {
            return nodeId;
        }

        public void setNodeId(String nodeId) {
            this.nodeId = nodeId;
        }

        public String getAvatarUrl() {
            return avatarUrl;
        }

        public void setAvatarUrl(String avatarUrl) {
            this.avatarUrl = avatarUrl;
        }

        public String getGravatarId() {
            return gravatarId;
        }

        public void setGravatarId(String gravatarId) {
            this.gravatarId = gravatarId;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getHtmlUrl() {
            return htmlUrl;
        }

        public void setHtmlUrl(String htmlUrl) {
            this.htmlUrl = htmlUrl;
        }

        public String getFollowersUrl() {
            return followersUrl;
        }

        public void setFollowersUrl(String followersUrl) {
            this.followersUrl = followersUrl;
        }

        public String getFollowingUrl() {
            return followingUrl;
        }

        public void setFollowingUrl(String followingUrl) {
            this.followingUrl = followingUrl;
        }

        public String getGistsUrl() {
            return gistsUrl;
        }

        public void setGistsUrl(String gistsUrl) {
            this.gistsUrl = gistsUrl;
        }

        public String getStarredUrl() {
            return starredUrl;
        }

        public void setStarredUrl(String starredUrl) {
            this.starredUrl = starredUrl;
        }

        public String getSubscriptionsUrl() {
            return subscriptionsUrl;
        }

        public void setSubscriptionsUrl(String subscriptionsUrl) {
            this.subscriptionsUrl = subscriptionsUrl;
        }

        public String getOrganizationsUrl() {
            return organizationsUrl;
        }

        public void setOrganizationsUrl(String organizationsUrl) {
            this.organizationsUrl = organizationsUrl;
        }

        public String getReposUrl() {
            return reposUrl;
        }

        public void setReposUrl(String reposUrl) {
            this.reposUrl = reposUrl;
        }

        public String getEventsUrl() {
            return eventsUrl;
        }

        public void setEventsUrl(String eventsUrl) {
            this.eventsUrl = eventsUrl;
        }

        public String getReceivedEventsUrl() {
            return receivedEventsUrl;
        }

        public void setReceivedEventsUrl(String receivedEventsUrl) {
            this.receivedEventsUrl = receivedEventsUrl;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public Boolean getSiteAdmin() {
            return siteAdmin;
        }

        public void setSiteAdmin(Boolean siteAdmin) {
            this.siteAdmin = siteAdmin;
        }
    }

    public static class ReactionsDTO implements Serializable {
        @Serial
        private static final long serialVersionUID = 5556106409646557350L;
        @SerializedName("url")
        private String url;
        @SerializedName("total_count")
        private Integer totalCount;
        @SerializedName("+1")
        private Integer _$1244;// FIXME check this code
        @SerializedName("-1")
        private Integer $1;
        @SerializedName("laugh")
        private Integer laugh;
        @SerializedName("hooray")
        private Integer hooray;
        @SerializedName("confused")
        private Integer confused;
        @SerializedName("heart")
        private Integer heart;
        @SerializedName("rocket")
        private Integer rocket;
        @SerializedName("eyes")
        private Integer eyes;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public Integer getTotalCount() {
            return totalCount;
        }

        public void setTotalCount(Integer totalCount) {
            this.totalCount = totalCount;
        }

        public Integer get_$1244() {
            return _$1244;
        }

        public void set_$1244(Integer _$1244) {
            this._$1244 = _$1244;
        }

        public Integer get$1() {
            return $1;
        }

        public void set$1(Integer $1) {
            this.$1 = $1;
        }

        public Integer getLaugh() {
            return laugh;
        }

        public void setLaugh(Integer laugh) {
            this.laugh = laugh;
        }

        public Integer getHooray() {
            return hooray;
        }

        public void setHooray(Integer hooray) {
            this.hooray = hooray;
        }

        public Integer getConfused() {
            return confused;
        }

        public void setConfused(Integer confused) {
            this.confused = confused;
        }

        public Integer getHeart() {
            return heart;
        }

        public void setHeart(Integer heart) {
            this.heart = heart;
        }

        public Integer getRocket() {
            return rocket;
        }

        public void setRocket(Integer rocket) {
            this.rocket = rocket;
        }

        public Integer getEyes() {
            return eyes;
        }

        public void setEyes(Integer eyes) {
            this.eyes = eyes;
        }
    }

    public static class AssetsDTO implements Serializable {
        @Serial
        private static final long serialVersionUID = 5625717455364239221L;
        @SerializedName("url")
        private String url;
        @SerializedName("id")
        private Integer id;
        @SerializedName("node_id")
        private String nodeId;
        @SerializedName("name")
        private String name;
        @SerializedName("label")
        private String label;
        @SerializedName("uploader")
        private UploaderDTO uploader;
        @SerializedName("content_type")
        private String contentType;
        @SerializedName("state")
        private String state;
        @SerializedName("size")
        private Integer size;
        @SerializedName("download_count")
        private Integer downloadCount;
        @SerializedName("created_at")
        private String createdAt;
        @SerializedName("updated_at")
        private String updatedAt;
        @SerializedName("browser_download_url")
        private String browserDownloadUrl;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getNodeId() {
            return nodeId;
        }

        public void setNodeId(String nodeId) {
            this.nodeId = nodeId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getLabel() {
            return label;
        }

        public void setLabel(String label) {
            this.label = label;
        }

        public UploaderDTO getUploader() {
            return uploader;
        }

        public void setUploader(UploaderDTO uploader) {
            this.uploader = uploader;
        }

        public String getContentType() {
            return contentType;
        }

        public void setContentType(String contentType) {
            this.contentType = contentType;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public Integer getSize() {
            return size;
        }

        public void setSize(Integer size) {
            this.size = size;
        }

        public Integer getDownloadCount() {
            return downloadCount;
        }

        public void setDownloadCount(Integer downloadCount) {
            this.downloadCount = downloadCount;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
        }

        public String getBrowserDownloadUrl() {
            return browserDownloadUrl;
        }

        public void setBrowserDownloadUrl(String browserDownloadUrl) {
            this.browserDownloadUrl = browserDownloadUrl;
        }

        public static class UploaderDTO implements Serializable {
            @Serial
            private static final long serialVersionUID = -6388124141858099338L;
            @SerializedName("login")
            private String login;
            @SerializedName("id")
            private Integer id;
            @SerializedName("node_id")
            private String nodeId;
            @SerializedName("avatar_url")
            private String avatarUrl;
            @SerializedName("gravatar_id")
            private String gravatarId;
            @SerializedName("url")
            private String url;
            @SerializedName("html_url")
            private String htmlUrl;
            @SerializedName("followers_url")
            private String followersUrl;
            @SerializedName("following_url")
            private String followingUrl;
            @SerializedName("gists_url")
            private String gistsUrl;
            @SerializedName("starred_url")
            private String starredUrl;
            @SerializedName("subscriptions_url")
            private String subscriptionsUrl;
            @SerializedName("organizations_url")
            private String organizationsUrl;
            @SerializedName("repos_url")
            private String reposUrl;
            @SerializedName("events_url")
            private String eventsUrl;
            @SerializedName("received_events_url")
            private String receivedEventsUrl;
            @SerializedName("type")
            private String type;
            @SerializedName("site_admin")
            private Boolean siteAdmin;

            public String getLogin() {
                return login;
            }

            public void setLogin(String login) {
                this.login = login;
            }

            public Integer getId() {
                return id;
            }

            public void setId(Integer id) {
                this.id = id;
            }

            public String getNodeId() {
                return nodeId;
            }

            public void setNodeId(String nodeId) {
                this.nodeId = nodeId;
            }

            public String getAvatarUrl() {
                return avatarUrl;
            }

            public void setAvatarUrl(String avatarUrl) {
                this.avatarUrl = avatarUrl;
            }

            public String getGravatarId() {
                return gravatarId;
            }

            public void setGravatarId(String gravatarId) {
                this.gravatarId = gravatarId;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getHtmlUrl() {
                return htmlUrl;
            }

            public void setHtmlUrl(String htmlUrl) {
                this.htmlUrl = htmlUrl;
            }

            public String getFollowersUrl() {
                return followersUrl;
            }

            public void setFollowersUrl(String followersUrl) {
                this.followersUrl = followersUrl;
            }

            public String getFollowingUrl() {
                return followingUrl;
            }

            public void setFollowingUrl(String followingUrl) {
                this.followingUrl = followingUrl;
            }

            public String getGistsUrl() {
                return gistsUrl;
            }

            public void setGistsUrl(String gistsUrl) {
                this.gistsUrl = gistsUrl;
            }

            public String getStarredUrl() {
                return starredUrl;
            }

            public void setStarredUrl(String starredUrl) {
                this.starredUrl = starredUrl;
            }

            public String getSubscriptionsUrl() {
                return subscriptionsUrl;
            }

            public void setSubscriptionsUrl(String subscriptionsUrl) {
                this.subscriptionsUrl = subscriptionsUrl;
            }

            public String getOrganizationsUrl() {
                return organizationsUrl;
            }

            public void setOrganizationsUrl(String organizationsUrl) {
                this.organizationsUrl = organizationsUrl;
            }

            public String getReposUrl() {
                return reposUrl;
            }

            public void setReposUrl(String reposUrl) {
                this.reposUrl = reposUrl;
            }

            public String getEventsUrl() {
                return eventsUrl;
            }

            public void setEventsUrl(String eventsUrl) {
                this.eventsUrl = eventsUrl;
            }

            public String getReceivedEventsUrl() {
                return receivedEventsUrl;
            }

            public void setReceivedEventsUrl(String receivedEventsUrl) {
                this.receivedEventsUrl = receivedEventsUrl;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public Boolean getSiteAdmin() {
                return siteAdmin;
            }

            public void setSiteAdmin(Boolean siteAdmin) {
                this.siteAdmin = siteAdmin;
            }
        }
    }
}
