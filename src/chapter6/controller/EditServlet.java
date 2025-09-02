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

import chapter6.beans.Message;
import chapter6.beans.UserMessage;
import chapter6.logging.InitApplication;
import chapter6.service.MessageService;

@WebServlet(urlPatterns = { "/edit" })
public class EditServlet extends HttpServlet {

	/**
	* ロガーインスタンスの生成
	*/
    Logger log = Logger.getLogger("twitter");

    /**
    * デフォルトコンストラクタ
    * アプリケーションの初期化を実施する。
    */
    public EditServlet() {
        InitApplication application = InitApplication.getInstance();
        application.init();

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

    	log.info(new Object(){}.getClass().getEnclosingClass().getName() +
        " : " + new Object(){}.getClass().getEnclosingMethod().getName());

    	HttpSession session = request.getSession();
	    List<String> errorMessages = new ArrayList<String>();

	    String messageIdStr = request.getParameter("messageId");

	    if (StringUtils.isBlank(messageIdStr) || !messageIdStr.matches("\\d+")) {
	        errorMessages.add("不正なパラメータが入力されました");
	        session.setAttribute("errorMessages", errorMessages);
	        response.sendRedirect("./"); // top.jspにリダイレクトされる
	        return;
	    }

	    int messageId = Integer.parseInt(messageIdStr);

	    List<UserMessage> message = new MessageService().select(messageId);
	    if (message.size() == 0) {
            errorMessages.add("不正なパラメータが入力されました");
            session.setAttribute("errorMessages", errorMessages);
            response.sendRedirect("./");
            return;
        }
      request.setAttribute("message", message.get(0));
      request.getRequestDispatcher("/edit.jsp").forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws IOException, ServletException {

		log.info(new Object(){}.getClass().getEnclosingClass().getName() +
	      " : " + new Object(){}.getClass().getEnclosingMethod().getName());

	    List<String> errorMessages = new ArrayList<String>();

	    String text = request.getParameter("text");
	    int messageId = Integer.parseInt(request.getParameter("messageId"));

	    //編集したテキストパラメータ取得
	    Message message = new Message();
	    message.setText(text);
	    message.setId(messageId);

	    if (!isValid(text, errorMessages)) {
	    	request.setAttribute("errorMessages", errorMessages);
	    	request.setAttribute("message", message);
            request.getRequestDispatcher("/edit.jsp").forward(request, response);
            return;
        }
	    new MessageService().update(message);
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