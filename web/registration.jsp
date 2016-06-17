<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel=stylesheet type="text/css" href="css/bootstrap.min.css">
<link rel=stylesheet type="text/css" href="css/bootstrap-theme.min.css">
<link rel=stylesheet type="text/css" href="css/tl.css">
<link rel=stylesheet type="text/css" href="css/post.css">
<title>新規登録</title>
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
					<h3 class="text-center">新規登録</h3>
					<div class="form-panel">
						<form action="registration" class="form-horizontal" method="post" enctype='multipart/form-data'>
							<input type="hidden" name="pagename" value="registration.jsp">
							<div class="panel-heading">
								<div class="container">
									<div class="icon">
										<img class="img-responsive" src="img/harinezumi.jpg" style="width: 150px; height: auto;" />
									</div>
									<div class="icon-upload">
										<label class="col-xs-offset-2 col-xs-2">
											<span>写真を選択</span>
											<input type="file" name="icon" size="30" style="display: none;" accept="image/*">
										</label>
									</div>
								</div>
							</div>
							<div class="panel-body">
								<div class="form-content">
									<div class="panel-username" style="margin-top: 10px">
										<div class="form-group" id="username-text">
											<span class="col-xs-4 control-label">ユーザ名：</span>
											<div class="col-xs-7">
												<input type="text" class="form-control" name="name" placeholder="ユーザ名" required />
											</div>
										</div>
									</div>
									<div class="panel-email" style="margin-top: 10px">
										<div class="form-group" id="email-text">
											<span class="col-xs-4 control-label">メールアドレス：</span>
											<div class="col-xs-7">
												<input type="email" class="form-control" name="email" placeholder="メールアドレス" required />
											</div>
										</div>
									</div>
									<div class="panel-password" style="margin-top: 10px;">
										<div class="form-group" id="password-text">
											<span class="col-xs-4 control-label">パスワード：</span>
											<div class="col-xs-7">
												<input type="password" name="pass" class="form-control" placeholder="パスワード" required />
											</div>
										</div>
									</div>
									<div class="panel-password_conf" style="margin-top: 10px;">
										<div class="form-group" id="password-text-conf">
											<span class="col-xs-4 control-label">パスワード確認：</span>
											<div class="col-xs-7">
												<input type="password" name="confpass" class="form-control" placeholder="パスワード確認" required />
											</div>
										</div>
									</div>
								</div>
								<div style="margin-top: 10px;">
									<div class="form-group" id="registration-button">
										<div class="text-center">
											<input type="submit" value="登録する" class="btn btn-info-outline" />
										</div>
									</div>
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

	<form action="registration" method="post">
		<input type="text" name="test">
			<input type="submit" value="go">
	</form>
</body>
</html>
