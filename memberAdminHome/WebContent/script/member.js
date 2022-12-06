/**
 * 
 */

function loginCheck(){
	// 로그인 버튼을 누르면 동작하는 메서드
	// 아이디와 비밀번호를 다 입력했는지 확인 후 다 입력했다면 true 반환해 submit 동작
	// 아니면 false를 반환해 submit 동작하지 않게 하기 위함
	if(document.frm.userid.value==''){
		alert('아이디를 입력해 주세요');
		document.frm.userid.focus();
		return false; // 서버로 안 보내기 위해
	}
	
	if(document.frm.userpw.value==''){
		alert('비밀번호를 입력해 주세요');
		document.frm.userpw.focus();
		return false;
	}
	return true;
	
}