<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
	import="java.io.PrintWriter, java.util.ArrayList, java.net.URLEncoder"%>
<%@ page import="user.*,memo.*"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>My Memopad</title>
<!-- bootstrap CSS 추가 -->
<link rel="stylesheet" href="./css/bootstrap.min.css">
<!-- custom CSS 추가 -->
<link rel="stylesheet" href="./css/custom.css">
</head>
<body>
	<!-- 메모 등록하기 화면 구현 -->
	<div class="container">
		<div class="modal-header">
			<h5 class="modal-title" id="modal">메모 등록</h5>
			<button type="button" class="close" data-dismiss="modal"
				onClick="location.href='main.jsp'">
				<span aria-hidden="true">&times;</span>
			</button>
		</div>
		<div class="modal-body">
			<form action="./writeAction.jsp" method="post">
				<div class="form-row">
					<div class="form-group col-sm-4">
						<label>그룹</label> 
						<select name="memoDivide" class="form-control">
							<option value="의류" selected>의류</option>
							<option value="음식">음식</option>
							<option value="기타">기타</option>
						</select>
					</div>
				</div>
				<div class="form-group">
					<label>제목</label> <input type="text" name="memoTitle"
						class="form-control" maxlength="50">
				</div>
				<div class="form-group">
					<label>내용</label>
					<textarea name="memoContent" id = "text" class="form-control" maxlength="2048"
						style="height: 200px;"></textarea>
				</div>
				<div class="form-row">
					<div class="form-group col-sm-3">
						<label>평가</label> <select name="totalScore" class="form-control">
							<option value="5" selected>5</option>
							<option value="4">4</option>
							<option value="3">3</option>
							<option value="2">2</option>
							<option value="1">1</option>
						</select>
					</div>
					<div class="form-group col-sm-3">
						<label>중요도</label> <select name="importantScore"
							class="form-control">
							<option value="5" selected>5</option>
							<option value="4">4</option>
							<option value="3">3</option>
							<option value="2">2</option>
							<option value="1">1</option>
						</select>
					</div>
				</div>
				<!--<div class="form-group">
					<label for="InputSubject1">파일첨부</label> <input id="fileInput"
						filestyle="" type="file" data-class-button="btn btn-default"
						data-class-input="form-control" data-button-text=""
						data-icon-name="fa fa-upload" class="form-control" tabindex="-1"
						style="position: absolute; clip: rect(0px, 0px, 0px, 0px);">
					<div class="bootstrap-filestyle input-group">
						<input type="text" id="userfile" class="form-control"
							name="userfile" disabled=""> <span
							class="group-span-filestyle input-group-btn" tabindex="0">
							<label for="fileInput" class="btn btn-default"> <span
								class="glyphicon fa fa-upload"></span>
						</label>
						</span>
					</div>
				</div>  -->
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						onClick="location.href='main.jsp'">취소</button>
					<button type="submit" class="btn btn-primary">등록하기</button>
				</div>
			</form>
		</div>
	</div>
	<!-- <script type="text/javascript">
		$(document).ready(
				function() {
					$("#fileInput").on(
							'change',
							function() { // 값이 변경되면 
								if (window.FileReader) { // modern browser 
									var filename = $(this)[0].files[0].name;
								} else { // old IE 
									var filename = $(this).val().split('/')
											.pop().split('\\').pop(); // 파일명만 추출 
								} // 추출한 파일명 삽입 
								$("#userfile").val(filename);
							});
				});
	</script> -->
	<!-- jQuery 추가 -->
	<script src="./js/jquery.min.js"></script>
	<!-- pooper 추가 -->
	<script src="./js/popper.js"></script>
	<!-- bootstrap.js 추가 -->
	<script src="./js/bootstrap.min.js"></script>
</body>
</html>