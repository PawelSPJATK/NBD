groupCurrency = {
    '$group': {
        '_id': '$credit.currency',
        'SumBalance': { '$sum': { '$toDouble': '$credit.balance' } },

    }
};

unwindCurrency = {
    '$unwind': '$credit'
};

printjson(db.people.aggregate([
    unwindCurrency,
    groupCurrency
 ]).toArray())