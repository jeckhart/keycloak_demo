(function() {
    'use strict';

    angular
        .module('cortex.detail')

        .controller('EditCargoItemCtrl', ['$scope', '$routeParams', 'CargoData', 'LocationData', 'JobData', 'toastr', editCargoItemCtrl])
        .controller('NewCargoItemCtrl', ['$scope', '$routeParams', 'CargoData', 'LocationData', 'JobData', 'toastr', 'Auth', newCargoItemCtrl]);

    /** @ngInject */
    function newCargoItemCtrl($scope, $routeParams, CargoData, LocationData, JobData, toastr, Auth ) {
        $scope.keycloak =  Auth;

        function getLocations() {
            LocationData.all()
                .then(function (result) {
                    $scope.locations = result.data;
                });
        }

        function getJobs() {
            JobData.all()
                .then(function (result) {
                    $scope.jobs = result.data;
                });
        }

        $scope.cargoItemMaster = [];
        $scope.cargoItem = {};

        $scope.locations = [];
        getLocations();

        $scope.jobs = [];
        getJobs();


        $scope.reset = function() {
            $scope.cargoItem = angular.copy($scope.cargoItemMaster);
        };

        $scope.save = function() {
            CargoData.create($scope.cargoItem).
                then(function() {
                    toastr.success($scope.cargoItem.description + ' successfully updated', 'Success');
            }, function() {
                    toastr.error($scope.cargoItem.description + ' update failed', 'Error' );
            });
        };

    }

    /** @ngInject */
    function editCargoItemCtrl($scope, $routeParams, CargoData, LocationData, JobData, toastr) {
        function getCargoItem() {
          CargoData.cargo($routeParams.cargoId)
            .then(function (result) {
              $scope.cargoItemMaster = result.data;
              $scope.reset();
            });
        }

        function getLocations() {
            LocationData.all()
                .then(function (result) {
                    $scope.locations = result.data;
                });
        }

        function getJobs() {
            JobData.all()
                .then(function (result) {
                    $scope.jobs = result.data;
                });
        }

        $scope.alerts = [];

        $scope.closeAlert = function(index) {
            $scope.alerts.splice(index, 1);
        };


        $scope.cargoItemMaster = [];
        $scope.cargoItem = [];
        getCargoItem();

        $scope.locations = [];
        getLocations();

        $scope.jobs = [];
        getJobs();

        $scope.reset = function() {
            $scope.cargoItem = angular.copy($scope.cargoItemMaster);
        };

        $scope.save = function() {
            CargoData.update($scope.cargoItem).
                then(function() {
                    toastr.success($scope.cargoItem.description + ' successfully updated', 'Success');
            }, function() {
                    toastr.error($scope.cargoItem.description + ' update failed', 'Error' );
            });
        };
    }

})();
