@scenarioUno
Feature: Loguearse y realizar la búsqueda de algún contacto de tu red y visualizar su perfil

	Scenario: Buscar Contacto
		Given usuario ingresa correo 
		And usuario ingresa contraseña
		And usuario presiona boton iniciar sesion
		When usuario busca un contacto
		Then se visualiza contacto
		
	Scenario: Usuario no registrado
		Given usuario ingresa correo no registrado en sitio 
		And usuario ingresa contraseña no existente
		When usuario presiona boton iniciar sesion no existente
		Then se visualiza mensaje indicando que no existe