
package com.twocentscode.nlevelexpandablelistview;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CatalogRespons {

    @SerializedName("error")
    @Expose
    private Integer error;
    @SerializedName("error_msg")
    @Expose
    private String errorMsg;
    @SerializedName("resArr")
    @Expose
    private List<ResArr> resArr = null;

    public Integer getError() {
        return error;
    }

    public void setError(Integer error) {
        this.error = error;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public List<ResArr> getResArr() {
        return resArr;
    }

    public void setResArr(List<ResArr> resArr) {
        this.resArr = resArr;
    }

    public class ResArr {

        @SerializedName("id")
        @Expose
        private String id;
        @SerializedName("title")
        @Expose
        private String title;
        @SerializedName("page_url")
        @Expose
        private String pageUrl;
        @SerializedName("parent_id")
        @Expose
        private String parentId;
        @SerializedName("status")
        @Expose
        private String status;
        @SerializedName("music")
        @Expose
        private String music;
        @SerializedName("subCat")
        @Expose
        private List<SubCat> subCat = null;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getPageUrl() {
            return pageUrl;
        }

        public void setPageUrl(String pageUrl) {
            this.pageUrl = pageUrl;
        }

        public String getParentId() {
            return parentId;
        }

        public void setParentId(String parentId) {
            this.parentId = parentId;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getMusic() {
            return music;
        }

        public void setMusic(String music) {
            this.music = music;
        }

        public List<SubCat> getSubCat() {
            return subCat;
        }

        public void setSubCat(List<SubCat> subCat) {
            this.subCat = subCat;
        }

    }

    public class SubCat {

        @SerializedName("id")
        @Expose
        private String id;
        @SerializedName("title")
        @Expose
        private String title;
        @SerializedName("page_url")
        @Expose
        private String pageUrl;
        @SerializedName("parent_id")
        @Expose
        private String parentId;
        @SerializedName("status")
        @Expose
        private String status;
        @SerializedName("music")
        @Expose
        private String music;
        @SerializedName("subCat")
        @Expose
        private List<SubCat_> subCat = null;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getPageUrl() {
            return pageUrl;
        }

        public void setPageUrl(String pageUrl) {
            this.pageUrl = pageUrl;
        }

        public String getParentId() {
            return parentId;
        }

        public void setParentId(String parentId) {
            this.parentId = parentId;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getMusic() {
            return music;
        }

        public void setMusic(String music) {
            this.music = music;
        }

        public List<SubCat_> getSubCat() {
            return subCat;
        }

        public void setSubCat(List<SubCat_> subCat) {
            this.subCat = subCat;
        }

    }

    public class SubCat_ {

        @SerializedName("id")
        @Expose
        private String id;
        @SerializedName("title")
        @Expose
        private String title;
        @SerializedName("page_url")
        @Expose
        private String pageUrl;
        @SerializedName("parent_id")
        @Expose
        private String parentId;
        @SerializedName("status")
        @Expose
        private String status;
        @SerializedName("music")
        @Expose
        private String music;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getPageUrl() {
            return pageUrl;
        }

        public void setPageUrl(String pageUrl) {
            this.pageUrl = pageUrl;
        }

        public String getParentId() {
            return parentId;
        }

        public void setParentId(String parentId) {
            this.parentId = parentId;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getMusic() {
            return music;
        }

        public void setMusic(String music) {
            this.music = music;
        }

    }

}
