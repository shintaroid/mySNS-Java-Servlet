$(function() {
	// 編集ボタンが押された時の処理
	$(document).on('click','.edit-text-button',function() {
		var text = $(this).parents('.time-line-text-box').find('.post-text-box').html();
		$(this).parents('.edit-form').find('.edit-text-area').val(text);
	});

	// 保存ボタンが押された時の処理
	$(document).on('click','.edit-text-box-sumbmit',function(){
		var text = $(this).parents('.edit-post-modal-content').find('.edit-text-area').val();
		var obj = $(this);
		if (text.length == 0) {
			alert('投稿を入力してください。');
		} else {
			// ajax非同期通信
			$.ajax({
				url: "post",
				type : 'POST',
				dataType : 'JSON',
				data : {
					'message' : 'edit',
					'postid' : '1'
				}
			}).done(function(data){ //ajaxの通信に成功した場合
//				alert("success!");
				obj.parents('.time-line-text-box').find('.post-text-box').html(text);
				obj.parents('.myModal').modal('hide');
			}).fail(function(data){ //ajaxの通信に失敗した場合
				alert("通信に失敗しました");
			});
		}
	});

	// 投稿削除ボタンが押された時の処理
	$(document).on('click','.edit-text-box-delete',function(){
		var ans = confirm('本当に投稿を削除しますか？');
		var obj = $(this);
		$.when(
			obj.parents('.myModal').modal('hide')
		).done(function() {
			if (ans == false) {
				alert('投稿を削除しませんでした');
			} else {
				// ajax非同期通信
				$.ajax({
					url: "post",
					type : 'POST',
					dataType : 'JSON',
					data : {
						'message' : 'delete',
						'postid' : '1'
					}
				}).done(function(data){ //ajaxの通信に成功した場合
//					alert("success!");
					$(function(){
						obj.parents('.tl-box').remove();
						alert('投稿を削除しました');
					});
				}).fail(function(data){ //ajaxの通信に失敗した場合
					alert("通信に失敗しました");
				});
			}
		});
	});
});

