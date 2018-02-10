var express = require('express');
var router = express.Router();
const mongoose = require('mongoose');
mongoose.Promise = global.Promise;
mongoose.connect('mongodb://localhost:27017/flightproject');

const flightSchema = new mongoose.Schema({
    flightNo: Number,
    origin: String,
    destination: String,
    timeDeparture: Date,
    timeArrival: Date,
    airlineName: String
});
const Flight = mongoose.model('flight', flightSchema);

router.post('/create', (req, res)=>{
    console.log(req.body);
    const flight = new Flight(req.body);
    flight.save((err, flight)=>{
        if(err) return console.error(err);
        console.log(flight.title + " is successfully created!")
        res.json(flight._id);
    })
})

router.get('/', (req, res) => {
    console.log('s');
    Flight.find({'timeDeparture' : {"$gte": '2018-01-30', "$lt": '2018-01-31'}}, (err, flights)=>{
        console.log(flights)
     } )
    Flight.find((err, flights)=>{
    if(err) return console.error(err);
res.json(flights);
    })
})

router.post('/search', (req, res)=>{
    const nextDate = new Date(req.body.timeDeparture);
    nextDate.setDate(nextDate.getDate() + 1);
    console.log(nextDate);
    Flight.find({
        'origin' : new RegExp(req.body.origin, 'i'),
        'destination' : new RegExp(req.body.destination, 'i'),
        'timeDeparture' : {"$gte": new Date(req.body.timeDeparture), "$lt": nextDate}
    }, (err, flights)=>{
        if(err) return console.error('wahh');
        console.log(flights);
        res.json(flights);
    })
})

router.delete('/delete/:id', (req, res)=>{
    Flight.remove({_id: req.params.id}, (err, flight)=>{
    if(err) return console.error(err);
console.log('Flight:' + flight._id + ' is successfully removed!')
res.json('ok');
    })
})

router.get('/populate', (req, res) =>{
    new Flight({
        'flightNo': 322,
        'origin' : 'Chicago',
        'destination' : 'Los Angeles',
        'timeDeparture': '02/18/2018 11:00',
        'timeArrival' : '02/18/2018 13:00',
        'airlineName' : 'American Airline'
    }).save();
    new Flight({
        'flightNo': 122,
        'origin' : 'Austin',
        'destination' : 'Chicago',
        'timeDeparture': '02/18/2018 01:00',
        'timeArrival' : '02/18/2018 03:00',
        'airlineName' : 'United'
    }).save();
    new Flight({
        'flightNo': 112,
        'origin' : 'Houston',
        'destination' : 'Seattle',
        'timeDeparture': '02/18/2018 13:00',
        'timeArrival' : '02/18/2018 18:00',
        'airlineName' : 'Delta'
    }).save();
    new Flight({
        'flightNo': 332,
        'origin' : 'Austin',
        'destination' : 'New York',
        'timeDeparture': '02/18/2018 12:00',
        'timeArrival' : '02/18/2018 18:00',
        'airlineName' : 'Delta'
    }).save();
    new Flight({
        'flightNo': 192,
        'origin' : 'Chicago',
        'destination' : 'New york',
        'timeDeparture': '02/18/2018 14:00',
        'timeArrival' : '02/18/2018 18:00',
        'airlineName' : 'American Airline'
    }).save();
    new Flight({
        'flightNo': 142,
        'origin' : 'Austin',
        'destination' : 'New york',
        'timeDeparture': '02/18/2018 01:00',
        'timeArrival' : '02/18/2018 03:00',
        'airlineName' : 'Delta'
    }).save();
    new Flight({
        'flightNo': 199,
        'origin' : 'Austin',
        'destination' : 'New york',
        'timeDeparture': '02/18/2018 04:00',
        'timeArrival' : '02/18/2018 08:00',
        'airlineName' : 'American Airline'
    }).save();
    new Flight({
        'flightNo': 142,
        'origin' : 'Austin',
        'destination' : 'New york',
        'timeDeparture': '02/18/2018 15:00',
        'timeArrival' : '02/18/2018 19:00',
        'airlineName' : 'Delta'
    }).save();
    new Flight({
        'flightNo': 102,
        'origin' : 'Austin',
        'destination' : 'New york',
        'timeDeparture': '02/18/2018 13:00',
        'timeArrival' : 'United'
    }).save();
    new Flight({
        'flightNo': 152,
        'origin' : 'Austin',
        'destination' : 'New York',
        'timeDeparture': '02/18/2018 12:00',
        'timeArrival' : '02/18/2018 17:00',
        'airlineName' : 'Delta'
    }).save();
    new Flight({
        'flightNo': 162,
        'origin' : 'Los Angeles',
        'destination' : 'Austin',
        'timeDeparture': '02/18/2018 11:00',
        'timeArrival' : '02/18/2018 18:00',
        'airlineName' : 'Delta'
    }).save();
    new Flight({
        'flightNo': 422,
        'origin' : 'New York',
        'destination' : 'Austin',
        'timeDeparture': '02/18/2018 12:00',
        'timeArrival' : '02/18/2018 18:00',
        'airlineName' : 'Delta'
    }).save();
    res.end('Database have been populated.');
})

module.exports = router;