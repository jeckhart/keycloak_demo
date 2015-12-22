(function() {
    'use strict';

    angular
        .module('cortex.cargo')
        .config(['$routeProvider',config]);


    /** @ngInject */
    function config($routeProvider) {
        $routeProvider.when('/cargo', {
            templateUrl: 'app/components/cargo/cargo.html',
            controller: 'CargoCtrl'
        });
    }

})();


