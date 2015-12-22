(function() {
  'use strict';

  angular
    .module('cortex.cargoService', [])

    .constant('ENDPOINT_URI', 'https://172.16.0.100/serenity/')

    .service('CargoData', [ '$http', 'ENDPOINT_URI', cargoData]);


    /** @ngInject */
    function cargoData($http, ENDPOINT_URI) {
        var service = this;

        var path = 'cargo';

        function getUrl() {
            return ENDPOINT_URI + path;
        }

        service.all = function() {
            return $http.get(getUrl());
        };

        service.cargo = function(cargoId) {
            return $http.get(getUrl()+ '/' + cargoId);
        };

        service.update = function(cargo) {
            return $http.post(getUrl() + '/' + cargo.id, cargo);
        };

        service.locations = function() {
            return $http.get(getUrl() + '/' + 'locations');
        };

        service.jobs = function() {
            return $http.get(getUrl() + '/' + 'jobs');
        };

    }
})();

