//공백 검사
function hasWhiteSpace(str){
return /\s/.test(str)
}
// 특수문자 검사 [!@#$%]
// ., -, \는 정규시에 사용되는 문자이므로 이스케이프(escape) 처리를 해야 합니다.
function hasSpecialChar(str) {
    return /[!@#$%^&*():{}|<>,'~_=\.\-\\`]/.test(str);
}
// 숫자로 시작하는지 검사
function startWithNumber(str) {
    // 1abc, 9abc 시작할 때 검사는 ^를 사용합니다.
    return /^[0-9]/.test(str)
}

document.getElementById('sup_id').addEventListener('input',function(e){
const value=e.target.value;

const spaceError=document.getElementById('spaceError');
const specialCharError = document.getElementById('specialCharError');
const startWithNumberError = document.getElementById('startWithNumberError');
    spaceError.style.display=hasWhiteSpace(value)? 'block':'none';
    specialCharError.style.display = hasSpecialChar(value) ? 'block' : 'none';
    startWithNumberError.style.display = startWithNumber(value) ? 'block' : 'none';
})


document.getElementById('supForm').addEventListener('submit', function(e) {

    e.preventDefault();

    const sup = {
        name: document.getElementById('sup_id').value,
        contact1: document.getElementById('sup_contact1').value,
        contact2: document.getElementById('sup_contact2').value,
        businessNumber: document.getElementById('sup_business_number').value

    }
    if(hasWhiteSpace(sup.name)||hasSpecialChar(sup.name)||startWithNumber(sup.name)){
    alert('입력값을 다시 확인해주세요')
    }else{alert('서버로 전송합니다.')
    }

    // fetch(요청주소, 요청내용객체)
    // 성공
    // 실패
    fetch("/sups", {
        method: 'post',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify(sup)
    }).then(response => {
        if (response.ok) {
            alert('아이템이 성공적으로 생성되었습니다.');
            document.getElementById('supForm').reset();
        } else {
            alert('아이템 생성에 실패했습니다.');
        }
    }).catch(error => {
        console.error('Error:', error);
        alert('오류가 발생했습니다.');
    });
});