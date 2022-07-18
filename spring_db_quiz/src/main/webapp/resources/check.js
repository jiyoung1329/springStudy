function allCheck(){
	id = document.getElementById('id').value;
	pwd1 = document.getElementById('pwd1').value;
	pwd2 = document.getElementById('pwd2').value;
	name = document.getElementById('name').value;
	
	if(id == ""){
		alert('아이디는 필수 항목입니다.');
	}else if(pwd1 == ""){
		alert('비밀번호는 필수 항목입니다.');
	}else if(pwd2 == ""){
		alert('비밀번호 확인은 필수 항목입니다.');
	}else if(name == ""){
		alert('이름은 필수 항목입니다.');
	}else{
		document.getElementById('f').submit();
	}
}
function pwCheck(){
	pwd1 = document.getElementById('pwd1');
	pwd2 = document.getElementById('pwd2');
	if(pwd1.value == pwd2.value){
		document.getElementById('label').innerHTML = '일치';
	}
	else {
		document.getElementById('label').innerHTML = '불일치';
		pwd1.value="";
		pwd2.value="";
		pwd1.focus();
	}
}
function loginCheck(){
	id = document.getElementById('id').value;
	pwd1 = document.getElementById('pwd1').value;
	
	if(id == ""){
		alert('아이디는 필수 항목입니다.');
	}else if(pwd1 == ""){
		alert('비밀번호는 필수 항목입니다.');
	}else{
		document.getElementById('f').method = 'post';
		document.getElementById('f').submit();
	}
}
