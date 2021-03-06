var app = angular.module("provider", []);
app.controller("AppCtrl", function ($scope, $http) {

    $scope.provider = [];
    $http.get('/api/provider').then(function (response) {
        $scope.provider= response.data;
    });

    this.insertProvider = function () {
        var name = document.getElementById("name").value;
        var phone = document.getElementById("phone").value;
        var req = {
            method: 'POST',
            url: '/api/provider/insert',
            data: {
                nameOfProvider: name,
                phone: phone
            }
        };
        console.log(req);
        $http(req).then(function (resp) {
            window.location.reload();
        })
    };

    this.deleteProvider = function (id) {
        $http.get("api/provider/delete?id="+id).then(function (response) {
            window.location.reload();
        })
    }

    this.startUpdate = function startUpdate(id, name, phone) {
        document.getElementById("updateId").innerText = id;
        document.getElementById("updateName").value = name;
        document.getElementById("updatePhone").value = phone;
    };

    this.updateProvider = function update() {
        var id = document.getElementById("updateId").innerText;
        var name = document.getElementById("updateName").value;
        var phone = document.getElementById("updatePhone").value;
        var req = {
            method: 'POST',
            url: "/api/provider/update?id="+id,
            data: {
                nameOfProvider: name,
                phone: phone
            }
        };
        // console.log(req);
        $http(req).then(function (resp) {
            window.location.reload();
        });
    };
});