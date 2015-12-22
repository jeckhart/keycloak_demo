(function() {
  'use strict';

  angular
    .module('cortex.user')

    .controller('UserCtrl', [ '$rootScope','$scope', 'Auth', UserCtrl]);


    /** @ngInject */
    function UserCtrl($rootScope, $scope, Auth) {
        if (!Auth.authenticated) {
            $rootScope.$broadcast('event:auth-loginRequired');
        }
        $scope.keycloak =  Auth;
    }

})();
