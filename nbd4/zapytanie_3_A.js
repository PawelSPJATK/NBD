groupJob={
      $group: {
        _id: "$job",
        count: { $sum: 1 },
      }
    };
   
    printjson(db.people.aggregate([
        groupJob
     ]).toArray())