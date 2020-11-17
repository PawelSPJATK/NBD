projectNationality=
    {
      $project: {
        nationality: "$nationality",
        bmi: { $divide: [{ '$toDouble': '$weight' }, { $pow: [{ '$toDouble': '$height' }, 2] }] },
      },
    };
groupBMI=
    {
      $group: {
        _id: "$nationality",
        bmiAvg: { $avg: "$bmi" },
        bmiMin: { $min: "$bmi" },
        bmiMax: { $max: "$bmi" },
      },
    };

  
  printjson(db.people.aggregate([
    projectNationality,
    groupBMI
 ]).toArray())