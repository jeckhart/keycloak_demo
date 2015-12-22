(function() {
    'use strict';

    angular
        .module('cortex')
        .config(['$httpProvider','toastrConfig', config]);

    /** @ngInject */
    function config($httpProvider, toastrConfig) {
        $httpProvider.interceptors.push('errorInterceptor');
        $httpProvider.interceptors.push('authInterceptor');

        angular.extend(toastrConfig, {
            timeOut: 3000,
            progressBar: true,
            allowHtml: true,
            positionClass: 'toast-top-center'
        });
    }

})();
