
function fibonacci(num: number): number {
    if (num <= 1) {
        return 1;
    }

    return fibonacci(num - 1) + fibonacci(num - 2);
}

let n:number = 4;
let total:number =0;

for(let i=1;i<=n;i++){
    total+=fibonacci(i);
    console.log(fibonacci(i));
}
console.log("sum of fibonancci is: " + total);


// function sumOfFibonancci(n:number) :number{
//     let fibo = [];
//     if (n <= 0)
//         return 0;
//
//     fibo[0] = 0;
//     fibo[1] = 1;
//
//     // Initialize result
//     let sum = fibo[0] + fibo[1];
//
//     // Add remaining terms
//     for(let i = 2; i <= n; i++)
//     {
//         fibo[i] = fibo[i - 1] +
//             fibo[i - 2];
//         sum += fibo[i];
//         fibo[i - 2]=fibo[i - 1];
//         fibo[i - 1] = fibo[i];
//     }
//
//     return sum;
// }
//
// console.log(sumOfFibonancci(4));


