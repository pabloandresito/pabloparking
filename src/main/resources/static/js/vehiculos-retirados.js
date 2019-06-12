'use strict'

var app = angular.module("vehiculosRetiradosModule", []);

app.controller("vehiculosRetirados", function($scope, $http) {

    refrescarLista();

    function refrescarLista() {
        $http({
            method: 'GET',
            url: '/retiro-parqueo/list'
        }).then(
            function(listVehiculos) {
                $scope.listVehiculosRetirados = listVehiculos.data;
            }, error
        );
    }

    function error(res) {
        var data = res.data;
        var status = res.status;
    }

});