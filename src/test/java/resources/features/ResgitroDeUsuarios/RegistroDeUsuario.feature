Feature: Regsitro de usuarios
  Con el fin de administrar mis propductos bacarios
  yo como usuario
  quiero poder registrarme
  para acceder a los servicios en linea del banco

  Scenario: Registro exitoso de usuario
    Given Un usuario mayor de edad quiere registrarse para administrar sus servicios bancarios
    When digita las credenciales de ingreso
    Then obtiene una cuenta virtual para realizar login

