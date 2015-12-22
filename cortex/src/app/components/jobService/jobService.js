(function() {
  'use strict';

  angular
    .module('cortex.jobService', [])

    .constant('ENDPOINT_URI', 'https://172.16.0.100/serenity/')

    .service('JobData', [ '$http', 'ENDPOINT_URI', jobData]);


    /** @ngInject */
    function jobData($http, ENDPOINT_URI) {
        var service = this;

        var path = 'jobs';

        function getUrl() {
            return ENDPOINT_URI + path;
        }

        service.all = function() {
            return $http.get(getUrl());
        };

    }
})();

