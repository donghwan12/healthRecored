    document.getElementById('addWorkoutDetail').addEventListener('click', function() {
        var container = document.getElementById('workoutDetails');
        var index = container.children.length; // 기존 항목의 개수
        var newWorkoutDetail = document.createElement('div');
        newWorkoutDetail.className = 'mb-3';
        newWorkoutDetail.innerHTML = `
            <div class="mb-3">
                <label for="workoutPart${index}" class="form-label">운동 부위</label>
                <input type="text" class="form-control" id="workoutPart${index}" name="workoutdetails[${index}].part">
            </div>
            <div class="routine">
                <div class="mb-3">
                    <label for="workoutType${index}" class="form-label">운동 종류</label>
                    <input type="text" class="form-control" id="workoutType${index}" name="workoutdetails[${index}].kind">
                    <label for="workset${index}" class="form-label">세트</label>
                    <input type="text" class="form-control" id="workset${index}" name="workoutdetails[${index}].workout_set">
                    <label for="workKg${index}" class="form-label">무게</label>
                    <input type="text" class="form-control" id="workKg${index}" name="workoutdetails[${index}].kg">
                    <label for="workNumber${index}" class="form-label">횟수</label>
                    <input type="text" class="form-control" id="worknumber${index}" name="workoutdetails[${index}].number">
                </div>
            </div>
        `;
        container.appendChild(newWorkoutDetail);
    });

    document.getElementById('saveWorkout').addEventListener('click', function() {
        var form = document.getElementById('workoutForm');
        var formData = new FormData(form);
        var dataObject = Object.fromEntries(formData.entries());
        console.log(dataObject);
        // 폼 데이터를 서버로 전송하는 추가적인 코드를 여기에 작성하세요.
        form.submit();
    });