package entity;

import java.sql.Date;

public class Notice {
    int id;
    String title;
    String writerId;
    Date regDate;
    String content;
    String files;
    int hit;

    public int getHit() {
        return hit;
    }

    public void setHit(int hit) {
        this.hit = hit;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWriterId() {
        return writerId;
    }

    public void setWriterId(String writerId) {
        this.writerId = writerId;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFiles() {
        return files;
    }

    public void setFile(String file) {
        this.files = files;
    }

    public Notice(int id, String title, String writerId, Date regDate, String content, String files,int hit) {
        this.id = id;
        this.title = title;
        this.writerId = writerId;
        this.regDate = regDate;
        this.content = content;
        this.files = files;
        this.hit = hit;
    }

    public Notice() {
    }
}
