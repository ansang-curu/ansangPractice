document.getElementById('fruitForm').addEventListener('submit', function(e) {

    e.preventDefault();

    const item = {
        id: document.getElementById('fruit_id').value,
        name: document.getElementById('fruit_name').value
    }

    // fetch(요청주소, 요청내용객체)
    // 성공
    // 실패
    fetch("/fruits/"+item.id+"/update", {
        method: 'post',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify(item)
    }).then(response => {
        if (response.ok) {
            alert('아이템이 성공적으로 변경되었습니다.');
            document.getElementById('fruitForm').reset();
            window.location.href = '/fruits';
        } else {
            alert('아이템 생성에 실패했습니다.');
        }
    }).catch(error => {
        console.error('Error:', error);
        alert('오류가 발생했습니다.');
    });
});