const http = require('http');

http.createServer(function (request, response) {

    // 发送 HTTP 头部
    // HTTP 状态值: 200 : OK
    // 内容类型: text/plain
    response.writeHead(200, {'Content-Type': 'application/json'});

    let res = {
        "id": "001",
        "name": "az",
        "tel": "19912345678",
        "addr": "shanghai,china"
    }

    // 发送响应数据 "Hello World"
    response.end(JSON.stringify(res));
}).listen(8888);

// 终端打印如下信息
console.log('Server running at http://127.0.0.1:8888/');
