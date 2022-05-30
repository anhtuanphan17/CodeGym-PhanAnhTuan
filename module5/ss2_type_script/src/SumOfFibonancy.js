function sumOfFibonancci(n) {
    var fibo = [];
    if (n <= 0)
        return 0;
    fibo[0] = 0;
    fibo[1] = 1;
    // Initialize result
    var sum = fibo[0] + fibo[1];
    // Add remaining terms
    for (var i = 2; i <= n; i++) {
        fibo[i] = fibo[i - 1] +
            fibo[i - 2];
        sum += fibo[i];
        fibo[i - 2] = fibo[i - 1];
        fibo[i - 1] = fibo[i];
    }
    return sum;
}
console.log(sumOfFibonancci(4));
