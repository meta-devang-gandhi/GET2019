const express = require('express');
const app = express();
const port = 3000;
const bodyParser = require('body-parser');


app.use(function(req, res, next) {
    res.header("Access-Control-Allow-Origin", "*");
    res.header(
        "Access-Control-Allow-Headers",
        "Origin, X-Requested-With, Content-Type, Accept"
    );
    next();
});

app.use(bodyParser.urlencoded({ extended: true }));
app.use(bodyParser.json());

let connection = require("./utilities/mySqlConnection").getDB();

/**
 * method to get the all products.
 */
app.route('/api/products').get((req, res) => {

    var sql = " SELECT P.id, P.name AS name, P.price, P.description, P.imagePath, C.name AS categoryName FROM " +
        " products AS P INNER JOIN category_list AS C ON P.categoryId=C.Id;";
    connection.query(sql, function(err, result, fields) {
        if (err) {
            res.send(": dbErr...");
        } else {
            res.send(result);
        }
    });
});

/**
 * method to get all order of user. 
 */
app.route('/api/shopperOrder').get((req, res) => {

    var sql = " SELECT * FROM " +
        " shopper_orders AS SO " +
        "  WHERE SO.userId=" + parseInt(req.query.params, 10) + ";";
    connection.query(sql, function(err, result, fields) {
        if (err) {
            res.send(": dbErr...");
        } else {
            res.send(result);
        }
    });
});

/**
 * method to get all item of cart. 
 */
app.route('/api/showCart').get((req, res) => {

    var sql = " SELECT P.id, P.name AS name, P.price, P.imagePath, C.quantity  FROM " +
        " (products AS P INNER JOIN cart AS C ON P.id=C.productId) " +
        "  WHERE C.userId=" + parseInt(req.query.params, 10) + ";";
    connection.query(sql, function(err, result, fields) {
        if (err) {
            res.send(": dbErr...");
        } else {
            res.send(result);
        }
    });
});

/**
 * method to get all information of particular oeder id. 
 */
app.route('/api/orderDetails').get((req, res) => {
    console.log(info() + " products request.... ");
    var sql = " SELECT P.id, P.name AS name, OD.unitPrice, P.imagePath, OD.quantity  FROM " +
        " (products AS P INNER JOIN order_detail AS OD ON P.id=OD.productID) " +
        "  WHERE OD.shopperOrderId=" + parseInt(req.query.params, 10) + ";";
    connection.query(sql, function(err, result, fields) {
        if (err) {
            res.send(info() + ": dbErr...");
        } else {
            res.send(result);
        }
    });
});


app.route('/api/shopperOrderId').get((req, res) => {

    var sql = " SELECT id FROM shopper_orders AS SO " +
        " WHERE SO.userId=" + parseInt(req.query.params, 10) +
        " ORDER BY id DESC LIMIT 1;";
    connection.query(sql, function(err, result, fields) {
        if (err) {
            res.send("dbErr...");
        } else {
            res.send(result);
        }
    });
});

app.route('/api/addCart').post((req, res) => {

    var data = req.body;
    var sql = "INSERT INTO cart (userId,productId, quantity) VALUES(?, ?, ?)";
    connection.query(sql, [data.userId, data.productId, data.quantity], function(err, result) {
        if (err) {
            res.send("dbErr02...");
        } else {
            res.send(result);
        }
    });
})

app.route('/api/updateCart').post((req, res) => {
    var Array = req.body;

    for (var i = 0; i < Array.length; i++) {
        var sql = "UPDATE cart SET quantity=" + Array[i].quantity + " WHERE productID=" + Array[i].productId + ";";
        connection.query(sql, function(err, result) {

        });
    }
})

app.route('/api/insertShopperOrder').post((req, res) => {

    var data = req.body;
    var sql = "INSERT INTO shopper_orders (timeStamp,totalAmount, status, userId) VALUES(now(), ?, ?, ?)";
    connection.query(sql, [data.totalAmount, data.status, data.userId], function(err, result) {
        if (err) {
            res.send(": dbErr02...");
        } else {
            res.send(result);
        }
    });
})

app.route('/api/insertOrderDetails').post((req, res) => {

    var Array = req.body;
    for (var i = 0; i < Array.length; i++) {

        var sql = "INSERT INTO order_detail (shopperOrderId,productID, quantity, unitPrice, status) VALUES(?, ?, ?, ?, ?)";

        connection.query(sql, [Array[i].shopperOrderId, Array[i].productID, Array[i].quantity,
            Array[i].unitPrice, Array[i].status
        ], function(err, result) {});
    }
})


app.listen(port, () => console.log(`Example app listening on port ${port}!`));