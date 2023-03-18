package controller.notice;

import entity.Notice;
import service.NoticeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/notice/detail")
public class detailController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        NoticeService service = new NoticeService();
        int id = Integer.parseInt(req.getParameter("id"));
        Notice notice = service.getNotice(id);
        Notice nextNotice = service.getNextNotice(id);
        Notice prevNotice = service.getPrevNotice(id);

        req.setAttribute("notice",notice);
        req.setAttribute("next",nextNotice);
        req.setAttribute("prev",prevNotice);
        req.getRequestDispatcher("/notice/detail.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {;
    }
}
