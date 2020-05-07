var app = angular.module('reportView', []);
app.controller('reportController', ['$http', '$scope', function ($http, $scope) {
    var report = this;
    report.pdfMaker = pdfMaker;
    report.sendMail = sendMail;

    function pdfMaker() {
        html2canvas(document.getElementById('reportToSend'), {
            onrendered: function (canvas) {
                var data = canvas.toDataURL();
                var docDefinition = {
                    content: [{
                        image: data,
                        width: 500,
                    }]
                };
                var t = pdfMake.createPdf(docDefinition);
                sendMail(t);
            }
        });
    }

    function sendMail(t) {
        t.download("report");
    }
}]);
