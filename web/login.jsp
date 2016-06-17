<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel=stylesheet type="text/css" href="css/bootstrap.min.css">
<link rel=stylesheet type="text/css" href="css/bootstrap-theme.min.css">
<title>ログイン</title>
</head>
<body>
	<div class="container-fluid"
		style="margin-top: 20px; margin-left: auto; margin-right: auto;">
		<div class="row">
			<div class="col-xs-12"></div>
		</div>
		<div class="row-fluid">
			<div class="col-xs-offset-2 col-xs-8">
				<div class="well panel-secondary">
					<div class="panel-body">
						<h3 class="text-center">ログイン</h3>
						<form action="login" class="form-horizontal" method="post">
							<input type="hidden" name="message" value="login">
							<input type="hidden" name="pagename" value="login.jsp">
							<div style="margin-top: 30px;">
								<div class="form-group" id="email-text">
									<label class="col-xs-4 control-label" for="mail">メールアドレス：</label>
									<div class="col-xs-7">
										<input type="email" class="form-control" name="mail" placeholder="メールアドレス" maxlength="254" style="ime-mode: disabled" required />
									</div>
								</div>
							</div>
							<div style="margin-top: 30px;">
								<div class="form-group" id="password-text">
									<label class="col-xs-4 control-label" for="pass">パスワード：</label>
									<div class="col-xs-7">
										<input type="password" name="pass" class="form-control" placeholder="パスワード" maxlength="16" style="ime-mode: disabled" required />
									</div>
								</div>
							</div>
							<div style="margin-top: 30px;">
								<div class="form-group" id="login-button">
									<div class="text-center">
										<input type="submit" value="ログイン" class="btn btn-info-outline" />
									</div>
								</div>
							</div>
							<div class="text-right">
								<div class="form-group">
									<p>
										<a href="registration.jsp">新規作成はこちら</a>
									</p>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script src="js/jquery-1.11.2.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>