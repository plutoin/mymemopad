<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.PrintWriter"%>
<%@ page import="memo.*, util.*, tab.*, user.*"%>

<%
	request.setCharacterEncoding("UTF-8");
	String userID = null;
	if(session.getAttribute("userID") != null) {
		userID = (String) session.getAttribute("userID");
	}
	if(userID == null) {
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('로그인을 해주세요.');");
		script.println("location.href = 'userLogin.jsp';");
		script.println("</script>");
		script.close();
		return;
	}
	
	request.setCharacterEncoding("UTF-8");
	String tabName = null;
	
	if(request.getParameter("tabName") != null)
		tabName = request.getParameter("tabName");	

	TabDAO tabDAO = new TabDAO();
	if(tabName.equals(tabDAO.getTabName(tabName))){
		int result = tabDAO.delete(userID, tabName);// 오류 뜨는 곳
		if(result == -1) {	// DB 오류
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('삭제 실패했습니다.');");
			script.println("history.back();");
			script.println("</script>");
			script.close();
			return;
		} else {
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('삭제되었습니다.');");
			script.println("location.href = 'main.jsp'");
			script.println("</script>");
			script.close();
			return;
		}
	}
	
%>