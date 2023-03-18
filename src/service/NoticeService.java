package service;

import entity.Notice;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NoticeService {

    public List<Notice> getNoticeList(int page, String field, String query) {
        List<Notice> list = new ArrayList<>();

        String url = "jdbc:mysql://localhost:3306/jdbc";
        String sql = ("select * from ( select @rn:=@rn+1 as rn,notice.* from (select @rn:=0)r, notice where " + field + " like ? order by regdate desc)a where rn between ? and ?;");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "root", "0143");
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, "%" + query + "%");
            st.setInt(2, (page - 1) * 10 + 1);
            st.setInt(3, (page - 1) * 10 + 10);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Notice notice = new Notice(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("writer_id"),
                        rs.getDate("regDate"),
                        rs.getString("content"),
                        rs.getString("files"),
                        rs.getInt("hit")
                );

                list.add(notice);
            }


            rs.close();
            st.close();
            con.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return list;
    }

    public Notice getNotice(int id) {
        Notice notice = null;
        String url = "jdbc:mysql://localhost:3306/jdbc";
        String sql = ("select * from notice where id = ?;");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "root", "0143");
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();


            rs.next();

            int detailId = rs.getInt("id");
            String title = rs.getString("title");
            String writerId = rs.getString("Writer_id");
            Date regDate = rs.getDate("regDate");
            int hit = rs.getInt("hit");
            String content = rs.getString("content");
            String files = rs.getString("files");

            notice = new Notice(detailId, title, writerId, regDate, content, files, hit);


            rs.close();
            st.close();
            con.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return notice;
    }

    public Notice getNextNotice(int id) {
        Notice notice = null;
        String url = "jdbc:mysql://localhost:3306/jdbc";
        String sql = ("select * from (select @rn:=@rn+1 as rn,notice.* from (select @rn:=0)r,notice where id>? order by regdate)a where rn = 1;");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "root", "0143");
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();


            rs.next();

            int detailId = rs.getInt("id");
            String title = rs.getString("title");
            String writerId = rs.getString("Writer_id");
            Date regDate = rs.getDate("regDate");
            int hit = rs.getInt("hit");
            String content = rs.getString("content");
            String files = rs.getString("files");

            notice = new Notice(detailId, title, writerId, regDate, content, files, hit);


            rs.close();
            st.close();
            con.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return notice;
    }
    public Notice getPrevNotice(int id) {
        Notice notice = null;
        String url = "jdbc:mysql://localhost:3306/jdbc";
        String sql = ("select * from (select @rn:=@rn+1 as rn,notice.* from (select @rn:=0)r,notice where id<? order by regdate desc)a where rn = 1;");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "root", "0143");
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();


            rs.next();

            int detailId = rs.getInt("id");
            String title = rs.getString("title");
            String writerId = rs.getString("Writer_id");
            Date regDate = rs.getDate("regDate");
            int hit = rs.getInt("hit");
            String content = rs.getString("content");
            String files = rs.getString("files");

            notice = new Notice(detailId, title, writerId, regDate, content, files, hit);


            rs.close();
            st.close();
            con.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return notice;
    }
}
