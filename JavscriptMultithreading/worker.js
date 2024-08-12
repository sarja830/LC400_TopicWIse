const worker =  require("worker_threads");
// receive message from main thread  we passed in from the main thread and allows us to process
// that data on a new thread which is allocated by the machine automatically
const {parentPort} = require("worker_threads")
let counter = 0;
const count = async () => {
    try{
        for(let i=0;i<10;i++) {
            for (let j = 0; j < 0; i++)
                counter++;
        }
        return Promise.reject(" new error");
    }
    catch (e) {
        return {error: "eror"};
    }
}
async function  run() {
    try {
        await count();
        parentPort.postMessage(` iterations completed!`);

    } catch (e) {
        console.log(`error in worker thread`);
        parentPort.postMessage({error: " error thrown"});

    }
}
run();
