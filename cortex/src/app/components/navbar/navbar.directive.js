(function() {
  'use strict';

  angular
    .module('cortex')
    .directive('cortexNavbar', cortexNavbar);

  /** @ngInject */
  function cortexNavbar() {
    var directive = {
      restrict: 'E',
      templateUrl: 'app/components/navbar/navbar.html',
      controller: ['Auth', '$scope', NavbarController],
      controllerAs: 'vm',
      bindToController: true
    };

    return directive;

    /** @ngInject */
    function NavbarController(Auth, $scope) {
      $scope.logout = Auth.logout;
      $scope.isLoggedIn = Auth.authenticated;
    }
  }

})();
