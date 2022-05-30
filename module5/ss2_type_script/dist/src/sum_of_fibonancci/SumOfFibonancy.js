function fibonacci(num) {
    if (num <= 1) {
        return 1;
    }
    return fibonacci(num - 1) + fibonacci(num - 2);
}
let n = 4;
let total = 0;
for (let i = 1; i <= n; i++) {
    total += fibonacci(i);
    console.log(fibonacci(i));
}
console.log("sum of fibonancci is: " + total);
//# sourceMappingURL=SumOfFibonancy.js.map