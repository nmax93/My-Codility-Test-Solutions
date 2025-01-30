function solution(A) {
    let index = 0;
    let arrLen = 1;
    
    for (let i = 0; i < A.length; i++) {
        if (A[index] === -1)
            return arrLen;

        index = A[index];
        arrLen++;
    }
}
