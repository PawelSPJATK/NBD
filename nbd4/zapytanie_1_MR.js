var mapperW = function () {
    var w = parseFloat(this.weight);
    emit(this.sex, w);
};

var mapperH = function () {
    var h = parseFloat(this.height);
    emit(this.sex, h);
};

var reducer = function(keySex, values) {
    return Array.avg(values);
};

db.people.mapReduce(
    mapperW,
    reducer,
    {
        out : "weight" 
    }
);

db.people.mapReduce(
    mapperH,
    reducer,
    {
        out : "height" 
    }
);

printjson(db.weight.find().toArray())
printjson(db.height.find().toArray())