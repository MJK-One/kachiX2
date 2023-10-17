<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>	
	
	<style>
		.hidden{
			display : none;
		}
	</style>
	<div class="top-screen"></div>
	<!-- 메인 화면 -->
	<div class="main">
		 <section class="storehome">
		 	<jsp:include page="/WEB-INF/views/mainpage/storehome.jsp" flush="false" />
		 </section>
		 <section class="interest hidden">
		 	<jsp:include page="/WEB-INF/views/mainpage/interest.jsp" flush="false" />
		 </section>	 
		 <section class="timesale hidden">
		 	<jsp:include page="/WEB-INF/views/mainpage/timesale.jsp" flush="false" />
		 </section>	 
		 <section class="newarticle hidden">
		 	<jsp:include page="/WEB-INF/views/mainpage/newarticle.jsp" flush="false" />
		 </section>	 	 
	</div>