<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel=stylesheet type="text/css" href="css/bootstrap.min.css">
<link rel=stylesheet type="text/css" href="css/bootstrap-theme.min.css">
</head>
<body>
	<div id="timeline-box" class="container-fluid tl-box"
		style="margin-left: auto; margin-right: auto;">
		<div class="timeline-panel">
			<div class="col-xs-offset-2 col-xs-8">
				<div class="well panel-info">
					<div class="panel-header">
						<div class="col-xs-1">
							<img class="media-object" src="img/harinezumi.jpg" width="34"
								height="34" />
						</div>
						<div class="col-xs-6">
							<h4 class="media-heading">
								<a href="tl.jsp"><strong>スズキイチロー</strong></a>
							</h4>
						</div>
					</div>
					<div id="time-line-text-box" class="panel-body" style="margin-top: 40px;">
						<div id="time-line-text">
							<div class="row">
								<div class="col-xs-12" id="post-text-box">古いプラットフォーム使うユーザへのサポート、すごい大変なの分かる…
正直もうiOS7対応辞めたいもん…(仕事じゃなかったら絶対に切り捨ててた)</div>
							</div>
						</div>
						<div class="panel-date">
							<div class="text-right">
								<small>2016年4月19日 10:32</small>
							</div>
						</div>
						<div class="panel-info" style="margin-top: 10px;">
							<div class="col-sm-4">
								<form action="http://localhost:8080/SNS/favorite" class="favorite" method="post">
									<input type="hidden" name="message" value="favorite" >
									<label class="favorite-button"> いいね！ <i
										class="glyphicon glyphicon-heart-empty"></i><input
										type="submit" id="favorite" style="display: none;">
									</label><span aria-hidden="true" data-toggle="tooltip"
										data-html="true">3</span>
									<input type="submit">
								</form>
							</div>
							<div class="col-sm-4">
								<form class="comment" method="post" action="post.jsp">
									<label> 返信 <i class="glyphicon glyphicon-envelope"></i><input
										type="submit" id="comment" style="display: none;">
									</label> <span aria-hidden="true" data-toggle="tooltip"
										data-html="true">5</span>
								</form>
							</div>
							<div class="col-sm-4">
								<form id="edit-form" method="post">
									<label id="edit-text-label"> 編集 <i class="glyphicon glyphicon-pencil"></i>
										<input type="button" id="edit-text-button" style="display: none;" data-toggle="modal" data-target=".myModal">
									</label>
									<div id="" class="modal fade myModal">
									    <div class="modal-dialog">
											<div class="modal-content" id="edit-post-modal-content">
												<div class="modal-header">
													<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
													<h4 class="modal-title">投稿編集</h4>
												</div>
												<div class="modal-body">
													<textarea rows="5" cols="80" maxlength="140" id="edit-text-area">test</textarea>
												</div>
												<div class="modal-footer">
													<button type="button" class="btn btn-default" data-dismiss="modal">閉じる</button>
													<input type="button" class="btn btn-secondary" value="保存" id="edit-text-box-sumbmit" />
												</div>
											</div>
										</div>
									</div>
								</form>
							</div>
						</div>
					</div>
					<div class="panel-footer" id="commentForm1">
						<div class="row">
							<form action="tl.jsp" method="post">
								<div class="col-sm-2">
									<img class="media-object" src="img/nero.jpg" width="34"
										height="34" />
								</div>
								<div class="col-sm-8">
									<input type="text" class="form-control" placeholder="コメントする" />
								</div>
								<div class="col-sm-2">
									<input type="submit" value="返信" class="btn btn-info-outline" />
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script src="js/jquery-1.11.2.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/post_modal.js"></script>
</body>
</html>