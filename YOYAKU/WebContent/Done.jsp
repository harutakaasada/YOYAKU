<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.Date, java.text.SimpleDateFormat" %>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
.button {
  display       : inline-block;
  font-size     : 15pt;        /* 文字サイズ */
  text-align    : center;      /* 文字位置   */
  cursor        : pointer;     /* カーソル   */
  padding       : 5px 12px;   /* 余白       */
  background    : #ffffff;     /* 背景色     */
  color         : #000000;     /* 文字色     */
  line-height   : 1em;         /* 1行の高さ  */
  opacity       : 0.9;         /* 透明度     */
  transition    : .3s;         /* なめらか変化 */
  box-shadow    : 2px 2px 4px #666666;  /* 影の設定 */
}
.button:hover {
  box-shadow    : none;        /* カーソル時の影消去 */
  opacity       : 1;           /* カーソル時透明度 */
}
</style>
<meta charset="UTF-8">
<title>予約完了させる</title>
</head>
<body>
<form action="DoneServlet" method="get" class="row">
<p>
<%=session.getAttribute("name") %>さん ログイン中
</p>
<p>
<%=session.getAttribute("selectPlace") %>の詳細
</p>
<p>
<%=session.getAttribute("selectDetails") %>
</p>
<%Date date = new Date();
 SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
 String day = format.format(date);
%>
<p>
チェックイン
<input type="date" name="checkInDay" min=<%=day%> max="2021-12-31">
チェックアウト
<input type="date" name="checkOutDay" min=<%=day%> max="2021-12-31">
</p>
<input type = "submit" value = "予約する" class="button">
<input type="button" onclick="history.go(-3)" value="戻る" class="button">
</body>
</html>