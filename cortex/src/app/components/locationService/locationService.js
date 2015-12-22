(function() {
  'use strict';

  angular
    .module('cortex.locationService', [])

    .constant('ENDPOINT_URI', 'https://172.16.0.100/serenity/')

    .service('LocationData', [ '$http', 'ENDPOINT_URI', locationData]);


    /** @ngInject */
    function locationData($http, ENDPOINT_URI) {
        var service = this;

        var path = 'locations';

        function getUrl() {
            return ENDPOINT_URI + path;
        }

        service.all = function() {
            return $http.get(getUrl());
        };

    }
})();

