<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import = "java.util.*" %>
    <%@ page import = "DTO.InfoDTO" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
.button {
  display       : inline-block;
  border-radius : 5%;          /* 角丸       */
  font-size     : 14pt;        /* 文字サイズ */
  text-align    : center;      /* 文字位置   */
  cursor        : pointer;     /* カーソル   */
  padding       : 12px 12px;   /* 余白       */
  background    : #9999ff;     /* 背景色     */
  color         : #000000;     /* 文字色     */
  line-height   : 1em;         /* 1行の高さ  */
  opacity       : 1;           /* 透明度     */
  transition    : .3s;         /* なめらか変化 */
}
.button:hover {
  opacity       : 0.8;         /* カーソル時透明度 */
}
</style>
<meta charset="UTF-8">
<title>検索情報表示</title>
</head>
<body>
 <form action="SelectServlet" method="post" class="row">
<p><%=session.getAttribute("name") %>さん ログイン中</p>
<div align="center">
<font  size="5" color="black">
<p>
 <%=session.getAttribute("pref")%>の検索結果です。
 </p>
<%=session.getAttribute("i") %>件ヒットしました。
 </font>
 </div>
 <p>
 検索情報表示
 <c:forEach var="info" items="${list}">
<p>
<input type = "submit" value = "<c:out value="${info.ryokan}"/>" class="button">
</p>
</c:forEach>
 </p>
 </form>
</body>
</html>