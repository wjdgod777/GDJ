document.getElementById('btn_signin').onclick = function(event){
    // var id = document.getElementById('id');
    // var pw = document.getElementById('pw');
    if(id.value == '') {
        alert('아이디를 입력하세요.');
        event.preventDefault();  // 서브밋을 막음 
        return;
    } else if(id.value.length < 4) {
        alert('아이디는 4글자 이상이여야 합니다.');
        event.preventDefault();
        return;
    } else if(pw.value == '') {
        alert('비밀번호를 입력하세요.');
        event.preventDefault();
        return;
    } else if(pw.value.length < 4) {
        alert('비밀번호는 4글자 이상이여야 합니다.');
        event.preventDefault();
        return;
    }
        
}
document.getElementById('id').onkeyup = function(event){
    // var id = document.getElementById('id');
    // var id_msg = document.getElementById('id_msg');
    if(id.value.length == 0) {
        id_msg.textContent = '';
    } else if(id.value.length < 4) {
        id_msg.textContent = '아이디는 4글자 이상이여야 합니다.';
    } else if(id.value.length >= 4) {
        id_msg.textContent = '회원가입 가능한 아이디입니다.';
    }
}
document.getElementById('pw').onkeyup = function(event){
    // var pw = document.getElementById('pw');
    // var pw_msg = document.getElementById('pw_msg');
    if(pw.value.length == 0) {
        pw_msg.textContent = '';
    } else if(pw.value.length < 4) {
        pw_msg.textContent = '비밀번호는 4글자 이상이여야 합니다.';
    } else if(pw.value.length >= 4) {
        pw_msg.textContent = '회원가입 가능한 비밀번호입니다.';
    }
}