// const delete_category = [{photo_url: "hello"}];
// console.log(delete_category.length)
// if(delete_category.length!=0  && delete_category[0].photo_url!=undefined)
//     console.log("hi")
// if(delete_category.length!=0  && delete_category[0].photo_url)
//     console.log("hi")



// this is the callback way of doing things in js
// returns a callback function
const count = function (a,b,callback)
{
    // console.log(a+b);
    if(a+b>1)
        return callback(null,a+b);
    else
        return callback(null,new Error("its an error"));
}

count(3,4,(res,error)=>{
    if(res)
        console.log(res+"res");
    else
        console.log(error+"error");
})


// This is the promise based version of doing it
// return a promise
const countPromise = function(a,b)
{
    if(a+b>1)
        return Promise.reject("sum greater than 1")
    else
        return Promise.resolve(a+b);
}

const promiseChaining = countPromise(1,2).then((res)=>{
    console.log(res);
}).catch((e) => {
    console.log(e);
});
const asyncAwait = async()=>{
    try {
        const res = await countPromise(2, 4);
        console.log(res)
    }
    catch (e)
    {
        console.log(e);
    }
}
asyncAwait();
// old javascript
// nodeStyle(params, function (err, data) {
//     if (err) {
//         // error
//     } else {
//         // success
//     }
// };
//
// yourStyle(params, function (data) {
//     if (isError(data)) {
//         // error
//     } else {
//         // success
//     }
// };
//
// promiseStyle(params)
//     .then(function (data) {
//         // success
//     })
//     .catch(function (err) {
//         // error
//     });


// https://www.geeksforgeeks.org/promise-vs-callback-in-javascript/