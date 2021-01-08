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
  padding       : 2px 2px;   /* 余白       */
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
<p>
<%=session.getAttribute("name") %>さん ログイン中
</p>
<%=session.getAttribute("ryokanName") %>に
<%=session.getAttribute("checkInDay")%>から<%=session.getAttribute("checkOutDay") %>で予約しました。
<p>
<button onclick="location.href='./2.LOGIN.jsp'" >戻る</button>
</p>
</body>
</html>