package service;

import entity.Notice;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class IndexService {

    public List<Notice> getLateNotice(){
        List<Notice> list = new ArrayList<>();

        String url = "jdbc:mysql://localhost:3306/jdbc";
        String sql = " select * from ( select @rn:=@rn+1 as rn,notice.* from (select @rn:=0)r,notice order by regdate desc)a where rn between 1 and 5;";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "root", "0143");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()){
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
}
