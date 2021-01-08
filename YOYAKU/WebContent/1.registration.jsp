<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
@charset "utf-8";

header{
  margin-top: 30px;
  color: #43A047;
}
hr{
  border-width: 3px;
  border-color: #43A047;
}
h1{
  font-size: 25px;
    font-weight: bold;
    margin: 0;
  text-align: center;
}
.align-light{
    text-align: right;
}
.form-group{
  margin-bottom: 35px;
}
footer p{
  text-align: center;
}
input:required{
  background: #ffcdd2;
}
input[type="email"]:invalid{
  background: #ffcdd2;
}
input:valid{
  background: transparent;
}
input:focus{
  background: #DCEDC8;
}
</style>
<meta charset="UTF-8">
<title>新規登録画面</title>
</head>
<body>
<!DOCTYPE html>
<html lang="jp">
<head>
    <title>ユーザー登録</title>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="css/style.css">
</head>
<body>

    <div class="container">
        <header>
           <div class="row">
                    <h1>ユーザー登録</h1>
            </div>
        </header>
    </div>

    <hr>

    <div class="container">
        <form action="ConectServlet" method="post" class="row">
            <div class="col-sm-8 col-sm-offset-2">
                <div class="form-group">
                    <label for="name"><span class="label label-danger"></span> お名前</label>
                    <input type="text" id="name" name="name" class="form-control" placeholder="例：masayuki02" autofocus required>
                </div>
                <div class="form-group">
                    <label for="password"><span class="label label-danger"></span> パスワード</label>
                    <input type="password" id="password" name="password" class="form-control" placeholder="例：danngomaru02" required>
                </div>
                <button type="submit" class="btn btn-primary">登録する</button>
                  <button type="reset" class="btn btn-primary">リセット</button>
            </div>
        </form>
    </div>

    <hr>

    <div class="container">
    </div>
</body>
</html>
</body>
</html>