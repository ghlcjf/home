/**
 * 
 */

function idCheck(){
	if(document.frm.userid.value==''){
		alert('아이디를 입력해 주세요.');
		document.frm.userid.focus();
		return false;
	}
	
	let url = "idCheck?userid="+document.frm.userid.value;
	
	window.open(url,'_blank_1',
	'toolbar=no, menubar=no, scrollbar=yes, resizeable=no, width=500, height=300');
}

function idOk(){
	
	let userid = document.frm.userid.value;
	
	opener.frm.userid.value = userid;
	opener.frm.idcheck.value = userid;
	
	self.close();
	// 새로 열린 창 닫기
	
}






function insertCheck(){
	if(document.frm.userid.value==''){
		alert('아이디를 입력해 주세요.');
		document.frm.userid.focus();
		return false;
	}
	if(document.frm.name.value==''){
		alert('이름을 입력해 주세요.');
		document.frm.name.focus();
		return false;
	}
	if(document.frm.userpw.value==''){
		alert('비밀번호를 입력해 주세요.');
		document.frm.userpw.focus();
		return false;
	}
	if(document.frm.userpw.value!=document.frm.pwcheck.value){
		alert('비밀번호가 일치하지 않습니다.');
		document.frm.pwcheck.focus();
		return false;
	}
	if(document.frm.ban.value==''){
		alert('반을 입력해 주세요.');
		document.frm.ban.focus();
		return false;
	}
	if(document.frm.type.value==''){
		alert('학생/선생 선택해 주세요.');
		return false;
	}
	if(document.frm.idcheck.value==''){ 
		alert('아이디 중복 체크를 해 주세요.');
		return false; 
	}
	
	return true;
	
}

function loginCheck() {
	
	if(document.frm.userid.value==''){
		alert('아이디를 입력해 주세요.');
		document.frm.userid.focus();
		return false;
	}
	
	if(document.frm.userpw.value==''){
		alert('비밀번호를 입력해 주세요.');
		document.frm.userpw.focus();
		return false;
	}
	
	return true;
}