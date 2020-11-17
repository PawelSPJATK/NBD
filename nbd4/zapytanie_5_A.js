  matchFemale= {
      $match: {
        sex: "Female",
        nationality: "Poland",
      },
    };
    unwindCurrency={
      $unwind: "$credit",
    };
    groupCurrency={
      $group: {
        _id: "$credit.currency",
        balanceSum: { $sum: { '$toDouble': '$credit.balance' } },
        balanceAvg: { $avg:{ '$toDouble': '$credit.balance' } },
      },
    };

  
  printjson(db.people.aggregate([
    matchFemale,
    unwindCurrency,
    groupCurrency
 ]).toArray())