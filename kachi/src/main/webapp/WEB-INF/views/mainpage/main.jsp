<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
        String select = request.getParameter("pageChange");
 
        if (select == null) {
            select = "/WEB-INF/views/mainpage/storehome.jsp";
        }
    %>
	<div class="top-screen"></div>
	<!-- 메인 화면 -->
	<div class="main">
			<jsp:include page="<%=select%>" flush="false" />
	</div>
</div>
</body>
</html>


