package controller.notice;

import entity.Notice;
import service.NoticeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/notice/list")
public class listController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int page = 1;
        String page_ =  req.getParameter("p");
        if(page_!=null && !page_.equals(""))
            page = Integer.parseInt(page_);
        String query = "";
        String query_ = req.getParameter("q");
        if(query_!=null && !query_.equals(""))
            query = query_;
        String field = "title";
        String field_ = req.getParameter("f");
        if(field_!=null && !field_.equals(""))
            field = field_;

        NoticeService service = new NoticeService();
        List<Notice> list = service.getNoticeList(page,field,query);

        req.setAttribute("list",list);

        req.getRequestDispatcher("/notice/list.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
