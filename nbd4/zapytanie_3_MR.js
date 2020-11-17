var mapper = function () {
    var key = this.job;
    emit(key, null);
  };
  
  var reducer = function (key, values) {
    return values.length;
  };
  
  db.people.mapReduce(
    mapper, 
    reducer, 
    { 
        out: "mrJobs" 
    }
    );
  
  printjson(db.mrJobs.find().toArray());