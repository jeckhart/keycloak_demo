(function() {
    'use strict';

    angular
        .module('cortex')
        .config(['$routeProvider', routeConfig]);

    function routeConfig($routeProvider) {
        $routeProvider
            .when('/', {
                templateUrl: 'app/main/main.html',
                controller: 'MainController'
            })
            .otherwise({redirectTo: '/'});
    }

})();
