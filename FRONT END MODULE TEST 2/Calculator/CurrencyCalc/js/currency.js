//creating variable
var currency = {
    'EUR': { 'INR': 78.85, 'USD': 1.11 },
    'USD': { 'INR': 71.30, 'EUR': 0.9 },
    'INR': { 'USD': 0.014, 'EUR': 0.013 }
}
//getting inputs from html pages
var btn = document.querySelector('.calculate-btn');
var baseCurrencyInput = document.getElementById('currency-1');
var secondCurrencyInput = document.getElementById('currency-2');
var amountInput = document.getElementById('amount');
var toShowAmount = document.querySelector('.given-amount');
var toShowBase = document.querySelector('.base-currency');
var toShowSecond = document.querySelector('.second-currency');
var toShowResult = document.querySelector('.final-result');
//function to convert currency
function convertCurrency(event) {
    event.preventDefault();
    var amount = amountInput.value;
    var from = baseCurrencyInput.value;
    var to = secondCurrencyInput.value;
    var result = 0;

    try {
        if (from == to) {
            result = amount;
        } else {
            result = amount * currency[from][to];
        }
    }
    catch (err) {
        result = amount * (1 / curerncy[to][from]);
    }

    toShowAmount.innerHTML = amount;
    toShowBase.textContent = from + ' = ';
    toShowSecond.textContent = to;
    toShowResult.textContent = result;
}
//on click of button function is been called
btn.addEventListener('click', convertCurrency);