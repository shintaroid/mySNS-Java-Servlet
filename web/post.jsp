<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE>
<html lang="ja">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel=stylesheet type="text/css" href="css/bootstrap.min.css">
<link rel=stylesheet type="text/css" href="css/bootstrap-theme.min.css">
<link rel=stylesheet type="text/css" href="css/tl.css">
<link rel=stylesheet type="text/css" href="css/post.css">
<title>タイムライン</title>
</head>
<body>
	<jsp:include page="header.jsp" flush="true" />

	<div class="container-fluid" style="margin-top: 60px; margin-left: auto; margin-right: auto;">
		<div class="post-panel">
			<div class="col-xs-offset-2 col-xs-8">
				<div class="well panel-info">
					<form action="post" method="post" enctype='multipart/form-data'>
						<input type="hidden" name="message" value="post">
						<input type="hidden" name="pagename" value="post.jsp">
						<div class="panel-body">
							<input type="text" class="form-control" name="post" maxlength="140" placeholder="今何してる？" required />
							<div class="panel-footer" class="comment-post" style="margin-top: 10px;">
								<div class="row bottom-0">
									<div class="panel-picture-upload col-xs-4">
										<label for="file_photo"> ＋写真を追加
											<input type="file" id="file_photo" name="imageurl" size="30" multiple="multiple" style="display: none;" accept="image/*">
										</label>
									</div>
									<div class="panel-post col-xs-offset-6 col-xs-2">
										<input type="submit" value="投稿" class="btn btn-info-outline" style="color:white;"/>
									</div>
								</div>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>

	<div id="timeline"></div>
	<div class="conteiner text-center">
		<button id="more-read" class="btn btn-secondary-outline">もっと読む</button>
	</div>

	<script src="js/jquery-1.11.2.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery.min.js"></script>
	<script src="js/jquery.jscroll.min.js"></script>
	<script src="js/tl.js"></script>
	<script src="js/post.js"></script>
	<script src="js/post_modal.js"></script>
</body>
</html>