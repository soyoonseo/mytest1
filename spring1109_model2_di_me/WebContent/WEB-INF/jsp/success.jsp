<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>success.jsp</title>
</head>
<body>
${tvo.writer}<br/>
${tvo.content}<br/>
${tvo.pwd}<br/>
${tvo.mfile}<br/>
</body>
</html>

<!-- 일반적인 WebContent 안에 파일들은 jsp 경로를 알면 서블릿의 호출 없이 접근이 가능하다. 

WEB-INF 디렉토리에 jsp파일을 넣어두면 클라이언트에는 접근이 불가능하다.
단, 컨테이너는 가능하다. 

따라서 WEB-INF에 jsp를 두는 이유는 보안상 좋기 때문이다. -->