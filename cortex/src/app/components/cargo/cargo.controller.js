(function() {
    'use strict';

    angular
        .module('cortex.cargo')

        .controller('CargoCtrl', [ 'CargoData', 'Auth', '$scope', cargoCtrl]);


    /** @ngInject */
    function cargoCtrl(CargoData, Auth, $scope) {
        function getCargo() {
            CargoData.all().then(function (result) {
                $scope.cargo = result.data;
            });
        }

        $scope.isCrew = function() {
            return Auth.hasRealmRole('crew');
        };


        $scope.cargo = [];
        getCargo();

    }

})();
