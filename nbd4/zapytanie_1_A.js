groupGender = {
    '$group': {
        '_id': '$sex',
        'avgWeight': { '$avg': { '$toDouble': '$weight' } },
        'avgHeight': { '$avg': { '$toDouble': '$height' } }

    }
};

printjson(db.people.aggregate([
    groupGender
 ]).toArray())