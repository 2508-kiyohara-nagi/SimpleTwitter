package chapter6.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;

import chapter6.beans.Comment;
import chapter6.beans.User;
import chapter6.logging.InitApplication;
import chapter6.service.CommentService;

@WebServlet(urlPatterns = { "/comment" })
public class CommentServlet extends HttpServlet {


    /**
    * ロガーインスタンスの生成
    */
    Logger log = Logger.getLogger("twitter");

    /**
    * デフォルトコンストラクタ
    * アプリケーションの初期化を実施する。
    */
    public CommentServlet() {
        InitApplication application = InitApplication.getInstance();
        application.init();

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

	  log.info(new Object(){}.getClass().getEnclosingClass().getName() +
        " : " + new Object(){}.getClass().getEnclosingMethod().getName());

        HttpSession session = request.getSession();
        //返信テキストのバリデーション
        List<String> errorMessages = new ArrayList<String>();
        String text = request.getParameter("text");
        String messageIdStr = request.getParameter("messageId");

	    if (StringUtils.isBlank(messageIdStr) || !messageIdStr.matches("\\d+")) {
	        errorMessages.add("不正なパラメータが入力されました");
	        session.setAttribute("errorMessages", errorMessages);
	        response.sendRedirect("./"); // top.jspにリダイレクトされる
	        return;
	    }

	    int messageId = Integer.parseInt(messageIdStr);

        if (!isValid(text, errorMessages)) {
            session.setAttribute("errorMessages", errorMessages);
            response.sendRedirect("./");
            return;
        }

        Comment comment = new Comment();
        comment.setText(text);
        comment.setMessageId(messageId);

        User user = (User) session.getAttribute("loginUser");
        comment.setUserId(user.getId());
        //CommentServiceの呼び出し
        new CommentService().insert(comment);
        response.sendRedirect("./");
    }
    private boolean isValid(String text, List<String> errorMessages) {

	  log.info(new Object(){}.getClass().getEnclosingClass().getName() +
        " : " + new Object(){}.getClass().getEnclosingMethod().getName());

        if (StringUtils.isBlank(text)) {
            errorMessages.add("メッセージを入力してください");
        } else if (140 < text.length()) {
            errorMessages.add("140文字以下で入力してください");
        }

        if (errorMessages.size() != 0) {
            return false;
        }
        return true;
    }
}
