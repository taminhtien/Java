<?xml version="1.0" ?>
<%@ page pageEncoding="UTF-8"%>

<jsp:element name="data">
	<h3>Please view source of this page</h3>
	
	<%-- Tao doi tuong Employee va set gia tri cho no --%>
	
	<jsp:useBean id="emp" class="com.tientm.tutorial.jsp.beans.Employee">
	
		<!-- name phai trung voi id cua Bean -->
		<!-- cac property lan luoc trung voi cac thuoc tinh trong class -->
		<!-- value la set gia tri cho thuoc tinh do -->
		
		<jsp:setProperty name="emp" property="empNo" value="E01" />
		<jsp:setProperty name="emp" property="empName" value="Tien" />
	</jsp:useBean>
	
	<!-- Tao doi tuong employee2 -->
	 <jsp:element name="employee2">
        <jsp:attribute name="empNo" trim="true">
            <jsp:getProperty name="emp" property="empNo" />        
        </jsp:attribute>
        <jsp:body>
            <jsp:getProperty name="emp" property="empName" />        
        </jsp:body>    
    </jsp:element>
</jsp:element>