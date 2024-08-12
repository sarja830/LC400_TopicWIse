const express = require("express");
const app = express();
//app.js
const {Worker} = require('node:worker_threads');

app.get("/heavy", (req, res) => {
    const worker = new Worker("./worker.js")
    worker.on("online", () => console.log("I am online"));
    worker.on("message", data => {
        console.log(data);
        res.send(data);
    });
    worker.on("error", async (data) => {
        console.log("error ")
        await res.send(data);
    });
})
app.get("/light", (req, res) => {
    res.send(`Request successful!\n`);
})


// app.get("/heavy", (req, res) => {
//     let counter = 0;
//     for(let i=0;i<100;i++)
//         for(let j=0;j<1e9;j++)
//             counter++;
//
//     res.send(`${counter} iterations completed!`);
// })
app.listen(3000, () => console.log("Listening to port 3000"));