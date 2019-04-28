const express = require('express');
const { sleep } = require('sleep');

const app = express();

let couter = 1;

function pi_digits(digits) {

}

app.get('/hello', (req, res) => {
    res.send('Hello DIYConf2019 ' + '(' + couter++ +')');
});
app.get('/naptime', (req, res) => {
    sleep(5);
    res.send('your slice of pi is ' + pi_digits(20000));
});
app.listen(8080, () => console.log(`Example app listening on port 8080!`))