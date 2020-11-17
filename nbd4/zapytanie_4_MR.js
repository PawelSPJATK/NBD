var mapper = function () {
    var key = this.nationality;
    var bmi = this.weight / (this.height * this.height);
    emit(key, bmi);
  };
  
  var reducer = function (key, values) {
    return [
      Array.avg(values),
      Math.min.apply(Math, values),
      Math.max.apply(Math, values)
    ];
  };
  
  db.people.mapReduce(
      mapper, 
      reducer, 
      { 
          out: "mrBMI" 
      }
    );
  
  printjson(db.mrBMI.find().toArray());