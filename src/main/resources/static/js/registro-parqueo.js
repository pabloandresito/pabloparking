'use strict'

var app = angular.module("RegistroParqueoModule", []);

app.controller("RegistroParqueo", function($scope, $http) {

    $scope.registroParqueoDto = [];

    $scope.textError = "";

    refreshAdviserData();

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
        $scope.textError = "Ocurrio un error " + data;
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