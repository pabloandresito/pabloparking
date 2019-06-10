'use strict'

var app = angular.module("registroParqueoModule", []);

app.controller("registroParqueo", function($scope, $http) {

    $scope.registroParqueoDto = [];

    $scope.textError = "";

    refrescarListaVehiculos();

    $scope.ingresar = function() {

        $scope.textError = "";

        /*if(validaciones($scope.registroParqueoDto)) {
            $scope.textError = "Por favor ingrese de manera correcta los datos";
            return false;
        }*/

        $http({
            method: "POST",
            url: '/registro-parqueo/ingresar',
            data: {
                placa: $scope.registroParqueoDto.placa,
                tipoVehiculo: $scope.registroParqueoDto.tipoVehiculo,
                cilindraje: $scope.registroParqueoDto.cilindraje
            },
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(success, error);
    };
    
    $scope.retirar = function() {

        $scope.textError = "";

        /*if(validaciones($scope.registroParqueoDto)) {
            $scope.textError = "Por favor ingrese de manera correcta los datos";
            return false;
        }*/

        $http({
            method: "POST",
            url: '/retirar-parqueo/retirar',
            data: {
                id: $scope.registroParqueoDto.id
            },
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(success, error);
    };

    function refrescarListaVehiculos() {
        $http({
            method: 'GET',
            url: '/registro-parqueo/list-vehiculos'
        }).then(
            function(listVehiculos) {
                $scope.listVehiculosIngresados = listVehiculos.data;
            }, error
        );
    }

    function success() {
    	refrescarListaVehiculos();
        limpiarFormulario();
    }

    function error(res) {
        var data = res.data;
        var status = res.status;
        $scope.textError = data.message;
    }

    function limpiarFormulario() {
        $scope.registroParqueoDto.placa ="";
        $scope.registroParqueoDto.tipoVehiculo = "";
        $scope.registroParqueoDto.cilindraje = "";
        $scope.textError = "";

    };

    function validaciones(registroParqueoDto) {

        var number = /^([0-9])*$/;
        var letters = /^[a-zA-ZñÑáéíóúÁÉÍÓÚ\s]+$/;

        if (!number.test(registroParqueoDto.cilindraje)) {
            return true;
        }
    };
});