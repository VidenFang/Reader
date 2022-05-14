package com.demo.manga.data;

/**
 * @ProjectName: Manga
 * @Package: com.demo.manga.data
 * @ClassName: Manga
 * @Description: java类作用描述
 * @Author: Viden
 * @CreateDate: 2021/8/28 18:06
 * @UpdateUser: 更新者
 * @UpdateDate: 2021/8/28 18:06
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class Manga {
    private String title;

    public Manga(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
