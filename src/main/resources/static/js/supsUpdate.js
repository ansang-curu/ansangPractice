document.getElementById('supForm').addEventListener('submit', function(e) {

    e.preventDefault();

    const sup = {
        id: document.getElementById('sup_id').value,
        name: document.getElementById('sup_name').value,
        contact1: document.getElementById('sup_contact1').value,
        contact2: document.getElementById('sup_contact2').value,
        businessNumber : document.getElementById('sup_businessNumber').value
    }

    // fetch(요청주소, 요청내용객체)
    // 성공
    // 실패
    fetch("/sups/"+sup.id+"/update", {
        method: 'post',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify(sup)
    }).then(response => {
        if (response.ok) {
            alert('아이템이 성공적으로 변경되었습니다.');
            document.getElementById('supForm').reset();
            window.location.href = '/sups';
        } else {
            alert('아이템 생성에 실패했습니다.');
        }
    }).catch(error => {
        console.error('Error:', error);
        alert('오류가 발생했습니다.');
    });
});