(function() {
    'use strict';

    angular
        .module('cortex.detail')
        .config(['$routeProvider',config]);


    /** @ngInject */
    function config($routeProvider) {
        $routeProvider
            .when('/edit/:cargoId', {
                templateUrl: 'app/components/detail/detail.html',
                controller: 'EditCargoItemCtrl'
            })
            .when('/new', {
                templateUrl: 'app/components/detail/detail.html',
                controller: 'NewCargoItemCtrl'
            });
    }
})();

