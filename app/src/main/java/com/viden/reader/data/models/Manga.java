package com.viden.reader.data.models;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * @ProjectName: Manga
 * @Package: com.viden.reader.data.models
 * @ClassName: Manga
 * @Description: java类作用描述
 * @Author: Viden
 * @CreateDate: 2022/5/14 14:30
 * @UpdateUser: 更新者
 * @UpdateDate: 2022/5/14 14:30
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class Manga {
    @Nullable
    public Long id;

    @NonNull
    public int source;

    @NonNull
    public String url;

    @NonNull
    public String artist;

    @NonNull
    public String author;

    @NonNull
    public String description;

    @NonNull
    public String genre;

    @NonNull
    public String title;

    @NonNull
    public String status;

    @NonNull
    public String thumbnail_url;

    @NonNull
    public int rank;

    @NonNull
    public long last_update;

    @NonNull
    public boolean initialized;

    @NonNull
    public int viewer;

    @NonNull
    public int chapter_order;

    public Manga() {}

    public Manga(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Manga manga = (Manga) o;

        if (source != manga.source) return false;
        if (rank != manga.rank) return false;
        if (last_update != manga.last_update) return false;
        if (initialized != manga.initialized) return false;
        if (viewer != manga.viewer) return false;
        if (chapter_order != manga.chapter_order) return false;
        if (id != null ? !id.equals(manga.id) : manga.id != null) return false;
        if (!url.equals(manga.url)) return false;
        if (!artist.equals(manga.artist)) return false;
        if (!author.equals(manga.author)) return false;
        if (!description.equals(manga.description)) return false;
        if (!genre.equals(manga.genre)) return false;
        if (!title.equals(manga.title)) return false;
        if (!status.equals(manga.status)) return false;
        return thumbnail_url.equals(manga.thumbnail_url);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + source;
        result = 31 * result + url.hashCode();
        result = 31 * result + artist.hashCode();
        result = 31 * result + author.hashCode();
        result = 31 * result + description.hashCode();
        result = 31 * result + genre.hashCode();
        result = 31 * result + title.hashCode();
        result = 31 * result + status.hashCode();
        result = 31 * result + thumbnail_url.hashCode();
        result = 31 * result + rank;
        result = 31 * result + (int) (last_update ^ (last_update >>> 32));
        result = 31 * result + (initialized ? 1 : 0);
        result = 31 * result + viewer;
        result = 31 * result + chapter_order;
        return result;
    }
}
