// followのボタンが押された時の処理
$(function() {
	$(document).on("click",'.follow-button',function() {
		var obj = $(this);
		var text = $(this).parent().find('.follow-text').html();
		if (text == 'フォロー') {
			$.ajax({
				url: "follow",
				type : 'POST',
				dataType : 'JSON',
				data : {
					'message' : 'follow'
				}
			}).done(function(data){ //ajaxの通信に成功した場合
//				alert("success!");
				obj.parent().toggleClass("follow-toggle");
				obj.toggleClass("follow-toggle");
				obj.parent().find('.follow-text').html("アンフォロー");
			}).fail(function(data){ //ajaxの通信に失敗した場合
				alert("通信に失敗しました");
			});
		} else {
			$.ajax({
				url: "follow",
				type : 'POST',
				dataType : 'JSON',
				data : {
					'message' : 'unfollow'
				}
			}).done(function(data){ //ajaxの通信に成功した場合
//				alert("success!");
				obj.parent().toggleClass("follow-toggle");
				obj.toggleClass("follow-toggle");
				obj.parent().find('.follow-text').html("フォロー");
			}).fail(function(data){ //ajaxの通信に失敗した場合
				alert("通信に失敗しました");
			});
		}
	});
});