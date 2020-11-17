var mapper = function () {
    for (var i = 0; i < this.credit.length; i++) {
      var key = this.credit[i].currency;
      var value = parseFloat(this.credit[i].balance);
      emit(key, value);
    }
  };
  var reducer = function (key, values) {
    var sum = 0;
    for (var i = 0; i < values.length; i++) {
      sum += values[i];
    }
    return sum;
  };
  db.people.mapReduce(
      mapper, 
      reducer, 
        { 
          out: "mrCurrency" 
        }
          
        );
  printjson(db.mrCurrency.find().toArray());